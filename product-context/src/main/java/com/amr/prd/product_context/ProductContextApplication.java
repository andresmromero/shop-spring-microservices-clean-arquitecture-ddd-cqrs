package com.amr.prd.product_context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.amr.prd.product_context")
public class ProductContextApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProductContextApplication.class, args);
    }

}