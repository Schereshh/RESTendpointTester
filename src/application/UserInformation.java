package application;

import org.json.simple.JSONObject;

import java.sql.SQLException;

public class UserInformation {
    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    public UserInformation(Object o) throws SQLException, ClassNotFoundException {
        this.id       = Integer.parseInt(((JSONObject) o).get("id").toString());
        this.name     = ((JSONObject) o).get("name").toString();
        this.username = ((JSONObject) o).get("username").toString();
        this.email    = ((JSONObject) o).get("email").toString();
        this.phone    = ((JSONObject) o).get("phone").toString();
        this.website  = ((JSONObject) o).get("website").toString();

        DBConnect db = new DBConnect("localhost", "users", "postgres", "1234");

        db.updateDB(
                "INSERT INTO users (user_id, name, username , email, phone, website)" +
                      "VALUES (" + this.id + ", '" + this.name + "', '" + this.username + "' ,'" + this.email + "', '" + this.phone + "', '" + this.website + "')"
        );
    }
}

