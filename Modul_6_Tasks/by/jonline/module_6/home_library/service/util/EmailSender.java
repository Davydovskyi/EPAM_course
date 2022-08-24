package by.jonline.module_6.home_library.service.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

	private static final String EMAIL = "youremail@mail.com";// your email
	private static final String PASSWORD = "***************";// your password

	private EmailSender() {
	}

	public static void sendEmail(String subject, String text, String... recipients) throws MessagingException {

		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.host", "smtp.mail.ru");
		properties.put("mail.smtp.host", "smtp.mail.ru");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.ssl.checkserveridentity", "true");
		properties.put("mail.smtp.socketFactory.fallback", "false");

		Session mailSession = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL, PASSWORD);
			}
		});

		Address[] addresses = new Address[recipients.length];
		MimeMessage message = new MimeMessage(mailSession);

		for (int i = 0; i < recipients.length; i++) {
			addresses[i] = new InternetAddress(recipients[i]);
		}

		message.setFrom(new InternetAddress(EMAIL));
		message.addRecipients(Message.RecipientType.TO, addresses);
		message.setSubject(subject);
		message.setText(text);

		Transport.send(message);
	}
}