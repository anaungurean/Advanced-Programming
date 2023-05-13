package org.example;

import org.example.Entities.Album;
import org.example.Entities.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            List<Artist> artists = createFakeArtists();

            for (Artist artist : artists) {
                em.persist(artist);
            }

            List<Album> albums = createFakeAlbums();

            for (Album album : albums) {
                long startTime = System.currentTimeMillis();

                em.persist(album);

                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                System.out.println("Execution time: " + executionTime + " ms");
            }

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }

    private static List<Artist> createFakeArtists() {
        List<Artist> artists = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Artist artist = new Artist("Artist " + i);
            artists.add(artist);
        }

        return artists;
    }

    private static List<Album> createFakeAlbums() {
        List<Album> albums = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Album album = new Album("Album " + i, 2023);
            albums.add(album);
        }

        return albums;
    }
}
