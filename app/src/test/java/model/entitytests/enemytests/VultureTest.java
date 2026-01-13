package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.desert.Vulture;

public class VultureTest {

    Vulture vulture;

    @Test
    void testConstructor() {
        vulture = new Vulture(10, 10, 10, 10);
        assertEquals("Vulture", vulture.getName());
        assertEquals(10, vulture.getHealth());
        assertEquals(10, vulture.getAttackDmg());
        assertEquals(7, vulture.getId());
    }
}
