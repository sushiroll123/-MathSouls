package model.abilities;

import org.json.JSONObject;

import model.entities.Entity;
import model.entities.Player;

// class for construction and effects of custom abilities
public class CustomAbility extends BaseAbility {

    private AbilityType type;
    private double effect;

    static int attackMult = 10;
    static double defenseMult = 0.01;
    static double agilityMult = 0.1;


    // MODIFIES: this
    // EFFECTS: name is set to name; description 
    //          is set according to type
    public CustomAbility(String name, AbilityType type, Player player) {
        super(name, setDescription(type, player));
        this.type = type;
        switch (type) {
            case ATTACK:
                int attackDmg = player.getLevel() * attackMult;
                this.effect = attackDmg;
                break;
            case DEFENSE:
                double defendAgainst = player.getLevel() * defenseMult;
                this.effect = defendAgainst;
                break;
            case AGILITY: 
                int agilityIncrease = (int) Math.round(player.getLevel() * agilityMult);
                this.effect =  agilityIncrease;
                break;
            default: 
                break;
        }
    }


    @Override
    public void use(Entity target) {
        switch (this.type) {
            case ATTACK:
                target.takeDamage((int) effect);
                break;
            case DEFENSE: 
            // TODO turn manager
                break;
            case AGILITY: 
            // TODO turn manager
                break;
        }
    }

    @Override
        public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.getName());       
        json.put("description", this.getDescription()); 
        json.put("type", this.type.toString()); 
        json.put("effect", this.effect);      
        return json;
    }

    // setters

    private static String setDescription(AbilityType type, Player player) {
        switch (type) {
            case ATTACK:
                int attackDmg = player.getLevel() * attackMult;
                return ("Deal " + attackDmg + " damage");
            case DEFENSE:
                return ("Take " + player.getLevel() + "% less damage next turn");
            case AGILITY: 
                int agilityIncrease = (int) Math.round(player.getLevel() * agilityMult);
                return ("Agility increased by " + agilityIncrease + " for three turns");
            default: 
                return null;
        }
    }

    // getters

    public AbilityType getType() {
        return type;
    }

    public double getEffect() {
        return effect;
    }
}
