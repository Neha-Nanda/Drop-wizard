package hello;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by c2005062 on 01/03/2016.
 */
public class ProductApplication extends Application<ProductConfiguration> {
    public static void main(String[] args) throws Exception {
        new ProductApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ProductConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ProductConfiguration configuration,
                    Environment environment) {
        final ProductResource resource = new ProductResource(
                configuration.getEndPoint()

        );
        environment.jersey().register(resource);
    }

}

