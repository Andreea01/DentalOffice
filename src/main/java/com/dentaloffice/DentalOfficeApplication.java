package com.dentaloffice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.dentaloffice", exclude = {
        SecurityAutoConfiguration.class})
public class DentalOfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DentalOfficeApplication.class);
    }
}