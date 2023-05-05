package org.example;

import org.example.Entities.Artist;
import org.example.Repositories.ArtistRepository;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePU");
        ArtistRepository artistRepository = new ArtistRepository(entityManagerFactory);

        Artist artist = new Artist(1,"Queen");
        artistRepository.create(artist);
        System.out.println("New artist created: " + artist);

        Artist foundArtist = artistRepository.findById(artist.getId());
        System.out.println("Found artist by id: " + foundArtist);

        List<Artist> artistsByName = artistRepository.findByName("Queen");
        System.out.println("Found artists by name: " + artistsByName);


        entityManagerFactory.close();
    }
}
