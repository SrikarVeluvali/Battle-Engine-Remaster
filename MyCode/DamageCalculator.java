import java.util.Random;

public class DamageCalculator {
    public static double calculateDamage(Bot b1, Bot b2, int power, int critHit){
        Random random = new Random();
        final int level = 100;
        double type1 = TypeEffectiveness.getTypeEffectiveness(b1, b2);
        double randomNumber = (random.nextInt(39) + 217) / 255.0;
        int A = b1.getAtk();
        int D = b2.getDef();
        
        double damage = (((((2 * level * critHit / 5) + 2) * power * A / D) / 50) + 2) * type1 * randomNumber;
        return Math.ceil(damage);
    }
}