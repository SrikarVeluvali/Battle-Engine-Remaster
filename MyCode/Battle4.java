import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Random;
import java.util.Scanner;

public class Battle4 extends Battle {
    MusicPlayer musicPlayer = new MusicPlayer();

    public void prelogue() {
        clearScreen();
        String s = "\nRed stands quietly, his cap pulled low over his eyes. He nods in acknowledgment as he meets your gaze, his expression serious and determined.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nRed reaches for his bots, his silent confidence speaking volumes.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nHe gives a brief, determined nod, signaling the start of the battle.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        clearScreen();
    }

    public void postlogueWin() {
        clearScreen();
        String s = "\nRed stands still, observing his defeated bots with a thoughtful expression. He looks at you with a hint of a smile, acknowledging your skill.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nRed reaches out and gives a firm, approving nod. His eyes convey respect and determination to improve.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nHe turns away, ready to train harder for the next encounter, his silence a testament to his resolve.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        sleep(1000);
    }

    public void postlogueLose() {
        clearScreen();
        String s = "\nRed's bot lands the final blow. He remains calm and collected, offering a slight smile of approval for your effort.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nHe steps forward and gives a brief nod, his eyes showing a mix of respect and encouragement.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nRed silently gestures a thumbs-up, conveying his acknowledgment of your potential and his anticipation of future battles.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nHe turns and walks away, his silent presence leaving a lasting impression of his strength and character.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        sleep(1000);
    }

    public Bot[] chooseBots() throws Exception {
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Red can choose any one from these four bots!\n" + ConsoleColors.RESET);
        File[] opponentBots = new File("Bots/Level4/Opp").listFiles();
        displayBots(opponentBots);
        sleep(3000);
        System.out.println(ConsoleColors.GREEN_BOLD + "The opponent chose a bot! Now, it's your turn! \nChoose a bot wisely!\nYou cannot switch bots in between!\n" + ConsoleColors.RESET);



        System.out.println("");
    
        
        File[] playerBots = new File("Bots/Level4/Player").listFiles();
        displayBots(playerBots);
        System.out.println("Choose a bot: ");
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
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "The opponent is ready!\n" + ConsoleColors.RESET);
        
        // Now let's make Red choose a bot based on the user's choice
        Bot playerBot = (Bot) new ObjectInputStream(new FileInputStream(chosenPlayerBot)).readObject();
        File chosenOpponentBot = null;
        
        // Determine Red's bot based on user's choice
        String playerBotType = playerBot.getType();
        for (File oppBotFile : opponentBots) {
            Bot opponentBot = (Bot) new ObjectInputStream(new FileInputStream(oppBotFile)).readObject();
            // Choose a bot that has an advantage over the player's bot type
            double effectiveness = TypeEffectiveness.getTypeEffectiveness(opponentBot, playerBot);
            if (effectiveness > 1) {
                chosenOpponentBot = oppBotFile;
                break;
            }
        }
    
        // If no advantageous bot found, choose a random one
        if (chosenOpponentBot == null) {
            Random random = new Random();
            chosenOpponentBot = opponentBots[random.nextInt(opponentBots.length)];
        }
    
        Bot opponentBot = (Bot) new ObjectInputStream(new FileInputStream(chosenOpponentBot)).readObject();
    
        clearScreen();
        Bot[] returnBots = {playerBot, opponentBot};
        return returnBots;
    }
    
    public int startBattle() throws Exception {
        musicPlayer.play("Music/sans.wav");
        prelogue();
        musicPlayer.stop();
        musicPlayer.play("Music/battle4.wav");
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
            System.out.println(ConsoleColors.GREEN_BOLD+ "YOU EARNED A BATTLE POINT BY WINNING AGAINST RED!" + ConsoleColors.RESET);
            musicPlayer.stop();
        } else {
            musicPlayer.play("Music/determination.wav");
            postlogueLose();
            System.out.println(ConsoleColors.RED_BOLD+ "YOU DIDN'T EARN A BATTLE POINT BECAUSE YOU LOST TO RED"+ ConsoleColors.RESET);
            musicPlayer.stop();
        }
        return status;
    }
}

