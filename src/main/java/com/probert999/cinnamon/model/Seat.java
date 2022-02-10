package com.probert999.cinnamon.model;

import java.text.MessageFormat;

public class Seat {

    private final char row;
    private final int seatNumber;
    private boolean isAllocated;
    private String customerId;

    public Seat(char row, int seatNumber) {
        this.row = row;
        this.seatNumber = seatNumber;
        this.isAllocated = false;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}{1}", row, seatNumber);
    }

    public boolean isAllocated() {
        return isAllocated;
    }

    public void allocate(String customerId) {
        isAllocated = true;
        this.customerId = customerId;
    }

    public String getCustomer() {
        if (customerId == null) {
            throw new IllegalStateException("Seat is not allocated");
        }
        return customerId;
    }
}
