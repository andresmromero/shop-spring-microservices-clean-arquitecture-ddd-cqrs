package com.amr.ctg.catalog_context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.amr.ctg.catalog_context")
public class CatalogContextApplication {

    public static void main(String[] args) {

        SpringApplication.run(CatalogContextApplication.class, args);
    }

}
