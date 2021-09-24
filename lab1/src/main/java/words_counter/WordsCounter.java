package words_counter;
import csv_object.Mail;
import handler.MailHandler;
import java.util.HashMap;
import java.util.List;

public class WordsCounter {


    private static final String SPACE = " ";

    public HashMap<String, Integer> process(List<Mail> mailList) {
        HashMap<String, Integer> wordsCountMap = new HashMap<>();
        for(Mail mail : mailList) {
            for(String s : mail.getContent().split(SPACE)) {
                if(wordsCountMap.containsKey(s) && !s.equals("")) {
                    wordsCountMap.put(s, wordsCountMap.get(s)+1);
                } else {
                    wordsCountMap.put(s, 1);
                }
            }
        }
        return wordsCountMap;
    }

}
