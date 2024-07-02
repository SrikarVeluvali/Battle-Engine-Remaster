import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.AudioFileFormat.Type;
/**
 * Concrete implementation of the Battle class for the second battle scenario.
 */
public class Battle2 extends Battle {
    MusicPlayer musicPlayer = new MusicPlayer();

    /**
     * Displays the pre-battle narrative.
     */
    public void prelogue() {
        clearScreen();

        String s = "\nLucy stands with her arms crossed, a smirk plastered across her face. She taps her foot impatiently as she looks you up and down.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.PURPLE_BOLD + "Lucy:");
        s = "\"Oh, look who decided to challenge me. I hope you're ready to lose. My bots are the best, and there's no way you'll beat them.\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.PURPLE + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        s = "\nShe flips her hair back, smiling confidently.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.PURPLE_BOLD + "Lucy:");
        s = "\"Let's get this over with. Try not to embarrass yourself too much, okay?\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.PURPLE + s.charAt(i) + ConsoleColors.RESET);
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
        String s = "\nLucy glares at her defeated bots, clearly frustrated. She clenches her fists but then takes a deep breath.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.PURPLE_BOLD + "Lucy:");
        s = "\"Ugh, I can't believe I lost. I must have underestimated you. Maybe your strategy wasn't as bad as I thought.\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.PURPLE + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        s = "\nShe reluctantly looks at you, her expression softening just a bit.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.PURPLE_BOLD + "Lucy:");
        s = "\"Fine, you win this time. But don't get too cocky. Next time, my bots will crush you. Count on it.\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.PURPLE + s.charAt(i) + ConsoleColors.RESET);
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
        String s = "\nLucy laughs triumphantly as her bot delivers the final blow, her eyes gleaming with satisfaction.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.PURPLE_BOLD + "Lucy:");
        s = " \"Ha! I knew it. My bots are unbeatable! Did you really think you stood a chance against me?\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.PURPLE + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        s = "\nShe walks over to you, still smirking but with a hint of genuine respect in her eyes.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.PURPLE_BOLD + "Lucy:");
        s = "\"You put up a decent fight, I'll give you that. Maybe you're not as hopeless as you look. But don't get too comfortable. I'm always improving my bots.\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.PURPLE + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        s = "\nShe flips her hair back again, looking at you challengingly.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW + s.charAt(i) + ConsoleColors.RESET);
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.PURPLE_BOLD + "Lucy:");
        s = "\"If you want a rematch, I'll be here. Just don't expect it to go any differently.\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.PURPLE + s.charAt(i) + ConsoleColors.RESET);
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
        System.out.println(ConsoleColors.PURPLE_BOLD + "Lucy can choose any one from these four bots!\n" + ConsoleColors.RESET);
        File[] opponentBots = new File("Bots/Level2/Opp").listFiles();
        displayBots(opponentBots);
        // Simulate Lucy choosing a random opponent bot
        Random random = new Random();
        File randomOpponentBot = opponentBots[random.nextInt(opponentBots.length)];
        FileInputStream fis = new FileInputStream(randomOpponentBot);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Bot opponentBot = (Bot) ois.readObject();

        sleep(3000);
        System.out.println(ConsoleColors.GREEN_BOLD + "The opponent chose a bot! Now, it's your turn! \nChoose a bot wisely!\nYou cannot switch bots in between!\n" + ConsoleColors.RESET);

        File[] playerBots = new File("Bots/Level2/Player").listFiles();
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
        Bot[] returnBots = { playerBot, opponentBot };
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
        musicPlayer.play("Music/battle2.wav");
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
            System.out.println(ConsoleColors.GREEN_BOLD + "YOU EARNED A BATTLE POINT BY WINNING AGAINST LUCY!" + ConsoleColors.RESET);
            musicPlayer.stop();
        } else {
            musicPlayer.play("Music/determination.wav");
            postlogueLose();
            System.out.println(ConsoleColors.RED_BOLD + "YOU DIDN'T EARN A BATTLE POINT BECAUSE YOU LOST TO LUCY" + ConsoleColors.RESET);
            musicPlayer.stop();
        }
        return status;
    }
}

