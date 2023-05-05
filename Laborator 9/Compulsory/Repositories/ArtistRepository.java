package org.example.Repositories;
import org.example.Entities.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository {
    private static final String PERSISTENCE_UNIT_NAME = "ExamplePU";
    private static EntityManagerFactory factory = null;

    public ArtistRepository(EntityManagerFactory entityManagerFactory) {
    }

    private static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public void create(Artist artist) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
        em.close();
    }

    public Artist findById(Integer id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Artist artist = em.find(Artist.class, id);
        em.close();
        return artist;
    }

    public List<Artist> findByName(String namePattern) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        TypedQuery<Artist> query = em.createNamedQuery("Artist.findByName", Artist.class);
        query.setParameter("namePattern", "%" + namePattern + "%");
        List<Artist> artists = query.getResultList();
        em.close();
        return artists;
    }
}
