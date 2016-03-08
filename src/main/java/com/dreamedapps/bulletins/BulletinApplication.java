package com.dreamedapps.bulletins;

import com.dreamedapps.bulletins.dto.AppInfoDTO;
import com.dreamedapps.bulletins.repository.BulletinRepository;
import com.dreamedapps.bulletins.resource.StudentCreationResource;
import com.dreamedapps.bulletins.resource.StudentInfoResource;
import com.dreamedapps.bulletins.resource.StudentNewsletterResource;
import com.dreamedapps.bulletins.service.StudentService;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class BulletinApplication extends Application<BulletinAppConfiguration>{
    public static void main(String[] args) throws Exception {
        new BulletinApplication().run(args);
    }

    @Override
    public void run(BulletinAppConfiguration appConfig, Environment environment) throws Exception {
        BulletinRepository bulletinRepository = new BulletinRepository();
        StudentService studentService = new StudentService(bulletinRepository);
        environment.jersey().register(new StudentInfoResource(studentService));
        environment.jersey().register(new StudentCreationResource(studentService));
        environment.jersey().register(new StudentNewsletterResource(studentService));
    }

    @Override
    public void initialize(Bootstrap<BulletinAppConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<Configuration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(Configuration configuration) {
                SwaggerBundleConfiguration swaggerConfig = new SwaggerBundleConfiguration();
                swaggerConfig.setResourcePackage("com.dreamedapps.bulletins.resource");
                swaggerConfig.setTitle("Bulletin API");
                swaggerConfig.setDescription("Bulletin Management Service");
                swaggerConfig.setVersion(new AppInfoDTO().getVersion());
                return swaggerConfig;
            }
        });
        super.initialize(bootstrap);
    }
}
