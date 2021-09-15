package com.accenture.Services;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class testGame {

    @Test
    public void canRollBall() {
        int result = Game.roll(10);
        Assert.assertTrue((result >= 0));
        Assert.assertTrue((result <= 10));
    }

    @Test
    public void frameTotalCannotBeOverTen() {
        int ball1 = Game.roll(10);
        int ball2 = Game.roll(10 - ball1);
        int frameScore = ball1 + ball2;
        Assert.assertTrue(frameScore <= 10);
    }
    @Test
    public void testFrameIteratorGeneration() {
        Assert.assertEquals(10, Game.frames.size());
        Assert.assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), Game.frames);
    }

    @Test
    public void testScoreTabulation() {
        Game.newGame();
        Game.gameScoreHash.put("1", List.of(5, 2));
        Game.gameScoreHash.put("2", List.of(10));
        Game.gameScoreHash.put("3", List.of(10));
        Game.gameScoreHash.put("4", List.of(9, 1));
        Game.gameScoreHash.put("5", List.of(8, 0));
        Game.gameScoreHash.put("6", List.of(0, 0));
        Game.gameScoreHash.put("7", List.of(0, 0));
        Game.gameScoreHash.put("8", List.of(0, 0));
        Game.gameScoreHash.put("9", List.of(0, 0));
        Game.gameScoreHash.put("10", List.of(9, 1, 10));
        int expected = 102;
        int actual = Game.score();
        Assert.assertEquals(expected, actual);


        Game.newGame();
        Game.gameScoreHash.put("1", List.of(5, 2));
        Game.gameScoreHash.put("2", List.of(10));
        Game.gameScoreHash.put("3", List.of(10));
        Game.gameScoreHash.put("4", List.of(9, 1));
        Game.gameScoreHash.put("5", List.of(8, 0));
        Game.gameScoreHash.put("6", List.of(0, 0));
        Game.gameScoreHash.put("7", List.of(0, 0));
        Game.gameScoreHash.put("8", List.of(0, 0));
        Game.gameScoreHash.put("9", List.of(0, 0));
        expected = 82;
        actual = Game.score();
        Assert.assertEquals(expected, actual);


        Game.newGame();
        Game.gameScoreHash.put("1", List.of(5, 2));
        Game.gameScoreHash.put("2", List.of(10));
        Game.gameScoreHash.put("3", List.of(10));
        Game.gameScoreHash.put("4", List.of(9, 1));
        Game.gameScoreHash.put("5", List.of(8, 0));
        Game.gameScoreHash.put("6", List.of(0, 0));
        Game.gameScoreHash.put("7", List.of(0, 0));
        Game.gameScoreHash.put("8", List.of(0, 0));
        Game.gameScoreHash.put("9", List.of(0, 0));
        Game.gameScoreHash.put("10", List.of(9, 0));
        expected = 91;
        actual = Game.score();
        Assert.assertEquals(expected, actual);


        Game.newGame();
        Game.gameScoreHash.put("1", List.of(5, 2));
        Game.gameScoreHash.put("2", List.of(10));
        Game.gameScoreHash.put("3", List.of(10));
        Game.gameScoreHash.put("4", List.of(9, 1));
        Game.gameScoreHash.put("5", List.of(10));
        expected = 86;
        actual = Game.score();
        Assert.assertEquals(expected, actual);


        Game.newGame();
        Game.gameScoreHash.put("1", List.of(10));
        Game.gameScoreHash.put("2", List.of(10));
        Game.gameScoreHash.put("3", List.of(10));
        Game.gameScoreHash.put("4", List.of(10));
        Game.gameScoreHash.put("5", List.of(10));
        Game.gameScoreHash.put("6", List.of(10));
        Game.gameScoreHash.put("7", List.of(10));
        Game.gameScoreHash.put("8", List.of(10));
        Game.gameScoreHash.put("9", List.of(10));
        Game.gameScoreHash.put("10", List.of(10, 10, 10));
        expected = 300;
        actual = Game.score();
        Assert.assertEquals(expected, actual);


        Game.newGame();
        Game.gameScoreHash.put("1", List.of(10));
        Game.gameScoreHash.put("2", List.of(10));
        Game.gameScoreHash.put("3", List.of(10));
        Game.gameScoreHash.put("4", List.of(10));
        Game.gameScoreHash.put("5", List.of(10));
        Game.gameScoreHash.put("6", List.of(10));
        Game.gameScoreHash.put("7", List.of(10));
        Game.gameScoreHash.put("8", List.of(10));
        Game.gameScoreHash.put("9", List.of(10));
        expected = 240;
        actual = Game.score();
        Assert.assertEquals(expected, actual);


        Game.newGame();
        Game.gameScoreHash.put("1", List.of(10));
        Game.gameScoreHash.put("2", List.of(10));
        Game.gameScoreHash.put("3", List.of(10));
        Game.gameScoreHash.put("4", List.of(10));
        Game.gameScoreHash.put("5", List.of(10));
        Game.gameScoreHash.put("6", List.of(10));
        Game.gameScoreHash.put("7", List.of(10));
        Game.gameScoreHash.put("8", List.of(10));
        Game.gameScoreHash.put("9", List.of(10));
        Game.gameScoreHash.put("10", List.of(0));
        expected = 240;
        actual = Game.score();
        Assert.assertEquals(expected, actual);


        Game.newGame();
        Game.gameScoreHash.put("1", List.of(10));
        Game.gameScoreHash.put("2", List.of(9, 1));
        expected = 30;
        actual = Game.score();
        Assert.assertEquals(expected, actual);


        Game.newGame();
        Game.gameScoreHash.put("1", List.of(10));
        Game.gameScoreHash.put("2", List.of(9));
        expected = 19;
        actual = Game.score();
        Assert.assertEquals(expected, actual);
    }
}
