/**
 * Class to calculate the type effectiveness between two bots.
 */
public class TypeEffectiveness {
    /**
     * Type Effectiveness Chart
     */
    private static final double[][] TYPE_CHART = {
        {1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
        {2.0, 1.0, 0.5, 0.5, 1.0, 2.0, 0.5, 0.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0},
        {1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0},
        {1.0, 1.0, 1.0, 0.5, 0.5, 0.5, 2.0, 0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0},
        {1.0, 1.0, 0.0, 2.0, 1.0, 2.0, 0.5, 1.0, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0},
        {1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0},
        {1.0, 0.5, 0.5, 2.0, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0},
        {0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0},
        {1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 0.5, 0.5, 2.0, 1.0, 1.0, 2.0, 0.5},
        {1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.5},
        {1.0, 1.0, 0.5, 0.5, 2.0, 2.0, 0.5, 1.0, 0.5, 2.0, 0.5, 1.0, 1.0, 1.0, 0.5},
        {1.0, 1.0, 2.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 0.5},
        {1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0},
        {1.0, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 0.5, 2.0},
        {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0}
    };
    /**
     * Gives the specified type effectiveness for the attacker and defender (0x, 1x, 2x or 0.5x).
     *
     * @param attacker Attacker bot
     * @param defender Defender bot
     */
    public static double getTypeEffectiveness(Bot attacker, Bot defender) {
        String attackerType = attacker.getType();
        String defenderType = defender.getType();

        int attackerIndex = getTypeIndex(attackerType);
        int defenderIndex = getTypeIndex(defenderType);
        if (attackerIndex == -1 || defenderIndex == -1) {
            return 1;
        }
        double effectiveness = TYPE_CHART[attackerIndex][defenderIndex];

        return effectiveness;
    }
    /**
     * Helper function to read the table properly.
     *
     * @param type Type of the bot
     */
    private static int getTypeIndex(String type) {
        switch (type.toUpperCase()) {
            case "NORMAL": return 0;
            case "FIGHTING": return 1;
            case "FLYING": return 2;
            case "POISON": return 3;
            case "GROUND": return 4;
            case "ROCK": return 5;
            case "BUG": return 6;
            case "GHOST": return 7;
            case "FIRE": return 8;
            case "WATER": return 9;
            case "GRASS": return 10;
            case "ELECTRIC": return 11;
            case "PSYCHIC": return 12;
            case "ICE": return 13;
            case "DRAGON": return 14;
            default: return -1;
        }
    }
}
