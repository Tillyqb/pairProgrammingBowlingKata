package com.accenture.Services;

import org.junit.Test;

import static com.accenture.Services.RandomGame.makeRandomGame;

public class testRandomGame {
    @Test
    public void randomGameGeneratesProperly(){
        makeRandomGame();
    }

    @Test
    public void anotherRandomGameGeneratesProperly(){
        makeRandomGame();
    }

    @Test
    public void stillAnotherTenRandomGameGeneratesProperly(){
        for (int k = 0; k <= 1000; k ++) {
            makeRandomGame();
        }
    }
}
