package com.mycompany.dao;

import com.mycompany.domain.DocumentEntity;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Document dao
 */
@Stateless
public class DocumentDao extends CommonDao<DocumentEntity> {

    /**
     * Get list of documents
     * @return list
     */
    public List<DocumentEntity> list() {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<DocumentEntity> query = builder.createQuery(DocumentEntity.class);
        Root<DocumentEntity> root = query.from(DocumentEntity.class);
        query.select(root);
        return getEntityManager().createQuery(query).getResultList();
    }

    /**
     * Find document by id
     * @param id - id of document for search
     * @return document entity
     */
    public DocumentEntity find(Integer id) {
        return getEntityManager().find(DocumentEntity.class, id);
    }
}
