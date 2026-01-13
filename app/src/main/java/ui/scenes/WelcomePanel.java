package ui.scenes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.MSGame;
import ui.GameArtiste;
import ui.MathSouls;

public class WelcomePanel extends JPanel {

    private JLabel welcomePrompt;
    private JButton loadSaveButton;
    private JTextField nameField;

    private MSGame game;
    private MathSouls ms;

    public WelcomePanel(MSGame game, MathSouls ms) {
        setPreferredSize(new Dimension(MSGame.WIDTH, MSGame.HEIGHT));
        setBackground(Color.CYAN);
        setLayout(null);

        this.game = game;
        this.ms = ms;

        // New welcome prompt
        welcomePrompt = new JLabel("WELCOME! Enter username: ");
        welcomePrompt.setFont(new Font("Arial", Font.BOLD, 20));
        welcomePrompt.setBounds(50, 50, 400, 30);

        // New name field
        nameField = new JTextField();
        nameField.setBounds(50, 90, 300, 30);

        // New load save button
        loadSaveButton = new JButton("Load Save");
        loadSaveButton.setBounds(50, 140, 200, 40);

        add(nameField);
        add(welcomePrompt);
        add(loadSaveButton);

        addActions();
    }

    private void addActions() {
        // If player loads save file
        loadSaveButton.addActionListener(e -> {
            game.loadGame();
            startGame();
        });

        // If user presses Enter
        nameField.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                game.createPlayer(name);
            }
            startGame();
        });
    }

    private void startGame() {
        ms.getContentPane().removeAll();
        ms.getContentPane().add(new GameArtiste(game));
        ms.revalidate();
        ms.repaint();
    }

}
