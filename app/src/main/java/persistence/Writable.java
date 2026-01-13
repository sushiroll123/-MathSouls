package persistence;

import org.json.JSONObject;

// interface representing a writable class
public interface Writable {

    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
