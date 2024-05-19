import com.engeto.hotel.Booking;
import com.engeto.hotel.Guest;
import com.engeto.hotel.ListOfBookings;
import com.engeto.hotel.Room;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Guest guest1 = new Guest("Adéla", "Malíková", LocalDate.of(1993,3,13));
        Guest guest2 = new Guest("Jan", "Dvořáček", LocalDate.of(1995,5,5));

        System.out.println("Hosté jsou:\n "+ guest1.getGuestSummary() + " a " + guest2.getGuestSummary());

        Room room1 = new Room(1,1, true,true, BigDecimal.valueOf(1000));
        Room room2 = new Room(2,1, true,true, BigDecimal.valueOf(1000));
        Room room3 = new Room(3,3, false,true, BigDecimal.valueOf(2400));

        System.out.println("\n Informace o pokojích:");
        System.out.println(room1.getRoomDescription());
        System.out.println(room2.getRoomDescription());
        System.out.println(room3.getRoomDescription() + "\n");

        Booking booking1 = new Booking(room1, guest1, new ArrayList<>(), LocalDate.of(2021,7,19), LocalDate.of(2021,7,26), true);

        Booking booking2 = new Booking(room3, guest1, new ArrayList<>(), LocalDate.of(2021,9,1), LocalDate.of(2021,9,14), true);
        booking2.addOtherGuest(guest2);

        Booking booking3 = new Booking(room2, guest2, new ArrayList<>());

        ListOfBookings listOfBookings = new ListOfBookings(new ArrayList<>());
        listOfBookings.addBookingsToManager(booking1);
        listOfBookings.addBookingsToManager(booking2);
        listOfBookings.addBookingsToManager(booking3);

        listOfBookings.displayAllBookings();

    }
}