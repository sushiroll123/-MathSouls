package model.abilities;

import model.entities.Entity; 

// an interface that represents every ability
public interface Ability {

    public String getName();

    public String getDescription();

    public void use(Entity target);
}
