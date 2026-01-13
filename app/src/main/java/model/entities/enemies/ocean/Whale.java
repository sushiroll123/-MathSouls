package model.entities.enemies.ocean;

import model.entities.enemies.Enemy;

// Attributes and actions for a whale enemy
public class Whale extends Enemy {

    private final static String graphicFilePath = "resources/Enemies/squid.jpg";

    public Whale(int health, int attackDmg, int x, int y) {
        super("Whale", 12, health, attackDmg, x, y, graphicFilePath);
    }

}
