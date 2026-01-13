package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

// represents the navigator graphic
public class Navigator extends JPanel {

    private static final String MENU_TXT = "Menu";
    private static final String STAGEMAP_TXT = "Stage Map";

    private static final int LBL_WIDTH = 800;
    private static final int LBL_HEIGHT = 50;

    private GameArtiste ga;

    private JButton toMenu;
    private JButton toStageMap;
	
	// Constructs a traveller panel
	// effects: sets the background colour
    public Navigator(GameArtiste ga) {
        setBackground(Color.GRAY);

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS)); // sets components on horizontal line

        toMenu = new JButton(MENU_TXT);
        toMenu.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        toMenu.addActionListener(e -> {
            ga.toMenu();
        });

        toStageMap = new JButton(STAGEMAP_TXT);
        toStageMap.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        toStageMap.addActionListener(e -> {
            ga.toStageMap();
        });

        add(toMenu);
        add(toStageMap);
    }

    public GameArtiste getGameArtiste() {
        return ga;
    }
}
