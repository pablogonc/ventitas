package apis;

import model.user.Normal;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class NotificarXEMAIL implements Notificar{

    @Override
    public void notificar(Normal usuario) {

        final String username = "ventitasSA425@gmail.com";
        final String password = "ventitas1234";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ventitasSA425@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(usuario.getMail())
            );
            message.setSubject("Pedido en Camino"); // tema del mail
            message.setText("Buenas,"
                    + "\n\n Su pedido se encuentra en camino.\n Muchas Gracias por su Compra. "); // cuerpo

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}