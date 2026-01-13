package model.entities.enemies.forest;

import model.entities.enemies.Enemy;

// Attributes and actions for a wolf enemy
public class Wolf extends Enemy {

    private final static String graphicFilePath = "app/src/main/resources/Enemies/wolf.png";
    
    public Wolf(int health, int attackDmg, int x, int y) {
        super("Wolf", 2, health, attackDmg, x, y, graphicFilePath);
    }
}
