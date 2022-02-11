package com.probert999.cinnamon.model;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {

    private final String movieName;
    private final String seats;
    private final LocalDateTime showTime;

    public Ticket(String movieName, String seats, LocalDateTime showTime) {
        this.movieName = movieName;
        this.seats = seats;
        this.showTime = showTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getSeats() {
        return seats;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        return MessageFormat.format("Seats {0} for {1} at {2} on {3}",
                                            seats,movieName,showTime.format(timeFormat),showTime.format(dateFormat));
    }

}
