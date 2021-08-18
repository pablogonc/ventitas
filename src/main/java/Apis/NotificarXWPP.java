package Apis;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

public class NotificarXWPP {
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC0dbb22b9eadb164c52cd8e02d4dcfb35";
    public static final String AUTH_TOKEN = "[AuthToken]";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5491169710820"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "Your Yummy Cupcakes Company order of 1 dozen frosted cupcakes has shipped and should be delivered on July 10, 2019. Details: http://www.yummycupcakes.com/")
                .create();

        System.out.println(message.getSid());
    }
}
