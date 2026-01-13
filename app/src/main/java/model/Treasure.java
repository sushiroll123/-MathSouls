package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Treasure extends JButton {

    private int xp;
    private int money;
    private final static String graphicFilePath = "resources/treasure.jpeg";
    private static BufferedImage graphic;

    public Treasure(int xp, int money) {
        this.xp = xp;
        this.money = money;

        try { 
            graphic = ImageIO.read(new File(graphicFilePath));
        } catch (IOException e) {
            // file path does not exist
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(graphic, 0, 0, 100, 100, null);
    }

    public int getMoney() {
        return money;
    }
    
    public int getXp() {
        return xp;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
