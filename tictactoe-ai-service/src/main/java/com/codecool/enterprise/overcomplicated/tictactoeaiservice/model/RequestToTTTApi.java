package com.codecool.enterprise.overcomplicated.tictactoeaiservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestToTTTApi {

    private String board;
    private String player;

}
