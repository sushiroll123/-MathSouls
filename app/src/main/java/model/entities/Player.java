package model.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Level;
import model.abilities.BaseAbility;
import model.Event;
import model.EventLog;
import persistence.Writable;

// Tracks player stats and abilities
public class Player extends Entity implements Writable {

    private static int baseHealth = 100;
    private static int baseAttackDmg = 10;
    private int agility;

    private EventLog log;

    private ArrayList<BaseAbility> abilities;
    private Level levelManager;

    private Shape graphic;

    // REQUIRES: name length != 0
    // MODIFIES: this
    // EFFECTS: Creates new player with name name; health baseHealth;
    //          attackDmg baseAttackDmg; experience 0; level 0;
    //          no abilities
    public Player(String name) {
        super(name, 0, baseHealth, baseAttackDmg);
        this.agility = 0;
        this.abilities = new ArrayList<>();
        this.levelManager = new Level(this);

        graphic = new Ellipse2D.Double(150, 300, 100, 100);

        log = EventLog.getInstance();
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.PINK);
        g2.fill(graphic);
    }

    // MODIFIES: this
    // EFFECTS: adds ability to abilities
    public void addAbility(BaseAbility ability) {
        abilities.add(ability);
        log.logEvent(new Event("Added ability: " + ability.getName()));
    }

    // MODIFIES: this
    // EFFECTS: adds amount to experience
    public void addExperience(int amount) {
        levelManager.addExperience(amount);
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.getName());
        json.put("health", this.getHealth());
        json.put("attack", this.getAttackDmg());
        json.put("level", this.getLevel());
        json.put("levelSinceLastAbility", this.getLevelManager().getLevelSinceLastAbility());
        json.put("xp", this.getExperience());

        JSONArray abilityArray = new JSONArray();
        for (BaseAbility ability : abilities) {
            abilityArray.put(ability.toJson()); // BaseAbility must have toJson()
        }
        json.put("abilities", abilityArray);
        return json;
    }

    public static Player fromJson(JSONObject json) {
        String name = json.getString("name");
        Player player = new Player(name);

        player.levelManager.setLevel(json.getInt("level"));
        player.levelManager.setXp(json.getInt("xp"));
        player.levelManager.setLevelSinceLastAbility(json.getInt("levelSinceLastAbility"));

        JSONArray abilityArray = json.getJSONArray("abilities");
        for (int i = 0; i < abilityArray.length(); i++) {
            JSONObject abilityJson = abilityArray.getJSONObject(i);
            BaseAbility ability = BaseAbility.fromJson(abilityJson, player);
            player.addAbility(ability);
        }

        return player;
    }

    // setters
    public void setAgility(int agility) {
        this.agility = agility;
    }
    
    // getters

    public ArrayList<BaseAbility> getAbilities() {
        return abilities;
    }

    public String[] getAbilityNames() {
        ArrayList<BaseAbility> abilities = getAbilities();
        String[] abilityNames = new String[(abilities.size())];
        for (int i = 0; i < abilities.size(); i++) {
            abilityNames[i] = abilities.get(i).getName();
        }
        return abilityNames;
    }

    public Level getLevelManager() {
        return levelManager;
    }

    public int getExperience() {
        return levelManager.getCurrentXp();
    }

    public int getLevel() {
        return levelManager.getLevel();
    }

    public int getAgility() {
        return agility;
    }
}
