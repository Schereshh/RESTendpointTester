package application;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    public Logger logger;
    FileHandler fh;

    public Log(String fileName) throws SecurityException, IOException {
        File f = new File(fileName);
        if(!f.exists()) {
            f.createNewFile();
        }

        fh = new FileHandler(fileName, true);
        logger = Logger.getLogger("test");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }

    public void newLine() throws IOException {
        FileWriter fw = new FileWriter("log.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("------------------------------");
        bw.newLine();
        bw.close();
    }
}
