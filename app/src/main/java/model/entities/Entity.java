package model.entities;

// Abstract class for all entities, including player and enemies
public abstract class Entity {

    private boolean active = true;
    protected String name; 
    private int id;
    private int health;
    private int attackDmg;

    public Entity(String name, int id, int health, int attackDmg) {
        this.name = name;
        this.id = id;
        this.health = health;
        this.attackDmg = attackDmg;
    }

    // REQUIRES: damageAmount >= 0
    // MODIFIES: this
    // EFFECTS: reduces health by damageAmount
    public void takeDamage(int damageAmount) {
        health -= damageAmount;
        if (health <= 0) {
            destroy();
        }
    }

    // REQUIRES: healAmount >= 0
    // MODIFIES: this
    // EFFECTS: increases health by damageAmount
    public void addHealth(int healthAmount) {
        health += healthAmount;
    }

    public boolean isActive() {
        return active;
    }

    public void destroy() {
        active = false;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    // setters
    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackDmg(int damage) {
        this.attackDmg = damage;
    }
}
