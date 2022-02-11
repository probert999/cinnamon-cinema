package com.probert999.cinnamon;

import com.probert999.cinnamon.model.Seat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SeatTest {

    @Test
    public void shouldBeAbleToCreateSeatA1() {
        Seat seat = new Seat('A', 1);
        assertEquals("A1", seat.toString());
    }

    @Test
    public void shouldBeAbleToCreateSeatB1() {
        Seat seat = new Seat('B', 1);
        assertEquals("B1", seat.toString());
    }

    @Test
    public void shouldDefaultToNotAllocated()
    {
        Seat seat = new Seat('A', 1);
        assertFalse(seat.isAllocated());
    }

    @Test
    public void shouldBeAbleToAllocateSeat()
    {
        Seat seat = new Seat('A', 1);
        seat.allocate("Customer-1");
        assertTrue(seat.isAllocated());
    }

    @Test
    public void shouldBeAbleToAllocateSeatToCustomer()
    {
        Seat seat = new Seat('A', 1);
        seat.allocate("Customer-1");
        assertTrue(seat.isAllocated());
    }

    @Test
    public void shouldBeAbleToRetrieveAllocatedCustomerId()
    {
        Seat seat = new Seat('A', 1);
        String customerId = "Customer-1";
        seat.allocate(customerId);
        assertEquals(customerId, seat.getCustomer());
    }

    @Test
    public void shouldGetNotAllocatedAsCustomerIdIfNotAllocated()
    {
        Seat seat = new Seat('A', 1);

        assertThrows(IllegalStateException.class, seat::getCustomer);
    }

}
