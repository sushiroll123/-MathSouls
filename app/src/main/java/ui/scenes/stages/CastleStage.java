package ui.scenes.stages;

import java.awt.Color;
import java.util.List;

import org.jspecify.annotations.NonNull;

import model.entities.enemies.*;
import model.entities.enemies.castle.*;
import ui.GameArtiste;

// represents the castle stage with all enemeies
public class CastleStage extends Stage {

    private static final List<@NonNull Enemy> ENEMIES = List.of(
        new Farmer(10, 10, 600, 150),
        new Farmer(10, 10, 600, 300),
        new Farmer(10, 10, 600, 450),
        new Knight(10, 10, 600, 150),
        new Knight(10, 10, 600, 300),
        new Knight(10, 10, 600, 450),
        new RoyalKnight(10, 10, 600, 150),
        new RoyalKnight(10, 10, 600, 300),
        new RoyalKnight(10, 10, 600, 450)
    );
    
    public CastleStage(GameArtiste ga) {
        super(ga, "Castle");
        setBackground(new Color(219, 156, 9));
        instantiateEnemies(ENEMIES);
        setTreasure(10000, 10000);
    }
}
