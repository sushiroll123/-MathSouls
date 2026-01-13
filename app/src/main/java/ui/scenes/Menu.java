package ui.scenes;

import javax.swing.*;
import java.awt.*;
import ui.scenes.Menu;
import model.MSGame;
import model.abilities.BaseAbility;
import model.abilities.CustomAbility;
import model.Event;
import model.EventLog;

// represents the menu graphic
public class Menu extends JPanel {

    static final int ABILITY_PANEL_WIDTH = 750;
    static final int ABILITY_PANEL_HEIGHT = 75;
    static final int ABILITY_PANEL_X = 25;
    static final int ABILITY_PANEL_Y = 450;

    private MSGame game;
    private EventLog log;

    private JButton levelUpButton;
    private JButton viewAbilityButton;
    private JButton quitButton;
    private JProgressBar xpBar;
    private JPanel abilitiesPanel;

    // EFECTS: Scene is set to Menu 
    public Menu(MSGame game) {
        this.game = game;
        log = EventLog.getInstance();

        setLayout(new BorderLayout());
        setBackground(Color.RED);

        // New Level Up button
        levelUpButton = new JButton("Level Up");
        levelUpButton.setBounds(600, 50, 150, 50);

        // New View Ability button
        viewAbilityButton = new JButton("View Ability");
        viewAbilityButton.setBounds(600, 150, 150, 50);

        // New Quit button
        quitButton = new JButton("Quit");
        quitButton.setBounds(10, 10, 100, 25);

        // New xp Progress Bar
        xpBar = new JProgressBar(0, game.getPlayer().getLevelManager().xpNeededForNextLevel());
        xpBar.setBounds(100, 350, 300, 50);

        add(levelUpButton);
        add(viewAbilityButton);
        add(quitButton);
        add(xpBar);

        setUpButtonActions();
        addAbilitiesPanel();
        setUpxpBar();
    }

    private void setUpxpBar() {
        xpBar.setValue(game.getPlayer().getExperience());
        xpBar.setStringPainted(true);
        xpBar.setForeground(Color.BLUE);
    }

    private void setUpButtonActions() {
        setUpLevelUp();
        setUpViewAbilities();
        setUpQuit();
    }

    private void setUpQuit() {
        quitButton.addActionListener(e -> {
            int choice = javax.swing.JOptionPane.showConfirmDialog(
                    null,
                    "Do you want to save your progress before quitting?", 
                    "Save Game",
                    javax.swing.JOptionPane.YES_NO_CANCEL_OPTION,
                    javax.swing.JOptionPane.QUESTION_MESSAGE
            );

            switch (choice) {
                case javax.swing.JOptionPane.YES_OPTION:
                    game.saveGame();
                    printLog();
                    System.exit(0);
                    break;
                case javax.swing.JOptionPane.NO_OPTION:
                    printLog();
                    System.exit(0);
                    break;
                case javax.swing.JOptionPane.CANCEL_OPTION:
                case javax.swing.JOptionPane.CLOSED_OPTION:
                    // do nothing, let user continue playing
                    break;
            }
        });
    }

    private void setUpViewAbilities() {
        viewAbilityButton.addActionListener(e -> {
            BaseAbility ability;
            try {
                Object[] options = game.getPlayer().getAbilities().toArray();
                ability = (BaseAbility) JOptionPane.showInputDialog(
                    this,
                    "Select ability", "All abilities",
                    javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[0]
                );

                if (ability == null) {
                    return; // user cancelled
                } 

                // Prompt for ability name
                javax.swing.JOptionPane.showMessageDialog(
                        this, ability.getDescription(), // message
                        ability.getName(), // title
                        javax.swing.JOptionPane.INFORMATION_MESSAGE
                );
            } catch (ArrayIndexOutOfBoundsException ex) {
                javax.swing.JOptionPane.showMessageDialog(
                        this, "YOU HAVE NO ABILITIES NLOL"
                );
            }
        });
    }

    private void setUpLevelUp() {
        levelUpButton.addActionListener(e -> {
            game.doLevelUp(); 
            refreshAbilities(); // refresh UI
            xpBar.setValue(game.getPlayer().getExperience());
            JOptionPane.showMessageDialog(this, 
                    "Leveled up! Current level: " + game.getPlayer().getLevel());
        });
    }

    private void addAbilitiesPanel() {
        setLayout(null);
        abilitiesPanel = new JPanel();
        abilitiesPanel.setBackground(Color.BLUE);

        abilitiesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
        abilitiesPanel.setBounds(ABILITY_PANEL_X, ABILITY_PANEL_Y, ABILITY_PANEL_WIDTH, ABILITY_PANEL_HEIGHT);

        add(abilitiesPanel);
    }

    public void refreshUI() {
        refreshAbilities();
        xpBar.setValue(game.getPlayer().getExperience());
    }

    // Dynamically update the abilities list
    private void refreshAbilities() {
        abilitiesPanel.removeAll(); 

        for (String abilityName : game.getPlayer().getAbilityNames()) {
            JLabel abilityLabel = new JLabel(abilityName);
            abilityLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            abilityLabel.setForeground(Color.BLACK);
            abilitiesPanel.add(abilityLabel);
        }

        abilitiesPanel.revalidate();
        abilitiesPanel.repaint(); 
    }

    public void promptCustomAbility() {
        // Prompt for ability type
        String[] options = {"ATTACK", "DEFENSE", "AGILITY"};
        String typeStr = selectAbilityTypePrompt(options);

        if (typeStr == null) {
            return; // user cancelled
        }

        // Prompt for ability name
        String name = selectAbilityNamePrompt();

        if (name == null || name.trim().isEmpty()) {
            return; // user cancelled or empty input
        }

        try {
            CustomAbility ability = game.getPlayer().getLevelManager().unlockCustomAbility(name, typeStr);

            // Update abilities panel immediately
            refreshAbilities();

            showAbilityUnlockedPopup(ability);

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid ability type!", "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void showAbilityUnlockedPopup(CustomAbility ability) {
        // Load PNG from resources of file path
        ImageIcon icon = new ImageIcon("resources/ability_unlocked.png");

        JLabel label = new JLabel(
                "<html><center><h2>Ability Unlocked!</h2>"
                + ability.getName() + "</center></html>",
                icon,
                JLabel.CENTER
        );

        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        JOptionPane.showMessageDialog(
                this,
                label,
                "New Ability :D",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    private String selectAbilityNamePrompt() {
        return
        JOptionPane.showInputDialog(
                this, 
                "You unlocked a custom ability! What do you want to name it?",
                "New Ability!",
                JOptionPane.QUESTION_MESSAGE
        );
    }

    private String selectAbilityTypePrompt(String[] options) {
        return
                (String) JOptionPane.showInputDialog(
                this,
                "Select the type of ability:", "Ability Type",
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]
                );
    }

    private void printLog() {
        System.out.println("----- EVENT LOG -----");
        for (Event e : log) {
            System.out.println(e);
            System.out.println("-------------");
        }
    }
}
