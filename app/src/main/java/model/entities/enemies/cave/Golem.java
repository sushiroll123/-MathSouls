package model.entities.enemies.cave;

import model.entities.enemies.Enemy;

// Attributes and actions for a golem enemy
public class Golem extends Enemy {
    
    private final static String graphicFilePath = "app/src/main/resources/Enemies/golem.jpg";

    public Golem(int health, int attackDmg, int x, int y) {
        super("Golem", 6, health, attackDmg, x, y, graphicFilePath);
    }

}
