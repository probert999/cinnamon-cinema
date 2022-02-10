package com.probert999.cinnamon;

import com.probert999.cinnamon.model.SeatingPlan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeatingPlanTest {

    @Test
    public void shouldBeAbleToCreateASeatingPlanFor1Seat()
    {
        SeatingPlan seatingPlan = new SeatingPlan('A',1);

        assertEquals(1, seatingPlan.getAvailableSeats());
    }

    @Test
    public void shouldBeAbleToCreateASeatingPlanFor2Seats()
    {
        SeatingPlan seatingPlan = new SeatingPlan('A',2);

        assertEquals(2, seatingPlan.getAvailableSeats());
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

}
