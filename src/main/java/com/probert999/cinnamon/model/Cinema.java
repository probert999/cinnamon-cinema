package com.probert999.cinnamon.model;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private String cinemaName;
    private final char MAX_ROW_LETTER = 'C';
    private final int SEATS_PER_ROW = 5;
    private List<Movie> movieList;

    public Cinema(String cinemaName) {
        this.cinemaName = cinemaName;
        this.movieList = new ArrayList<>();
    }

    public String getName() {
        return cinemaName;
    }

    public void addMovie(String movieName, LocalDateTime showTime) {
        String movieId = MessageFormat.format("Movie-{0}",movieList.size() + 1);
        SeatingPlan seatingPlan = new SeatingPlan(MAX_ROW_LETTER, SEATS_PER_ROW);
        Movie newMovie = new Movie(movieId, movieName, showTime, seatingPlan);
        movieList.add(newMovie);
    }

    public List<Movie> getMovieList()
    {
        return movieList;
    }
}
