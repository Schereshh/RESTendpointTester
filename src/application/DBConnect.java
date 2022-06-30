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

    public void queryWrite (String query) throws SQLException {
        this.stmt = this.c.createStatement();
        ResultSet rs = this.stmt.executeQuery(query);
        while(rs.next()) {
            int id = rs.getInt("actor_id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            System.out.println("actor_id = " + id + "\n" +
                    "first_name = " + first_name + "\n" +
                    "last_name = " + last_name + "\n" +
                    "-------");
        }
    }
}
