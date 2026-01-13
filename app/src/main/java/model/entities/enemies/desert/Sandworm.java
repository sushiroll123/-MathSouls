package model.entities.enemies.desert;

import model.entities.enemies.Enemy;

// Attributes and actions for a sandworm enemy
public class Sandworm extends Enemy {

    private final static String graphicFilePath = "app/src/main/resources/Enemies/sandworm.jpg";

    public Sandworm(int health, int attackDmg, int x, int y) {
        super("Sandworm", 9, health, attackDmg,x , y, graphicFilePath);
    }

}
