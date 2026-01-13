package model;

import model.entities.*;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.GameState;


import java.io.FileNotFoundException;
import java.io.IOException;

public class MSGame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private Player player;
    private GameState gs;
    private EventLog log;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/gameState.json";

    // represents the math souls game
    public MSGame() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        log = EventLog.getInstance();
    }

    public void createPlayer(String name) {
        this.player = new Player(name);
        gs = new GameState(player);
        log.logEvent(new Event("created player" + player.getName()));
    }

    public Player getPlayer() {
        return player;
    }

    public void doLevelUp() {
        player.addExperience(player.getLevelManager().xpNeededForNextLevel() / 5);
        log.logEvent(new Event("player leveled up"));
        if (player.getLevelManager().getLevelSinceLastAbility() <= 0) {
            // let the GUI handle input
            Runnable listener = player.getLevelManager().getUnlockCustomAbilityListener();
            if (listener != null) {
                listener.run();
            }
        }
    }

    // EFFECTS: saves the game state to file
    public void saveGame() {
        try {
            jsonWriter.open();
            jsonWriter.write(gs);
            jsonWriter.close();
            log.logEvent(new Event ("Saved game state for " + gs.getPlayer().getName() 
                            + " to " + JSON_STORE));
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads game state from file
    public void loadGame() {
        try {
            gs = jsonReader.read();
            log.logEvent(new Event(("Loaded game state for " + gs.getPlayer().getName() 
                                + " from " + JSON_STORE)));
            this.player = gs.getPlayer();

        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
