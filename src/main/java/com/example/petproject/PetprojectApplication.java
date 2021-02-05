package com.example.petproject;

import org.apache.naming.factory.BeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PetprojectApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(PetprojectApplication.class);

    public static void main(String[] args) {
//        System.out.println(AppConfig.helloString);
        SpringApplication.run(PetprojectApplication.class, args);
    }

}
