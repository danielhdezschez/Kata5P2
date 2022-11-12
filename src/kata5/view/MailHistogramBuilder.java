/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata5.view;


import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;

/**
 *
 * @author yadai
 */
public class MailHistogramBuilder {
    
    public static Histogram<String> build(List<Mail> emails) {
        Histogram<String> histogram = new Histogram<String>();
        for(Mail email : emails) {
            histogram.increment(email.getDomain());
        }
        return histogram;
    }
    
}
