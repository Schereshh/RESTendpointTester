package application;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        // Connecting to public API:
        // https://jsonplaceholder.typicode.com/users
        try {
            // Instantiate the custom logger class
            Log APILog = new Log("log.txt");
            APILog.logger.setLevel(Level.INFO);


            URL url = new URL("https://jsonplaceholder.typicode.com/users");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if(responseCode != 200){
                APILog.logger.warning("Conenction failed to: " + url + "\n" +
                        "Response code: " + responseCode + "\n");
                APILog.newLine();
                throw new RuntimeException("HTTP response code: " + responseCode);
            } else {

                APILog.logger.info("HTTP OK 200\n" +
                        "Connection established to: " + url + "\n");
                APILog.newLine();

                StringBuilder result = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext()) {
                    result.append(scanner.nextLine());
                }

                scanner.close();

                System.out.println(result);

                DBConnect db = new DBConnect("localhost", "dvdrental", "postgres", "1234");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
