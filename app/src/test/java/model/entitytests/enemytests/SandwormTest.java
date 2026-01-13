package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.desert.Sandworm;

public class SandwormTest {

    Sandworm sandworm;

    @Test
    void testConstructor() {
        sandworm = new Sandworm(10, 10, 10, 10);
        assertEquals("Sandworm", sandworm.getName());
        assertEquals(10, sandworm.getHealth());
        assertEquals(10, sandworm.getAttackDmg());
        assertEquals(9, sandworm.getId());
    }
}
