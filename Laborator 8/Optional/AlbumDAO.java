package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
 public class AlbumDAO implements DAO<Album>{

    @Override
    public void create(Album item) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums values ((SELECT NVL(MAX(id),0) +1 FROM albums),?,?,?,?)")) {
            pstmt.setInt(1, item.getReleaseYear());
            pstmt.setString(2, item.getTitle());
            pstmt.setString(3,item.getArtist().getName());
            pstmt.setString(4, String.join(",", item.getGenres().stream()
                    .map(genre -> genre.getName())
                    .collect(Collectors.toList())));
            pstmt.executeUpdate();

    }}

    @Override


        public List<Album> findAll() throws SQLException {
            List<Album> albums = new ArrayList<>();

            Connection con = Database.getConnection();
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM albums")) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int releaseYear = rs.getInt("release_year");
                    String title = rs.getString("title");
                    String artistName = rs.getString("artist");
                    String genreNames = rs.getString("genre");


                    ArtistDAO artistDAO = new ArtistDAO();
                    Artist artist = artistDAO.findByName(artistName);

                     List<Genre> genres = new ArrayList<>();
                    String[] genreNamesArr = genreNames.split(",");
                    for (String genreName : genreNamesArr) {
                        GenreDAO genreDAO = new GenreDAO();
                        Genre genre = genreDAO.findByName(genreName);
                        genres.add(genre);
                    }

                    Album album = new Album(id, releaseYear, title, artist, genres);
                    albums.add(album);
                }
            }

            return albums;
        }


    @Override
    public Album findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from albums where title='" + name + "'")) {
            if (rs.next()) {
                int id = rs.getInt("id");
                int releaseYear = rs.getInt("release_year");
                String title = rs.getString("title");
                String artistName = rs.getString("artist");
                String genreNames = rs.getString("genre");

                ArtistDAO artistDAO = new ArtistDAO();
                Artist artist = artistDAO.findByName(artistName);

                List<Genre> genres = new ArrayList<>();
                String[] genreNamesArr = genreNames.split(",");
                for (String genreName : genreNamesArr) {
                    GenreDAO genreDAO = new GenreDAO();
                    Genre genre = genreDAO.findByName(genreName);
                    genres.add(genre);
                }
                return new Album(id, releaseYear, title, artist, genres);
            } else {
                return null;
            }
        }
    }


    @Override
    public Album findById(int givenId) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from albums where id='" + givenId + "'")) {
            if (rs.next()) {
                int id = rs.getInt("id");
                int releaseYear = rs.getInt("release_year");
                String title = rs.getString("title");
                String artistName = rs.getString("artist");
                String genreNames = rs.getString("genre");

                ArtistDAO artistDAO = new ArtistDAO();
                Artist artist = artistDAO.findByName(artistName);

                List<Genre> genres = new ArrayList<>();
                String[] genreNamesArr = genreNames.split(",");
                for (String genreName : genreNamesArr) {
                    GenreDAO genreDAO = new GenreDAO();
                    Genre genre = genreDAO.findByName(genreName);
                    genres.add(genre);
                }

                return new Album(id, releaseYear, title, artist, genres);

            } else {
                return null;
            }
        }

    }
}

