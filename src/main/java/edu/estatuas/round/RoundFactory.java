package edu.estatuas.round;

public class RoundFactory {

    public static Round getRound(String roundScore) {
        if (roundScore.equalsIgnoreCase("10 - 9") || roundScore.equalsIgnoreCase("9 - 10")) {
            return new RegularRound(roundScore);
        }else if (roundScore.equalsIgnoreCase("10 - 8") || roundScore.equalsIgnoreCase("8 - 10")) {
            return new KnockdownRound(roundScore);
        }
        return null;
    }
}
