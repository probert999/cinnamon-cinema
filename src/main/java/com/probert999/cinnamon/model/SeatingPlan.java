package com.probert999.cinnamon.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SeatingPlan implements SeatingPlanInterface {

    private final char maxRowLetter;
    private final int maxSeatsPerRow;
    private static final String VALID_ROWS = "ABC";
    private LinkedHashMap<String, Seat> seats;

    private void createSeatingPlan() {
        seats = new LinkedHashMap<>();
        for (char row = 'A'; row <= maxRowLetter; row++) {
            for (int seatNumber = 1; seatNumber <= maxSeatsPerRow; seatNumber++) {
                Seat addSeat = new Seat(row, seatNumber);
                seats.put(addSeat.toString(), addSeat);
            }
        }
    }

    public SeatingPlan(char maxRowLetter, int maxSeatsPerRow) {
        if (VALID_ROWS.indexOf(maxRowLetter) == -1) {
            throw new IllegalArgumentException("Invalid value for maxRow");
        }
        if (maxSeatsPerRow < 1) {
            throw new IllegalArgumentException("Invalid value for maxSeatsPerRow");
        }

        this.maxRowLetter = maxRowLetter;
        this.maxSeatsPerRow = maxSeatsPerRow;
        createSeatingPlan();
    }

    public int getAvailableSeatCount() {
        return (int) seats.values().stream().filter(seat -> !seat.isAllocated()).count();
    }

    public void reserveSeats(List<String> seatNumbers, String customerId) {
        List<Seat> seatsToAllocate = new ArrayList<>();

        // Check all seats are valid and available, only then perform allocation
        for (String seatNumber : seatNumbers) {
            Seat checkSeat = seats.get(seatNumber);
            if (checkSeat == null) {
                throw new IllegalArgumentException("Seat not found");
            }
            if (checkSeat.isAllocated()) {
                throw new IllegalStateException("Seat already allocated");
            } else {
                seatsToAllocate.add(checkSeat);
            }
        }

        for (Seat seats : seatsToAllocate) {
            seats.allocate(customerId);
        }
    }

    public List<String> getAvailableSeats()
    {
        return seats.values().stream().filter(seat -> !seat.isAllocated()).map(Seat::toString).toList();
    }
}
