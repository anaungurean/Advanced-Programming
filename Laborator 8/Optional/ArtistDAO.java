package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO implements DAO<Artist>{

    @Override
    public void create(Artist item) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (id,name) values ((SELECT NVL(MAX(id),0) +1 FROM artists),?)")) {
            pstmt.setString(1, item.getName());
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Artist> findAll() throws SQLException {
        List<Artist> artists = new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id, name from artists")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Artist artist = new Artist(id, name);
                artists.add(artist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return artists;
    }

    @Override
    public Artist findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name='" + name + "'")) {
            int id = rs.next() ? rs.getInt(1) : 0;
            return new Artist(id, name);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Artist findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from artists where id='" + id + "'")) {
            String name = rs.next() ? rs.getString(1) : null;
            return new Artist(id, name);
        } catch (SQLException e) {
             e.printStackTrace();
            return null;
        }
    }


}