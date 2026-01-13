package model.persistencetests;

import org.junit.jupiter.api.*;

import model.abilities.BaseAbility;
import model.abilities.Fireball;
import model.abilities.Heal;
import model.entities.Player;
import ui.GameState;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestReader {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // catch
        }
    }

    @Test
    void testReaderEmptyGameState() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyGameState.json");
        try {
            GameState gs = reader.read();
            assertEquals("TestPlayer", gs.getPlayer().getName());
            assertEquals(0, gs.getPlayer().getLevel());
            assertEquals(0, gs.getPlayer().getExperience());
            assertEquals(0, gs.getPlayer().getAbilities().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralGameState() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralGameState.json");
        try {
            GameState gs = reader.read();
            Player player = gs.getPlayer();

            assertEquals("TestPlayer", player.getName());
            assertEquals(10, player.getLevel());
            assertEquals(150, player.getExperience());

            List<BaseAbility> abilities = player.getAbilities();
            assertEquals(2, abilities.size());

            // Check abilities
            assertTrue(abilities.get(0) instanceof Fireball);
            assertTrue(abilities.get(1) instanceof Heal);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}