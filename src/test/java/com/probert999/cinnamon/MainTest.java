package com.probert999.cinnamon;

import com.probert999.cinnamon.app.Main;
import com.probert999.cinnamon.model.Cinema;
import com.probert999.cinnamon.service.BookingService;
import com.probert999.cinnamon.testhelper.RandomStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    private Cinema cinema;
    private BookingService bookingService;

    @BeforeEach
    public void setup()
    {
        cinema = new Cinema("Cinnamon Cinema");
        bookingService = new BookingService(cinema);
        LocalDateTime movieShowTime = LocalDateTime.of(2022, 3, 6, 19, 0);
        bookingService.addMovie("Star Wars", movieShowTime);
    }

    @Test
    public void shouldReturnZeroSeatsRemainingIfAllSingleSeatAllocation() {
        RandomStub random = new RandomStub(0);
        assertEquals(0,Main.doRandomPurchases(cinema, bookingService, random, 3));
    }

    @Test
    public void shouldReturnZeroSeatsRemainingIfThreeSeatAllocation() {
        RandomStub random = new RandomStub(2);
        assertEquals(0,Main.doRandomPurchases(cinema, bookingService, random, 3));
    }

}
