package com.codecool.enterprise.overcomplicated.service;

import com.codecool.enterprise.overcomplicated.model.Comic;
import org.springframework.web.client.RestTemplate;

public class ComicService {

    private RestTemplate restTemplate = new RestTemplate();
    private String apiUrl = "http://localhost:60003/random-comic";

    public Comic getComic() {
        Comic comic = restTemplate.getForObject(apiUrl, Comic.class);
        if (comic == null) return null;
        return comic;
    }
}
