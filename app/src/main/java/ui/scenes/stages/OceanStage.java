package ui.scenes.stages;

import java.awt.Color;
import java.util.List;

import org.jspecify.annotations.NonNull;

import model.entities.enemies.Enemy;
import model.entities.enemies.ocean.*;
import ui.GameArtiste;

// represents the ocean stage with all enemeies
public class OceanStage extends Stage {

    private static final List<@NonNull Enemy> ENEMIES = List.of(
        new Squid(10, 10, 600, 150),
        new Squid(10, 10, 600, 300),
        new Squid(10, 10, 600, 450),
        new Shark(10, 10, 600, 150),
        new Shark(10, 10, 600, 300),
        new Shark(10, 10, 600, 450),
        new Whale(10, 10, 600, 150),
        new Whale(10, 10, 600, 300),
        new Whale(10, 10, 600, 450)
    );

    public OceanStage(GameArtiste ga) {
        super(ga, "OCEAN");
        setBackground(new Color(43, 48, 120));
        instantiateEnemies(ENEMIES);
        setTreasure(1000, 1000);
    }
}
