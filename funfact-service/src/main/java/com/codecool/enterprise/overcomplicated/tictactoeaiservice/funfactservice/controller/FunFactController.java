package com.codecool.enterprise.overcomplicated.tictactoeaiservice.funfactservice.controller;

import com.codecool.enterprise.overcomplicated.tictactoeaiservice.funfactservice.model.Fact;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class FunFactController {

    @Value("${apiUrl}")
    private String apiUrl;

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/get-random-fact")
    public String getRandomFact() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);


        try{
            Fact fact = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, Fact.class).getBody();
            return fact.getValue() != null ? fact.getValue() : "500";
        }catch(Exception e){
            System.out.println("exception");
        }

        return "500";
    }



}
