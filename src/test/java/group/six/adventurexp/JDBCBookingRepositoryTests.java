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



  class JDBCBookingRespositoryTests {
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
    jdbc2.delete(jdbc2.readByName("Deathmatch").getId());
    }
}
