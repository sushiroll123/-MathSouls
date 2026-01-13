package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entities.enemies.ocean.Squid;

public class SquidTest {

    Squid squid;

    @Test
    void constructorTest() {
        squid = new Squid(10, 10, 10, 10);
        assertEquals("Squid", squid.getName());
        assertEquals(10, squid.getHealth());
        assertEquals(10, squid.getAttackDmg());
        assertEquals(10, squid.getId());
    }

}
