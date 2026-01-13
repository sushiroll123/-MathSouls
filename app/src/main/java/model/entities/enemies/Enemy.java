package model.entities.enemies;

import model.entities.Entity;
import model.entities.Player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// abstract class for all enemies
public abstract class Enemy extends Entity {

    private int x, y;
    protected BufferedImage graphic;    

    public Enemy(String name, int id, int health, int attackDmg, int x, int y, String graphicFilePath) {
        super(name, id, health, attackDmg);
        this.x = x;
        this.y = y;
        try {
            graphic = ImageIO.read(new File(graphicFilePath));
        } catch (IOException e) {
            System.out.println(name + " graphic not found");
        }
    }

    // MODIFIES: player
    // EFFECTS: attempts to reduce player's health by attackDmg
    public void attackPlayer(Player player) {
        player.takeDamage(getAttackDmg()); 
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(graphic, x, y, 50, 50, null);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
