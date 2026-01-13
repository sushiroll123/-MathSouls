package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.castle.RoyalKnight;

public class RoyalKnightTest {

    RoyalKnight royalKnight;

    @Test
    void constructorTest() {
        royalKnight = new RoyalKnight(10, 10, 10, 10);
        assertEquals("RoyalKnight", royalKnight.getName());
        assertEquals(10, royalKnight.getHealth());
        assertEquals(10, royalKnight.getAttackDmg());
        assertEquals(15, royalKnight.getId());
    }

}
