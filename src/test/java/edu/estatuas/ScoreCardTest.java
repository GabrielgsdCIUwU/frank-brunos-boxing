package edu.estatuas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ScoreCardTest 
{

    @Test
    public void testSetGetRCorner() {
        ScoreCard sc = new ScoreCard("WHITE");
        String boxerName = "Mike Tyson";
        sc.setRCorner(boxerName);

        assertEquals(boxerName, sc.getRCorner());
    }

    @Test
    public void testSetGetBCorner() {
        ScoreCard sc = new ScoreCard("BLACK");
        String boxerName = "John Doe";
        sc.setBCorner(boxerName);

        assertEquals(boxerName, sc.getBCorner());
    }
}
