package com.probert999.cinnamon;

import com.probert999.cinnamon.model.SeatingPlan;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeatingPlanTest {

    @Test
    public void shouldBeAbleToCreateASeatingPlanForOneSeat()
    {
        SeatingPlan seatingPlan = new SeatingPlan('A',1);

        assertEquals(1, seatingPlan.getAvailableSeatCount());
    }

    @Test
    public void shouldBeAbleToCreateASeatingPlanForTwoSeats()
    {
        SeatingPlan seatingPlan = new SeatingPlan('A',2);
        assertEquals(2, seatingPlan.getAvailableSeatCount());
    }

    @Test
    public void shouldBeAbleToCreateASeatingPlanForMoreThanOneRow()
    {
        SeatingPlan seatingPlan = new SeatingPlan('B',5);
        assertEquals(10, seatingPlan.getAvailableSeatCount());
    }


    @Test
    public void shouldNotBeAbleToCreateASeatingPlanWithAnInvalidLetter()
    {
        assertThrows(IllegalArgumentException.class, () -> new SeatingPlan('-',2));
    }

    @Test
    public void shouldNotBeAbleToCreateASeatingPlanWithAnInvalidMaxRowValue()
    {
        assertThrows(IllegalArgumentException.class, () -> new SeatingPlan('A',0));
    }

    @Test
    public void shouldBeAbleToReserveAnAvailableSeat()
    {
        SeatingPlan seatingPlan = new SeatingPlan('A',2);
        List<String> seats = List.of("A1");
        seatingPlan.reserveSeats(seats, "Customer-1");
        assertEquals(1, seatingPlan.getAvailableSeatCount());
    }

    @Test
    public void shouldNotBeAbleToReserveAnAllocatedSeat()
    {
        SeatingPlan seatingPlan = new SeatingPlan('A',2);
        List<String> seats = List.of("A1");

        seatingPlan.reserveSeats(seats, "Customer-1");
        assertThrows(IllegalStateException.class, () -> seatingPlan.reserveSeats(seats, "Customer-2"));
    }

    @Test
    public void shouldNotBeAbleToReserveAnInvalidSeat()
    {
        SeatingPlan seatingPlan = new SeatingPlan('A',2);
        List<String> seats = List.of("Z1");
        assertThrows(IllegalArgumentException.class, () -> seatingPlan.reserveSeats(seats, "Customer-2"));
    }

    @Test
    public void shouldBeAbleToReserveMoreThanOneSeat()
    {
        SeatingPlan seatingPlan = new SeatingPlan('A',2);
        List<String> seats = List.of("A1","A2");
        seatingPlan.reserveSeats(seats, "Customer-1");
        assertEquals(0, seatingPlan.getAvailableSeatCount());
    }

    @Test
    public void shouldNotBeAbleToReserveAnySeatsIfOneOrMoreSeatsAreInvalid()
    {
        SeatingPlan seatingPlan = new SeatingPlan('A',2);
        List<String> seats = List.of("A1","Z2");
        assertThrows(IllegalArgumentException.class, () -> seatingPlan.reserveSeats(seats, "Customer-1"));
        assertEquals(2, seatingPlan.getAvailableSeatCount());
    }

    @Test
    public void shouldNotBeAbleToReserveAnySeatsIfOneOrMoreSeatsAreAllocated()
    {
        SeatingPlan seatingPlan = new SeatingPlan('A',5);
        List<String> seats = List.of("A1","A2");
        seatingPlan.reserveSeats(seats, "Customer-1");
        assertThrows(IllegalStateException.class, () -> seatingPlan.reserveSeats(seats, "Customer-2"));
        assertEquals(3, seatingPlan.getAvailableSeatCount());
    }

    @Test
    public void shouldBeAbleToGetAListOfAvailableSeatsForOneRow()
    {
        SeatingPlan seatingPlan = new SeatingPlan('A',2);
        List<String> seats = List.of("A1","A2");
        assertEquals(seats, seatingPlan.getAvailableSeats());
    }

    @Test
    public void shouldBeAbleToGetAListOfAvailableSeatsForMoreThanOneRow()
    {
        SeatingPlan seatingPlan = new SeatingPlan('B',2);
        List<String> seats = List.of("A1","A2","B1","B2");
        assertEquals(seats, seatingPlan.getAvailableSeats());
    }

    @Test
    public void shouldBeAbleToGetCorrectListOfAvailableSeatsAfterAReservation()
    {
        SeatingPlan seatingPlan = new SeatingPlan('B',2);
        List<String> remainingSeats = List.of("A1","A2","B2");
        List<String> reserveSeats = List.of("B1");
        seatingPlan.reserveSeats(reserveSeats, "Customer-1");
        assertEquals(remainingSeats, seatingPlan.getAvailableSeats());
    }


}
