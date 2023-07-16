package com.nicos.wpusher.pusher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.nicos.wpusher")
public class PusherApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(PusherApplication.class);
        application.run(args);
    }
}
