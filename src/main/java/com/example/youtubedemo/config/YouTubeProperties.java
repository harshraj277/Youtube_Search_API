package com.example.youtubedemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "youtube")
public class YouTubeProperties {
    private String apiKey = "AIzaSyC1XmiWPTXowOMJ-OxRR4VsF7xVVIPV0e0";
    
  
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
} 