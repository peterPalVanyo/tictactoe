package com.codecool.enterprise.overcomplicated.comicsservice.controller;

import com.codecool.enterprise.overcomplicated.comicsservice.model.Comic;
import com.codecool.enterprise.overcomplicated.comicsservice.model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
public class ComicsController {

    RestTemplate restTemplate = new RestTemplate();
    Random random = new Random();

    @Value("${apiUrl}")
    String apiUrl;

    @GetMapping("/random-comic")
    public Response getRandomComic() {
        int num = random.nextInt(1928) + 1;
        Comic comic = restTemplate.getForObject(apiUrl + num + "/info.0.json", Comic.class);
        if(comic == null) return null;
        return Response.builder()
                .img(comic.getImg())
                .hoverText(comic.getAlt())
                .build();
    }

}
