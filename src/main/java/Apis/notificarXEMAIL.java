package Apis;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

public class notificarXEMAIL {
    /**
     * Run:
     */
    public static void main(String[] args) throws MailjetException {
        MailjetRequest request;
        MailjetResponse response;

        ClientOptions options = ClientOptions.builder().apiKey(System.getenv("bb31b8ff155bce268c81cf05498bfb24")).apiSecretKey(System.getenv("487a584e2cbce76ab601c3c9372da6e0")).build();

        MailjetClient client = new MailjetClient(ClientOptions.builder().apiKey(System.getenv("bb31b8ff155bce268c81cf05498bfb24")).apiSecretKey(System.getenv("487a584e2cbce76ab601c3c9372da6e0")).build());

        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "stevenhca12@gmail.com")
                                        .put("Name", "Steven"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", "stevenhca12@gmail.com")
                                                .put("Name", "Steven")))
                                .put(Emailv31.Message.SUBJECT, "My first Mailjet Email!")
                                .put(Emailv31.Message.TEXTPART, "Greetings from Mailjet!")
                                .put(Emailv31.Message.HTMLPART, "<h3>Dear passenger 1, welcome to <a href=\"https://www.mailjet.com/\">Mailjet</a>!</h3><br />May the delivery force be with you!")));
        response = client.post(request);
        System.out.println(response.getStatus());
        System.out.println(response.getData());
    }
}