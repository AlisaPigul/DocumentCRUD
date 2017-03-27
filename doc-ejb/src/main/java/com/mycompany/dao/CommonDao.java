package com.mycompany.dao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Common dao
 */
@Stateless
public class CommonDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public T persistInNewTransaction(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T mergeInNewTransaction(T entity) {
        return entityManager.merge(entity);
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
