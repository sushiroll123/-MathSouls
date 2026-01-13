package ui.scenes.stages;

import java.awt.Color;
import java.util.List;

import org.jspecify.annotations.NonNull;

import model.entities.enemies.*;
import model.entities.enemies.forest.*;
import ui.GameArtiste;

// represents the forest stage with all enemeies
public class ForestStage extends Stage {

    private static final List<@NonNull Enemy> ENEMIES = List.of(
        new Mosquito(10, 10, 600, 150),
        new Mosquito(10, 10, 600, 300),
        new Mosquito(10, 10, 600, 450),
        new Wolf(10, 10, 600, 150),
        new Wolf(10, 10, 600, 300),
        new Wolf(10, 10, 600, 450),
        new Goblin(10, 10, 600, 150),
        new Goblin(10, 10, 600, 300),
        new Goblin(10, 10, 600, 450)
    );

    public ForestStage(GameArtiste ga) {
        super(ga, "FOREST");
        setBackground(new Color(70, 105, 76));
        instantiateEnemies(ENEMIES);
        setTreasure(1, 1);
    }
}
