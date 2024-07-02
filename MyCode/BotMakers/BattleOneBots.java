import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BattleOneBots {
    public static void main(String[] args) {
        // WATER BOT
        List<Move> waterMoves = new ArrayList<>();
        waterMoves.add(new Move("Aqua Cannon", "User releases a high-pressure blast of water from its cannons, striking the target with great force.", 10, 5));
        waterMoves.add(new Move("Torrential Slam", "User summons a powerful wave and crashes it down onto the opponent, dealing damage with the force of the tide.", 20,10));
        waterMoves.add(new Move("Hydro Surge", "User channels the power of the ocean, boosting its Attack or Defense stats.", 0, 2));
        waterMoves.add(new Move("Aqua Regen", "User taps into its fiery energy to heal itself, restoring its health", 0, 2));

        // Create bots
        Bot waterBot = new Bot("Hydrocoil", 100, 10, 10, 10,"WATER", waterMoves);

        // FIRE BOT
        List<Move> fireMoves = new ArrayList<>();
        fireMoves.add(new Move("Heat Wave", "User releases a scorching wave of heat that spreads out in all directions, hitting all adjacent foes.", 10, 10));
        fireMoves.add(new Move("Flare Tackle", "User charges at the opponent with blazing speed, engulfing them in fiery energy upon impact", 20, 5));
        fireMoves.add(new Move("Overheat Boost", "User supercharges its internal furnace, raising its Attack and Speed stats", 15, 2));
        fireMoves.add(new Move("Solar Repair", "User taps into its fiery energy to heal itself, restoring its health", 17, 2));

        // Create bots
        Bot fireBot = new Bot("Scorchip", 100, 10, 10, 10, "FIRE", fireMoves);

        // GRASS BOT
        List<Move> grassMoves = new ArrayList<>();
        grassMoves.add(new Move("Vine Whip", "User lashes out with long, flexible vines, striking the target multiple times.", 10, 5));
        grassMoves.add(new Move("Leaf Blade", "User forms sharp blades of grass energy and slashes the opponent with them.", 20, 10));
        grassMoves.add(new Move("Photosynthesize", "User absorbs sunlight, boosting its Attack or Defense stats.", 0, 2));
        grassMoves.add(new Move("Bloom", "User surrounds itself with a field of blooming flowers, restoring its health.", 0, 2));

        // Create bots
        Bot grassBot = new Bot("Floraforge", 100, 10, 10, 10, "GRASS", grassMoves);

        List<Move> electricMoves = new ArrayList<>();
        electricMoves.add(new Move("Thunderbolt", "User unleashes a rapid barrage of electrified bolts, striking the opponent multiple times.", 10, 10));
        electricMoves.add(new Move("Electro Shockwave", "User  sends out a powerful shockwave of electricity, hitting all adjacent foes.", 20, 5));
        electricMoves.add(new Move("Charge Surge", "User charges up with electrical energy, boosting its Attack or Defense stats.", 0, 2));
        electricMoves.add(new Move("Static Charge Recharge", "User absorbs ambient electrical energy from its surroundings to heal itself.", 0, 2));

        // Create bots
        Bot electricBot = new Bot("Voltroid", 100, 10, 10, 10, "ELECTRIC", electricMoves);


        List<Move> groundMoves = new ArrayList<>();
        groundMoves.add(new Move("Quick Strike", "User kicks up a fierce sandstorm and hurls it at the opponent, dealing damage.", 10, 10));
        groundMoves.add(new Move("Earthquake", "User generates powerful seismic waves, causing the ground to tremble and deal damage to all opponents.", 20, 5));
        groundMoves.add(new Move("Sandstorm Curl", "User surrounds the battle arena with a sandstorm increasing it's attack and defense.", 0, 2));
        groundMoves.add(new Move("Earthen", "User taps into the energy of the earth to heal itself.", 0, 2));

        // Create bots
        Bot groundBot = new Bot("Terrabot", 100, 10, 10, 10, "GROUND", groundMoves);

        List<Move> rockMoves = new ArrayList<>();
        rockMoves.add(new Move("Stone Barrage", "User launches a barrage of sharp stones at the opponent, striking the opponent.", 10, 10));
        rockMoves.add(new Move("Rockslide Rush", "User triggers a rockslide, sending boulders crashing down onto the opponent.", 20, 5));
        rockMoves.add(new Move("Rock Harden", "User hardens its rocky exterior, boosting its Defense or Attack stats.", 0, 2));
        rockMoves.add(new Move("Mineral Replenish", "User absorbs minerals from the surrounding environment to heal itself.", 0, 2));

        // Create bots
        Bot rockBot = new Bot("Petrolem", 100, 10, 10, 10, "ROCK", rockMoves);

        List<Move> bugMoves = new ArrayList<>();
        bugMoves.add(new Move("Bug Buzz", "User emits a powerful buzzing sound that vibrates the air, striking the opponent with a burst of energy.", 10, 10));
        bugMoves.add(new Move("Nano Sting", "User launches a barrage of tiny, precise stings infused with technological energy, piercing the opponent's defenses.", 20, 5));
        bugMoves.add(new Move("Data Upgrade", "User upgrades its internal systems, boosting its Attack or Defense stats.", 0, 2));
        bugMoves.add(new Move("Byte Drain", "User siphons energy from the flowers to replenish its health.", 0, 2));

        // Create bots
        Bot bugBot = new Bot("Wirewing", 100, 10, 10, 10, "BUG", bugMoves);

        List<Move> iceMoves = new ArrayList<>();
        iceMoves.add(new Move("Frost Beam", "User emits a freezing beam of ice energy that chills the opponent to the core.", 10, 10));
        iceMoves.add(new Move("Blizzard Rush", "User summons a fierce blizzard that engulfs the opponent, dealing damage with sharp ice shards.", 20, 5));
        iceMoves.add(new Move("Glacial Surge", "User channels the power of glaciers, boosting its Attack or Defense stats.", 0, 2));
        iceMoves.add(new Move("Ice Shard Rejuvenation", "User absorbs energy from surrounding ice to heal itself.", 0, 2));

        // Create bots
        Bot iceBot = new Bot("Frozeon", 100, 10, 10, 10, "ICE", iceMoves);


        // Serialize bots
        serializeBot(fireBot, "PlayerBot1.dat");
        serializeBot(waterBot, "PlayerBot2.dat");
        serializeBot(grassBot, "PlayerBot3.dat");
        serializeBot(electricBot, "PlayerBot4.dat");

        serializeBot(groundBot, "OpponentBot1.dat");
        serializeBot(rockBot, "OpponentBot2.dat");
        serializeBot(bugBot, "OpponentBot3.dat");
        serializeBot(iceBot, "OpponentBot4.dat");

        BattleEngine.startBattleEngine(electricBot, groundBot);
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
