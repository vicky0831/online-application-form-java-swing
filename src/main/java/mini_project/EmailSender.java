package mini_project;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class EmailSender {
    public static void sendUserDetails(String toEmail, String subject, String body) {
        final String fromEmail = "bangimalaysianinstitute79@gmail.com";         // ✅ Your Gmail
        final String password = "ksrv zptb dutp gkkh";       // ✅ App Password, NOT your Gmail password

        // SMTP configuration for Gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Create session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject(subject);
            msg.setText(body);
            Transport.send(msg);
            System.out.println("✅ Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("❌ Failed to send email.");
        }
    }
}
