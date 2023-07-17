package com.nicos.wpusher.consumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("mpusher.consumer")
@Data
public class ConsumerProperties {

    private String type;
}
