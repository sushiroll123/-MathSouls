package model.abilitytests;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import model.abilities.AbilityType;
import model.abilities.CustomAbility;
import model.entities.Entity;
import model.entities.Player;

public class TestCustomAbility {

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

    CustomAbility testAttack;
    CustomAbility testDefense;
    CustomAbility testAgility;

    Player testPlayer;
    Entity dummyTarget;

    @BeforeEach
    void setup() {
        testPlayer = new Player("Tester");

        testPlayer.getLevelManager().setCurrentLevel(20);
        dummyTarget = new TestEntity("Dummy", 1, 200, 10);
        
        testAttack = new CustomAbility("testAttack", AbilityType.ATTACK, testPlayer);
        testDefense = new CustomAbility("testDefense", AbilityType.DEFENSE, testPlayer);
        testAgility = new CustomAbility("testAgility", AbilityType.AGILITY, testPlayer);
    }
    
    @Test 
    void testConstructorInitialState() {
        // test name
        assertEquals("testAttack", testAttack.getName());
        assertEquals("testDefense", testDefense.getName());
        assertEquals("testAgility", testAgility.getName());
        // test description
        assertEquals("Deal 200 damage", testAttack.getDescription());
        assertEquals("Take 20% less damage next turn", testDefense.getDescription());
        assertEquals("Agility increased by 2 for three turns", testAgility.getDescription());
        // test type
        assertEquals(AbilityType.ATTACK, testAttack.getType());
        assertEquals(AbilityType.DEFENSE, testDefense.getType());
        assertEquals(AbilityType.AGILITY, testAgility.getType());
        // test effect
        assertEquals(200, testAttack.getEffect());
        assertEquals(0.2, testDefense.getEffect());
        assertEquals(2, testAgility.getEffect());
    }

    @Test
    void testToJson() {
        JSONObject json = testAttack.toJson();

        assertEquals("testAttack", json.getString("name"));
        assertEquals("Deal 200 damage", json.getString("description"));
        assertEquals("ATTACK", json.getString("type"));
        assertEquals(200, json.getInt("effect"));
    }

    @Test
    void testAttackUse() {
        int initialHealth = dummyTarget.getHealth();
        testAttack.use(dummyTarget);
        int expectedHealth = initialHealth - 200;
        assertEquals(expectedHealth, dummyTarget.getHealth());
    }

    @Test
    void testDefenseUse() {
        // need to make a turn manager
    }

    @Test
    void testAgilityUse() {
        // need to make a turn manager
    }
}
