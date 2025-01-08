package com.example.bsujavaexam.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "pp.message")
public class MessageConfiguration {
    private String noErrors;
    private String textFileUpload;
}
