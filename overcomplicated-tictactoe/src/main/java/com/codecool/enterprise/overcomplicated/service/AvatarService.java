package com.codecool.enterprise.overcomplicated.service;

import java.util.Random;

public class AvatarService {

    Random random = new Random();

    public String getAvatar() {
        return  "https://api.adorable.io/avatars/90/" + random.nextInt(500) +  ".png";
    }
}
