package handler;

import csv_object.Mail;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class LowerCaseHand implements MailHand {

    @Override
    public List<Mail> process(List<Mail> mail) {
        return mail
                .stream()
                .map(mail -> new Mail(mail.getType(), mail.getContent().toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

}
