package com.probert999.cinnamon.model;

import java.util.List;

public interface SeatingPlanInterface {

    int getAvailableSeatCount();

    void reserveSeats(List<String> seatNumbers, String customerId);

    List<String> getAvailableSeats();

}
