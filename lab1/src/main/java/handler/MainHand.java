package handler;

import csv_object.Mail;

import java.util.List;

public class MainHand implements MailHand{

    @Override
    public List<Mail> process(List<Mail> mail) {
        mail = new LowerCaseHand().process(mail);
        mail = new DeleteNoNumberHand().process(mail);
        return new DeleteStopWordHand().process(mail);
    }
}
