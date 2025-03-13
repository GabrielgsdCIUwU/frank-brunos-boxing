package edu.estatuas.round;

public class PointsDeducted implements Round {
    private String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;

    public PointsDeducted(String roundScore) {
        this.roundScore = roundScore;
        boxerRoundScore();
    }

    String getRoundScore() {
        return roundScore;
    }
    
    public byte getRedBoxerScore() {
        return redBoxerScore;
    }

    public byte getBlueBoxerScore() {
        return blueBoxerScore;
    }

    @Override
    public byte redBoxerScore() {
        return getRedBoxerScore();
    }

    @Override
    public byte blueBoxerScore() {
        return getBlueBoxerScore();
    }

    @Override
    public void boxerRoundScore() {
        String[] scores = getRoundScore().split(" - ", 2);
        for (int i=0; i < scores.length ; i++) {
            if(scores[i].contains(",")){
                setBoxerRoundScore(i, "7");
            } else {
                setBoxerRoundScore(i, scores[i]);
            }
        }
    }

    private void setBoxerRoundScore(int i, String score) {
        if (i == 0) {
            redBoxerScore = Byte.parseByte(score);
        } else if (i == 1) {
            blueBoxerScore = Byte.parseByte(score);
        }
    }
}
