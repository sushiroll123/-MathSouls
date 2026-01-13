package ui.scenes;

import java.awt.Color;
import javax.swing.*;

import ui.GameArtiste;

// represents the stage map graphic
public class StageMap extends JPanel {

    private GameArtiste ga;

    private JButton s1;
    private JButton s2;
    private JButton s3;
    private JButton s4;
    private JButton s5;

    public StageMap(GameArtiste ga) {
        this.ga = ga;

        setBackground(Color.GREEN);
        setLayout(null);

        s1 = new JButton();
        s1.setBounds(100, 400, 50, 50);

        s2 = new JButton();
        s2.setBounds(600, 400, 50, 50);

        s3 = new JButton();
        s3.setBounds(200, 250, 50, 50);

        s4 = new JButton();
        s4.setBounds(500, 250, 50, 50);

        s5 = new JButton();
        s5.setBounds(350, 100, 50, 50);

        add(s1);
        add(s2);
        add(s3);
        add(s4);
        add(s5);

        addStageNavigation();
    }

    private void addStageNavigation() {
        s1.addActionListener(e -> {
            ga.toStage("FOREST");
        });

        s2.addActionListener(e -> {
            ga.toStage("CAVE");
        });

        s3.addActionListener(e -> {
            ga.toStage("DESERT");
        });

        s4.addActionListener(e -> {
            ga.toStage("OCEAN");
        });

        s5.addActionListener(e -> {
            ga.toStage("CASTLE");
        });
    }
}
