package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.cave.Golem;

public class GolemTest {

    Golem golem;

    @Test
    void testConstructor() {
        golem = new Golem(10, 10, 10, 10);
        assertEquals("Golem", golem.getName());
        assertEquals(10, golem.getHealth());
        assertEquals(10, golem.getAttackDmg());
        assertEquals(6, golem.getId());
    }
}
