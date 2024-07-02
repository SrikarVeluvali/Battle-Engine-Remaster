import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BattleFourBots {
    public static void main(String[] args) {
        // Player's Team

        // DRAGON Bot
        List<Move> dragonMoves = new ArrayList<>();
        dragonMoves.add(new Move("Dragon Pulse", "User unleashes a powerful pulse of dragon energy, striking the opponent with force.", 10, 15));
        dragonMoves.add(new Move("Scale Slash", "User uses its razor-sharp scales to slash at the opponent, dealing significant damage.", 20, 10));
        dragonMoves.add(new Move("Dragon Fury", "User taps into its draconic power, boosting its Attack or Defense stats.", 0, 2));
        dragonMoves.add(new Move("Ancient Restoration", "User draws on ancient dragon energy to heal itself.", 0, 2));
        Bot dragonBot = new Bot("Dracotron", 100, 20, 15, 12, "DRAGON", dragonMoves);

        // PSYCHIC Bot
        List<Move> psychicMoves = new ArrayList<>();
        psychicMoves.add(new Move("Mind Crush", "User crushes the opponent's mind with overwhelming psychic power.", 20, 10));
        psychicMoves.add(new Move("Psycho Blast", "User unleashes a devastating blast of psychic energy.", 25, 8));
        psychicMoves.add(new Move("Mind Barrier", "User erects a psychic barrier to boost Defense.", 0, 2));
        psychicMoves.add(new Move("Teleportation", "User teleports to evade attacks and heal slightly.", 0, 2));
        Bot psychicBot = new Bot("Psionix", 110, 18, 10, 14, "PSYCHIC", psychicMoves);

        // GHOST Bot
        List<Move> ghostMoves = new ArrayList<>();
        ghostMoves.add(new Move("Shadow Claw", "User slashes with ghostly claws, ignoring opponent's defenses.", 22, 10));
        ghostMoves.add(new Move("Soul Drain", "User drains the opponent's life force, healing itself.", 18, 12));
        ghostMoves.add(new Move("Ethereal Veil", "User shrouds itself in an ethereal veil, boosting Defense.", 0, 2));
        ghostMoves.add(new Move("Spectral Shift", "User shifts between dimensions, evading attacks and healing slightly.", 0, 2));
        Bot ghostBot = new Bot("Spectre", 95, 22, 8, 16, "GHOST", ghostMoves);

        // ICE Bot
        List<Move> iceMoves = new ArrayList<>();
        iceMoves.add(new Move("Frostbite", "User bites with freezing cold, potentially causing the opponent to become frozen.", 22, 8));
        iceMoves.add(new Move("Ice Shard", "User fires a sharp shard of ice, prioritizing speed over power.", 18, 12));
        iceMoves.add(new Move("Glacial Shield", "User creates a shield of ice to boost Defense.", 0, 2));
        iceMoves.add(new Move("Avalanche", "User triggers an avalanche, damaging the opponent and healing slightly.", 0, 2));
        Bot iceBot = new Bot("Frostbite", 95, 20, 12, 13, "ICE", iceMoves);



        // Opponent's Team

        // ELECTRIC Bot (Inspired by Pikachu)
        List<Move> electricMoves = new ArrayList<>();
        electricMoves.add(new Move("Thunderbolt", "User fires a powerful bolt of electricity at the opponent.", 20, 15));
        electricMoves.add(new Move("Volt Tackle", "User charges the opponent with a high voltage tackle.", 25, 10));
        electricMoves.add(new Move("Electro Shield", "User surrounds itself with an electric barrier, boosting Defense.", 0, 2));
        electricMoves.add(new Move("Recharge", "User recharges its energy, healing itself slightly.", 0, 2));  // Limited to 2 heals
        Bot electricBot = new Bot("Voltazer", 110, 22, 15, 13, "ELECTRIC", electricMoves);

        // FIRE/FLYING Bot (Inspired by Charizard)
        List<Move> fireFlyingMoves = new ArrayList<>();
        fireFlyingMoves.add(new Move("Flamethrower", "User breathes a stream of intense flames at the opponent.", 20, 15));
        fireFlyingMoves.add(new Move("Sky Attack", "User dives from the sky to strike the opponent with great force.", 25, 8));
        fireFlyingMoves.add(new Move("Fire Shield", "User surrounds itself with a shield of fire, boosting Defense.", 0, 2));
        fireFlyingMoves.add(new Move("Aerial Heal", "User soars into the air, evading attacks and healing slightly.", 0, 2));  // Limited to 2 heals
        Bot fireFlyingBot = new Bot("Flamestar", 115, 24, 12, 11, "FIRE", fireFlyingMoves);

        // WATER Bot (Inspired by Blastoise)
        List<Move> waterMoves = new ArrayList<>();
        waterMoves.add(new Move("Hydro Pump", "User blasts the opponent with a high-pressure stream of water.", 25, 10));
        waterMoves.add(new Move("Aqua Tail", "User strikes the opponent with a water-imbued tail.", 20, 12));
        waterMoves.add(new Move("Water Shield", "User creates a shield of water, boosting Defense.", 0, 2));
        waterMoves.add(new Move("Aqua Ring", "User surrounds itself with a ring of water, healing over time.", 0, 2));  // Limited to 2 heals
        Bot waterBot = new Bot("Hydrator", 120, 20, 16, 10, "WATER", waterMoves);

        // GRASS/POISON Bot (Inspired by Venusaur)
        List<Move> grassPoisonMoves = new ArrayList<>();
        grassPoisonMoves.add(new Move("Solar Beam", "User absorbs sunlight and unleashes a powerful beam of solar energy.", 25, 10));
        grassPoisonMoves.add(new Move("Sludge Bomb", "User hurls a toxic sludge bomb at the opponent, potentially poisoning them.", 20, 15));
        grassPoisonMoves.add(new Move("Vine Shield", "User creates a shield of vines, boosting Defense.", 0, 2));
        grassPoisonMoves.add(new Move("Synthesis", "User heals itself by absorbing sunlight.", 0, 2));  // Limited to 2 heals
        Bot grassPoisonBot = new Bot("Leafzilla", 115, 18, 15, 14, "GRASS", grassPoisonMoves);


        // Serialize bots
        serializeBot(dragonBot, "PlayerBot1.dat");
        serializeBot(psychicBot, "PlayerBot2.dat");
        serializeBot(ghostBot, "PlayerBot3.dat");
        serializeBot(iceBot, "PlayerBot4.dat");

        serializeBot(electricBot, "OpponentBot1.dat");
        serializeBot(fireFlyingBot, "OpponentBot2.dat");
        serializeBot(waterBot, "OpponentBot3.dat");
        serializeBot(grassPoisonBot, "OpponentBot4.dat");
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
