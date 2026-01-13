package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.castle.Farmer;

public class FarmerTest {

    Farmer farmer;
    
    @Test
    void constructorTest() {
        farmer = new Farmer(10, 10, 10, 10);
        assertEquals("Farmer", farmer.getName());
        assertEquals(10, farmer.getHealth());
        assertEquals(10, farmer.getAttackDmg());
        assertEquals(13, farmer.getId());
    }
}
