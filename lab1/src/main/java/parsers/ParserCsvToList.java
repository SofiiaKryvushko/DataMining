package parsers;

import au.com.bytecode.opencsv.CSVReader;
import csv_object.Mail;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParserCsvToList {

    private static final int indexType = 0;
    private static final int indexValue = 1;

    private ParserCsvToList() {

    }

    public static List<Mail> read(String pathToFile, char separator, char quotChar)
    throws Exception {

        CSVReader reader = new CSVReader(new FileReader(pathToFile), separator, quotChar);
        List<Mail> mailList = new ArrayList<>();
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            mailList.add(new Mail(
                    nextLine[indexType],
                    nextLine[indexValue]));
        }

        return mailList;

    }

}
