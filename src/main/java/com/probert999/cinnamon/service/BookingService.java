package com.probert999.cinnamon.service;

import com.probert999.cinnamon.model.CinemaInterface;
import com.probert999.cinnamon.model.Movie;
import com.probert999.cinnamon.model.SeatingPlanInterface;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private final CinemaInterface cinema;
    private List<Movie> movieList;

    public BookingService(CinemaInterface cinema) {
        if (cinema == null) {
            throw new IllegalArgumentException("Invalid cinema object");
        }
        this.cinema = cinema;
        this.movieList = new ArrayList<>();
    }

    public void addMovie(String movieName, LocalDateTime showTime) {
        String movieId = MessageFormat.format("MOVIE-{0}",movieList.size() + 1);
        Movie newMovie = new Movie(movieId, movieName, showTime, cinema.getSeatingPlan());
        movieList.add(newMovie);
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public String bookSeats(String customerId, Movie movie, int numberOfSeats)
    {
        // get the seating plan
        SeatingPlanInterface seatingPlan = movie.getSeatingPlan();
        int availableSeatCount = seatingPlan.getAvailableSeatCount();

        if (availableSeatCount < numberOfSeats) {
            throw new IllegalStateException("Not enough seats available");
        }

        List<String> availableSeats = seatingPlan.getAvailableSeats();
        List<String> selectedSeats = new ArrayList<>();

        // Simple selection, taking next available seats. We could extend this to ensure group is sat together!
        for (int seat = 0; seat < numberOfSeats; seat++) {
            selectedSeats.add(availableSeats.get(seat));
        }

        seatingPlan.reserveSeats(selectedSeats, customerId);

        return MessageFormat.format("{0} has {1}",customerId,selectedSeats.toString());
    }
}
