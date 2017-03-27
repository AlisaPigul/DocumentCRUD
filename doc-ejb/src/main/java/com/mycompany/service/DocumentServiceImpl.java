package com.mycompany.service;

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
public class DocumentServiceImpl implements DocumentService{

    @EJB
    private DocumentDao dao;

   @Override
    public DocumentVO createDocument(DocumentVO plannedDocument) {
        DocumentEntity document = DocumentConverter.fromVOToEntity(plannedDocument);
        dao.persistInNewTransaction(document);
        return DocumentConverter.fromEntityToVO(document);
    }

    @Override
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

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteDocumentById(Integer id) {
        DocumentEntity entity = dao.find(id);
        dao.remove(entity);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public DocumentVO updateDocument(DocumentVO plannedDocument) {
        DocumentEntity plannedEntity = DocumentConverter.fromVOToEntity(plannedDocument);
        DocumentEntity actualEntity = dao.find(plannedDocument.getId());
        if (actualEntity != null) {
            actualEntity.getItems().clear();
        }
        return DocumentConverter.fromEntityToVO(dao.getEntityManager().merge(plannedEntity));
    }

    @Override
    public DocumentVO getDocumentById(Integer id) {
        return DocumentConverter.fromEntityToVO(dao.find(id));
    }
}
