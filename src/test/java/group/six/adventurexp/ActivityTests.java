package group.six.adventurexp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

public class ActivityTests {

    Activity testActivitySetup(){
        Activity deathMatch = new Activity("Deathmatch", 2999.99,"A no-holds-barred blood sport for the whole family!", "No children under the age of 6.");
        return deathMatch;
    }


    @Test
    void GetterAndConstructorTest(){
        //Activity deathMatch = new Activity("Deathmatch", 2999.99,"A no-holds-barred blood sport for the whole family!", "No children under the age of 6.");
        Activity deathMatch = testActivitySetup();
        assertEquals(deathMatch.getName(), "Deathmatch");
        assertEquals(deathMatch.getDescription(), "A no-holds-barred blood sport for the whole family!");
        assertEquals(deathMatch.getRestriction(), "No children under the age of 6.");
        assertEquals(deathMatch.getPrice(), 2999.99);
    }

    @Test
    void ConsoleDisplayTest(){
        Activity deathMatch = testActivitySetup();
        deathMatch.display();
        //testing console output looks fucking complicated holy shit
    }
}
