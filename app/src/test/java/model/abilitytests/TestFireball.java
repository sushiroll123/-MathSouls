package model.abilitytests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.abilities.Fireball;
import model.entities.Entity;

public class TestFireball {
    
    private Fireball fireball;
    private Entity dummyTarget;

    // Test dummy
    private static class TestEntity extends Entity {
        public TestEntity(String name, int id, int health, int baseAttackDmg) {
            super(name, id, health, baseAttackDmg);
        }

        @Override
        public void takeDamage(int damage) {
            setHealth(getHealth() - damage);
        }
    }

    @BeforeEach
    void setUp() {
        fireball = new Fireball();
        dummyTarget = new TestEntity("Dummy", 1, 100, 10);
    }

    @Test
    void testFireballReducesHealth() {
        int initialHealth = dummyTarget.getHealth();
        fireball.use(dummyTarget);
        int expectedHealth = initialHealth - 50;
        assertEquals(expectedHealth, dummyTarget.getHealth());
    }

    @Test
    void testMultipleFireballs() {
        fireball.use(dummyTarget);
        fireball.use(dummyTarget);
        int expectedHealth = 100 - 50 * 2; // initial - 2 fireballs
        assertEquals(expectedHealth, dummyTarget.getHealth());
    }
}
