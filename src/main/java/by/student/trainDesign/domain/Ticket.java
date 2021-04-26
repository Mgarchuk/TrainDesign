package by.student.trainDesign.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Ticket {
    private final String ticketId;
    private String userId;
    private final int passengerCarriageId;
    private final int placeNumber;
    private final Station departureStation;
    private final Station arrivalStation;
    private double price;
    private final Date departureDate;
    private final Date arrivalDate;
    private boolean isBedLinenIncluded;

    private static final Logger logger = LoggerFactory.getLogger(Ticket.class.getName());

    public Ticket(String ticketId, int passengerCarriageId, int placeNumber, Station departureStation,
                  Station arrivalStation, double price, Date departureDate, Date arrivalDate,
                  boolean isBedLinenIncluded) {
        this.ticketId = ticketId;
        this.passengerCarriageId = passengerCarriageId;
        this.placeNumber = placeNumber;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.price = price;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.isBedLinenIncluded = isBedLinenIncluded;

        logger.info("Ticket created");
    }

    public Ticket(String ticketId, int passengerCarriageId, int placeNumber, Station departureStation,
                  Station arrivalStation, double price, Date departureDate, Date arrivalDate) {
        this(ticketId, passengerCarriageId, placeNumber, departureStation, arrivalStation, price, departureDate,
                arrivalDate, false);
    }

    public Ticket(String ticketId, String userId, int passengerCarriageId, int placeNumber, Station departureStation,
                  Station arrivalStation, double price, Date departureDate, Date arrivalDate) {
        this(ticketId, userId, passengerCarriageId, placeNumber, departureStation, arrivalStation, price, departureDate,
                arrivalDate, false);
    }

    public Ticket(String ticketId, String userId, int passengerCarriageId, int placeNumber, Station departureStation,
                  Station arrivalStation, double price, Date departureDate, Date arrivalDate,
                  boolean isBedLinenIncluded) {
        this(ticketId, passengerCarriageId, placeNumber, departureStation, arrivalStation, price, departureDate,
                arrivalDate, isBedLinenIncluded);
        this.userId = userId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public int getPassengerCarriageId() {
        return passengerCarriageId;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public double getPrice() {
        return price;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public boolean isBedLinenIncluded() {
        return isBedLinenIncluded;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBedLinenIncluded(boolean bedLinenIncluded) {
        isBedLinenIncluded = bedLinenIncluded;
    }

}
