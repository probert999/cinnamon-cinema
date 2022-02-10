package com.probert999.cinnamon.model;

import java.time.LocalDateTime;

public class Movie {

    private String movieId;
    private String movieName;
    private LocalDateTime showTime;
    private SeatingPlanInterface seatingPlan;

    public Movie(String movieId, String movieName, LocalDateTime showTime, SeatingPlanInterface seatingPlan)
    {
        this.movieId = movieId;
        this.movieName = movieName;
        this.showTime = showTime;
        this.seatingPlan = seatingPlan;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

}
