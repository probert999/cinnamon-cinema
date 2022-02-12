package com.probert999.cinnamon;

import com.probert999.cinnamon.app.Main;
import com.probert999.cinnamon.model.Cinema;
import com.probert999.cinnamon.service.BookingService;
import com.probert999.cinnamon.testhelper.RandomStub;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void shouldReturnZeroSeatsRemainingIfAllSingleSeatAllocation() {
        Cinema cinema = new Cinema("Cinnamon Cinama");
        BookingService bookingService = new BookingService(cinema);

        LocalDateTime movieShowTime = LocalDateTime.of(2022, 3, 6, 19, 0);
        bookingService.addMovie("Star Wars", movieShowTime);
        RandomStub random = new RandomStub(0);
        assertEquals(0,Main.doRandomPurchases(cinema, bookingService, random, 3));
    }

    @Test
    public void shouldReturnOneSeatsRemainingIfAllTwoSeatAllocation() {
        Cinema cinema = new Cinema("Cinnamon Cinama");
        BookingService bookingService = new BookingService(cinema);

        LocalDateTime movieShowTime = LocalDateTime.of(2022, 3, 6, 19, 0);
        bookingService.addMovie("Star Wars", movieShowTime);
        RandomStub random = new RandomStub(1);
        assertEquals(1,Main.doRandomPurchases(cinema, bookingService, random, 3));
    }

}
