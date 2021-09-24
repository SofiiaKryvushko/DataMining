package build_histograms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import csv_object.Mail;


public class BuildHistogramWordLength extends BuildHistogram {

    public static void build(List<Mail> mailList, String fileName) throws IOException {
        List<Integer> wordsLength = getWordsLengthList(mailList);
        String title = "Довжина слів (середня довжина - " + findArithmeticMean(wordsLength) + ")";
        build(getWordsLengthList(mailList), fileName,
                title, "Довжина слова", "Частота зустрічей");
    }

    private static List<Integer> getWordsLengthList(List<Mail> mailList) {
        List<Integer> lengthList = new ArrayList<>();
        for (Mail mail : mailList) {
            for (String s : mail.getContent().split(" ")) {
                if (s.length() != 0) {
                    lengthList.add(s.length());
                }
            }
        }
        return lengthList;
    }

}
