package application;

import java.sql.*;

public class DBConnect {
    private Connection c;
    private Statement stmt = null;
    public DBConnect (String dbHost, String dbName, String username, String password) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        this.c = DriverManager.getConnection("jdbc:postgresql://" + dbHost + ":5432/" + dbName + "", username, password);

        this.c.setAutoCommit(false);
    }

    public void updateDB (String query) throws SQLException {
        this.stmt = this.c.createStatement();
        this.stmt.executeUpdate(query);
        this.c.commit();
    }
}
