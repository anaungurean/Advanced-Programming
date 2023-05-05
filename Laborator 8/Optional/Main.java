package org.example;

import java.sql.SQLException;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {

            var artist1 = new Artist(1, "Pink Floyd");
            var artist2 = new Artist(2, "Michael Jackson");
            var artistDAO = new ArtistDAO();
             artistDAO.create(artist1);
             artistDAO.create(artist2);

            System.out.println("Find artist by name:");
            var artistByName = artistDAO.findByName("Pink Floyd");
            System.out.println(artistByName);

            System.out.println("Find artist by ID:");
            var artistById = artistDAO.findById(1);
            System.out.println(artistById);

            System.out.println("Find all artists:");
            var allArtists = artistDAO.findAll();
            for (var a : allArtists) {
                System.out.println(a);
            }

            var genre1 = new Genre(1,"Folk");
            var genre2 = new Genre(2,"Rock");
            var genre3 = new Genre(3,"Pop");

            var genreDAO = new GenreDAO();
            genreDAO.create(genre1);
            genreDAO.create(genre2);
            genreDAO.create(genre3);


            System.out.println("Find genre by name:");
            var genreByName = genreDAO.findByName("Folk");
            System.out.println(genreByName);

            System.out.println("Find genre by ID:");
            var genreById = genreDAO.findById(1);
            System.out.println(genreById);

            System.out.println("Find all genres:");
            var allGenres = genreDAO.findAll();
            for (var a : allGenres) {
                System.out.println(a);
            }

            var album = new Album(1,1982, "Thriller", artist1, List.of(genre1));
            var albumDAO = new AlbumDAO();
            albumDAO.create(album);

            System.out.println("Find all albums:");
            var allAlbums = albumDAO.findAll();
            for (var a : allAlbums) {
                System.out.println(a);
            }

            System.out.println("Find album by name:");
            var albumByName = albumDAO.findByName("Thriller");
            System.out.println(albumByName);

            System.out.println("Find album by ID:");
            var albumById = albumDAO.findById(1);
            System.out.println(albumById);


//            Database.getConnection().commit();
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
