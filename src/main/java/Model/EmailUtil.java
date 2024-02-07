package Model;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
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
 *@author ALBERTO BARCALA GUTIÉRREZ
 */

public class EmailUtil {
	private final String fromEmail = "barcalaalberto@gmail.com";
	private final String password = "tyvrgqdhbkgthycu";

	public void sendEmail(String Nombre,String nuevaContraseña) {
		final String toEmail = Nombre;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.user", fromEmail);
		props.put("mail.smtp.ssl.enable", "TLSv1.2");

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));
			msg.setSubject("MiAplicacion", "UTF-8");
			msg.setSentDate(new Date());
			String nuevaContrasena = "Garbagool"; 
			String body = "<html><h1>Nueva contraseña</h1><p>Hola</p>"
					+ "<p>Desde Nuestra aplicacion hemos detectado un cambio en tu contraseña, aqui te dejo la nueva</p>"
					+ "<p>" + nuevaContrasena + "</p></html>";
			msg.setContent(body, "text/html");
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			Transport.send(msg);
		} catch (MessagingException | UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
}
