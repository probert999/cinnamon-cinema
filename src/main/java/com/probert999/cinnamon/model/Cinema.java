package com.probert999.cinnamon.model;

import java.text.MessageFormat;
import java.time.LocalDateTime;


public class Cinema implements CinemaInterface {

    private String cinemaName;
    private final char MAX_ROW_LETTER = 'C';
    private final int SEATS_PER_ROW = 5;


    public Cinema(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getName() {
        return cinemaName;
    }


    public SeatingPlan getSeatingPlan() {
        return new SeatingPlan(MAX_ROW_LETTER, SEATS_PER_ROW);
    }
}
