package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.cave.Slime;

public class SlimeTest {

    Slime slime;

    @Test
    void constructorTest() {
        slime = new Slime(10, 10, 10, 10);
        assertEquals("Slime", slime.getName());
        assertEquals(10, slime.getHealth());
        assertEquals(10, slime.getAttackDmg());
        assertEquals(4, slime.getId());
    }

}
