import com.engeto.hotel.Booking;
import com.engeto.hotel.Guest;
import com.engeto.hotel.BookingManager;
import com.engeto.hotel.Room;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        BookingManager listOfBookings = new BookingManager(new ArrayList<>());


        fillBookings(listOfBookings);
        printGuestStatistics(listOfBookings);
        printAllBookings(listOfBookings);
        printRecreationalBookings(listOfBookings, 8);
        callMethods(listOfBookings);






    }

    private static void callMethods(BookingManager listOfBookings) {
        System.out.println("Počet rezervací pro pracovní pobyty: " + listOfBookings.getNumberOfWorkingBookings());
        System.out.println("Průměrný počet hostů na rezervaci: " + listOfBookings.getAverageGuests());

        System.out.println("Počet nocí pro Booking1: " + listOfBookings.getBookings().get(0).getBookingLength());
        System.out.println("Celková cena za Booking1 pro pana " +listOfBookings.getBooking(0).getMainGuest().getLastName() + " je " + listOfBookings.getBooking(0).getPrice() + " Kč");

        System.out.println("Celkový počet rezervací " + listOfBookings.getBookings().size());
    }

    private static void fillBookings(BookingManager listOfBookings){
            Guest karelDvorak1 = new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15));
            Guest karelDvorak2 = new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3));
            Guest karolinaTmava = new Guest("Karolina", "Tmava", LocalDate.of(1985, 5, 7));

            Room room1 = new Room(1,1, true,true, BigDecimal.valueOf(1000));
            Room room2 = new Room(2,1, true,true, BigDecimal.valueOf(1000));
            Room room3 = new Room(3,3, false,true, BigDecimal.valueOf(2400));

            listOfBookings.addBooking(new Booking(room3, karelDvorak1, new ArrayList<>(), LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), false));
            listOfBookings.addBooking(new Booking(room2, karelDvorak2, new ArrayList<>(), LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), true));
            listOfBookings.addBooking(new Booking(room3, karolinaTmava, new ArrayList<>(), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), true));

        for (int i = 0; i < 10; i++){
                LocalDate startDate = LocalDate.of(2023, 8, 1).plusDays(i * 2);
                LocalDate endDate = startDate.plusDays(1);
                listOfBookings.addBooking(new Booking(room3, karolinaTmava, new ArrayList<>(), startDate, endDate, true));
            }

        // test přidání hostů do stávajících rezervací
        listOfBookings.getBooking(1).addOtherGuest(new Guest("Jana", "Nováková", LocalDate.of(1989, 2, 12)));
        listOfBookings.getBooking(1).addOtherGuest(new Guest("Jana", "Nováková", LocalDate.of(1989, 2, 12)));
        listOfBookings.getBooking(1).addOtherGuest(new Guest("Jana", "Nováková", LocalDate.of(1989, 2, 12)));
        listOfBookings.getBooking(5).addOtherGuest(new Guest("Jana", "Nováková", LocalDate.of(1989, 2, 12)));
    }

    private static void printAllBookings(BookingManager listOfBookings) {
        System.out.println("\nInformace o všech rezervacích:");
        for (Booking booking : listOfBookings.getBookings()) {
            System.out.println(booking.getBookingSummaryFormatted());
        }
    }

    private static void printGuestStatistics(BookingManager listOfBookings) {
        int singleGuestBookings = 0;
        int doubleGuestBookings = 0;
        int moreThanTwoGuestsBookings = 0;

        for (Booking booking : listOfBookings.getBookings()) {
            int numberOfGuests = booking.getNumberOfGuests();
            if (numberOfGuests == 1) {
                singleGuestBookings++;
            } else if (numberOfGuests == 2) {
                doubleGuestBookings++;
            } else {
                moreThanTwoGuestsBookings++;
            }
        }

        System.out.println("Statistika podle počtu hostů");
        System.out.println("Celkový počet rezervací s jedním hostem: " + singleGuestBookings);
        System.out.println("Celkový počet rezervací se dvěma hosty: " + doubleGuestBookings);
        System.out.println("Celkový počet rezervací s více než dvěma hosty: " + moreThanTwoGuestsBookings);
    }

    private static void printRecreationalBookings(BookingManager listOfBookings, int n) {
        int count = 0;
        System.out.println("Prvních " + n + " rezervací pro rekreační pobyty:");
        for (Booking booking : listOfBookings.getBookings()) {
            if (!booking.isTypeOfVacation()) {
                continue;
            }
            System.out.println(booking.getBookingSummaryFormatted());
            count++;
            if (count == n) {
                break;
            }
        }
    }

}