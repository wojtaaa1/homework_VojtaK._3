package com.engeto.hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    public List<Booking> getBookings() {
        return bookings;
    }

    private final List<Booking> bookings;

    public BookingManager(List<Booking> bookings) {
        this.bookings = new ArrayList<>(bookings);
    }

    public void addBooking(Booking newBooking) {
        bookings.add(newBooking);
    }

    public void displayAllBookings() {
        System.out.println("\n Informace o všech rezervacích: ");
        for (Booking booking : bookings) {
            System.out.println(booking.getBookingSummary());
        }
    }



    public Booking getBooking(int index) {
        if (index >= 0 && index < bookings.size()) {
            return bookings.get(index);
        }
        else {
            System.out.println("Neplatný index rezervace");
        }
        return null;
    }

    public void clearAllBookings() {
        bookings.clear();
    }

    public int getNumberOfWorkingBookings() {
        int count = 0;
        for (Booking booking : bookings) {
            if (!booking.isTypeOfVacation()) {
                count++;
            }
        }
        return count;
    }

    public double getAverageGuests() {
        double sum = 0;
        for (Booking booking : bookings) {
            sum += booking.getNumberOfGuests();
        }
        return sum / bookings.size();
    }



}
