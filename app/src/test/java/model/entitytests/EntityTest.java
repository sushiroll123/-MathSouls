package model.entitytests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.entities.Entity;


public class EntityTest {

    private Entity testEntity;

    // Simple concrete subclass of Entity for testing
    private static class TestEntity extends Entity {
        public TestEntity(String name, int id, int health, int attackDmg) {
            super(name, id, health, attackDmg);
        }
    }

    @BeforeEach
    void setUp() {
        testEntity = new TestEntity("Goblin", 1, 100, 15);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("Goblin", testEntity.getName());
        assertEquals(1, testEntity.getId());
        assertEquals(100, testEntity.getHealth());
        assertEquals(15, testEntity.getAttackDmg());
        assertTrue(testEntity.isActive());
    }

    @Test
    void testTakeDamage() {
        testEntity.takeDamage(20);
        assertEquals(80, testEntity.getHealth());
    }

    @Test
    void testAddHealth() {
        testEntity.takeDamage(50);
        testEntity.addHealth(30);
        assertEquals(80, testEntity.getHealth());
    }

    @Test
    void testSetters() {
        testEntity.setHealth(200);
        testEntity.setAttackDmg(25);
        assertEquals(200, testEntity.getHealth());
        assertEquals(25, testEntity.getAttackDmg());
    }

    @Test
    void testDestroy() {
        testEntity.destroy();
        assertFalse(testEntity.isActive());
    }
}
