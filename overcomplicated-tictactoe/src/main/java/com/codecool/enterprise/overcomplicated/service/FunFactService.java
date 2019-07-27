package com.codecool.enterprise.overcomplicated.service;

import org.springframework.web.client.RestTemplate;

public class FunFactService {

    private RestTemplate restTemplate = new RestTemplate();
    private String apiUrl = "http://localhost:60002/get-random-fact";

    public String getFunFact() {
        String fact = restTemplate.getForObject(apiUrl, String.class);
        return fact;
    }
}
