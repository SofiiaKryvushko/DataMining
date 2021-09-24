package main;

import build_histograms.BuildHistogramSentenceLength;
import build_histograms.BuildHistogramWordLength;
import build_histograms.BuildHistogramWordsCounter;
import csv_object.Mail;
import handler.MainHand;
import parsers.ParserCsvToList;
import parsers.SaveCollectionToTxt;
import words_counter.WordsCounter;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String FILE_PATH = "src/main/resources/sms-spam-corpus.csv";
    private static final String OUTPUT_DIRECTORY = "output/";
    private static final String TYPE_HAM = "ham";
    private static final String TYPE_SPAM = "spam";
    private static final char SEPARATOR = ',';
    private static final char QUOT_CHAR = '\n';

    public static void main(String[] args) throws Exception {
        List<Mail> allMails = ParserCsvToList.read(FILE_PATH, SEPARATOR, QUOT_CHAR);

        List<Mail> ham = allMails
                .stream()
                .filter(m -> m.getType().equals(TYPE_HAM))
                .collect(Collectors.toList());


        List<Mail> spam = allMails
                .stream()
                .filter(m -> m.getType().equals(TYPE_SPAM))
                .collect(Collectors.toList());

        spam = new MainHand().process(spam);
        ham = new MainHand().process(ham);

        SaveCollectionToTxt.write(spam, OUTPUT_DIRECTORY + "sms-spam-corpus.txt");
        SaveCollectionToTxt.write(ham, OUTPUT_DIRECTORY + "sms-ham-corpus.txt");


        SaveCollectionToTxt.write(new WordsCounter().process(spam),
                OUTPUT_DIRECTORY + "spamWords.txt");


        SaveCollectionToTxt.write(new WordsCounter().process(ham),
                OUTPUT_DIRECTORY + "hamWords.txt");


        BuildHistogramWordLength.build(spam, OUTPUT_DIRECTORY + "spamLengthWord.PNG");

        BuildHistogramWordLength.build(ham, OUTPUT_DIRECTORY + "hamLengthWord.PNG");

        BuildHistogramSentenceLength.build(spam, OUTPUT_DIRECTORY + "spamLengthSentence.PNG");

        BuildHistogramSentenceLength.build(ham, OUTPUT_DIRECTORY + "hamLengthSentence.PNG");

        BuildHistogramWordsCounter.build(spam, OUTPUT_DIRECTORY + "spamMostFrequentWords.PNG");

        BuildHistogramWordsCounter.build(ham, OUTPUT_DIRECTORY + "hamMostFrequentWords.PNG");

    }
}
