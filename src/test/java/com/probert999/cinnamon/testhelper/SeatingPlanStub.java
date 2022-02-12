package com.probert999.cinnamon.testhelper;

import com.probert999.cinnamon.model.SeatingPlanInterface;

import java.util.List;

public class SeatingPlanStub implements SeatingPlanInterface  {

    public SeatingPlanStub(char maxRowLetter, int maxSeatsPerRow)
    {

    }

    public int getAvailableSeatCount() {
        return 2;
    }

    public void reserveSeats(List<String> seatNumbers, String customerId) {};

    public List<String> getAvailableSeats() {
        return List.of("A1","A2");
    };

}
