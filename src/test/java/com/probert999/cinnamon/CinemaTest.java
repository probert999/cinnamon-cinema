package com.probert999.cinnamon;

import com.probert999.cinnamon.model.Cinema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CinemaTest {

    @Test
    public void shouldBeAbleToCreateANewCinema()
    {
        String cinemaName = "Cinnamon Cinema";
        Cinema cinema = new Cinema(cinemaName);
        assertEquals(cinemaName, cinema.getName());
    }

    @Test
    public void shouldBeAbleToGetTheSeatingPlan()
    {
        String cinemaName = "Cinnamon Cinema";
        Cinema cinema = new Cinema(cinemaName);
        assertNotNull(cinema.getSeatingPlan());
    }


}
