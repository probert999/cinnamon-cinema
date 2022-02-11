package com.probert999.cinnamon.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String id;
    private List<Ticket> tickets;


    public Customer(String customerId)
    {
        this.id = customerId;
        this.tickets = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void addTicket(Ticket ticket)
    {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
