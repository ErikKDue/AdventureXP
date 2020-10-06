package group.six.adventurexp;

import group.six.adventurexp.models.Activity;
import group.six.adventurexp.models.Booking;
import group.six.adventurexp.repositories.JDBCActivityRepository;
import group.six.adventurexp.repositories.JDBCBookingRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



 public class JDBCBookingRepositoryTests {
    JDBCBookingRepository jdbc1 = new JDBCBookingRepository();

    @Test
    void TestBattery(){
    Activity deathMatch = new Activity(2,"Deathmatch", 2999.99,"A no-holds-barred blood sport for the whole family!", "No children under the age of 6.");
    JDBCActivityRepository jdbc2 = new JDBCActivityRepository();
    jdbc2.create(deathMatch);

    Booking testBooking= new Booking("Deathmatch", LocalDate.now(), 12, 4, "Eriks Telefonnummer");
    assertEquals(jdbc1.create(testBooking), true);

    Booking readBooking = jdbc1.readByClient(testBooking.getTelephoneNumber());
    assertEquals(readBooking.getParticipants(), testBooking.getParticipants());

    readBooking.setParticipants(8);

    assertEquals(jdbc1.update(readBooking), true);

    readBooking.setParticipants(200);
    readBooking = jdbc1.readByClient(testBooking.getTelephoneNumber());
    assertEquals(readBooking.getParticipants(), 8);
    assertNotEquals(readBooking.getParticipants(), testBooking.getParticipants());

    assertEquals(    jdbc1.delete(readBooking.getId()), true);

    List<Booking> Danny = jdbc1.readAll();
    jdbc1.create(testBooking);
    jdbc1.create(testBooking);
    jdbc1.create(testBooking);
    List<Booking> Donny = jdbc1.readAll();
    assertEquals(Danny.size()-Donny.size(), -3);


       for (Booking booking: Donny
            ) {    jdbc1.delete(jdbc1.readByClient(booking.getTelephoneNumber()).getId()); }

       jdbc2.delete(jdbc2.readByName("Deathmatch").getId());
    }

    @Test
    void readAllByClientTest(){

       Activity deathMatch = new Activity(2,"Deathmatch", 2999.99,"A no-holds-barred blood sport for the whole family!", "No children under the age of 6.");
       JDBCActivityRepository jdbc2 = new JDBCActivityRepository();
       jdbc2.create(deathMatch);

       Booking testBooking= new Booking("Deathmatch", LocalDate.now(), 12, 4, "Eriks Telefonnummer");
       assertEquals(jdbc1.create(testBooking), true);
       assertEquals(jdbc1.create(testBooking), true);
       assertEquals(jdbc1.create(testBooking), true);

       List<Booking> testList = jdbc1.readAllByClient(testBooking.getTelephoneNumber());
       for (Booking booking:testList
            ) {assertEquals(testBooking.getTelephoneNumber(), booking.getTelephoneNumber());

       }

       for (Booking booking:testList
       ) {jdbc1.delete(booking.getId());

       }
       jdbc2.delete(jdbc2.readByName("Deathmatch").getId());
    }

}
