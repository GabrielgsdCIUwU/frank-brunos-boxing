package edu.estatuas;

import java.util.ArrayList;
import java.util.List;

import edu.estatuas.round.Round;
import edu.estatuas.round.RoundFactory;

public class ScoreCard {

    private String color;
    private String redCorner = "";
    private String blueCorner = "";
    private List<Round> rounds = new ArrayList<>();

    ScoreCard(String color) {
        this.color = color;
    }

    public void setRCorner(String boxerName) {
        redCorner = boxerName;
    }

    public void setBCorner(String boxerName) {
        blueCorner = boxerName;
    }

    String getRCorner() {
        return redCorner;
    }

    String getBCorner() {
        return blueCorner;
    }

    public void loadJudgeScoreCard(String[] judgeScoreCard) {
        rounds.clear();
        for (String score : judgeScoreCard) {
            rounds.add(RoundFactory.getRound(score));
        }
    }

    private List<Round> getRounds() {
        return rounds;
    }

    private String getEachScoreRound() {
        if (getRounds().isEmpty()) {
            return "";
        }

        byte scoreTotalBoxerRedCorner = 0;
        byte scoreTotalBoxerBlueCorner = 0;

        StringBuilder finalMessage = new StringBuilder();
        for (int i = 0; i < rounds.size(); i++) {
            byte scoreRedBoxer = getRounds().get(i).redBoxerScore();
            byte scoreBlueBoxer = getRounds().get(i).blueBoxerScore();

            scoreTotalBoxerRedCorner += scoreRedBoxer;
            scoreTotalBoxerBlueCorner += scoreBlueBoxer;

            int currentRound = i + 1;
            finalMessage.append(find7AndConvertToComma(scoreRedBoxer, Boolean.TRUE))
                    .append("\t")
                    .append(scoreTotalBoxerRedCorner)
                    .append("\t")
                    .append(currentRound)
                    .append("\t")
                    .append(scoreTotalBoxerBlueCorner)
                    .append("\t")
                    .append(find7AndConvertToComma(scoreBlueBoxer, Boolean.FALSE))
                    .append("\n");
        }
        return finalMessage.toString();
    }

    private String find7AndConvertToComma(byte score, Boolean boxer) {
        if (score == 7 && boxer.booleanValue()) {
            return "1, 8";
        } else if (score == 7 && !boxer.booleanValue()) {
            return "8, 1";
        } else {
            return String.valueOf(score);
        }
    }

    public int getRedBoxerFinalScore() {
        return getFinalScoreBoxer(Boolean.TRUE);
    }

    public int getBlueBoxerFinalScore() {
        return getFinalScoreBoxer(Boolean.FALSE);
    }

    private int getFinalScoreBoxer(Boolean boxer) {

        return rounds.stream().map(round -> boxer.booleanValue() ? (int) round.redBoxerScore() : (int) round.blueBoxerScore())
                .mapToInt(Integer::intValue).sum();
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
