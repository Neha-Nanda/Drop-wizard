package product;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by c2005062 on 01/03/2016.
 */
public class ProductApplication extends Application <Configuration>{
    public static void main(String[] args) throws Exception {
        new ProductApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        {
            final ProductResource resource = new ProductResource();
            environment.jersey().register(resource);
        }
    }


}

