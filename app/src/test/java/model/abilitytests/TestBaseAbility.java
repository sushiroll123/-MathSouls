package model.abilitytests;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.abilities.*;
import model.entities.*;

public class TestBaseAbility {

    private BaseAbility testAbility;
    private Player player;

    // Simple concrete subclass of BaseAbility for testing
    private static class TestAbility extends BaseAbility {
        public TestAbility(String name, String description) {
            super(name, description);
        }

        @Override
        public void use(model.entities.Entity target) {
            // do nothing for testing
        }
    }

    @BeforeEach
    void setUp() {
        testAbility = new TestAbility("TestAbility", "This is a test ability");
        player = new Player("TestDummy");
    }

    @Test
    void testToString() {
        assertEquals("TestAbility", testAbility.toString());
    }

    @Test
    void testGetName() {
        assertEquals("TestAbility", testAbility.getName());
    }

    @Test
    void testDescription() {
        assertEquals("This is a test ability", testAbility.getDescription());
    }

    @Test
    void testFromJsonFireball() {
        JSONObject json = new JSONObject();
        json.put("name", "Fireball");

        BaseAbility ability = BaseAbility.fromJson(json, player);

        assertTrue(ability instanceof Fireball, "Should create a Fireball ability");
    }

    @Test
    void testFromJsonHeal() {
        JSONObject json = new JSONObject();
        json.put("name", "Heal");

        BaseAbility ability = BaseAbility.fromJson(json, player);

        assertTrue(ability instanceof Heal, "Should create a Heal ability");
    }

    @Test
    void testFromJsonCustomAbility() {
        JSONObject json = new JSONObject();
        json.put("name", "LightningStrike");
        json.put("type", "ATTACK");

        BaseAbility ability = BaseAbility.fromJson(json, player);

        assertTrue(ability instanceof CustomAbility, "Should create a CustomAbility");
        CustomAbility custom = (CustomAbility) ability;
        assertEquals("LightningStrike", custom.getName());
        assertEquals(AbilityType.ATTACK, custom.getType());
    }

    @Test
    void testFromJsonInvalidAbilityType() {
        try {
            JSONObject json = new JSONObject();
            json.put("name", "UnknownAbility");
            json.put("type", "INVALID_TYPE");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }
}
