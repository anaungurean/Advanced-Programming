package org.example.Repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractRepository<T> {
    private static final String PERSISTENCE_UNIT_NAME = "ExamplePU";
    private static EntityManagerFactory factory = null;
    private Class<T> entityClass;

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    private static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public void create(T entity) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public T findById(Integer id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        T entity = em.find(entityClass, id);
        em.close();
        return entity;
    }

    public List<T> findByName(String namePattern) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        TypedQuery<T> query = em.createNamedQuery(entityClass.getSimpleName() + ".findByName", entityClass);
        query.setParameter("namePattern", "%" + namePattern + "%");
        List<T> entities = query.getResultList();
        em.close();
        return entities;
    }
}
