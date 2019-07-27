package com.codecool.enterprise.overcomplicated.tictactoeaiservice.model;

import lombok.Data;

@Data
public class ResponseFromTTTApi {

    private String game;
    private String player;
    private String recommendation;
    private String strength;

}
