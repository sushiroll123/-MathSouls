package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.abilities.*;
import model.entities.Player;

public class TestLevel {

    private Player testPlayer;
    Level level;

    @BeforeEach
    void setUp() {
        testPlayer = new Player("TestPlayer");
        level = testPlayer.getLevelManager();
    }

    @Test
    void testInitialState() {
        assertEquals(0, level.getLevel());
        assertEquals(0, level.getCurrentXp());
        assertTrue(testPlayer.getAbilities().isEmpty());
    }

    @Test
    void testLevelUpOnce() {
        double expGrowth = Math.exp(0.1 * (level.getLevel() - 21)); 
        // xpNeeded linear until currentLevel ≈ 50
        double smoother = 1 + Math.exp(-0.000 * (level.getLevel() - 21)); 
        // smooths the exponential growth around currentLevel ≈ 50

        int xpNeeded = (int) (500 // starts xpNeeded at level 0 to 500
                              * 1 + (expGrowth / smoother)
                              + 150 * level.getLevel()); // linear growth is 150
                              // xp needed increases relatively linearly 
        level.addExperience(xpNeeded);
        assertEquals(1, level.getLevel()); // level increase by 1
        assertEquals(0, level.getCurrentXp()); // no xp 'left over'
        assertEquals(175, testPlayer.getHealth()); // health increases by 75
        assertEquals(25, testPlayer.getAttackDmg()); // attachDmg increases by 15
        assertEquals(1, testPlayer.getAgility()); // agility increases by 1
    }

    @Test
    void testAddExperienceWithoutLevelUp() {
        level.addExperience(1);
        assertEquals(1, level.getCurrentXp());
        assertEquals(0, level.getLevel());
    }

    @Test
    void testUnlockFireballAtLevel5() {
        level.setLevel(4);
        level.addExperience(10000);
        boolean hasFireball = testPlayer.getAbilities().stream().anyMatch(a -> a instanceof Fireball);
        // converts ArrayList to stream, anyMatch() uses lambda to find instance of Fireball
        assertTrue(hasFireball);
    }

    @Test
    void testUnlockHealAtLevel10() {
        level.setLevel(9);
        level.addExperience(10000);
        boolean hasHeal = testPlayer.getAbilities().stream().anyMatch(a -> a instanceof Heal);
        // converts ArrayList to stream, anyMatch() uses lambda to find instance of Heal
        assertTrue(hasHeal);
    }

    @Test
    void testMultipleLevelUpsAtOnce() {
        level.setLevel(0);

        double expGrowth = Math.exp(0.1 * (level.getLevel() - 21)); 
        // xpNeeded linear until currentLevel ≈ 50
        double smoother = 1 + Math.exp(-0.000 * (level.getLevel() - 21)); 
        // smooths the exponential growth around currentLevel ≈ 50

        int xpNeeded = (int) (500 // starts xpNeeded at level 0 to 500
                              * 1 + (expGrowth / smoother)
                              + 150 * level.getLevel()); // linear growth is 150
                              // xp needed increases relatively linearly 

        level.addExperience(xpNeeded);
        level.addExperience(xpNeeded);
        level.addExperience(xpNeeded); // level up to level 3

        assertEquals(2, level.getLevel());
        assertEquals(250, testPlayer.getHealth());
        assertEquals(40, testPlayer.getAttackDmg());
        assertEquals(2, testPlayer.getAgility());
    }

    @Test
    void testUnlockCustomAbility() {
        level.setLevelSinceLastAbility(0);
        level.unlockCustomAbility("Lightning", "Attack");

        assertEquals(1, testPlayer.getAbilities().size());
        CustomAbility ability = (CustomAbility) testPlayer.getAbilities().get(0);
        assertEquals("Lightning", ability.getName());
        assertEquals(AbilityType.ATTACK, ability.getType());

        assertEquals(10, testPlayer.getLevelManager().getLevelSinceLastAbility());
    }

    @Test
    void testSetXp() {
        level.setXp(42);  
        assertEquals(42, level.getCurrentXp());

        level.setXp(0);   // reset XP
        assertEquals(0, level.getCurrentXp());
    }
}

