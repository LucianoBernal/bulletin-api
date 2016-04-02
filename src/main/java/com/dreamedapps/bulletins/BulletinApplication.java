package com.dreamedapps.bulletins;

import com.dreamedapps.bulletins.dto.AppInfoDTO;
import com.dreamedapps.bulletins.repository.MemoryBulletinRepository;
import com.dreamedapps.bulletins.resource.*;
import com.dreamedapps.bulletins.service.AdminService;
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
        MemoryBulletinRepository bulletinRepository = new MemoryBulletinRepository();
        StudentService studentService = new StudentService(bulletinRepository);
        AdminService adminService = new AdminService(bulletinRepository);
        environment.jersey().register(new StudentInfoResource(studentService));
        environment.jersey().register(new StudentCreationResource(studentService));
        environment.jersey().register(new StudentNewsletterInfoResource(studentService));
        environment.jersey().register(new StudentNewslatterCreationResource(studentService));
        environment.jersey().register(new SchoolCreationResource((adminService)));
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
