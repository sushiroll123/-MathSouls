package model.persistencetests;

import org.junit.jupiter.api.Test;

import model.abilities.BaseAbility;
import model.abilities.Fireball;
import model.abilities.Heal;
import model.entities.Player;
import ui.GameState;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestWriter {

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    void testWriterEmptyGameState() {
        try {
            Player player = new Player("TestPlayer");
            GameState gs = new GameState(player);

            JsonWriter writer = new JsonWriter("./data/testWriterEmptyGameState.json");
            writer.open();
            writer.write(gs);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyGameState.json");
            GameState readGs = reader.read();

            Player readPlayer = readGs.getPlayer();
            assertEquals("TestPlayer", readPlayer.getName());
            assertEquals(0, readPlayer.getLevel());
            assertEquals(0, readPlayer.getExperience());
            assertEquals(0, readPlayer.getAbilities().size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralGameState() {
        try {
            Player player = new Player("TestPlayer");
            // Add abilities to player
            player.addAbility(new Fireball());
            player.addAbility(new Heal());

            GameState gs = new GameState(player);

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralGameState.json");
            writer.open();
            writer.write(gs);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralGameState.json");
            GameState readGs = reader.read();

            Player readPlayer = readGs.getPlayer();
            assertEquals("TestPlayer", readPlayer.getName());
            List<BaseAbility> abilities = readPlayer.getAbilities();
            assertEquals(2, abilities.size());

            assertTrue(abilities.get(0) instanceof Fireball);
            assertTrue(abilities.get(1) instanceof Heal);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}