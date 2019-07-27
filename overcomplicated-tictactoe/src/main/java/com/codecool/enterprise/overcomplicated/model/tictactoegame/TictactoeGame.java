package com.codecool.enterprise.overcomplicated.model.tictactoegame;


public class TictactoeGame {

    private int[][] board;
    private boolean isOver;
    private String DRAW = "DRAW";
    private int EMPTY = 0;
    private int PLAYER = 1;
    private boolean isPlayerMoved = true;
    private String winner;

    private AiService aiService;

    public TictactoeGame(AiService aiService) {
        this.aiService = aiService;
        initBoard();
    }

    public boolean getIsOver() {
        return this.isOver;
    }

    public String getWinner() {
        return winner;
    }

    public void initBoard() {
        this.board = new int[][]{{0,0,0,}, {0,0,0}, {0,0,0}};
    }

    public int[][] getBoard() {
        return this.board;
    }

    public void step(int step) {
        int[] coordinate = convertStepToCoordinate(step);
        int row = coordinate[0];
        int column = coordinate[1];
        int spot = this.board[row][column];
        if (spot == EMPTY) {
            this.board[row][column] = 1;
            isPlayerMoved = true;
        } else {
            isPlayerMoved = false;
        }
    }

    private void makeOpponentMove(int step) {
        int[] coordinate = convertStepToCoordinate(step);
        int row = coordinate[0];
        int column = coordinate[1];
        int spot = this.board[row][column];
        if (spot == EMPTY) {
            this.board[row][column] = -1;
        }
    }

    public int[] convertStepToCoordinate(int step) {
        int row = 0;
        int column = 0;
        if (step >= 0 && step <= 2) row = 0;
        if (step >= 3 && step <= 5) row = 1;
        if (step >= 6 && step <= 8) row = 2;
        if (step % 3 == 0) column = 0;
        if (step % 3 == 1) column = 1;
        if (step % 3 == 2) column = 2;
        return new int[]{row, column};
    }


    public void nextTurn(int playerMove) throws Exception {
        if (!isOver) {
            step(playerMove);
            if (isEmptySpots() && isPlayerMoved) makeOpponentMove(aiService.nextMove(board, PLAYER));
            if (!isEmptySpots() || !theWinner().equals(DRAW)) {
                isOver = true;
                winner = theWinner();
            }
        }
    }

    public boolean isEmptySpots() {
        for (int[] row : board) {
            for (Integer spot : row){
                if(spot == EMPTY) return true;
            }
        }
        return false;
    }

    private String theWinner() {
        boolean winnerIsFound = false;
        String winner = DRAW;

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] != EMPTY && !winnerIsFound) {
                    winner = Integer.toString(board[i][0]);
                    winnerIsFound = true;

                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] != EMPTY && !winnerIsFound) {
                    winner = Integer.toString(board[0][i]);
                    winnerIsFound = true;
                }
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] != EMPTY && !winnerIsFound) {
                winner = Integer.toString(board[0][0]);
                winnerIsFound = true;
            }
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] != EMPTY && !winnerIsFound) {
                winner = Integer.toString(board[0][2]);
                winnerIsFound = true;
            }
        }

        return winner;
    }


}
