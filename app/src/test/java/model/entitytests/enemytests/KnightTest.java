package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.castle.Knight;

public class KnightTest {

    Knight knight;
    
    @Test
    void constructorTest() {
        knight = new Knight(10, 10, 10, 10);
        assertEquals("Knight", knight.getName());
        assertEquals(10, knight.getHealth());
        assertEquals(10, knight.getAttackDmg());
        assertEquals(14, knight.getId());
    }
}
