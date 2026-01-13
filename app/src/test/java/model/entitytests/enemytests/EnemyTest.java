package model.entitytests.enemytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import model.entities.Player;
import model.entities.enemies.Enemy;

public class EnemyTest {


    private Enemy enemy;
    private Player player;

    // Simple concrete subclass to instantiate Enemies
    private static class TestEnemy extends Enemy {
        public TestEnemy(String name, int id, int health, int attackDmg, int x, int y, String filePath) {
            super(name, id, health, attackDmg, x, y, filePath);
        }
    }

    @BeforeEach
    void setup() {
        player = new Player("tester");
        enemy = new TestEnemy("testEnemy", 0, 10, 10, 10, 10, "Test");
    }
    
    @Test
    public void testAttackPlayerReducesPlayerHealth() {
        enemy.attackPlayer(player);
        assertEquals(90, player.getHealth());
    }

    @Test
    public void testAttackPlayerMultipleAttacks() {
        enemy.attackPlayer(player);
        enemy.attackPlayer(player);
        assertEquals(80, player.getHealth());
    }
}
