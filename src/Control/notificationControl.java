package Control;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class notificationControl {
    public static void main (String args[])
    {
        final String username = "epiclol1998@gmail.com"; // to be added
        final String password = "mrshark1998"; // to be added

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("epiclol1998@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("jtchen002@e.ntu.edu.sg")); // to be added an email addr
            message.setSubject("Testing Subject");
            message.setText("Dear Jee Wern,"
                    + "\n\n Imma SneK Snek dat ass!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
