package com.amr.shop.usr.user_context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.amr.shop.usr.user_context"})
public class UserContextApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserContextApplication.class, args);
    }
}
