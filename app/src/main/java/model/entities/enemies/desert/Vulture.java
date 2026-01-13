package model.entities.enemies.desert;

import model.entities.enemies.Enemy;

// Attributes and actions for a vulture enemy
public class Vulture extends Enemy {

    private final static String graphicFilePath = "app/src/main/resources/Enemies/vulture.jpg";

    public Vulture(int health, int attackDmg, int x, int y) {
        super("Vulture", 7, health, attackDmg, x, y, graphicFilePath);
    }

}
