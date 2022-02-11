package com.probert999.cinnamon;

import com.probert999.cinnamon.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TicketTest {

    private Ticket ticket;
    private String movieName;
    private String seats;
    private LocalDateTime movieShowTime;

    @BeforeEach
    public void setup()
    {
        movieName = "Star Wars";
        seats = "A1";
        movieShowTime = LocalDateTime.of(2022, 3, 6, 19, 0);
        ticket = new Ticket(movieName,seats,movieShowTime);
    }


    @Test
    public void shouldBeAbleToCreateATicket()
    {
        assertNotNull(ticket);
    }

    @Test
    public void shouldBeAbleToGetMovieNameFromTicket()
    {
        assertEquals(movieName, ticket.getMovieName());
    }

    @Test
    public void shouldBeAbleToGetSeatsFromTicket()
    {
        assertEquals(seats, ticket.getSeats());
    }

    @Test
    public void shouldBeAbleToGetShowTimeFromTicket()
    {
        assertEquals(movieShowTime, ticket.getShowTime());
    }

    @Test
    public void shouldBeTheCorrectFormatForToString()
    {
        String expectedString = "Seats A1 for Star Wars at 19:00 on 06/03/2022";
        assertEquals(expectedString, ticket.toString());
    }
}
