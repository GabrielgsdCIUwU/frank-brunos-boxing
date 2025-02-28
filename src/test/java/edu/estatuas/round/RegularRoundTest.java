package edu.estatuas.round;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RegularRoundTest {

    @Test
    public void testRegularRound() {
        String roundString = "10 - 9";
        RegularRound round = new RegularRound(roundString);

        assertEquals(roundString, round.getRoundScore());
    }

    @Test
    public void testRedBoxerScore() {
        RegularRound round = new RegularRound("10 - 9");
        round.boxerRoundScore();

        assertEquals(10, round.redBoxerScore());
    }

    @Test
    public void testBlueBoxerScore() {
        RegularRound round = new RegularRound("10 - 9");
        round.boxerRoundScore();
        
        assertEquals(9, round.blueBoxerScore());
    }
}
