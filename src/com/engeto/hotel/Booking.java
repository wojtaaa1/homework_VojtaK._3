package com.engeto.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Room room;
    private Guest mainGuest;
    private List<Guest> otherGuests;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean bookingIsRecreational; // true = rekreační, false = pracovní

    public Booking(Room room, Guest mainGuest, List<Guest> otherGuests, LocalDate startDate, LocalDate endDate, boolean typeOfVacation) {
        if (mainGuest == null) {
            throw new IllegalArgumentException("Nelze vytvořit rezervace bez hosta");
        }
        this.room = room;
        this.mainGuest = mainGuest;
        this.otherGuests = new ArrayList<>(otherGuests);
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingIsRecreational = typeOfVacation;

        //contructor pro challenge
    }    public Booking(Room room, Guest mainGuest, List<Guest> otherGuests) {
        if (mainGuest == null) {
            throw new IllegalArgumentException("Nelze vytvořit rezervace bez hosta");
        }
        this.room = room;
        this.mainGuest = mainGuest;
        this.otherGuests = new ArrayList<>(otherGuests);
        this.startDate = LocalDate.now();
        this.endDate = this.startDate.plusDays(6);
        this.bookingIsRecreational = true;

    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getMainGuest() {
        return mainGuest;
    }

    public void setMainGuest(Guest mainGuest) {
        if (mainGuest == null) {
            throw new IllegalArgumentException("Nelze vytvořit rezervace bez hosta");
        }
        this.mainGuest = mainGuest;
    }

    public List<Guest> getOtherGuests() {
        return otherGuests;
    }

    public void setOtherGuests(List<Guest> otherGuests) {
        this.otherGuests = otherGuests;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isBookingIsRecreational() {
        return bookingIsRecreational;
    }

    public void setBookingIsRecreational(boolean bookingIsRecreational) {
        this.bookingIsRecreational = bookingIsRecreational;
    }

    public void addOtherGuest(Guest guest){
        otherGuests.add(guest);
    }

    public String getBookingSummary(){
        String result = "";
        result += room.getRoomDescription() + "\n";
        result += "Hosté:\n" + mainGuest.getGuestSummary() + "\n";
        for (Guest otherGuests : otherGuests) {
            result += otherGuests.getGuestSummary() + "\n";
        }
        result += "Datum začátku: " + startDate + "\n";
        result += "Datum konce: " + endDate + "\n";
        result += "Typ dovolené: ";
        if (bookingIsRecreational) {   // if (typeOfVacation) {
            result += "rekreační";
        } else {
            result += "pracovní";
        }
        result += "\n";
        return result;
    }

    public int getNumberOfGuests(){
        return otherGuests.size() + 1;
    }

    public String getBookingSummaryFormatted(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d. M. yyyy");
        String formattedStartDate = formatter.format(startDate);
        String formattedEndDate = formatter.format(endDate);
        String formattedBirthDate = formatter.format(mainGuest.getBirthDate());

        String seaView;
        if (room.isHasSeaView()) {
            seaView = "ano";
        } else {
            seaView = "ne";
        }

        int totalGuest = getNumberOfGuests();

        String summary = formattedStartDate + " až " + formattedEndDate + ": " + mainGuest.getFirstName() + " ";
        summary += mainGuest.getLastName() + " " + "("+ formattedBirthDate + ")";
        summary += " [" + totalGuest + ", " + seaView + "]" + " za " + room.getPricePerNight() + " Kč";

        return summary;
    }

    public long getBookingLength() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    public BigDecimal getPrice (){
        int numberOfNights = (int) getBookingLength();
        BigDecimal pricePerNight = room.getPricePerNight();
        BigDecimal totalPrice = pricePerNight.multiply(BigDecimal.valueOf(numberOfNights));
        return totalPrice;
    }

}
