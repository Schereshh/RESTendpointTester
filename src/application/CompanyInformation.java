package application;

import org.json.simple.JSONObject;

import java.sql.SQLException;

public class CompanyInformation {
    private String name;
    private String catchPrase;
    private String bs;

    public CompanyInformation(Object o) throws SQLException, ClassNotFoundException {
        JSONObject companyData = (JSONObject) ((JSONObject) o).get("company");
        this.name       = companyData.get("name").toString();
        this.catchPrase = companyData.get("catchPhrase").toString();
        this.bs         = companyData.get("bs").toString();

        DBConnect db = new DBConnect("localhost", "users", "postgres", "1234");

        db.updateDB(
                "INSERT INTO company (name, catch_phrase, bs)" +
                        "VALUES ('" + this.name + "', '" + this.catchPrase + "', '" + this.bs + "');"
        );
    }
}
