import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Random;
import java.util.Scanner;

public class Battle5 extends Battle {
    MusicPlayer musicPlayer = new MusicPlayer();
    int currScore;
    Battle5(int score){
        currScore = score;
    }
    public void prelogue() {
        clearScreen();
        String s = "\nYou feel a weird presence approaching...\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\n???: Hey! You made it this far! Congratulations! Wait! You made it this far..... that means this game wasn't boring then! Phew, atleast someone likes it!\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nYou feel awkward...\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\n???: Feel awkward all you want boy! Or perhaps a girl? Eh, whoever. Let's see your score so far.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        if(currScore<3){
            s = "\n???: Wow, That's some score! " + currScore +"?!That's awful! You suck!";
        } else {
            s = "\n???: Okay, you seem to be pretty good at this game! Regardless, I'm gonna crush you anyways\n";
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nSrikar: I forgot to introduce myself didn't I? I am Srikar! I am the one who made this game. Let's have a good fight!!\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        sleep(1000);
        clearScreen();
    }

    public void postlogueWin() {
        clearScreen();
        String s = "\nSrikar: Oh wow you're too good! I like your determination! Congratulations!\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nYou feel the presense leaving...\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        sleep(1000);
    }

    public void postlogueLose() {
        clearScreen();
        String s = "\nSrikar: Yeah I knew that you'd lose. Too bad try again some other time >:)\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nYou feel the presense leaving...\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        sleep(1000);
    }

    public Bot[] chooseBots() throws Exception {
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Srikar can choose any one from these four bots!\n" + ConsoleColors.RESET);
        sleep(2000);
        File[] opponentBots = new File("Bots/Level5/Opp").listFiles();
        displayBots(opponentBots);


        sleep(3000);
        System.out.println(ConsoleColors.GREEN_BOLD + "The opponent chose a bot! Now, it's your turn! \nChoose a bot wisely!\nYou cannot switch bots in between!\n" + ConsoleColors.RESET);

        System.out.println("");
    
        
        File[] playerBots = new File("Bots/Level5/Player").listFiles();
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
        musicPlayer.play("Music/spamton.wav");
        prelogue();
        musicPlayer.stop();
        musicPlayer.play("Music/battle5.wav");
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
            System.out.println(ConsoleColors.GREEN_BOLD+ "YOU EARNED A BATTLE POINT BY WINNING AGAINST SRIKAR!" + ConsoleColors.RESET);
            musicPlayer.stop();
        } else {
            musicPlayer.play("Music/determination.wav");
            postlogueLose();
            System.out.println(ConsoleColors.RED_BOLD+ "YOU DIDN'T EARN A BATTLE POINT BECAUSE YOU LOST TO SRIKAR"+ ConsoleColors.RESET);
            musicPlayer.stop();
        }
        return status;
    }
}

