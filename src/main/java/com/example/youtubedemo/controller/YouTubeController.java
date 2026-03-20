package com.example.youtubedemo.controller;

import com.example.youtubedemo.service.YouTubeService;
import com.google.api.services.youtube.model.SearchResult;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class YouTubeController {

    private final YouTubeService youTubeService;

    public YouTubeController(YouTubeService youTubeService) {
        this.youTubeService = youTubeService;
    }

    // Web interface endpoints
    @GetMapping("/")
    public String home() {
        return "youtube";
    }

    // @GetMapping("/search")
    // public String search(@RequestParam String query, Model model) {
    //     List<SearchResult> results = youTubeService.searchVideos(query);
    //     model.addAttribute("videos", results);
    //     model.addAttribute("query", query);
    //     return "youtube";
    // }

    @GetMapping("/search")
    public String search(@RequestParam(required = false) String query, Model model) {
    
        if (query != null && !query.isEmpty()) {
            List<SearchResult> results = youTubeService.searchVideos(query);
            model.addAttribute("videos", results);
        }
    
        return "youtube";
    }

    //REST API endpoints
    @GetMapping("/v1/search")
    @ResponseBody
    public List<SearchResult> searchApi(@RequestParam String query) {
        return youTubeService.searchVideos(query);
    }

 

} 