import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BattleThreeBots {
    public static void main(String[] args) {
        // Player Bots
        Bot playerBot1 = createFireBot();
        Bot playerBot2 = createElectricBot();
        Bot playerBot3 = createFlyingBot();
        Bot playerBot4 = createRockBot();

        // Opponent Bots
        Bot opponentBot1 = createWaterBot();
        Bot opponentBot2 = createFightingBot();
        Bot opponentBot3 = createGroundBot();
        Bot opponentBot4 = createPsychicBot();

        // Serialize bots
        serializeBot(playerBot1, "PlayerBot1.dat");
        serializeBot(playerBot2, "PlayerBot2.dat");
        serializeBot(playerBot3, "PlayerBot3.dat");
        serializeBot(playerBot4, "PlayerBot4.dat");
        
        serializeBot(opponentBot1, "OpponentBot1.dat");
        serializeBot(opponentBot2, "OpponentBot2.dat");
        serializeBot(opponentBot3, "OpponentBot3.dat");
        serializeBot(opponentBot4, "OpponentBot4.dat");

        BattleEngine.startBattleEngine(playerBot4, opponentBot4);
    }

    private static Bot createFireBot() {
        List<Move> fireMoves = new ArrayList<>();
        fireMoves.add(new Move("Flame Burst", "User launches a burst of flames, dealing significant damage.", 18, 6)); // Decrease power and PP
        fireMoves.add(new Move("Inferno Blast", "User unleashes a powerful blast of fire, causing burn.", 22, 4)); // Decrease power and PP
        fireMoves.add(new Move("Heat Shield", "User creates a shield of fire, boosting Defense.", 0, 2)); // Decrease PP
        fireMoves.add(new Move("Burning Rage", "User's rage boosts Attack and Speed.", 0, 1)); // Decrease PP

        return new Bot("Blazefury", 105, 18, 12, 10, "FIRE", fireMoves); // Adjust stats
    }

    private static Bot createElectricBot() {
        List<Move> electricMoves = new ArrayList<>();
        electricMoves.add(new Move("Thunder Strike", "User strikes the opponent with a powerful bolt of lightning.", 20, 8)); // Decrease power and PP
        electricMoves.add(new Move("Volt Tackle", "User charges the opponent with electrified tackle, causing recoil.", 24, 6)); // Decrease power and PP
        electricMoves.add(new Move("Static Shield", "User generates a shield of electricity, boosting Defense.", 0, 3)); // Decrease PP
        electricMoves.add(new Move("Electro Boost", "User's electrical energy boosts Speed.", 0, 2)); // Decrease PP

        return new Bot("Voltiger", 100, 20, 12, 15, "ELECTRIC", electricMoves); // Adjust stats
    }

    private static Bot createFlyingBot() {
        List<Move> flyingMoves = new ArrayList<>();
        flyingMoves.add(new Move("Sky Attack", "User soars and strikes from above, dealing massive damage.", 24, 6)); // Decrease power and PP
        flyingMoves.add(new Move("Aerial Slash", "User slashes with sharp wings, dealing quick damage.", 20, 8)); // Decrease power and PP
        flyingMoves.add(new Move("Wind Shield", "User creates a shield of wind, boosting Defense.", 0, 2)); // Decrease PP
        flyingMoves.add(new Move("Speed Boost", "User's agility boosts Speed significantly.", 0, 1)); // Decrease PP

        return new Bot("Skyblade", 95, 20, 10, 18, "FLYING", flyingMoves); // Adjust stats
    }

    private static Bot createRockBot() {
        List<Move> rockMoves = new ArrayList<>();
        rockMoves.add(new Move("Rock Slide", "User hurls rocks at the opponent, causing significant damage.", 22, 6)); // Decrease power and PP
        rockMoves.add(new Move("Stone Edge", "User sharpens stones to strike, dealing critical damage.", 26, 4)); // Decrease power and PP
        rockMoves.add(new Move("Rock Barrier", "User creates a barrier of rocks, boosting Defense.", 0, 2)); // Decrease PP
        rockMoves.add(new Move("Sturdy Stance", "User's stance boosts Attack and Defense.", 0, 1)); // Decrease PP

        return new Bot("Granite", 110, 25, 15, 8, "ROCK", rockMoves); // Adjust stats
    }

    private static Bot createWaterBot() {
        List<Move> waterMoves = new ArrayList<>();
        waterMoves.add(new Move("Aqua Blast", "User fires a powerful blast of water, dealing heavy damage.", 18, 6)); // Decrease power and PP
        waterMoves.add(new Move("Tidal Wave", "User summons a tidal wave, hitting all opponents.", 22, 4)); // Decrease power and PP
        waterMoves.add(new Move("Water Shield", "User surrounds itself with water, boosting Defense.", 0, 2)); // Decrease PP
        waterMoves.add(new Move("Hydro Boost", "User's water energy boosts Attack.", 0, 1)); // Decrease PP

        return new Bot("Aquarion", 100, 18, 12, 10, "WATER", waterMoves); // Adjust stats
    }

    private static Bot createFightingBot() {
        List<Move> fightingMoves = new ArrayList<>();
        fightingMoves.add(new Move("Punch Fury", "User unleashes a series of rapid punches.", 18, 8)); // Decrease power and PP
        fightingMoves.add(new Move("Roundhouse Kick", "User delivers a powerful kick, dealing heavy damage.", 24, 6)); // Decrease power and PP
        fightingMoves.add(new Move("Iron Defense", "User hardens its body, significantly boosting Defense.", 0, 3)); // Decrease PP
        fightingMoves.add(new Move("Adrenaline Surge", "User's adrenaline boosts Attack and Speed.", 0, 2)); // Decrease PP

        return new Bot("Fistmaster", 105, 24, 15, 12, "FIGHTING", fightingMoves); // Adjust stats
    }

    private static Bot createGroundBot() {
        List<Move> groundMoves = new ArrayList<>();
        groundMoves.add(new Move("Earth Shatter", "User shatters the ground, dealing massive damage to all opponents.", 26, 4)); // Decrease power and PP
        groundMoves.add(new Move("Mud Slap", "User slaps the opponent with mud, reducing their accuracy.", 20, 8)); // Decrease power and PP
        groundMoves.add(new Move("Sand Shield", "User creates a shield of sand, boosting Defense.", 0, 2)); // Decrease PP
        groundMoves.add(new Move("Tremor", "User causes a tremor, damaging all opponents and boosting its Attack.", 0, 1)); // Decrease PP
        return new Bot("Terramight", 110, 26, 18, 10, "GROUND", groundMoves); // Adjust stats
    }
    
    private static Bot createPsychicBot() {
        List<Move> psychicMoves = new ArrayList<>();
        psychicMoves.add(new Move("Psywave", "User unleashes a wave of psychic energy, confusing the opponent.", 20, 8)); // Decrease power and PP
        psychicMoves.add(new Move("Mind Blast", "User blasts the opponent with powerful psychic energy.", 24, 6)); // Decrease power and PP
        psychicMoves.add(new Move("Psychic Shield", "User creates a shield of psychic energy, boosting Defense.", 0, 2)); // Decrease PP
        psychicMoves.add(new Move("Mind Over Matter", "User's mental focus boosts Attack and Defense.", 0, 1)); // Decrease PP
    
        return new Bot("Mindstorm", 105, 24, 12, 15, "PSYCHIC", psychicMoves); // Adjust stats
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
