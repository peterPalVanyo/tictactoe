package com.codecool.enterprise.overcomplicated.service;

import com.codecool.enterprise.overcomplicated.model.tictactoegame.AiService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class OutsourcedAiService implements AiService {

    private RestTemplate restTemplate = new RestTemplate();
    private String aiUrl = "http://localhost:60001/next-move";

    @Override
    public int nextMove(int[][] board, int player) throws Exception {
        String requestJson = "{\n" +
                "\t\"board\": \"" + convertBoardToSymbols(board) + "\",\n" +
                "\t\"player\": \"" + convertNumberToSymbol(player) + "\"\n" +
                "}";


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String answer = restTemplate.postForObject(aiUrl, entity, String.class);

        if (answer.equals("500")) {
            throw new Exception(aiUrl + " responded with " + "500");
        }

        return Integer.parseInt(answer);
    }



    private String convertBoardToSymbols(int[][] board) {
        String result = "";
        for (int[] row : board) {
            for (Integer spot : row) {
                result += convertNumberToSymbol(spot);
            }
        }
        return result;
    }

    private String convertNumberToSymbol(int num) {
        if (num == 1) return "O";
        if (num == -1) return "X";
        return "-";
    }
}
