package com.example.petproject.config;

import com.example.petproject.repositories.impl.ParkRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.function.Supplier;

@Configuration
public class AppConfig {
    public static String helloString = "Hello from Pet project " + Instant.now().minus(2L, ChronoUnit.DAYS);

    @Bean("tspl")
    public Instant time(){
        return Instant.now().minus(2L, ChronoUnit.HOURS);
    }

    @Bean
    String applicationName(){
        return "petproject";
    }


    @Primary
    @Bean    public Supplier<Instant> timeSupplierAdvanced(){
        return () -> Instant
                .now()
                .minus(2L, ChronoUnit.DAYS);
    }

    @Bean
    public String helloString(Supplier<Instant> timeSupplier){
        return "Hello from pet project" + timeSupplier.get();
    }
}
