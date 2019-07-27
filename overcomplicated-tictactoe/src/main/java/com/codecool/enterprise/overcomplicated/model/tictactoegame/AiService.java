package com.codecool.enterprise.overcomplicated.model.tictactoegame;

public interface AiService {

    int nextMove(int[][] board, int player) throws Exception;
}
