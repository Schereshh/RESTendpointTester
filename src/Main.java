import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.*;

import javax.swing.text.html.parser.Parser;

public class Main {
    public static void main(String[] args) {
        // Public API:
        // https://jsonplaceholder.typicode.com/users
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if(responseCode != 200){
                throw new RuntimeException("HTTP response code: " + responseCode);
            } else {
                StringBuilder result = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext()) {
                    result.append(scanner.nextLine());
                }

                scanner.close();

                System.out.println(result);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
