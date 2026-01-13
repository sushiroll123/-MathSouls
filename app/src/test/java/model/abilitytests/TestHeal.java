package model.abilitytests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.abilities.Heal;
import model.entities.Entity;

class TestHeal {

    private Heal heal;
    private Entity dummyTarget;

    // Test dummy
    private static class TestEntity extends Entity {
        public TestEntity(String name, int id, int health, int baseAttackDmg) {
            super(name, id, health, baseAttackDmg);
        }

        @Override
        public void addHealth(int amount) {
            setHealth(getHealth() + amount);
        }
    }

    @BeforeEach
    void setUp() {
        heal = new Heal();
        dummyTarget = new TestEntity("Dummy", 1, 50, 10);
    }

    @Test
    void testHealIncreasesHealth() {
        int initialHealth = dummyTarget.getHealth();
        heal.use(dummyTarget);
        int expectedHealth = initialHealth + 50;
        assertEquals(expectedHealth, dummyTarget.getHealth());
    }

    @Test
    void testMultipleHeals() {
        heal.use(dummyTarget);
        heal.use(dummyTarget);
        int expectedHealth = 50 + 50 * 2; // initial + 2 heals
        assertEquals(expectedHealth, dummyTarget.getHealth());
    }

    @Test
    void testHealWorksFromZeroHealth() {
        dummyTarget.setHealth(0);
        heal.use(dummyTarget);
        int expectedHealth = 50;
        assertEquals(expectedHealth, dummyTarget.getHealth());
    }
}
