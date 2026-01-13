package ui;

import javax.swing.*;
import java.awt.*;
import ui.scenes.StageMap;
import ui.scenes.stages.*;
import ui.scenes.Menu;
import model.MSGame;

// draws the game
public class GameArtiste extends JPanel {

    private MSGame game;
    private CardLayout cardLayout;
    private JPanel cards;

    private Navigator navigation;
    private Menu menu;
    private StageMap stageMap;
    private Stage stage1;
    private Stage stage2;
    private Stage stage3;
    private Stage stage4;
    private Stage stage5;


    public GameArtiste(MSGame game) {
        this.game = game;

        setPreferredSize(new Dimension(MSGame.WIDTH, MSGame.HEIGHT));
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        menu = new Menu(game);
        stageMap = new StageMap(this);
        stage1 = new ForestStage(this);
        stage2 = new CaveStage(this);
        stage3 = new DesertStage(this);
        stage4 = new OceanStage(this);
        stage5 = new CastleStage(this);
        
        addCards(cards);

        navigation = new Navigator(this);
        navigation.setVisible(false);

        add(cards, BorderLayout.CENTER);
        add(navigation, BorderLayout.SOUTH);

        initialize();
    }

    private void addCards(JPanel card) {
        cards.add(menu, "MENU");
        cards.add(stageMap, "STAGE_MAP");
        cards.add(stage1, "FOREST");
        cards.add(stage2, "CAVE");
        cards.add(stage3, "DESERT");
        cards.add(stage4,"OCEAN");
        cards.add(stage5, "CASTLE");
    }

    private void showCard(String name) {
        cardLayout.show(cards, name);
    }

    public void initialize() {
        // registers listener
        game.getPlayer().getLevelManager().setUnlockCustomAbilityListener(() -> {
            menu.promptCustomAbility();
        });
        toMenu();
        JOptionPane.showMessageDialog(this, 
                "Welcome " + game.getPlayer().getName() + "!");
    }

    public void toMenu() {
        navigation.setVisible(true);
        showCard("MENU");
        menu.refreshUI();
    }

    public void toStageMap() {
        navigation.setVisible(true);
        showCard("STAGE_MAP");
    }

    public void toStage(String type) {
        Stage stage = getStage(type);
        // stage.reset();
        // TODO
        showCard(type);
        navigation.setVisible(false);
    }

    public MSGame getGame() {
        return game;
    }

    private Stage getStage(String type) {
        switch (type) {
            case "FOREST":
                return stage1;
            case "CAVE":
                return stage2;
            case "DESERT":
                return stage3;
            case "OCEAN":
                return stage4;
            case "CASTLE":
                return stage5;
            default:
                return null;
        }
    }
}
