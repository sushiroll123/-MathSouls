package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.ocean.Shark;

public class SharkTest {

    Shark shark;

    @Test
    void constructorTest() {
        shark = new Shark(10, 10, 10, 10);
        assertEquals("Shark", shark.getName());
        assertEquals(10, shark.getHealth());
        assertEquals(10, shark.getAttackDmg());
        assertEquals(11, shark.getId());
    }

}
