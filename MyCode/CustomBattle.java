import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CustomBattle {
    private static Scanner sc = new Scanner(System.in);

    public static Bot createBot(String botType) {
        System.out.println("Enter details for " + botType + " bot:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("HP: ");
        int hp = sc.nextInt();
        System.out.print("Attack: ");
        int attack = sc.nextInt();
        System.out.print("Defense: ");
        int defense = sc.nextInt();
        System.out.print("Speed: ");
        int speed = sc.nextInt();
        sc.nextLine();
        System.out.print("Type: ");
        String type = sc.nextLine();

        List<Move> moves = createMoves();

        return new Bot(name, hp, speed,attack, defense,type, moves);
    }

    private static List<Move> createMoves() {
        List<Move> moves = new ArrayList<>();
        moves.add(new Move("Pounce", "A basic attack", 10, 10));
        moves.add(new Move("Dash", "A quick and powerful attack", 20, 5));
        moves.add(new Move("Grow", "Boost your attack or defense stats", 15, 2));
        moves.add(new Move("Heal", "Regain some of your HP", 17, 2));
        return moves;
    }
}
