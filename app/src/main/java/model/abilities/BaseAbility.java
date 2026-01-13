package model.abilities;

import org.json.JSONObject;

import model.entities.Player;
import persistence.Writable;

// Abstract class for the three base abilities every player has
public abstract class BaseAbility implements Ability, Writable {

    private String name;
    private String description;


    // MODIFIES: this
    // EFFECTS: Ability name is set to abilityName; ability description 
    //          is set to abilityDescr
    public BaseAbility(String abilityName, String abilityDescr) {
        this.name = abilityName;
        this.description = abilityDescr;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return getName();
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("description", description);
        return json;
    }

    public static BaseAbility fromJson(JSONObject json, Player player) {
        String abilityName = json.getString("name");

        switch (abilityName) {
            case "Fireball":
                return new Fireball();
            case "Heal":
                return new Heal();
            default:
                AbilityType type = AbilityType.valueOf(json.getString("type"));
                return new CustomAbility(abilityName, type, player);
        }
    }
}
