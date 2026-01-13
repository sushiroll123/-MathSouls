package model.entities.enemies.desert;

import model.entities.enemies.Enemy;

// Attributes and actions for a mummy enemy
public class Mummy extends Enemy {

    private final static String graphicFilePath = "resources/Enemies/mummy.jpg";

    public Mummy(int health, int attackDmg, int x, int y) {
        super("Mummy", 8, health, attackDmg, x, y, graphicFilePath);
    }

}
