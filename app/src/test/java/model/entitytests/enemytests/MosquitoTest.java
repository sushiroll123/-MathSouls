package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.forest.Mosquito;

public class MosquitoTest {

    Mosquito mosquito;

    @Test
    void constructorTest() {
        mosquito = new Mosquito(10, 10, 10, 10);
        assertEquals("Mosquito", mosquito.getName());
        assertEquals(10, mosquito.getHealth());
        assertEquals(10, mosquito.getAttackDmg());
        assertEquals(1, mosquito.getId());
    }

}
