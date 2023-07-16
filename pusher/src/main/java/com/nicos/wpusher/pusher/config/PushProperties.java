package com.nicos.wpusher.pusher.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "mpusher.push")
@Configuration
@Data
public class PushProperties {

    private String type;

    private String transportType;

    private String topic;
}
