package model.abilities;

import model.entities.Entity;

// one of the three bases ability, increases player health by 50
public class Heal extends BaseAbility {

    private int healAmount = 50;
    
    public Heal() {
        super("Heal", "Heals 50 health");
    }

    // EFFECTS: increases target's health by healAmount
    @Override
    public void use(Entity target) {
        target.addHealth(healAmount); 
    }
}
