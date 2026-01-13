package model.entities.enemies.castle;

import model.entities.enemies.Enemy;

// Attributes and actions for a royal knight enemy
public class RoyalKnight extends Enemy {

    private final static String graphicFilePath = "resources/Enemies/royalKnight.jpg";

    public RoyalKnight(int health, int attackDmg, int x, int y) {
        super("RoyalKnight", 15, health, attackDmg, x, y, graphicFilePath);
    }
}
