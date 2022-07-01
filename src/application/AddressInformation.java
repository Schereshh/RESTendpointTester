package application;

import org.json.simple.JSONObject;

import java.sql.SQLException;

public class AddressInformation {
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    public AddressInformation (Object o) throws SQLException, ClassNotFoundException {
        JSONObject addressData = (JSONObject) ((JSONObject) o).get("address");
        this.street  = addressData.get("street").toString();
        this.suite   = addressData.get("suite").toString();
        this.city    = addressData.get("city").toString();
        this.zipcode = addressData.get("zipcode").toString();

        DBConnect db = new DBConnect("localhost", "users", "postgres", "1234");

        db.updateDB(
                "INSERT INTO address(zipcode, city, street, suite)" +
                        "VALUES ('" + this.zipcode+ "', '" + this.city + "', '" + this.street + "', '" + this.suite + "')"
        );
    }
}
