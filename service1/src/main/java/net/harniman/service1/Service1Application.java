package net.harniman.service1;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.harniman.service1.health.TemplateHealthCheck;
import net.harniman.service1.resources.DateTimeResource;
import net.harniman.service1.resources.VersionResource;

public class Service1Application
        extends Application<Service1Configuration> {
    public static void main(String[] args) throws Exception {
        new Service1Application().run(args);
    }

    @Override
    public String getName() {
        return "service1";
    }

    @Override
    public void initialize(Bootstrap<Service1Configuration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(Service1Configuration configuration,
            Environment environment) {
        final VersionResource vresource = new VersionResource(
                configuration.getVersion());
        final DateTimeResource dtresource = new DateTimeResource();
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(
                configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(vresource);
        environment.jersey().register(dtresource);
    }

}
