package edu.estatuas;

import edu.estatuas.round.Round;
import edu.estatuas.round.RoundFactory;

public class ScoreCard {

    private String color;
    private String redCorner = "";
    private String blueCorner = "";
    private Round[] rounds;

    ScoreCard (String color) {
        this.color = color;
    }

    public void setRCorner (String boxerName) {
        redCorner = boxerName;
    }

    public void setBCorner (String boxerName) {
        blueCorner = boxerName;
    }

    String getRCorner() {
        return redCorner;
    }

    String getBCorner() {
        return blueCorner;
    }

    public void loadJudgeScoreCard(String[] judgeScoreCard) {
        rounds = new Round[judgeScoreCard.length];
        for (int i = 0; i < rounds.length; i++) {
            rounds[i] = RoundFactory.getRound(judgeScoreCard[i]);
        }
    }


    private Round[] getRounds() {
        return rounds;
    }

    private String getEachScoreRound() {
        if (getRounds() == null) {return "";}

        byte scoreTotalBoxerRedCorner = 0;
        byte scoreTotalBoxerBlueCorner = 0;
        
        StringBuilder finalMessage = new StringBuilder();
        for (int i = 0; i < rounds.length; i++) {
            byte scoreRedBoxer = getRounds()[i].redBoxerScore();
            byte scoreBlueBoxer = getRounds()[i].blueBoxerScore();

            scoreTotalBoxerRedCorner += scoreRedBoxer;
            scoreTotalBoxerBlueCorner += scoreBlueBoxer;

            int currentRound = i+1;
            finalMessage.append(scoreRedBoxer + "\t " + scoreTotalBoxerRedCorner + "\t " + currentRound + "\t " + scoreTotalBoxerBlueCorner + "\t " + scoreBlueBoxer + "\n");
        }
        return finalMessage.toString();
    }

    public int getRedBoxerFinalScore() {
        return getFinalScoreBoxer(0);
    }

    public int getBlueBoxerFinalScore() {
        return getFinalScoreBoxer(1);
    }

    private int getFinalScoreBoxer(int corner) {
        
        int finalScoreBoxer = 0;
        for (Round round : rounds) {
            if (corner == 0) {
                finalScoreBoxer += Integer.parseInt(String.valueOf(round.redBoxerScore())); 
            } else {
                finalScoreBoxer += Integer.parseInt(String.valueOf(round.blueBoxerScore()));
            }

        }
        return finalScoreBoxer;
    }

    @Override
    public String toString() {
        return "\n\t\t" + color + "\n\t"
                + getRCorner() + "\t"
                + getBCorner() + "\n"
                + "Round \t Score \t Round \t Score \t Round\n" 
                + "Score \t Total \t       \t Total \t Score\n"
                + getEachScoreRound();
    }
}
