/**
 * Created by c2005062 on 01/03/2016.
 */
package product;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.SystemConfiguration;
import org.apache.commons.lang.StringUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
/**
 * This method exposes product API and get the
 * Result.
 */
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    @GET
    public JsonNode getResult() throws IOException, ConfigurationException {
        String endPointVal = getEndPointVal();
        // Calling the endPoint and getting result
        Client client = ClientBuilder.newClient();
        WebTarget target=null;
        try {
            if(StringUtils.isNotBlank(endPointVal))
            target = client.target(new URI(endPointVal));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Invocation.Builder builder =   target.request();
        JsonNode result  = builder.get(JsonNode.class);
        return result;
    }
    /**
     * This method reads the EndPoint value from EnVars
     * If not present,give public API endPoint.
     */
    private String getEndPointVal() {
        String endPointVal = null;
        endPointVal = getEndPointFromSystemConfig(endPointVal);
        //TODO : Remove hardCoded API and handle exceptions.
        if(StringUtils.isBlank(endPointVal)){
            endPointVal = "http://jsonplaceholder.typicode.com/posts/1";
        }
        return endPointVal;
    }

    private String getEndPointFromSystemConfig(String endPointVal) {
        SystemConfiguration config=new SystemConfiguration();
        Iterator<String> keys = config.getKeys();
        while (keys.hasNext()) {
            String key = keys.next();
           if("endpoint".equalsIgnoreCase(key)){
               endPointVal = config.getProperty(key).toString();
               break;
           }
        }
        return endPointVal;
    }
}