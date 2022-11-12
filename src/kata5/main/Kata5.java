/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata5.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import kata5.view.HistogramDisplay;
import kata5.model.Histogram;
import kata5.model.Mail;
import kata5.view.MailHistogramBuilder;
import kata5.view.MailListReader;
import kata5.view.MailListReaderBD;
/**
 *
 * @author yadai
 */
public class Kata5 {
    public static void main(String[] args) throws IOException {
 
	// List<Mail> emails_valid = MailListReader.read("C:\\Users\\yadai\\Documents\\NetBeansProjects\\Kata5P2\\src\\kata5\\main\\email.txt"); 
        
        MailListReaderBD cox = new MailListReaderBD("C:\\Users\\yadai\\Documents\\NetBeansProjects\\Kata5P2\\src\\kata5\\main\\KATA5.db");
        cox.connect();
        List<Mail> emails = cox.read();
        Histogram<String> histogram = MailHistogramBuilder.build(emails);

        //view
        HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM DISPLAY", histogram);
        histogramDisplay.execute();
        
        cox.close();
    }
}
