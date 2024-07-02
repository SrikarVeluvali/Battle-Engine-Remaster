import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class FinalBattleBots {
    public static void main(String[] args) {
        // Player's Team
        Bot playerBot1 = createFightingBot();
        Bot playerBot2 = createWaterBot();
        Bot playerBot3 = createGhostBot();
        Bot playerBot4 = createDragonBot();

        // Serialize bots
        serializeBot(playerBot1, "PlayerBot1.dat");
        serializeBot(playerBot2, "PlayerBot2.dat");
        serializeBot(playerBot3, "PlayerBot3.dat");
        serializeBot(playerBot4, "PlayerBot4.dat");

        serializeBot(playerBot1, "OpponentBot1.dat");
        serializeBot(playerBot2, "OpponentBot2.dat");
        serializeBot(playerBot3, "OpponentBot3.dat");
        serializeBot(playerBot4, "OpponentBot4.dat");
    }

    private static Bot createFightingBot() {
        List<Move> fightingMoves = new ArrayList<>();
        fightingMoves.add(new Move("Punch", "A strong punch.", 30, 15));
        fightingMoves.add(new Move("Kick", "A powerful kick.", 35, 10));
        fightingMoves.add(new Move("Block", "Increase defense.", 0, 5));
        fightingMoves.add(new Move("Meditate", "Heals the bot.", 0, 3));

        return new Bot("Fightor", 180, 30, 40, 20, "FIGHTING", fightingMoves);
    }

    private static Bot createWaterBot() {
        List<Move> waterMoves = new ArrayList<>();
        waterMoves.add(new Move("Water Jet", "A strong jet of water.", 30, 15));
        waterMoves.add(new Move("Tsunami", "A powerful wave.", 35, 10));
        waterMoves.add(new Move("Water Shield", "Increase defense.", 0, 5));
        waterMoves.add(new Move("Hydrate", "Heals the bot.", 0, 3));

        return new Bot("Aquaforce", 180, 30, 40, 20, "WATER", waterMoves);
    }

    private static Bot createGhostBot() {
        List<Move> ghostMoves = new ArrayList<>();
        ghostMoves.add(new Move("Shadow Punch", "A punch from the shadows.", 30, 15));
        ghostMoves.add(new Move("Haunt", "A haunting attack.", 35, 10));
        ghostMoves.add(new Move("Spectral Shield", "Increase defense.", 0, 5));
        ghostMoves.add(new Move("Ghostly Heal", "Heals the bot.", 0, 3));

        return new Bot("Spectreon", 180, 30, 40, 20, "GHOST", ghostMoves);
    }

    private static Bot createDragonBot() {
        List<Move> dragonMoves = new ArrayList<>();
        dragonMoves.add(new Move("Dragon Breath", "A breath of dragon fire.", 30, 15));
        dragonMoves.add(new Move("Tail Whip", "A powerful tail attack.", 35, 10));
        dragonMoves.add(new Move("Dragon Shield", "Increase defense.", 0, 5));
        dragonMoves.add(new Move("Ancient Heal", "Heals the bot.", 0, 3));

        return new Bot("Dracos", 180, 30, 40, 20, "DRAGON", dragonMoves);
    }

    private static void serializeBot(Bot bot, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(bot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
