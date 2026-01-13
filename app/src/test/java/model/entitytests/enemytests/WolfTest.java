package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.forest.Wolf;

public class WolfTest {

    Wolf wolf;

    @Test
    void constructorTest() {
        wolf = new Wolf(10, 10, 10, 10);
        assertEquals("Wolf", wolf.getName());
        assertEquals(10, wolf.getHealth());
        assertEquals(10, wolf.getAttackDmg());
        assertEquals(2, wolf.getId());

    }

}
