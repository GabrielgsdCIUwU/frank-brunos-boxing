package edu.estatuas.round;

public class KnockdownRound implements Round {
    private String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;

    public KnockdownRound(String roundScore) {
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
        String[] scores = getRoundScore().split(" - ");
        redBoxerScore = Byte.parseByte(scores[0]);
        blueBoxerScore = Byte.parseByte(scores[1]);
    }
}
