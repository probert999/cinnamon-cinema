package com.probert999.cinnamon;

import com.probert999.cinnamon.model.Cinema;
import com.probert999.cinnamon.model.Movie;
import com.probert999.cinnamon.service.BookingService;
import com.probert999.cinnamon.testhelper.CinemaDummy;
import com.probert999.cinnamon.testhelper.SeatingPlanDummy;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

public class BookingServiceTest {

    private CinemaDummy dummyCinema;
    private BookingService bookingService;
    String movieName1;
    String movieName2;
    String expectedMovieId1;
    String expectedMovieId2;
    private LocalDateTime movieShowTime;

    @BeforeEach
    public void setup()
    {
        dummyCinema = new CinemaDummy("Cinema-Test");
        bookingService = new BookingService(dummyCinema);
        movieName1 = "Star Wars";
        movieName2 = "Empire Strikes Back";
        expectedMovieId1 = "MOVIE-1";
        expectedMovieId2 = "MOVIE-2";
        movieShowTime = LocalDateTime.of(2021, 3, 6, 19, 00);
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
        String expectedTicket = "CUSTOMER-1 has [A1]";
        assertEquals(expectedTicket,bookingService.bookSeats("CUSTOMER-1", movies.get(0), 1));
    }

    @Test
    public void shouldBeAbleToBookMoreThanSeatIfThereAreSeatsAvailable()
    {
        bookingService.addMovie(movieName1,movieShowTime);
        List<Movie> movies = bookingService.getMovieList();
        String expectedTicket = "CUSTOMER-1 has [A1, A2]";
        assertEquals(expectedTicket,bookingService.bookSeats("CUSTOMER-1", movies.get(0), 2));
    }

    @Test
    public void shouldNotBeAbleToBookMoreSeatsThanThereAreAvailable()
    {
        bookingService.addMovie(movieName1,movieShowTime);
        List<Movie> movies = bookingService.getMovieList();
        assertThrows(IllegalStateException.class, () -> bookingService.bookSeats("CUSTOMER-1", movies.get(0), 100));
    }

}
