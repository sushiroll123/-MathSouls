package model.entities.enemies.castle;

import model.entities.enemies.Enemy;

// Attributes and actions for a farmer enemy
public class Farmer extends Enemy {

    private final static String graphicFilePath = "resources/Enemies/farmer.jpg";

    public Farmer(int health, int attackDmg, int x, int y) {
        super("Farmer", 13, health, attackDmg, x, y, graphicFilePath);
    }
}
