package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO implements DAO<Genre> {
    @Override
    public void create(Genre item) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (id,name) values ((SELECT NVL(MAX(id),0) +1 FROM genres),?)")) {
            pstmt.setString(1, item.getName());
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<Genre> findAll() throws SQLException {
        List<Genre> genres = new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id, name from genres")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Genre genre = new Genre(id, name);
                genres.add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return genres;

    }

    @Override
    public Genre findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        String query = "select id from genres where name=?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            int id = rs.next() ? rs.getInt(1) : 0;
            return new Genre(id, name);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Genre findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id='" + id + "'")) {
            String name = rs.next() ? rs.getString(1) : null;
            return new Genre(id, name);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }
}
