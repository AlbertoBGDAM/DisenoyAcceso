/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Alumno
 */
public class EmailUtil {
  public static void sendEmail(Session session, String toEmail, String subject, String body) throws MessagingException {
    try {
      MimeMessage mimeMessage = new MimeMessage(session);
      mimeMessage.addHeader("Content-type","text/HTML; charset-UTF-8");
      mimeMessage.addHeader("format","flowed");
      mimeMessage.addHeader("Content-Transfer-Encoding","8bit");
        try {
            mimeMessage.setFrom(new InternetAddress("alberto.bargut@educa.jcyl.es","NoReply-JD"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
      mimeMessage.setReplyTo(InternetAddress.parse("alberto.bargut@educa.jcyl.es",false));
      mimeMessage.setSubject("prueba","UTF-8");
      mimeMessage.setText("hola, ¿me ves?","UTF-8");
      mimeMessage.setSentDate(new Date());
      mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
      System.out.println("Sending email...");
      Transport.send(mimeMessage);
      System.out.println("Email sent successfully!");
 
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }
}
