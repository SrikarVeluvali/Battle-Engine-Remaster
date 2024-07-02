import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Abstract class representing a Battle in the game.
 */
public abstract class Battle {

    // Abstract methods to be defined in subclasses
    /**
     * Method to execute pre-battle preparations.
     */
    abstract void prelogue();

    /**
     * Method to allow players to choose their bots for the battle.
     * 
     * @return An array of chosen bots.
     * @throws Exception if an error occurs during bot selection.
     */
    abstract Bot[] chooseBots() throws Exception;

    /**
     * Method to start the battle.
     * 
     * @return An integer representing the result of the battle.
     * @throws Exception if an error occurs during the battle.
     */
    abstract int startBattle() throws Exception;

    /**
     * Method to execute post-battle actions if the player wins.
     */
    abstract void postlogueWin();

    /**
     * Method to execute post-battle actions if the player loses.
     */
    abstract void postlogueLose();

    // Defined methods

    /**
     * Clears the console screen.
     */
    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Pauses the execution for the specified delay in milliseconds.
     * 
     * @param DELAY_MS Delay in milliseconds.
     */
    static void sleep(int DELAY_MS) {
        try {
            Thread.sleep(DELAY_MS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the details of the opponent's bots.
     * 
     * @param opponentBots An array of files containing the opponent's bots.
     * @throws Exception if an error occurs while reading the bot files.
     */
    void displayBots(File[] opponentBots) throws Exception {
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-5s | %-10s | %-5s | %-6s | %-7s |\n", "Name", "HP", "Type", "Speed", "Attack", "Defense");
        System.out.println("------------------------------------------------------------------------");
        for (File f : opponentBots) {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Bot b = (Bot) ois.readObject();
            String typeColor = getTypeColor(b.getType());
            System.out.printf("| %-20s | %-5d | %s%-10s%s | %-5d | %-6d | %-7d |\n", b.getName(), b.getMaxHP(), typeColor, b.getType(), ConsoleColors.RESET, b.getSpd(), b.getAtk(), b.getDef());
            fis.close();
            ois.close();
        }
        System.out.println("------------------------------------------------------------------------");
    }

    /**
     * Gets the color code for the specified bot type.
     * 
     * @param type The type of the bot.
     * @return The corresponding color code as a string.
     */
    private String getTypeColor(String type) {
        switch (type) {
            case "NORMAL":
                return ConsoleColors.WHITE_BOLD;
            case "FIGHTING":
                return ConsoleColors.RED_BOLD;
            case "FLYING":
                return ConsoleColors.CYAN_BOLD;
            case "POISON":
                return ConsoleColors.PURPLE_BOLD;
            case "GROUND":
                return ConsoleColors.YELLOW_BOLD;
            case "ROCK":
                return ConsoleColors.WHITE_BOLD;
            case "BUG":
                return ConsoleColors.GREEN_BOLD;
            case "GHOST":
                return ConsoleColors.WHITE_BOLD;
            case "FIRE":
                return ConsoleColors.RED_BOLD;
            case "WATER":
                return ConsoleColors.BLUE_BOLD;
            case "GRASS":
                return ConsoleColors.GREEN_BOLD;
            case "ELECTRIC":
                return ConsoleColors.YELLOW_BOLD;
            case "PSYCHIC":
                return ConsoleColors.PURPLE_BOLD;
            case "ICE":
                return ConsoleColors.CYAN_BOLD;
            case "DRAGON":
                return ConsoleColors.PURPLE_BOLD;
            default:
                return ConsoleColors.RESET;
        }
    }
}
