package parsers;
import au.com.bytecode.opencsv.CSVReader;
import csv_object.Mail;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveCollectionToTxt {

    private static final String COLON = ": ";

    private SaveCollectionToTxt() {

    }

    public static void write(List<Mail> mailList, String pathToFile) {

        try (FileWriter writer = new FileWriter(pathToFile)) {
            for (Mail mail : mailList) {
                writer.write(mail.getContent() + System.lineSeparator());
            }

            writer.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void write(HashMap<String, Integer> mailMap, String pathToFile) {

        try (FileWriter writer = new FileWriter(pathToFile)) {
            for (Map.Entry<String, Integer> mail : mailMap.entrySet()) {
                writer.write(mail.getKey() + COLON + mail.getValue() + System.lineSeparator());
            }

            writer.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
