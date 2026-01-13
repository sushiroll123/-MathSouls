package ui;

import javax.swing.*;

import model.MSGame;
import ui.scenes.WelcomePanel;

// runs the game
public class MathSouls extends JFrame {

    private MSGame game;
    private WelcomePanel panel;

    public MathSouls() {
        super("Math Souls");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game = new MSGame();
        panel = new WelcomePanel(game, this);

        add(panel);

        pack();
        setLocationRelativeTo(null); // center
        setVisible(true);
    }

    public static void main(String[] args) {
        new MathSouls();
    }
}
