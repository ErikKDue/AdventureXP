package group.six.adventurexp;

import group.six.adventurexp.models.Activity;
import group.six.adventurexp.repositories.JDBCActivityRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JDBCActivityRepositoryTests {

    JDBCActivityRepository jdbc = new JDBCActivityRepository();
    Activity deathMatch = new Activity(1,"Deathmatch", 2999.99,"A no-holds-barred blood sport for the whole family!", "No children under the age of 6.");

    @Test
    void createTest(){


        assertEquals(jdbc.create(deathMatch), true);


    }
}
