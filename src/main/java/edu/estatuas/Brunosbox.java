package edu.estatuas;

import edu.estatuas.round.RegularRound;
import edu.estatuas.round.RoundFactory;
import edu.estatuas.round.KnockdownRound;
import edu.estatuas.round.PointsDeducted;

public class Brunosbox 
{
    public static void main( String[] args ) {

        System.out.println("\n - I see three of them out there." + 
                           "\n - Hit the one in the middle.- Rocky Balboa\n");

        String[][] data = {

            //  White ScoreCard
            {"9 - 10", 
             "9 - 10", 
             "9 - 10", 
             "9 - 10",
             "10 - 9",
             "10 - 9",
             "10 - 9", 
             "9 - 10", 
             "10 - 9", 
             "9 - 10"},
            
             // Blue ScoreCard
            {"9 - 10", 
             "9 - 10", 
             "9 - 10", 
             "8 - 10", // knockdown
             "10 - 8", // knockdown
             "10 - 8",
             "10 - 9", 
             "9 - 10", 
             "10 - 9", 
             "10 - 9"},

            // Pink ScoreCard
            {"9 - 10", 
             "9 - 10", 
             "9 - 10", 
             "1, 8 - 10", // referee point deduction
             "10 - 8",    // knockdown
             "10 - 8 ,1", // referee point deduction
             "10 - 9", 
             "9 - 10", 
             "10 - 9", 
             "10 - 8" // knockdown
            }

        };


        ScoreCard whiteScoreCard = new ScoreCard("WHITE");
        
        whiteScoreCard.setRCorner("Rocky Balboa");
        whiteScoreCard.setBCorner("Apollo Creed");

        System.out.println(whiteScoreCard);


        RegularRound round = new RegularRound("10 - 9");
        round.boxerRoundScore();
        System.out.println("\n\t Regular round\t" + round.getRedBoxerScore() +
                            " - " + round.getBlueBoxerScore());

        whiteScoreCard.loadJudgeScoreCard(data[0]);
        System.out.println(whiteScoreCard);


        System.out.println("\t FINAL SCORE: " + whiteScoreCard.getRedBoxerFinalScore() + 
                           " - " + whiteScoreCard.getBlueBoxerFinalScore() + " FINAL SCORE");

 
        KnockdownRound knockdownRound = new KnockdownRound("10 - 8");
        knockdownRound.boxerRoundScore();
        System.out.println("\n\t knockdown round\t" + knockdownRound.getRedBoxerScore() +
                             " - " + knockdownRound.getBlueBoxerScore());
     

        RegularRound regular = (RegularRound) RoundFactory.getRound("9 - 10");
        System.out.println("\t regular round: " + regular);
        KnockdownRound knockdown = (KnockdownRound) RoundFactory.getRound("8 - 10");
        System.out.println("\t knockdown round: " + knockdown);



        ScoreCard blueScoreCard = new ScoreCard("BLUE");
        blueScoreCard.setRCorner("Rocky Balboa");
        blueScoreCard.setBCorner("Apollo Creed");
 
        blueScoreCard.loadJudgeScoreCard(data[1]);
        System.out.println(blueScoreCard);

        
        System.out.println("\t FINAL SCORE: " + blueScoreCard.getRedBoxerFinalScore() + 
         " - " + blueScoreCard.getBlueBoxerFinalScore() + " FINAL SCORE");

       
        PointsDeducted deducted = new PointsDeducted("10 - 8 ,1");
        deducted.boxerRoundScore();
        System.out.println("\n\t points deducted round\t" + deducted.getRedBoxerScore() +
                              " - " + deducted.getBlueBoxerScore());
        
        deducted = new PointsDeducted("1, 8 - 10");
        deducted.boxerRoundScore();
        System.out.println("\n\t points deducted round\t" + deducted.getRedBoxerScore() +
                                                    " - " + deducted.getBlueBoxerScore());  
        
        
        PointsDeducted pointsDeducted = (PointsDeducted) RoundFactory.getRound("1, 8 - 10");
        System.out.println("\n\t factory deducted round: " + pointsDeducted);

      
        ScoreCard pinkScoreCard = new ScoreCard("PINK");
        pinkScoreCard.setRCorner("Rocky Balboa");
        pinkScoreCard.setBCorner("Apollo Creed");
  
        pinkScoreCard.loadJudgeScoreCard(data[2]);
        System.out.println(pinkScoreCard);

       
        
         System.out.println("\t FINAL SCORE: " + pinkScoreCard.getRedBoxerFinalScore() + 
         " - " + pinkScoreCard.getBlueBoxerFinalScore() + " FINAL SCORE");
    }
}