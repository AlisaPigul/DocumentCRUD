package com.mycompany.service;

import com.mycompany.vo.DocumentVO;
import com.mycompany.vo.DocumentsVO;

/**
 * Document service
 */
public interface DocumentService {

    /**
     * Create new document
     * @param plannedDocument - new document
     * @return created document with auto generated id
     */
    DocumentVO createDocument(DocumentVO plannedDocument);

    /**
     * Get all documents from database
     * @return all documents from database
     */
    DocumentsVO getAllDocuments();

    /**
     * Delete document by id
     * @param id - id of document that should be deleted
     */
    void deleteDocumentById(Integer id);

    /**
     * Update document
     * @param plannedDocument - document that should be updated
     * @return - updated document
     */
    DocumentVO updateDocument(DocumentVO plannedDocument);

    /**
     * Get document by id
     * @param id - id of document for search
     * @return document with given id
     */
    DocumentVO getDocumentById(Integer id);
}
