package hello;

import com.fasterxml.jackson.databind.JsonNode;
import org.glassfish.jersey.client.ClientResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**ß
 * Created by c2005062 on 01/03/2016.
 */
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    private String productUrl;

    public ProductResource(String productUrl) {
        this.productUrl = productUrl;

    }

    @GET

    public JsonNode sayHello() throws IOException {

        Client client = ClientBuilder.newClient();
        WebTarget target=null;
        try {
            target = client.target(new URI(productUrl));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Invocation.Builder builder =   target.request();
        JsonNode result  = builder.get(JsonNode.class);

        return result;
    }
}