package edu.estatuas;

public class ScoreCard {

    private String color;
    private String redCorner = "";
    private String blueCorner = "";
    private String[] judgeScoreCard;

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
        this.judgeScoreCard = judgeScoreCard;
    }

    private String[] getJudgeScoreCard() {
        return judgeScoreCard;
    }

    private String getEachScoreRound() {
        if (getJudgeScoreCard() == null) {return "";}

        int scoreTotalBoxerRedCorner = 0;
        int scoreTotalBoxerBlueCorner = 0;
        
        StringBuilder finalMessage = new StringBuilder();
        for (int i = 0; i < getJudgeScoreCard().length; i++) {
            String[] scoreBoxerRound = splitScoreCorner(getJudgeScoreCard()[i]);

            scoreTotalBoxerRedCorner += Integer.parseInt(scoreBoxerRound[0]);
            scoreTotalBoxerBlueCorner += Integer.parseInt(scoreBoxerRound[1]);

            int currentRound = i+1;
            finalMessage.append(scoreBoxerRound[0] + "\t " + scoreTotalBoxerRedCorner + "\t " + currentRound + "\t " + scoreTotalBoxerBlueCorner + "\t " + scoreBoxerRound[1] + "\n");
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
        for (int i = 0; i < getJudgeScoreCard().length; i++) {
            String[] scoreBoxerRound = splitScoreCorner(getJudgeScoreCard()[i]);

            finalScoreBoxer += Integer.parseInt(scoreBoxerRound[corner]);
        }
        return finalScoreBoxer;
    }

    private String[] splitScoreCorner(String scoreRound) {
        return scoreRound.split(" - ");
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
