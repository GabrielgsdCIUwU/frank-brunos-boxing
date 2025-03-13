package edu.estatuas.round;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PointsDeductedTest {
    
    @Test
    public void testPointsDeducted() {
        String roundScore = "1, 8 - 10";

        PointsDeducted deducted = new PointsDeducted(roundScore);

        assertEquals(roundScore, deducted.getRoundScore());
    }

    @Test
    public void testBlueBoxerScore() {

        PointsDeducted deducted = new PointsDeducted("1, 8 - 10");
        Byte expected = 10;
        assertTrue(expected.equals(deducted.getBlueBoxerScore()));
    }

    @Test
    public void testRedBoxerScore() {
        PointsDeducted deducted = new PointsDeducted("1, 8 - 10");
        Byte expected = 7;
        assertTrue(expected.equals(deducted.getRedBoxerScore()));
    }


}
