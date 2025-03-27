package com.bridgelabz.flightScheduling;


class Booking<T> {
    private T bookingId;
    private Flight<?> flight;
    private String passengerName;

    public Booking(T bookingId, Flight<?> flight, String passengerName) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.passengerName = passengerName;
    }

    public void displayBookingInfo() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Passenger: " + passengerName);
        flight.displayFlightInfo();
    }
}

