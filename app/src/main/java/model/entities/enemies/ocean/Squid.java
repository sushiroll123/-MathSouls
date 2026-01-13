package model.entities.enemies.ocean;

import model.entities.enemies.Enemy;

// Attributes and actions for a squid enemy
public class Squid extends Enemy {

    private final static String graphicFilePath = "app/src/main/resources/Enemies/squid.jpg";

    public Squid(int health, int attackDmg, int x, int y) {
        super("Squid", 10, health, attackDmg, x, y, graphicFilePath);
    }
}
