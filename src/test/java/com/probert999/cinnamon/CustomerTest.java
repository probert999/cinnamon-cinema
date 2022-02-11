package com.probert999.cinnamon;

import com.probert999.cinnamon.model.Customer;
import com.probert999.cinnamon.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerTest {

    private Customer customer;
    private String customerId;


    @BeforeEach
    public void setup()
    {
        customerId = "Customer-1";
        customer = new Customer(customerId);
    }

    @Test
    public void shouldBeAbleToCreateACustomer()
    {
        assertNotNull(customer);
    }

    @Test
    public void shouldBeAbleToGetCustomerId()
    {
        assertEquals(customerId, customer.getId());
    }

    @Test
    public void shouldBeAbleToGetEmptyTicketList()
    {
        assertEquals(0,customer.getTickets().size());
    }

    @Test
    public void shouldBeAbleToAddATicket()
    {
        String movieName = "Star Wars";
        String seats = "A1";
        LocalDateTime movieShowTime = LocalDateTime.of(2022, 3, 6, 19, 0);
        Ticket ticket = new Ticket(movieName, seats, movieShowTime);
        customer.addTicket(ticket);
        assertEquals(1,customer.getTickets().size());
    }



}
