package alertEmailSend;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class mailAlert {
	
    public static void main(String[] args) {
    	sendMail();
    }

    private static void sendMail() {
    	String from = "sumaiya@lrglobalbd.com";
        String password = "sumaiya@978#";
        String to = "sumaiya@lrglobalbd.com";
        Properties properties = new Properties();
            
        properties.put("mail.smtp.auth", "true");
    	properties.put("mail.smtp.starttls.enable", "true");
    	properties.put("mail.smtp.starttls.required", "true");
    	properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
    	properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {                                                 
               return new PasswordAuthentication(from, password);
           }
        });
        try {
             MimeMessage message = new MimeMessage(session);

             message.setFrom(new InternetAddress(from));
             message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
             message.setSubject("Error Test Email");
             message.setText("This is a test email!");
                
             Transport.send(message);
             System.out.println("Message sent successfully!");
        } catch (MessagingException ex) {
             ex.printStackTrace();
        }		
	}    
}
