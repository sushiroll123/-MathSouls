package ui.scenes.stages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import model.Treasure;
import model.entities.enemies.*;
import ui.GameArtiste;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jspecify.annotations.NonNull;

// abstract class representing attributes of all stages
public abstract class Stage extends JPanel {
    
    private JButton nextRound;
    private JButton returnToMap;
    protected Treasure treasure;

    private JLabel roundSign;

    private GameArtiste ga;
    private String name;
    private int round;
    private List<List<Enemy>> enemies;

    public Stage(GameArtiste ga, String name) {
        setLayout(null);
        this.ga = ga;
        this.name = name;
        round = 0;

        nextRound = new JButton("Next Round");
        nextRound.setBounds(250, 10, 100, 100);

        returnToMap = new JButton("Return to Map");
        returnToMap.setBounds(350, 10, 100, 100);

        treasure = new Treasure(0, 0);
        treasure.setBounds(350, 290, 100, 100);
        treasure.setVisible(false);

        roundSign = new JLabel(String.valueOf(round + 1));
        roundSign.setOpaque(true);
        roundSign.setBackground(Color.BLACK);
        roundSign.setForeground(Color.WHITE);
        roundSign.setBounds(450, 10, 100, 100);
        roundSign.setFont(new Font("Arial", Font.BOLD, 20));
        
        add(nextRound);
        add(returnToMap);
        add(roundSign);
        add(treasure);

        addActions();
        refreshUI();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (round < enemies.size()) {
            Graphics2D g2 = (Graphics2D) g;
            ga.getGame().getPlayer().draw(g2);

            List<Enemy> roundOneEnemies = enemies.get(round);
            for (Enemy e : roundOneEnemies) {
                e.draw(g2);
            }
        } else {
            treasure.setVisible(true);
        }
    }

    private void addActions() {
        nextRound.addActionListener(e -> {
            if (round < enemies.size()) {
                round++;
                roundSign.setText(String.valueOf(round + 1));
                revalidate();
                repaint();
            } else {
                ga.toStageMap();
            }
        });
        returnToMap.addActionListener(e -> {
            ga.toStageMap();
        });
        treasure.addActionListener(e -> {
            ga.getGame().getPlayer().addExperience(treasure.getXp());
            System.out.println(ga.getGame().getPlayer().getExperience());
        });
    }
    
    @SuppressWarnings("null")
    protected void instantiateEnemies(List<@NonNull Enemy> allEnemies) {
        enemies = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            enemies.add(allEnemies.subList(i * 3, (i + 1) * 3));
        }
    }

    // public void reset() {
    //     round = 0;
    //     enemies.clear();
    //     List<Enemy> allEnemies = createEnemies();
    //     for (int i = 0; i < 3; i++) {
    //         enemies.add(allEnemies.subList(i * 3, (i + 1) * 3));
    //     }
    //     refreshUI();
    // }

    private void refreshUI() {
        roundSign.setText(String.valueOf(round + 1));
        treasure.setVisible(false);
    }

    public String getName() {
        return name;
    }

    public void setTreasure(int xp, int money) {
        treasure.setXp(xp);
        treasure.setMoney(money);
    }

    public Treasure getTreasure() {
        return treasure;
    }
}
