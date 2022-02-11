package com.probert999.cinnamon.service;

import com.probert999.cinnamon.model.*;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookingService {
    private final CinemaInterface cinema;
    private List<Movie> movieList;
    private HashMap<String, Customer> customers;

    public BookingService(CinemaInterface cinema) {
        if (cinema == null) {
            throw new IllegalArgumentException("Invalid cinema object");
        }
        this.cinema = cinema;
        this.movieList = new ArrayList<>();
        this.customers = new HashMap<>();
    }

    public void addMovie(String movieName, LocalDateTime showTime) {
        String movieId = MessageFormat.format("MOVIE-{0}", movieList.size() + 1);
        Movie newMovie = new Movie(movieId, movieName, showTime, cinema.getSeatingPlan());
        movieList.add(newMovie);
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public Ticket bookSeats(String customerId, Movie movie, int numberOfSeats) {
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

        Ticket ticket = new Ticket(movie.getMovieName(), selectedSeats.toString(), movie.getShowTime());

        Customer customer = customers.get(customerId);
        if (customer == null)
        {
            customer = new Customer(customerId);
            customers.put(customerId,customer);
        }
        customer.addTicket(ticket);

        return ticket;
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers.values());
    }

    public Customer getCustomerById(String customerId)
    {
        return customers.get(customerId);
    }
}
