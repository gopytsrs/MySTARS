package Control;

import Entity.CourseRegistration;
import java.util.Properties;
import Entity.Student;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This class represents notifications sent by email
 */
public class notificationControl implements notification{
    /**
     * Creates a notification
     */
    public notificationControl(){}

    /**
     * This method sends a notification to the student who got assigned into a course
     * @param S The student
     * @param C The course registered
     */
    public void sendnotification(Student S, CourseRegistration C)
    {
        final String username = "cz2002testemail@gmail.com"; // to be added
        final String password = "ilovebcg2"; // to be added

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
            message.setFrom(new InternetAddress("cz2002testemail@gmail.com.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(S.getEmail())); // to be added an email addr
            message.setSubject("Assigning of course");
            message.setText("Dear "+S.getName()+","
                    + "\n\n Congratulations, you have attained a spot in "+ C.getCourseName() +","+C.getCourseCode()+","+C.getIndex().getIndexNo());

            Transport.send(message);

            //System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
