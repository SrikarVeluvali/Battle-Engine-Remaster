import java.util.Scanner;
import java.util.List;
import java.util.Random;
/**
 * The BattleEngine class manages the battle logic between two bots.
 */
public class BattleEngine {
    private static Random random = new Random();
    private static Scanner sc = new Scanner(System.in);
    private static final int DELAY_MS = 2000;
    /**
     * Starts the battle engine, managing the turns and announcing the winner.
     * 
     * @param playerBot   The player's bot.
     * @param opponentBot The opponent's bot.
     * @return 1 if the player wins, 0 if the player loses.
     */
    public static int startBattleEngine(Bot playerBot, Bot opponentBot) {
        System.out.println(ConsoleColors.GREEN_BOLD + "Your Bot: " + playerBot.getName() + " (" + playerBot.getType() + ")" + ConsoleColors.RESET + "\n" +
                           ConsoleColors.RED_BOLD + "Opponent's Bot: " + opponentBot.getName() + " (" + opponentBot.getType() + ")" + ConsoleColors.RESET);

        int turn = decideFirstTurn(playerBot, opponentBot);

        while (playerBot.getHP() > 0 && opponentBot.getHP() > 0 && playerBot.getTotalPP() > 0 && opponentBot.getTotalPP() > 0) {
            takeTurn(playerBot, opponentBot, turn);
            turn = (turn + 1) % 2;
            try {
                Thread.sleep(DELAY_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (playerBot.getTotalPP() == 0 && playerBot.getHP() != 0) {
            System.out.println(ConsoleColors.RED + "Your bot ran out of all the Power Points! You lost!" + ConsoleColors.RESET);
            try {
                Thread.sleep(DELAY_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 0;
        } else if (opponentBot.getTotalPP() == 0 && opponentBot.getHP() != 0) {
            System.out.println(ConsoleColors.GREEN + "The opponent bot ran out of all the Power Points! You win!" + ConsoleColors.RESET);
            try {
                Thread.sleep(DELAY_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 1;
        }
        announceWinner(playerBot);
        return playerBot.getHP() > 0 ? 1 : 0;
    }
    /**
     * Decides which bot goes first based on their speed.
     * 
     * @param playerBot   The player's bot.
     * @param opponentBot The opponent's bot.
     * @return 0 if the player bot goes first, 1 if the opponent bot goes first.
     */
    private static int decideFirstTurn(Bot playerBot, Bot opponentBot) {
        return playerBot.getSpd() >= opponentBot.getSpd() ? 0 : 1;
    }
    /**
     * Takes a turn in the battle based on whose turn it is.
     * 
     * @param playerBot   The player's bot.
     * @param opponentBot The opponent's bot.
     * @param turn        The current turn (0 for player, 1 for opponent).
     */
    private static void takeTurn(Bot playerBot, Bot opponentBot, int turn) {
        if (turn == 0) {
            playerTurn(playerBot, opponentBot);
        } else {
            opponentTurn(playerBot, opponentBot);
        }
    }
    /**
     * Manages the player's turn, allowing them to choose an attack.
     * 
     * @param playerBot   The player's bot.
     * @param opponentBot The opponent's bot.
     */
    private static void playerTurn(Bot playerBot, Bot opponentBot) {
        List<Move> moves = playerBot.getMoves();
        System.out.println(ConsoleColors.YELLOW_BOLD + "\nList of attacks:" + ConsoleColors.RESET);
        for (int i = 0; i < moves.size(); i++) {
            Move move = moves.get(i);
            String formattedMove = String.format("%d. %-15s %-30s (%d/%d)",
                    i + 1,
                    move.getName(),
                    move.getDescription(),
                    move.getPP(),
                    move.getMaxPP());
            System.out.println(formattedMove);
        }
        System.out.print("Choose an attack: ");
        int userAttack;
        while (true) {
            try {
                userAttack = Integer.parseInt(sc.nextLine());

                if (userAttack < 1 || userAttack > moves.size()) {
                    throw new NumberFormatException();
                }
                if (moves.get(userAttack - 1).getPP() <= 0) {
                    System.out.println(ConsoleColors.RED + "This move can't be used anymore." + ConsoleColors.RESET);
                    continue;
                }
                if (userAttack == 4 && playerBot.getHP() == playerBot.getMaxHP()) {
                    System.out.println(ConsoleColors.RED + "Your health is already full! Can't use this attack!" + ConsoleColors.RESET);
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED + "Invalid input. Please enter a number corresponding to the attack." + ConsoleColors.RESET);
            }
        }

        int miss_prob = random.nextInt(31);
        int critHitPer = random.nextInt(51);
        int critHit = critHitPer == 2 ? 2 : 1;
        Move selectedMove = moves.get(userAttack - 1);
        selectedMove.decrementPP();
        if (miss_prob == 2) {
            System.out.println(ConsoleColors.YELLOW + "Your attack missed!" + ConsoleColors.RESET);
            return;
        }
        if (critHit == 2 && userAttack < 2) {
            System.out.println(ConsoleColors.PURPLE_BOLD + "A Critical Hit!" + ConsoleColors.RESET);
        }

        if (userAttack == 3 || userAttack == 4) {
            playerBot.useSpecialMove(userAttack);
        } else {
            int damageToOpponent = (int) DamageCalculator.calculateDamage(playerBot, opponentBot, selectedMove.getPower(), critHit);
            opponentBot.setHP(opponentBot.getHP() - damageToOpponent);
            System.out.println(ConsoleColors.GREEN + "\nYou used " + selectedMove.getName() + " and dealt " + damageToOpponent + " HP damage!" + ConsoleColors.RESET);
        }

        printHP(playerBot, opponentBot);
    }
    /**
     * Manages the opponent's turn, selecting and performing an attack.
     * 
     * @param playerBot   The player's bot.
     * @param opponentBot The opponent's bot.
     */
    private static void opponentTurn(Bot playerBot, Bot opponentBot) {
        int selectedMoveIndex = opponentBot.selectMove(playerBot);
        if (selectedMoveIndex == -1) {
            System.out.println(ConsoleColors.YELLOW + "The opponent bot is too tired to proceed!" + ConsoleColors.RESET);
        }
        List<Move> moves = opponentBot.getMoves();
        Move selectedMove = moves.get(selectedMoveIndex);

        selectedMove.decrementPP();
        int miss_prob = random.nextInt(41);
        int critHitPer = random.nextInt(31);
        int critHit = critHitPer == 2 ? 2 : 1;

        if (miss_prob == 2) {
            System.out.println(ConsoleColors.YELLOW + "The opponent's attack missed!" + ConsoleColors.RESET);
            return;
        }
        if (critHit == 2 && selectedMoveIndex < 2) {
            System.out.println(ConsoleColors.PURPLE_BOLD + "The opponent landed a Critical Hit!" + ConsoleColors.RESET);
        }

        if (selectedMoveIndex == 2 || selectedMoveIndex == 3) {
            opponentBot.useSpecialMove(selectedMoveIndex + 1);
        } else {
            int damageToPlayer = (int) DamageCalculator.calculateDamage(opponentBot, playerBot, selectedMove.getPower(), critHit);
            playerBot.setHP(playerBot.getHP() - damageToPlayer);
            System.out.println(ConsoleColors.RED + "\nThe opponent used " + selectedMove.getName() + " and dealt " + damageToPlayer + " HP Damage!" + ConsoleColors.RESET);
        }

        printHP(playerBot, opponentBot);
    }
    /**
     * Prints the current HP of both the player's bot and the opponent's bot.
     * 
     * @param playerBot   The player's bot.
     * @param opponentBot The opponent's bot.
     */
    private static void printHP(Bot playerBot, Bot opponentBot) {
        System.out.println(ConsoleColors.CYAN_BOLD + "Your HP: " + playerBot.getHP() + "/" + playerBot.getMaxHP() + ConsoleColors.RESET + "\n" +
                           ConsoleColors.RED_BOLD + "Opponent's HP: " + opponentBot.getHP() + "/" + opponentBot.getMaxHP() + ConsoleColors.RESET + "\n");
    }
    /**
     * Announces the winner of the battle based on the remaining HP.
     * 
     * @param playerBot The player's bot.
     */
    private static void announceWinner(Bot playerBot) {
        if (playerBot.getHP() <= 0) {
            System.out.println(ConsoleColors.RED_BOLD + "You lost!" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.GREEN_BOLD + "You won!" + ConsoleColors.RESET);
        }
    }
}
