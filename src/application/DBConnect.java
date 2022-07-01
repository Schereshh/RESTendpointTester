package application;

import java.sql.*;

import org.postgresql.Driver;

public class DBConnect {
    private Connection c = null;
    private Statement stmt = null;
    public DBConnect (String dbHost, String dbName, String username, String password) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        this.c = DriverManager.getConnection("jdbc:postgresql://" + dbHost + ":5432/" + dbName + "", username, password);

        this.c.setAutoCommit(false);

        System.out.println("Database connection is successful");
    }

    public void updateDB (String query) throws SQLException {
        this.stmt = this.c.createStatement();
        this.stmt.executeUpdate(query);
        this.c.commit();
    }
}
