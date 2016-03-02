package hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by c2005062 on 01/03/2016.
 */
public class ProductConfiguration extends Configuration{
    @NotEmpty
    private String endPoint;


    @JsonProperty
    public String getEndPoint() {
        return endPoint;
    }




}
