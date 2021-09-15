package com.accenture.Services;

import java.util.ArrayList;
import java.util.List;

import static com.accenture.Services.Game.*;

public class RandomGame {


    public static void makeRandomGame() {
        newGame();
        for (int i = 1; i<=10; i++){
            List<Integer> frame = new ArrayList<>();
            int ball = roll(10);
            frame.add(ball);
            if (i <= 9) {
                if (frame.get(0) < 10) {
                    ball = roll((10 - frame.get(0)));
                    frame.add(ball);
                }
            } else {

                if (frame.get(0) == 10) {
                    ball = roll(10);
                    frame.add(ball);

                    if (frame.get(1) == 10) {
                        ball = roll(10);
                        frame.add(ball);

                    } else {
                        ball = roll(10 - frame.get(1));
                        frame.add(ball);
                    }
                } else{
                    ball = roll(10 - frame.get(0));
                    frame.add(ball);
                    if (frame.get(0) + frame.get(1) == 10) {
                        ball = roll(10);
                        frame.add(ball);
                    }
                }

            }
            gameScoreHash.put(String.valueOf(i), frame);
        }
        System.out.println(gameScoreHash);
        System.out.println(score());
    }
}

