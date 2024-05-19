package com.engeto.hotel;

import java.util.ArrayList;
import java.util.List;

public class ListOfBookings {
    private final List<Booking> bookings;

    public ListOfBookings(List<Booking> bookings) {
        this.bookings = new ArrayList<>(bookings);
    }

    public List<Booking> setBookingsToManager() {
        return bookings;
    }

    public void addBookingsToManager(Booking booking) {
        bookings.add(booking);
    }

    public void displayAllBookings() {
        System.out.println("\n Informace o všech rezervacích: ");
        for (Booking booking : bookings) {
            System.out.println(booking.getBookingSummary());
        }
    }



}
