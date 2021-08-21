package apis;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import model.user.Normal;

public class NotificarXWPP implements Notificar{
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC0dbb22b9eadb164c52cd8e02d4dcfb35";
    public static final String AUTH_TOKEN = "2fddec75963132e73f1e3327c3b54923";

    @Override
    public void notificar(Normal usuario) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+54" +  usuario.getTelefono()),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "Su pedido se encuentra en camino. Gracias por su compra :) .")
                .create();

        System.out.println(message.getSid());
    }
}
