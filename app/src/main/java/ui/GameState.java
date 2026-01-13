package ui;

import model.entities.Player;
import persistence.Writable;

import org.json.JSONObject;

// Represents the entire state of the game at a given time.
public class GameState implements Writable {

    private Player player;
    private int stageCompletion;

    // EFFECTS: constructs a GameState with given player
    public GameState(Player player) {
        this.player = player;
        stageCompletion = 0;
    }

    public Player getPlayer() {
        return player;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("player", player.toJson());
        json.put("Highest Stage Completion", this.getStageCompletion());
        return json;
    }

    public int getStageCompletion() {
        return stageCompletion;
    }

    public static GameState fromJson(JSONObject json) {
        JSONObject playerJson = json.getJSONObject("player");
        Player player = Player.fromJson(playerJson);
        return new GameState(player);
    }
}