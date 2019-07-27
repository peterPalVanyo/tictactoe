package com.codecool.enterprise.overcomplicated.model;

import com.codecool.enterprise.overcomplicated.model.tictactoegame.AiService;
import com.codecool.enterprise.overcomplicated.model.tictactoegame.TictactoeGame;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class TictactoeGameTest {

    @Mock
    AiService aiService;
    private TictactoeGame tictactoeGame;


    @BeforeEach
    void init() {
        tictactoeGame = new TictactoeGame(aiService);
    }


    @Test
    public void stepConversion() {
        int[] exp = new int[]{2, 2};
        assertEquals(exp[0], tictactoeGame.convertStepToCoordinate(8)[0]);
        assertEquals(exp[1], tictactoeGame.convertStepToCoordinate(8)[1]);
    }


    @Test
    public void stepPlayerOneToZeroZero(){
        tictactoeGame.step(0);
        assertEquals(1 ,tictactoeGame.getBoard()[0][0]);
    }



    @Test
    public void checkPlayerWin() throws Exception {
        assertFalse(tictactoeGame.getIsOver());
        tictactoeGame.nextTurn(1);
        tictactoeGame.nextTurn(4);
        tictactoeGame.nextTurn(7);
        assertTrue(tictactoeGame.getIsOver());
        assertEquals("1", tictactoeGame.getWinner());
    }





}