package com.codecool.enterprise.overcomplicated.tictactoeaiservice.controller;

import com.codecool.enterprise.overcomplicated.tictactoeaiservice.model.RequestToTTTApi;
import com.codecool.enterprise.overcomplicated.tictactoeaiservice.model.ResponseFromTTTApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AiController {

    RestTemplate restTemplate = new RestTemplate();
    private String aiUrl = "http://tttapi.herokuapp.com/api/v1/";


    @PostMapping("/next-move")
    public String nextMove(@RequestBody RequestToTTTApi requestToTTTApi){
        String board = requestToTTTApi.getBoard();
        String player = requestToTTTApi.getPlayer();
        ResponseFromTTTApi forObject = restTemplate.getForObject(aiUrl + board + "/" + player, ResponseFromTTTApi.class);
        if(forObject != null) {
        return forObject.getRecommendation();
        }
        return "500";
    }




}
