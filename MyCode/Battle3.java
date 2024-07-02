import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Random;
import java.util.Scanner;

public class Battle3 extends Battle {
    MusicPlayer musicPlayer = new MusicPlayer();

    public void prelogue() {
        clearScreen();

        String s = "\nJulie approaches with a bright smile, her eyes sparkling with excitement.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.GREEN_BOLD + "Julie:");
        s = " \"Hey there! I'm Julie. I've been looking forward to a fun battle today. My bots and I are ready to give it our all. How about you?\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.GREEN + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nShe gives you a thumbs up, her enthusiasm infectious.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.GREEN_BOLD + "Julie:");
        s = "\"Let's have a great match! Win or lose, it's all about enjoying the battle and learning from it. Ready? Let's go!\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.GREEN + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        sleep(1000);
        clearScreen();
    }

    public void postlogueWin() {
        clearScreen();
        String s = "\nJulie kneels down beside her defeated bots, patting them gently with a sad smile. She quickly regains her usual cheerfulness.s\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.GREEN_BOLD+"Julie:");
        s = "\"Aww, my poor bots. They did their best, but you were amazing out there! I guess it's my turn to step up my game.\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.GREEN+s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nShe stands up and gives you a big smile.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.GREEN_BOLD+"Julie:");
        s = "\"Congratulations on your win! I'm really impressed. You've inspired me to work even harder. Next time, we'll be even better. Keep up the great work!\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.GREEN+s.charAt(i));
            sleep(70);
        }
        System.out.println();
        sleep(1000);
    }

    public void postlogueLose() {
        clearScreen();
        String s = "\nJulie's bot lands the final blow, and she cheers happily before looking at you with a kind smile.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD+s.charAt(i));
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.GREEN_BOLD+"Julie:");
        s = "\"That was fantastic! My bots really pulled through this time. You put up a great fight, though.\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.GREEN+s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nShe walks over and pats you on the shoulder encouragingly.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD+s.charAt(i));
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.GREEN_BOLD+"Julie:");
        s = "\"Don't lose heart, okay? Every battle is a step towards getting better. Keep training, and I know you'll come back even stronger. I can't wait to see how you improve!\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.GREEN + s.charAt(i));
            sleep(70);
        }
        System.out.println();
        s = "\nShe waves cheerfully as she heads off.\n";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.YELLOW_BOLD+s.charAt(i));
            sleep(70);
        }
        System.out.println();
        System.out.print(ConsoleColors.GREEN_BOLD+"Julie:");
        s = "\"Until next time! Keep smiling and keep battling!\"";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ConsoleColors.GREEN+s.charAt(i));
            sleep(70);
        }
        System.out.println();
        sleep(1000);
    }

    public Bot[] chooseBots() throws Exception {
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.println(ConsoleColors.GREEN_BOLD + "Julie can choose any one from these four bots!\n" + ConsoleColors.RESET);
        File[] opponentBots = new File("Bots/Level3/Opp").listFiles();
        displayBots(opponentBots);
        // Simulate Julie choosing a random opponent bot
        Random random = new Random();
        File randomOpponentBot = opponentBots[random.nextInt(opponentBots.length)];
        FileInputStream fis = new FileInputStream(randomOpponentBot);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Bot opponentBot = (Bot) ois.readObject();

        sleep(3000);
        System.out.println(ConsoleColors.GREEN_BOLD + "The opponent chose a bot! Now, it's your turn! \nChoose a bot wisely!\nYou cannot switch bots in between!\n" + ConsoleColors.RESET);

        File[] playerBots = new File("Bots/Level3/Player").listFiles();
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

    public int startBattle() throws Exception {
        musicPlayer.play("Music/sans.wav");
        prelogue();
        musicPlayer.stop();
        musicPlayer.play("Music/battle3.wav");
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
            System.out.println(ConsoleColors.GREEN_BOLD + "YOU EARNED A BATTLE POINT BY WINNING AGAINST JULIE!" + ConsoleColors.RESET);
            musicPlayer.stop();
        } else {
            musicPlayer.play("Music/determination.wav");
            postlogueLose();
            System.out.println(ConsoleColors.RED_BOLD + "YOU DIDN'T EARN A BATTLE POINT BECAUSE YOU LOST TO JULIE" + ConsoleColors.RESET);
            musicPlayer.stop();
        }
        return status;
    }

    public static void main(String[] args) throws Exception {
        Battle3 battle3 = new Battle3();
        battle3.startBattle();
    }
}

