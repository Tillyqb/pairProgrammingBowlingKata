package com.accenture.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    public static int roll(int range){
        int result = (int) (Math.random() * (range + 1));
        System.out.println(result);
        return result;

    }


    public static List<Integer> frames = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    static Map<String, List<Integer>> gameScoreHash = new HashMap<>();


    public static void newGame() {
        List<Integer> emptyFrame = new ArrayList<>();
        gameScoreHash.put("1",emptyFrame);
        gameScoreHash.put("2",emptyFrame);
        gameScoreHash.put("3",emptyFrame);
        gameScoreHash.put("4",emptyFrame);
        gameScoreHash.put("5",emptyFrame);
        gameScoreHash.put("6",emptyFrame);
        gameScoreHash.put("7",emptyFrame);
        gameScoreHash.put("8",emptyFrame);
        gameScoreHash.put("9",emptyFrame);
        gameScoreHash.put("10",emptyFrame);
    }

    public static int score(){



            int score = 0;
            List<Integer> nextFrame = new ArrayList<>();
            List<Integer> nextNextFrame = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                List<Integer> frameScores = gameScoreHash.get(String.valueOf(i));
                if (i < 10) {
                    nextFrame = gameScoreHash.get(String.valueOf(i + 1));
                }
                if (i < 9) {
                    nextNextFrame = gameScoreHash.get(String.valueOf(i+2));
                }
                if (frameScores.size() > 0) {
                    if (i == 10) {
                        for (int j = 0 ; j < frameScores.size(); j++) {
                            score = score + frameScores.get(j);
                        }
                    } else if (i == 9) {
                        if (frameScores.size() == 2 && frameScores.get(0) + frameScores.get(1) != 10) {
                            score = score + frameScores.get(0) + frameScores.get(1);
                        } else if (frameScores.get(0) == 10) {
                            if (nextFrame.size() == 0) {
                                break;
                            } else {
                                if (nextFrame.size() == 1) {
                                    score = score + frameScores.get(0) + nextFrame.get(0);
                                } else if (nextFrame.size() > 1) {
                                    score = score + frameScores.get(0) + nextFrame.get(0) + nextFrame.get(1);
                                }
                            }
                        } else {
                            if (nextFrame.size() > 0) {
                                score = score + frameScores.get(0) + frameScores.get(1) + nextFrame.get(0);
                            }
                        }
                    } else {
                        if (frameScores.size() == 2 && frameScores.get(0) + frameScores.get(1) != 10) {
                            score = score + frameScores.get(0) + frameScores.get(1);
                        } else if (frameScores.size() == 2 && frameScores.get(0) + frameScores.get(1) == 10) {
                            if (nextFrame.size() == 0) {
                                score = score + frameScores.get(0) + frameScores.get(1);
                            } else {
                                score = score + frameScores.get(0) + frameScores.get(1) + nextFrame.get(0);
                            }
                        } else if (frameScores.get(0) == 10) {
                            if (nextFrame.size() == 0) {
                                score = score + 10;
                            }
                            if (nextFrame.size() == 2) {
                                score = score + 10 + nextFrame.get(0) + nextFrame.get(1);
                            }
                            if ((nextFrame.size() == 1) && (nextFrame.get(0) != 10)) {
                                score = score + 10 + nextFrame.get(0);
                            }
                            if (nextFrame.size() == 1 && (nextFrame.get(0) == 10)) {
                                if (nextNextFrame.size() == 0) {
                                    score = score + 20;
                                } else {
                                    score = score + 20 + nextNextFrame.get(0);
                                }
                            }
                        }
                    }
                }
            }
            return score;
        }

    }

