package org.example.Repositories;

import org.example.Entities.Artist;

public class ArtistRepository extends AbstractRepository<Artist> {
    public ArtistRepository() {
        super(Artist.class);
    }
}
