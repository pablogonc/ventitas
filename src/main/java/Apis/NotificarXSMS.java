package Apis;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

    public class NotificarXSMS {
        // Find your Account Sid and Token at twilio.com/console
        public static final String ACCOUNT_SID = "AC0dbb22b9eadb164c52cd8e02d4dcfb35";
        public static final String AUTH_TOKEN = "2fddec75963132e73f1e3327c3b54923";

        public static void main(String[] args) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                    ACCOUNT_SID,
                    new com.twilio.type.PhoneNumber("+541169710820"),
                    "MGa97b42a845c5e3fe4d0255ecbd1cbc04",
                    "Your message")
                    .create();

            System.out.println(message.getSid());
        }
    }
