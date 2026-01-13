package model.entities.enemies.ocean;

import model.entities.enemies.Enemy;

// Attributes and actions for a shark enemy
public class Shark extends Enemy {

    private final static String graphicFilePath = "app/src/main/resources/Enemies/shark.jpg";

    public Shark(int health, int attackDmg, int x, int y) {
        super("Shark", 11, health, attackDmg, x, y, graphicFilePath);
    }
}
