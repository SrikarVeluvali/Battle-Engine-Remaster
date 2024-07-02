// package BotMakers;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BattleTwoBots {
    public static void main(String[] args) {
        // DRAGON Bot
        List<Move> dragonMoves = new ArrayList<>();
        dragonMoves.add(new Move("Dragon Pulse", "User unleashes a powerful pulse of dragon energy, striking the opponent with force.", 10, 15));
        dragonMoves.add(new Move("Scale Slash", "User uses its razor-sharp scales to slash at the opponent, dealing significant damage.", 20, 10));
        dragonMoves.add(new Move("Dragon Fury", "User taps into its draconic power, boosting its Attack or Defense stats.", 0, 3));
        dragonMoves.add(new Move("Ancient Restoration", "User draws on ancient dragon energy to heal itself.", 0, 2));

        // Create bots
        Bot dragonBot = new Bot("Dracotron", 100, 20, 15, 12, "DRAGON", dragonMoves);

        // POISON Bot
        List<Move> poisonMoves = new ArrayList<>();
        poisonMoves.add(new Move("Venom Blast", "User fires a concentrated blast of toxic energy, poisoning and damaging the opponent.", 10, 15));
        poisonMoves.add(new Move("Acid Spray", "User sprays a corrosive acid at the opponent, melting defenses and causing damage.", 20, 10));
        poisonMoves.add(new Move("Toxic Surge", "User increases its internal toxicity levels, boosting its Attack or Defense stats", 0, 3));
        poisonMoves.add(new Move("Poison Recycle", "User recycles toxic waste within its system to repair and heal itself.", 0, 2));

        Bot poisonBot = new Bot("Toxibot", 100, 20, 12, 16, "POISON", poisonMoves);
        // Create PSYCHIC bot
        List<Move> psychicMoves = new ArrayList<>();
        psychicMoves.add(new Move("Mind Crush", "User crushes the opponent's mind with overwhelming psychic power.", 20, 10));
        psychicMoves.add(new Move("Psycho Blast", "User unleashes a devastating blast of psychic energy.", 25, 8));
        psychicMoves.add(new Move("Mind Barrier", "User erects a psychic barrier to boost Defense.", 0, 5));
        psychicMoves.add(new Move("Teleportation", "User teleports to evade attacks and heal slightly.", 0, 3));

        Bot psychicBot = new Bot("Psionix", 110, 18, 10, 14, "PSYCHIC", psychicMoves);

        // Create GHOST bot
        List<Move> ghostMoves = new ArrayList<>();
        ghostMoves.add(new Move("Shadow Claw", "User slashes with ghostly claws, ignoring opponent's defenses.", 22, 10));
        ghostMoves.add(new Move("Soul Drain", "User drains the opponent's life force, healing itself.", 18, 12));
        ghostMoves.add(new Move("Ethereal Veil", "User shrouds itself in an ethereal veil, boosting Defense.", 0, 5));
        ghostMoves.add(new Move("Spectral Shift", "User shifts between dimensions, evading attacks and healing slightly.", 0, 3));

        Bot ghostBot = new Bot("Spectre", 95, 22, 8, 16, "GHOST", ghostMoves);

        // Create ICE bot
        List<Move> iceMoves = new ArrayList<>();
        iceMoves.add(new Move("Frostbite", "User bites with freezing cold, potentially causing the opponent to become frozen.", 22, 8));
        iceMoves.add(new Move("Ice Shard", "User fires a sharp shard of ice, prioritizing speed over power.", 18, 12));
        iceMoves.add(new Move("Glacial Shield", "User creates a shield of ice to boost Defense.", 0, 5));
        iceMoves.add(new Move("Avalanche", "User triggers an avalanche, damaging the opponent and healing slightly.", 0, 3));

        Bot iceBot = new Bot("Frostbite", 95, 20, 12, 13, "ICE", iceMoves);

        // Create GRASS bot
        List<Move> grassMoves = new ArrayList<>();
        grassMoves.add(new Move("Vine Whip", "User strikes the opponent with sharp vines.", 20, 10));
        grassMoves.add(new Move("Petal Dance", "User dances among petals, striking the opponent multiple times.", 24, 8));
        grassMoves.add(new Move("Photosynthesis", "User absorbs sunlight to heal itself over time.", 0, 5));
        grassMoves.add(new Move("Mega Drain", "User drains the opponent's energy, healing itself.", 0, 3));

        Bot grassBot = new Bot("Florabot", 105, 18, 15, 12, "GRASS", grassMoves);

        // Create GROUND bot
        List<Move> groundMoves = new ArrayList<>();
        groundMoves.add(new Move("Earthquake", "User creates a powerful earthquake, damaging all opponents.", 28, 8));
        groundMoves.add(new Move("Sandstorm", "User summons a raging sandstorm, damaging opponents each turn.", 0, 15));
        groundMoves.add(new Move("Rock Shield", "User erects a shield of rocks to boost Defense.", 0, 5));
        groundMoves.add(new Move("Quicksand Trap", "User sets a trap of quicksand, healing slightly and slowing the opponent.", 0, 3));

        Bot groundBot = new Bot("Terratron", 110, 22, 10, 10, "GROUND", groundMoves);

        // Create BUG bot
        List<Move> bugMoves = new ArrayList<>();
        bugMoves.add(new Move("Bug Bite", "User bites the opponent with sharp mandibles, stealing their held item if they have one.", 20, 10));
        bugMoves.add(new Move("Venomous Sting", "User stings the opponent with a venomous stinger, potentially poisoning them.", 18, 12));
        bugMoves.add(new Move("Harden", "User hardens its exoskeleton, boosting Defense.", 0, 5));
        bugMoves.add(new Move("Leech Life", "User drains the opponent's life force, healing itself.", 0, 3));

        Bot bugBot = new Bot("Venomoth", 100, 18, 12, 14, "BUG", bugMoves);

        // Serialize bots
        serializeBot(dragonBot, "PlayerBot1.dat");
        serializeBot(psychicBot, "PlayerBot2.dat");
        serializeBot(ghostBot, "PlayerBot3.dat");
        serializeBot(iceBot, "PlayerBot4.dat");
        serializeBot(poisonBot, "OpponentBot1.dat");
        serializeBot(grassBot, "OpponentBot2.dat");
        serializeBot(groundBot, "OpponentBot3.dat");
        serializeBot(bugBot, "OpponentBot4.dat");
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
