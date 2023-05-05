package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImportAlbums {

    private static final String INSERT_SQL = "INSERT INTO albums (id, release_year, title, artist, genre) VALUES (?, ?, ?, ?, ?)";

    public static void main(String[] args) {
        String csvFile = "C:/Users/anama/OneDrive/Desktop/albumlist.csv";
        String line;
        String delimiter = ",";
        Connection conn = null;
        PreparedStatement pstmt = null;
        BufferedReader br = null;

        try {
            conn = Database.getConnection();
            pstmt = conn.prepareStatement(INSERT_SQL);
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(delimiter);

                int id = Integer.parseInt(fields[0].replaceAll("\"", ""));
                 int year = Integer.parseInt(fields[1]);
                String title = fields[2];
                String artist = fields[3];
                String genre = fields[4];

                pstmt.setInt(1, id);
                pstmt.setInt(2, year);
                pstmt.setString(3, title);
                pstmt.setString(4, artist);
                pstmt.setString(5, genre);
                pstmt.executeUpdate();
            }
            System.out.println("Data imported successfully");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                if (br != null) br.close();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
