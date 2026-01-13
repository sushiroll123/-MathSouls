package model.entities.enemies.forest;

import model.entities.enemies.Enemy;

// Attributes and actions for a mosquito enemy
public class Mosquito extends Enemy {

    private final static String graphicFilePath = "resources/Enemies/mosquito.jpg";

    public Mosquito(int health, int attackDmg, int x, int y) {
        super("Mosquito", 1, health, attackDmg,x ,y, graphicFilePath);
    }
}
