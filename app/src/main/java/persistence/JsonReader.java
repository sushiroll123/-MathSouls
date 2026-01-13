package persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.*;

import ui.GameState;

// Represents a reader that reads gamestate from JSON data stored in file
public class JsonReader {

    private String source;

    public JsonReader(String source) { 
        this.source = source; 
    }

    public GameState read() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(source)));
        JSONObject json = new JSONObject(content);
        return GameState.fromJson(json);
    }

}