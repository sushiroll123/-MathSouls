package model.entities.enemies.forest;

import model.entities.enemies.Enemy;

// Attributes and actions for a goblin enemy
public class Goblin extends Enemy {

    private final static String graphicFilePath = "resources/Enemies/goblin.jpg";

    public Goblin(int health, int attackDmg, int x, int y) {
        super("Goblin", 3, health, attackDmg, x, y, graphicFilePath);
    }
}
