package com.nicos.wpusher.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.nicos.wpusher")
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ConsumerApplication.class);
        application.run(args);
    }
}
