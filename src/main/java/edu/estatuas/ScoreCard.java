package edu.estatuas;

public class ScoreCard {

    private static String color;
    private String redCorner = "";
    private String blueCorner = "";

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

    @Override
    public String toString() {
        return "\t" + color + "\n"
                + getRCorner() + "\t"
                + getBCorner();
    }
}
