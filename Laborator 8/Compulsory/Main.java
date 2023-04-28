package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database.getConnection();
            try {
                var artists = new ArtistDAO();
                artists.create("Pink Floyd");
                artists.create("Michael Jackson");
                var genres = new GenreDAO();
                genres.create("Rock");
                genres.create("Funk");
                genres.create("Soul");
                genres.create("Pop");
                Database.getConnection().commit();
                var albums = new AlbumDAO();
                albums.create("The Wall");
                albums.create("Thriller");
                Database.getConnection().commit();
                Database.getConnection().close();
            } catch (SQLException e) {
                System.err.println(e);
//                Database.rollback();
            }
        }


    }
