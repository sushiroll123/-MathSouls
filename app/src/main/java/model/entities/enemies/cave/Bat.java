package model.entities.enemies.cave;

import model.entities.enemies.Enemy;

// Attributes and actions for a bat enemy
public class Bat extends Enemy {

    private final static String graphicFilePath = "app/src/main/resources/Enemies/bat.jpg";

    public Bat(int health, int attackDmg, int x, int y) {
        super("Bat", 5, health, attackDmg, x, y, graphicFilePath);
    }
}
