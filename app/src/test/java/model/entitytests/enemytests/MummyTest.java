package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.desert.Mummy;

public class MummyTest {

    Mummy mummy;

    @Test
    void testConstructor() {
        mummy = new Mummy(10, 10, 10, 10);
        assertEquals("Mummy", mummy.getName());
        assertEquals(10, mummy.getHealth());
        assertEquals(10, mummy.getAttackDmg());
        assertEquals(8, mummy.getId());
    }
}
