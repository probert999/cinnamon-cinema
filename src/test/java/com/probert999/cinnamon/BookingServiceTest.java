package com.probert999.cinnamon;

import com.probert999.cinnamon.model.Movie;
import com.probert999.cinnamon.model.Ticket;
import com.probert999.cinnamon.service.BookingService;
import com.probert999.cinnamon.testhelper.CinemaDummy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookingServiceTest {

    private BookingService bookingService;
    private String movieName1;
    private String movieName2;
    private String expectedMovieId1;
    private String expectedMovieId2;
    private LocalDateTime movieShowTime;

    @BeforeEach
    public void setup()
    {
        CinemaDummy dummyCinema = new CinemaDummy("Cinema-Test");
        bookingService = new BookingService(dummyCinema);
        movieName1 = "Star Wars";
        movieName2 = "Empire Strikes Back";
        expectedMovieId1 = "MOVIE-1";
        expectedMovieId2 = "MOVIE-2";
        movieShowTime = LocalDateTime.of(2022, 3, 6, 19, 0);
    }

    @Test
    public void shouldBeAbleToCreateABookingService()
    {
        assertNotNull(bookingService);
    }

    @Test
    public void shouldNotBeAbleToCreateABookingServiceWithNoCinema()
    {
        assertThrows(IllegalArgumentException.class, ()-> new BookingService(null));
    }

    @Test
    public void shouldBeAbleToRetrieveEmptyMovieList()
    {
        assertEquals(0, bookingService.getMovieList().size());
    }

    @Test
    public void shouldBeAbleToAddAMovie()
    {
        bookingService.addMovie(movieName1, movieShowTime);
        assertEquals(expectedMovieId1, bookingService.getMovieList().get(0).getMovieId());
    }

    @Test
    public void shouldBeAbleToAddMoreThanOneMovie()
    {
        bookingService.addMovie(movieName1, movieShowTime);
        bookingService.addMovie(movieName2, movieShowTime);

        assertEquals(expectedMovieId2, bookingService.getMovieList().get(1).getMovieId());
        assertEquals(movieName2, bookingService.getMovieList().get(1).getMovieName());
        assertEquals(movieShowTime, bookingService.getMovieList().get(1).getShowTime());
    }

    @Test
    public void shouldBeAbleToBookOneSeatIfThereAreSeatsAvailable()
    {
        bookingService.addMovie(movieName1,movieShowTime);
        List<Movie> movies = bookingService.getMovieList();
        String expectedTicket = "[A1]";

        Ticket ticket = bookingService.bookSeats("CUSTOMER-1", movies.get(0), 1);

        assertEquals(movieName1,ticket.getMovieName());
        assertEquals(expectedTicket,ticket.getSeats());
        assertEquals(movieShowTime,ticket.getShowTime());
    }

    @Test
    public void shouldBeAbleToBookMoreThanSeatIfThereAreSeatsAvailable()
    {
        bookingService.addMovie(movieName1,movieShowTime);
        List<Movie> movies = bookingService.getMovieList();
        String expectedTicket = "[A1, A2]";

        Ticket ticket = bookingService.bookSeats("CUSTOMER-1", movies.get(0), 2);
        assertEquals(movieName1,ticket.getMovieName());
        assertEquals(expectedTicket,ticket.getSeats());
        assertEquals(movieShowTime,ticket.getShowTime());
    }

    @Test
    public void shouldNotBeAbleToBookMoreSeatsThanThereAreAvailable()
    {
        bookingService.addMovie(movieName1,movieShowTime);
        List<Movie> movies = bookingService.getMovieList();
        assertThrows(IllegalStateException.class, () -> bookingService.bookSeats("CUSTOMER-1", movies.get(0), 100));
    }

}
