package com.codecool.enterprise.overcomplicated.service;

import com.codecool.enterprise.overcomplicated.model.tictactoegame.AiService;
import org.springframework.web.client.RestTemplate;

public class OutsourcedAiService implements AiService {

    private RestTemplate restTemplate = new RestTemplate();
    private String aiUrl = "http://tttapi.herokuapp.com/api/v1";

    @Override
    public int nextMove(int[][] board, int player) throws Exception {

        return 0;
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
