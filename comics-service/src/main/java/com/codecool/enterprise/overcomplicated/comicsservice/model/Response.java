package com.codecool.enterprise.overcomplicated.comicsservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private String img;
    private String hoverText;
}
