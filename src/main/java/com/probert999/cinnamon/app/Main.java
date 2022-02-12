package com.probert999.cinnamon.app;

import com.probert999.cinnamon.model.Cinema;
import com.probert999.cinnamon.model.Customer;
import com.probert999.cinnamon.model.Movie;
import com.probert999.cinnamon.model.Ticket;
import com.probert999.cinnamon.service.BookingService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Cinema cinema = new Cinema("Cinnamon Cinama");
        BookingService bookingService = new BookingService(cinema);

        // Set-up test movie
        LocalDateTime movieShowTime = LocalDateTime.of(2022, 3, 6, 19, 0);
        bookingService.addMovie("Star Wars", movieShowTime);
        Random random = new Random();
        doRandomPurchases(cinema, bookingService, random, 3);
    }

    public static int doRandomPurchases(Cinema cinema, BookingService bookingService, Random random, int randomBounds)
    {
        List<Movie> movies = bookingService.getMovieList();
        Movie movie = movies.get(0);

        // Run the specified test
        // A random number of seats (between 1 & 3) are allocated per customer
        // until there are not enough seats left to complete an order
        int randomSeats = random.nextInt(randomBounds) + 1;
        int customerCount = 0;

        while (randomSeats <= movie.getSeatingPlan().getAvailableSeatCount()) {
            customerCount++;
            bookingService.bookSeats("Customer-"+customerCount,movie, randomSeats);
            randomSeats = random.nextInt(randomBounds) + 1;
        }

        // Output ticket purchases
        System.out.println(cinema.getName());
        List<Customer> customers = bookingService.getCustomers();
        for (Customer customer : customers) {
            System.out.println("------------------------");
            System.out.println(customer.getId());
            List<Ticket> tickets = customer.getTickets();
            for (Ticket ticket : tickets) {
                System.out.println(ticket.toString());
            }
        }
        int seatsRemaining = movie.getSeatingPlan().getAvailableSeatCount();
        System.out.println("\n\nThere are " + seatsRemaining + " seats remaining");
        return seatsRemaining;
    }
}
