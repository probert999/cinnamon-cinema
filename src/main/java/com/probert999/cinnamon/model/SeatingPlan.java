package com.probert999.cinnamon.model;

public class SeatingPlan {

    private char maxRowLetter;
    private int maxSeatsPerRow;
    private static final String VALID_ROWS = "ABC";
    int availableSeats = 0;

    public SeatingPlan(char maxRowLetter, int maxSeatsPerRow)
    {
        if (VALID_ROWS.indexOf(maxRowLetter) == -1) {
            throw new IllegalArgumentException("Invalid value for maxRow");
        }
        if (maxSeatsPerRow < 1) {
            throw new IllegalArgumentException("Invalid value for maxSeatsPerRow");
        }

        this.maxRowLetter = maxRowLetter;
        this.maxSeatsPerRow = maxSeatsPerRow;
    }

    public int getAvailableSeats() {
        return (VALID_ROWS.indexOf(maxRowLetter) + 1) * maxSeatsPerRow;
    }
}
