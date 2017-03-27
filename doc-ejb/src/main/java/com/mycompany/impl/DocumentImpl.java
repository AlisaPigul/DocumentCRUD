package com.mycompany.impl;

import com.mycompany.converter.DocumentConverter;
import com.mycompany.dao.DocumentDao;
import com.mycompany.domain.DocumentEntity;
import com.mycompany.vo.DocumentVO;
import com.mycompany.vo.DocumentsVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.ArrayList;
import java.util.List;

/**
 * Bean for document processing
 */
@Stateless
public class DocumentImpl {

    @EJB
    private DocumentDao dao;

    /**
     * Create new document
     * @param plannedDocument - new document
     * @return created document with auto generated id
     */
    public DocumentVO createDocument(DocumentVO plannedDocument) {
        DocumentEntity document = DocumentConverter.fromVOToEntity(plannedDocument);
        dao.persistInNewTransaction(document);
        return DocumentConverter.fromEntityToVO(document);
    }

    /**
     * Get all documents from database
     * @return all documents from database
     */
    public DocumentsVO getAllDocuments() {
        List<DocumentEntity> entities = dao.list();
        List<DocumentVO> list = new ArrayList<>();
        for (DocumentEntity entity: entities) {
            list.add(DocumentConverter.fromEntityToVO(entity));
        }
        DocumentsVO result = new DocumentsVO();
        result.setDocuments(list);
        return result;
    }

    /**
     * Delete document by id
     * @param id - id of document that should be deleted
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteDocumentById(Integer id) {
        DocumentEntity entity = dao.find(id);
        dao.remove(entity);
    }

    /**
     * Update document
     * @param plannedDocument - document that should be updated
     * @return - updated document
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public DocumentVO updateDocument(DocumentVO plannedDocument) {
        DocumentEntity plannedEntity = DocumentConverter.fromVOToEntity(plannedDocument);
        DocumentEntity actualEntity = dao.find(plannedDocument.getId());
        if (actualEntity != null) {
            actualEntity.getItems().clear();
        }
        return DocumentConverter.fromEntityToVO(dao.getEntityManager().merge(plannedEntity));
    }

    /**
     * Get document by id
     * @param id - id of document for search
     * @return document with given id
     */
    public DocumentVO getDocumentById(Integer id) {
        return DocumentConverter.fromEntityToVO(dao.find(id));
    }
}
