package com.example.youtubedemo.service;

import com.example.youtubedemo.config.YouTubeProperties;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;

@Service
public class YouTubeService {

    private static final Logger logger = LoggerFactory.getLogger(YouTubeService.class);
    private final YouTube youTube;
    private final YouTubeProperties properties;

    public YouTubeService(YouTube youTube, YouTubeProperties properties) {
        this.youTube = youTube;
        this.properties = properties;
        logger.info("YouTube API Key: {}", properties.getApiKey());
    }

    public List<SearchResult> searchVideos(String query) {
        try {
            logger.info("Searching for: {}", query);
            YouTube.Search.List search = youTube.search().list(Arrays.asList("snippet"));
            String apiKey = properties.getApiKey();
            logger.info("Using API Key: {}", apiKey);
            search.setKey(apiKey);
            search.setQ(query);
            search.setType(Arrays.asList("video"));
            search.setMaxResults(10L);
            search.setFields("items(id/videoId,snippet/title,snippet/description,snippet/thumbnails/default/url)");

            SearchListResponse response = search.execute();
            return response.getItems();
        } catch (Exception e) {
            logger.error("Error searching YouTube videos: {}", e.getMessage());
            throw new RuntimeException("Error searching YouTube videos: " + e.getMessage(), e);
        }
    }
}