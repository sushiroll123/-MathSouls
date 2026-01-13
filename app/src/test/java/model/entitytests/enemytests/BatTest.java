package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import model.entities.enemies.cave.Bat;

public class BatTest {

    Bat bat;
    
    @Test
    void constructorTest() {
        bat = new Bat(10, 10, 10, 10);
        assertEquals("Bat", bat.getName());
        assertEquals(10, bat.getHealth());
        assertEquals(10, bat.getAttackDmg());
        assertEquals(5, bat.getId());
    }
}
