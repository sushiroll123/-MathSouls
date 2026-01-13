package model.entities.enemies.castle;

import model.entities.enemies.Enemy;

// Attributes and actions for a knight enemy
public class Knight extends Enemy {

    private final static String graphicFilePath = "resources/Enemies/knight.jpg";

    public Knight(int health, int attackDmg, int x, int y) {
        super("Knight", 14, health, attackDmg, x, y, graphicFilePath);
    }
}
