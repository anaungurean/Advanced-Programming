package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "Student";
    private static final String PASSWORD = "STUDENT";
    private static DataSource dataSource = null;

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            createDataSource();
        }
        return dataSource.getConnection();
    }

    private static void createDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl(URL);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);
        ds.setInitialSize(5);
        ds.setMaxTotal(10);
        dataSource = ds;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing database connection - " + e.getMessage());
            }
        }
    }

    public static void rollback(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                System.err.println("Error rolling back database changes - " + e.getMessage());
            }
        }
    }
}
