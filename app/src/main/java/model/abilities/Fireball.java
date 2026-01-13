package model.abilities;

import model.entities.Entity;

// one of the two base abilities, deals 50 damage to target 
public class Fireball extends BaseAbility {

    private int damageAmount = 50;

    public Fireball() {
        super("Fireball", "Deals 50 damage");
    }

    // EFFECTS: reduces target's health by damageAmount
    @Override
    public void use(Entity target) {
        target.takeDamage(damageAmount);
    }
}
