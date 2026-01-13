package ui.scenes.stages;

import java.awt.Color;
import java.util.List;

import org.jspecify.annotations.NonNull;

import model.entities.enemies.Enemy;
import model.entities.enemies.desert.*;
import ui.GameArtiste;

// represents the desert stage with all enemeies
public class DesertStage extends Stage {

    private static final List<@NonNull Enemy> ENEMIES = List.of(
        new Vulture(10, 10, 600, 150),
        new Vulture(10, 10, 600, 300),
        new Vulture(10, 10, 600, 450),
        new Mummy(10, 10, 600, 150),
        new Mummy(10, 10, 600, 300),
        new Mummy(10, 10, 600, 450),
        new Sandworm(10, 10, 600, 150),
        new Sandworm(10, 10, 600, 300),
        new Sandworm(10, 10, 600, 450)
    );

    public DesertStage(GameArtiste ga) {
        super(ga, "DESERT");
        setBackground(new Color(184, 174, 123));
        instantiateEnemies(ENEMIES);
        setTreasure(100, 100);
    }
}
