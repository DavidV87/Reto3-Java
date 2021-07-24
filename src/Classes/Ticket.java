/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author Elkin David Valencia
 */
public class Ticket implements Serializable{
    
    private String from;
    private String to;
    private int typeTicket;
    private String departureDate;
    private String returnDate;
    private double ticketPrice;
    private Passengers passenger;

    public Ticket(String from, String to, int typeTicket, String departureDate, double ticketPrice, Passengers passenger) {
        this.from = from;
        this.to = to;
        this.typeTicket = typeTicket;
        this.departureDate = departureDate;
        this.ticketPrice = ticketPrice;
        this.passenger = passenger;
    }

    public Ticket(String from, String to, int typeTicket, String departureDate, String returnDate, double ticketPrice, Passengers passenger) {
        this.from = from;
        this.to = to;
        this.typeTicket = typeTicket;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.ticketPrice = ticketPrice;
        this.passenger = passenger;
    }
        /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }
    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }
    /**
     * @return the typeTicket
     */
    public int getTypeTicket() {
        return typeTicket;
    }
    /**
     * @return the departureDate
     */
    public String getDepartureDate() {
        return departureDate;
    }
    /**
     * @return the returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }
    /**
     * @return the ticketPrice
     */
    public double getTicketPrice() {
        return ticketPrice;
    }
    /**
     * @return the passenger
     */
    public Passengers getPassenger() {
        return passenger;
    }
}
