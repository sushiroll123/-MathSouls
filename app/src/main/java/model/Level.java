package model;

import model.abilities.*;
import model.entities.*;

// Tracks and calculates player level as well as distributes level awards
public class Level {

    private Player player;
    private int level;
    private int xp;
    private int levelSinceLastAbility;
    private Runnable unlockCustomAbilityListener;

    // EFFECTS: User starts at level 0, with 0 experience points
    public Level(Player player) {
        this.levelSinceLastAbility = 20; // first custom ability at lvl 20
        this.player = player;
        level = 0;
        xp = 0;
    }

    // REQUIRES: amount >= 0
    // MODIFIES: this
    // EFFECTS: amount is added to currentXp, if enough xp,
    //          level is increased and ability unlocked
    public void addExperience(int amount) {
        xp += amount;
        checkLevelUp();
    }
    
    // MODIFIES: this
    // EFFECTS: calculates the amount of xp needed for
    //          the next level
    public int xpNeededForNextLevel() {
        double expGrowth = Math.exp(0.1 * (level - 21)); 
        // xpNeeded linear until currentLevel ≈ 50
        double smoother = 1 + Math.exp(-0.000 * (level - 21)); 
        // smooths the exponential growth around currentLevel ≈ 50

        int xpNeeded = (int) (500 // starts xpNeeded at level 0 to 500
                              * 1 + (expGrowth / smoother)
                              + 150 * level); // linear growth is 150
                              // xp needed increases relatively linearly 
        return xpNeeded;
    }

    // MODIFIES: this
    // EFFECTS: checks if can level up and unlock ability;
    //          if can level up, increase level by 1 and 
    //          reduce experience by amount of experience needed
    //          to level up.
    private void checkLevelUp() {
        while (xp >= xpNeededForNextLevel()) {
            xp -= xpNeededForNextLevel();
            level++;
            levelSinceLastAbility--;
            unlockAbilityForLevel(level); // check if can unlock ability
            player.setHealth(player.getHealth() + 75); // increase health by 75
            player.setAttackDmg(player.getAttackDmg() + 15); // increase attackDmg by 15
            player.setAgility(player.getAgility() + 1); // increase agility by 1

        }
    }

    // MODIFIES: this
    // EFFECTS: adds ability Fireball at level 5 and 
    //          ability Heal at level 10
    private void unlockAbilityForLevel(int level) {        
        switch (level) {
            case 5: // unlock Fireball
                player.addAbility(new Fireball());
                break;
            case 10:// unlock Heal
                player.addAbility(new Heal());
                break;
            default: 
                break;
        }
    }

    // MODIFIES: this
    // EFFECTS: adds custom ability
    public CustomAbility unlockCustomAbility(String name, String typeStr) {
        AbilityType type = AbilityType.valueOf(typeStr.toUpperCase());
        CustomAbility ability = new CustomAbility(name, type, player);
        player.addAbility(ability);
        levelSinceLastAbility = 10;
        return ability;
    }

    // getters

    public int getLevel() {
        return level;
    }

    public int getCurrentXp() {
        return xp;
    }

    public int getLevelSinceLastAbility() {
        return levelSinceLastAbility;
    }

    public Runnable getUnlockCustomAbilityListener() {
        return unlockCustomAbilityListener;
    }

    // setters

    public void setLevel(int lvl) {
        this.level = lvl;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setCurrentLevel(int level) {
        this.level = level;
    }

    public void setLevelSinceLastAbility(int levelSinceLastAbility) {
        this.levelSinceLastAbility = levelSinceLastAbility;
    }

    public void setUnlockCustomAbilityListener(Runnable unlockCustomAbilityListener) {
        this.unlockCustomAbilityListener = unlockCustomAbilityListener;
    }
}
