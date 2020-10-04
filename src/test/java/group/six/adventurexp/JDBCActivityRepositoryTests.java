package group.six.adventurexp;

import group.six.adventurexp.models.Activity;
import group.six.adventurexp.repositories.JDBCActivityRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


public class JDBCActivityRepositoryTests {

    JDBCActivityRepository jdbc = new JDBCActivityRepository();
    Activity deathMatch = new Activity(2,"Deathmatch", 2999.99,"A no-holds-barred blood sport for the whole family!", "No children under the age of 6.");

    @Test
    void createTest(){


        assertEquals(jdbc.create(deathMatch), true);


    }

    @Test
    void readTest(){

        assertEquals(jdbc.readByName("Deathmatch").getDescription(), jdbc.read(jdbc.readByName("Deathmatch").getId()).getDescription());
        assertEquals(deathMatch.getDescription(), jdbc.read(jdbc.readByName("Deathmatch").getId()).getDescription());

    }

    @Test
    void updateTest(){
        Activity changeActivity = jdbc.readByName("Deathmatch");
        changeActivity.setRestriction("Boef!");
        jdbc.update(changeActivity);
        assertEquals(jdbc.read(changeActivity.getId()).getRestriction(), "Boef!");
    }


    @Test
    void deleteTest(){

        assertEquals(jdbc.delete(jdbc.readByName("Deathmatch").getId()), true);

    }

    @Test
    void readAllTest(){
        assertEquals(jdbc.create(deathMatch), true);
        assertEquals(jdbc.create(deathMatch), true);
        assertEquals(jdbc.create(deathMatch), true);

        List<Activity> testList = jdbc.readAll();
        assertEquals(testList.size(), 3);

        assertEquals(jdbc.delete(jdbc.readByName("Deathmatch").getId()), true);
        assertEquals(jdbc.delete(jdbc.readByName("Deathmatch").getId()), true);
        assertEquals(jdbc.delete(jdbc.readByName("Deathmatch").getId()), true);
    }
}
