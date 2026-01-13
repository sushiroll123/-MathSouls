package model.entitytests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.abilities.*;
import model.entities.*;

public class TestPlayer {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("TestPlayer");
    }

    @Test
    void testConstructorInitialState() {
        assertEquals("TestPlayer", player.getName());
        assertEquals(100, player.getHealth());
        assertEquals(10, player.getAttackDmg());
        assertEquals(0, player.getLevel());
        assertEquals(0, player.getAgility());
        assertEquals(0, player.getExperience());
        assertTrue(player.getAbilities().isEmpty());
    }

    @Test
    void testAddAbility() {
        BaseAbility fireball = new Fireball();
        player.addAbility(fireball);

        List<BaseAbility> abilities = player.getAbilities();
        assertEquals(1, abilities.size());
        assertTrue(abilities.contains(fireball));
    }

    @Test
    void testGainExperienceIncreasesXP() {
        int initialXp = player.getExperience();
        player.addExperience(5);
        assertEquals(initialXp + 5, player.getExperience());
    }

    @Test
    void testLevelUpUnlocksAbilities() {
        player.addExperience(10000);
        boolean hasFireball = player.getAbilities().stream().anyMatch(a -> a instanceof Fireball);
        assertTrue(hasFireball);
    }

    @Test
    void testMultipleAbilitiesAdded() {
        player.addAbility(new Fireball());
        player.addAbility(new Heal());

        List<BaseAbility> abilities = player.getAbilities();
        assertEquals(2, abilities.size());
        assertTrue(abilities.stream().anyMatch(a -> a instanceof Fireball));
        assertTrue(abilities.stream().anyMatch(a -> a instanceof Heal));
    }
}
