package ui.scenes.stages;

import java.awt.Color;
import java.util.List;

import org.jspecify.annotations.NonNull;

import model.entities.enemies.Enemy;
import model.entities.enemies.cave.*;
import ui.GameArtiste;

// represents the cave stage with all enemeies
public class CaveStage extends Stage {

    private static final List<@NonNull Enemy> ENEMIES = List.of(
        new Slime(10, 10, 600, 150),
        new Slime(10, 10, 600, 300),
        new Slime(10, 10, 600, 450),
        new Bat(10, 10, 600, 150),
        new Bat(10, 10, 600, 300),
        new Bat(10, 10, 600, 450),
        new Golem(10, 10, 600, 150),
        new Golem(10, 10, 600, 300),
        new Golem(10, 10, 600, 450)
    );

    public CaveStage(GameArtiste ga) {
        super(ga, "CAVE");
        setBackground(new Color(78, 80, 89));
        instantiateEnemies(ENEMIES);
        setTreasure(10, 10);
    }
}
