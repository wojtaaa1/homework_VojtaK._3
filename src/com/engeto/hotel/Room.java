package com.engeto.hotel;

import java.math.BigDecimal;

public class Room {
    private int roomNumber;
    private int capacity;
    private boolean hasBalcony;
    private boolean hasSeaView;
    private BigDecimal pricePerNight;

    public Room(int roomNumber, int capacity, boolean hasBalcony, boolean hasSeaView, BigDecimal pricePerNight) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.hasBalcony = hasBalcony;
        this.hasSeaView = hasSeaView;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean isHasSeaView() {
        return hasSeaView;
    }

    public void setHasSeaView(boolean hasSeaView) {
        this.hasSeaView = hasSeaView;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getRoomDescription(){
        String description = "Pokoj číslo " + roomNumber + " s " + capacity;
                if (capacity == 1) {
                    description += " lůžkem";
                } else {
                    description += " lůžky";
                }
                description += " za cenu " + pricePerNight + " Kč/noc.";
                if (hasBalcony) {
                    description += " Má balkón.";
                } else {
                    description += " Bez balkónu.";
                }
                if (hasSeaView) {
                    description += " S výhledem na moře.";
                } else {
                    description += " Bez výhledu na moře.";
                }
                return description;
    }
}
