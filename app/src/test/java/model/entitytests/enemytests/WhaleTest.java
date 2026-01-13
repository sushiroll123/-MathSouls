package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.ocean.Whale;

public class WhaleTest {

    Whale whale;

    @Test
    void constructorTest() {
        whale = new Whale(10, 10, 10, 10);
        assertEquals("Whale", whale.getName());
        assertEquals(10, whale.getHealth());
        assertEquals(10, whale.getAttackDmg());
        assertEquals(12, whale.getId());
    }

}
