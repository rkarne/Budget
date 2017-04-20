/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.Properties;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author c0689497
 */
@Named
@ApplicationScoped

public class SendMail extends Authenticator {

	/*public String send() {

		final String username = "roja4jayashree@gmail.com";
		final String password = "KARNE2jayashre";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
                        @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("roja4jayashree@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("roja4jayashree@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			
		}
               return "index";
	} */
    
    public static void sendMessage(String recipient, String subject, String message) throws MessagingException {

        if ( theService == null ) {
            theService = new SendMail();
        }

        MimeMessage mimeMessage = new MimeMessage(mailSession);

	mimeMessage.setFrom(new InternetAddress(FROM));
	mimeMessage.setSender(new InternetAddress(FROM));
	mimeMessage.setSubject(subject);
        mimeMessage.setContent(message, "text/plain");

        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        Transport transport = mailSession.getTransport("smtps");
        transport.connect(HOST, PORT, USER, PASSWORD);

        transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
        transport.close();

    }

    private SendMail() {
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", HOST);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.from", FROM);
        props.put("mail.smtps.quitwait", "false");

        mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
    }

    private static SendMail theService = null;

    private static Session mailSession;

    private static final String HOST = "smtp.d.umn.edu";
    private static final int PORT = 465;
    private static final String USER = "";     // Must be valid user in d.umn.edu domain, e.g. "smit0012"
    private static final String PASSWORD = ""; // Must be valid password for smit0012
    private static final String FROM = "";     // Full info for user, e.g. "Fred Smith <smit0012@d.umn.edu>"
    
}
