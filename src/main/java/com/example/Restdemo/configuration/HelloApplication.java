package com.example.Restdemo.configuration;


import io.swagger.jaxrs.config.BeanConfig;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
//Add comment
@ApplicationPath("/api")
public class HelloApplication extends Application {
    public HelloApplication(@Context ServletConfig servletConfig) {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("TODO Api");
        beanConfig.setBasePath("/Restdemo/api");
        beanConfig.setResourcePackage("com.example.Restdemo");
        beanConfig.setScan(true);
    }
}