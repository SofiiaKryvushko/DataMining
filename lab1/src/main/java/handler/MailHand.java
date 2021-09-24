package handler;

import csv_object.Mail;
import java.util.List;

public interface MailHand {

    List<Mail> process(List<Mail> mail);

}
