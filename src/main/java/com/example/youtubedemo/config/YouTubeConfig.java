package com.example.youtubedemo.config;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Configuration
public class YouTubeConfig {

    // private final YouTubeProperties properties;
    
    // public YouTubeConfig(YouTubeProperties properties) {
    //     this.properties = properties;
    // }

    @Bean
    public YouTube youTube() throws GeneralSecurityException, IOException {
        return new YouTube.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GsonFactory.getDefaultInstance(),
                null)
                .setApplicationName("youtube-demo")
                .build();
    }
} 