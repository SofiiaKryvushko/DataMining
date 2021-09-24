package handler;

import csv_object.Mail;

import java.util.List;
import java.util.stream.Collectors;

public class DeleteNoNumberHand implements MailHand {

    String regex = "[^a-zA-Z^ \\t\\n\\r]";

    @Override
    public List<Mail> process(List<Mail> mail) {
        return mail
                .stream()
                .map(mail -> new Mail(mail.getType(),
                mail.getContent().replaceAll(regex, "")))
                .collect(Collectors.toList());

    }
}
