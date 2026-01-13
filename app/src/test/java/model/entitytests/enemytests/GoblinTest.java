package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.forest.Goblin;

public class GoblinTest {

    Goblin goblin;
    
    @Test
    void constructorTest() {
        goblin = new Goblin(10, 10, 10, 10);
        assertEquals("Goblin", goblin.getName());
        assertEquals(10, goblin.getHealth());
        assertEquals(10, goblin.getAttackDmg());
        assertEquals(3, goblin.getId());
    }
}
