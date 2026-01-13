package model.entities.enemies.cave;

import model.entities.enemies.Enemy;

// Attributes and actions for a slime enemy
public class Slime extends Enemy {

    private final static String graphicFilePath = "resources/Enemies/slime.jpg";

    public Slime(int health, int attackDmg, int x, int y) {
        super("Slime", 4, health, attackDmg, x, y, graphicFilePath);
    }
}
