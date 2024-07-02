import java.util.Scanner;

/**
 * Main class to run the battle engine game.
 */
public class Main {
    // Static instance of MusicPlayer to control background music
    static MusicPlayer musicPlayer = new MusicPlayer();

    /**
     * Displays the main menu to the user.
     */
    private static void displayMainMenu() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\r\n" + //
                "                                                              \r\n" + //
                " _____       _    _    _         _____            _           \r\n" + //
                "| __  | ___ | |_ | |_ | | ___   |   __| ___  ___ |_| ___  ___ \r\n" + //
                "| __ -|| .'||  _||  _|| || -_|  |   __||   || . || ||   || -_|\r\n" + //
                "|_____||__,||_|  |_|  |_||___|  |_____||_|_||_  ||_||_|_||___|\r\n" + //
                "                                            |___|             \r\n" + //
                "" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD + "1. Play" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD + "2. Rules" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.CYAN_BOLD_BRIGHT + "Enter your choice: " + ConsoleColors.RESET);
    }

    /**
     * Displays the rules of the game to the user.
     */
    private static void displayRules() {
        System.out.println(ConsoleColors.PURPLE_BOLD + "\r\n" + //
                "                         \r\n" + //
                " _____       _           \r\n" + //
                "| __  | _ _ | | ___  ___ \r\n" + //
                "|    -|| | || || -_||_ -|\r\n" + //
                "|__|__||___||_||___||___|\r\n" + //
                "                         \r\n" + //
                "" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "1. Each player has a bot with different moves." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "2. Each player can choose from 4 given bots." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "3. Each opponent can also choose from 4 given bots." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "4. The player will not know what the opponent chose and the opponent won't know what the player chose." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "5. Players take turns to attack each other." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "6. The goal is to reduce the opponent's HP to 0." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "7. Each move has limited PP (Power Points)." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "8. Some moves can heal or boost stats." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "9. If a player runs out of PP for all moves, they lose the game." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "10. You'll be made to go through 5 battles. Win battles to add up to your score and climb the leaderboards!" + ConsoleColors.RESET);
    }

    /**
     * Gets the user's choice from the main menu.
     *
     * @param sc Scanner object for reading user input
     * @return The user's choice as an integer
     */
    private static int getUserChoice(Scanner sc) {
        int choice = -1;
        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(ConsoleColors.RED_BOLD + "Invalid input. Please enter a number." + ConsoleColors.RESET);
        }
        return choice;
    }

    /**
     * Starts a battle with the specified opponent.
     *
     * @param bNo      Battle number
     * @param opponent Name of the opponent
     */
    private static void battleStart(int bNo, String opponent) {
        Battle.clearScreen();
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Battle " + bNo + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD + "Opponent: " + opponent + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BOLD + "Starting in..." + ConsoleColors.RESET);
        Battle.sleep(1000);
        System.out.print(ConsoleColors.GREEN_BOLD + "3..." + ConsoleColors.RESET);
        Battle.sleep(1000);
        System.out.print(ConsoleColors.YELLOW_BOLD + "2..." + ConsoleColors.RESET);
        Battle.sleep(1000);
        System.out.print(ConsoleColors.RED_BOLD + "1..." + ConsoleColors.RESET);
        Battle.sleep(1000);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "GO!" + ConsoleColors.RESET);
        Battle.sleep(500);
        Battle.clearScreen();
    }

    /**
     * Main method to run the bot battle game.
     *
     * @param args Command line arguments
     * @throws Exception if an error occurs
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        musicPlayer.play("Music/high.wav");
        Battle.clearScreen();
        displayMainMenu();
        int choice = getUserChoice(sc);
        Battle.clearScreen();
        if (choice == 1) {
            int score = 0;
            musicPlayer.stop();

            // Battle 1
            battleStart(1, "Lucas");
            score += new Battle1().startBattle();
            System.out.println(ConsoleColors.GREEN_BOLD + "Your score: " + score + ConsoleColors.RESET);
            Battle.sleep(2000);

            // Battle 2
            battleStart(2, "Lucy");
            score += new Battle2().startBattle();
            System.out.println(ConsoleColors.GREEN_BOLD + "Your score: " + score + ConsoleColors.RESET);
            Battle.sleep(2000);

            // Battle 3
            battleStart(3, "Julie");
            score += new Battle3().startBattle();
            System.out.println(ConsoleColors.GREEN_BOLD + "Your score: " + score + ConsoleColors.RESET);
            Battle.sleep(2000);

            // Battle 4
            battleStart(4, "Red");
            score += new Battle4().startBattle();
            System.out.println(ConsoleColors.GREEN_BOLD + "Your score: " + score + ConsoleColors.RESET);
            Battle.sleep(2000);

            // Battle 5
            battleStart(5, "???");
            score += new Battle5(score).startBattle();
            System.out.println(ConsoleColors.GREEN_BOLD + "Your score: " + score + ConsoleColors.RESET);
            Battle.sleep(2000);

        } else if (choice == 2) {
            displayRules();
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "Invalid choice. Please try again." + ConsoleColors.RESET);
        }
    }
}
