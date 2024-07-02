import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Random;
import java.util.Scanner;
/**
 * Concrete implementation of the Battle class for the first battle scenario.
 */
public class Battle1 extends Battle {
    MusicPlayer musicPlayer = new MusicPlayer();

    /**
     * Displays the pre-battle narrative.
     */
    public void prelogue() {
        clearScreen();

        String s = "\nLucas stands hesitantly, clutching a small remote control in his hands. He glances up at you, his eyes wide with a mix of excitement and nervousness.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.CYAN_BOLD + "Lucas:");
        s = "\"Um, hi there... I'm Lucas. I-I've been working on my bots for a while now. They're pretty cool, I think. Would you... would you like to have a battle with me? I really want to see how they perform in a real fight.\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.CYAN + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        s = "\nHe takes a deep breath, trying to steady himself.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.CYAN_BOLD + "Lucas:");
        s = "\"I-I promise I'll do my best. Let's go!\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.CYAN + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        sleep(1000);
        clearScreen();
    }
    /**
     * Displays the postlogue when player wins.
     */
    public void postlogueWin() {
        clearScreen();
        String s = "\nLucas drops to his knees, a mixture of disbelief and admiration on his face. He looks up at you with a faint smile.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.CYAN_BOLD + "Lucas:");
        s = "\"Wow... You really are amazing. I-I never thought my bots would lose like that. But it's okay, this just means I have to work harder. Thank you for the battle!\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.CYAN + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        s = "\nHe stands up, determination burning in his eyes.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        s = "Lucas: \"Next time, I'll be stronger. I won't give up!\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.CYAN + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        sleep(1000);
    }
    /**
     * Displays the postlogue when player loses.
     */
    public void postlogueLose() {
        clearScreen();
        String s = "\nLucas's eyes widen with joy and relief as his bots stand victorious. He jumps up, pumping his fist in the air.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.CYAN_BOLD + "Lucas:");
        s = "\"I did it! I actually won! This is incredible! Thank you so much for the battle, it means a lot to me. You've helped me see that all my hard work is paying off.\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.CYAN + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        s = "\nHe beams at you, pure happiness radiating from him.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        s = "Lucas: \"I'll keep improving. You can fight me again if you want!\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.CYAN + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        sleep(1000);
    }
    /**
     * Lets the user and the opponent choose bots.
     * @return Bot array which in index 0 has player's bot and at 1st index has opponent's bot. 
     */
    public Bot[] chooseBots() throws Exception {
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.println(ConsoleColors.YELLOW_BOLD + "Lucas can choose any one from these four bots!\n" + ConsoleColors.RESET);
        File[] opponentBots = new File("Bots/Level1/Opp").listFiles();
       
        displayBots(opponentBots);
        // Simulate Lucas choosing a random opponent bot
        Random random = new Random();
        File randomOpponentBot = opponentBots[random.nextInt(opponentBots.length)];
        FileInputStream fis = new FileInputStream(randomOpponentBot);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Bot opponentBot = (Bot) ois.readObject();

        sleep(3000);
        System.out.println(ConsoleColors.GREEN_BOLD + "The opponent chose a bot! Now, it's your turn! \nChoose a bot wisely!\nYou cannot switch bots in between!\n" + ConsoleColors.RESET);

        File[] playerBots = new File("Bots/Level1/Player").listFiles();
        displayBots(playerBots);
        System.out.println(ConsoleColors.GREEN_BOLD + "Choose a bot: " + ConsoleColors.RESET);
        int chosenPlayerIndex;
        File chosenPlayerBot;
        while (true) {
            try {
                chosenPlayerIndex = Integer.parseInt(sc.nextLine()) - 1;
                chosenPlayerBot = playerBots[chosenPlayerIndex];
                break;
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED_BOLD + "Invalid input. Please enter a valid number." + ConsoleColors.RESET);
            } catch (Exception e) {
                System.out.println(ConsoleColors.RED_BOLD + "Enter the values in a valid range!" + ConsoleColors.RESET);
            }
        }
        clearScreen();
        fis = new FileInputStream(chosenPlayerBot);
        ois = new ObjectInputStream(fis);
        Bot playerBot = (Bot) ois.readObject();
        fis.close();
        ois.close();
        Bot[] returnBots = {playerBot, opponentBot};
        return returnBots;
    }

    /**
     * Starts the battle.
     * @return Integer value either 0 (for loss) or 1 (for win).
     */
    public int startBattle() throws Exception {
        musicPlayer.play("Music/sans.wav");
        prelogue();
        musicPlayer.stop();
        musicPlayer.play("Music/battle1.wav");
        Bot[] bots = chooseBots();
        double TypeEffect = TypeEffectiveness.getTypeEffectiveness(bots[0], bots[1]);
        if (TypeEffect == 1) {
            System.out.println(ConsoleColors.BLUE_BOLD + "Normal Matchup!" + ConsoleColors.RESET);
        } else if (TypeEffect == 2) {
            System.out.println(ConsoleColors.RED_BOLD + "Super Effective Matchup!" + ConsoleColors.RESET);
        } else if (TypeEffect == 0.5) {
            System.out.println(ConsoleColors.GREEN_BOLD + "Not very effective matchup!" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.YELLOW_BOLD + "No Effect!" + ConsoleColors.RESET);
        }
        int status = BattleEngine.startBattleEngine(bots[0], bots[1]);
        musicPlayer.stop();
        if (status == 1) {
            musicPlayer.play("Music/victory.wav");
            postlogueWin();
            System.out.println(ConsoleColors.GREEN_BOLD + "YOU EARNED A BATTLE POINT BY WINNING AGAINST LUCAS!" + ConsoleColors.RESET);
            musicPlayer.stop();
        } else {
            musicPlayer.play("Music/determination.wav");
            postlogueLose();
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "YOU DIDN'T EARN A BATTLE POINT BECAUSE YOU LOST TO LUCAS" + ConsoleColors.RESET);
            musicPlayer.stop();
        }
        return status;
    }
}
