import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Bot implements Serializable{
    private String name;
    private int hp;
    private int spd;
    private int atk;
    private int def;
    private String type;
    private List<Move> moves;
    private int maxHP;
    private int level;


    Bot(String name, int hp, int spd, int atk, int def, String type, List<Move> moves){
        this.name = name;
        this.hp = hp;
        this.spd = spd;
        this.atk = atk;
        this.def = def;
        this.type = type;
        this.moves = moves;
        this.maxHP = hp;
    }
    public int getTotalPP(){
        int s = 0;
        for(Move i:moves){
            s+=i.getPP();
        }
        return s;
    }
    public String getName(){
        return name;
    }
    public int getHP(){
        return hp;
    }
    public int getSpd(){
        return spd;
    }
    public int getAtk(){
        return atk;
    }
    public int getDef(){
        return def;
    }
    public String getType() {
        return type;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public int getMaxHP(){
        return maxHP;
    }
    public int getLevel(){
        return level;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setHP(int hp){
        this.hp = hp;
    }
    public void setSpd(int spd){
        this.spd = spd;
    }
    public void setAtk(int atk){
        this.atk = atk;
    }
    public void setDef(int def){
        this.def = def;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public void setLevel(int level){
        this.level = level;
    }   
    /**
     * Uses a special move based on the given move index.
     *
     * @param  moveIndex  the index of the special move to use
     * @return            void
     */
    public void useSpecialMove(int moveIndex) {
        Random random = new Random();

        switch (moveIndex) {
            case 3:
                int boostAmount = random.nextInt(10) + 3; // Random boost amount between 3 and 13
                int boostStat = random.nextInt(6); // Randomly choose between atk and def
                if (boostStat <=2) {
                    // Boost attack
                    this.atk += boostAmount;
                    System.out.println(this.name+"'s attack has been boosted by " + boostAmount + "!");
                } else {
                    // Boost defense
                    this.def += boostAmount;
                    System.out.println(this.name+"'s defense has been boosted by " + boostAmount + "!");
                }
                break;
            case 4:
                int healAmount = random.nextInt(11) + 10; // Random heal amount between 10 and 20
                this.hp = Math.min(this.maxHP, this.hp + healAmount);
                System.out.println(this.name+" healed for " + healAmount + " HP!");
                break;
            default:
                System.out.println("Invalid move!");
                break;
        }
    }

    /**
     * Selects a move based on the current health of the player and the opponent.
     *
     * @param  playerBot   the Bot representing the player
     * @return             the index of the selected move, or -1 if no valid move is available
     */
    public int selectMove(Bot playerBot) {
        List<Move> moves = getMoves();
        int selectedMoveIndex = -1; // Default to no move selected
    
        // Check player's health
        int playerHP = playerBot.getHP();
        int playerMaxHP = playerBot.getMaxHP();
    
        // Check opponent's health
        int opponentHP = getHP();
        int opponentMaxHP = getMaxHP();
    
        // Check if all moves are out of PP
        boolean allMovesOutOfPP = true;
        for (Move move : moves) {
            if (move.getPP() > 0) {
                allMovesOutOfPP = false;
                break;
            }
        }
    
        // If all moves are out of PP, the opponent loses
        if (allMovesOutOfPP) {
            return selectedMoveIndex; // Struggle move index (or indicate loss)
        }
    
        // Determine move priorities
        int healingMoveIndex = 3; // Assuming the healing move is at index 3
        int boostingMoveIndex = 2; // Assuming the boosting move is at index 2
        int strongAttackIndex = 1; // Assuming a strong attack move is at index 1
        int weakAttackIndex = 0; // Assuming a weak attack move is at index 0
    
        // Heal if opponent's health is critically low and healing move is available
        if (opponentHP < opponentMaxHP / 4 && moves.get(healingMoveIndex).getPP() > 0) {
            selectedMoveIndex = healingMoveIndex;
        } else {
            // If the player's health is low, prioritize attacking moves aggressively
            if (playerHP < playerMaxHP / 2) {
                if (moves.get(strongAttackIndex).getPP() > 0 && playerHP < opponentHP) {
                    selectedMoveIndex = strongAttackIndex; // Strong attack if opponent's HP is higher
                } else if (moves.get(healingMoveIndex).getPP() > 0 && opponentHP < playerHP) {
                    selectedMoveIndex = healingMoveIndex; // Heal if opponent's HP is lower
                }
            } else {
                // If opponent's health is not critically low and player's health is not low
                // consider boosting stats or using an attack move
                if (moves.get(boostingMoveIndex).getPP() > 0) {
                    // Boost stats if opponent's health is below 40% or lower than player's HP
                    if ((opponentHP < opponentMaxHP * 0.4 && moves.get(boostingMoveIndex).getPP() > 0)
                            || (opponentHP < playerHP && moves.get(boostingMoveIndex).getPP() > 0)) {
                        selectedMoveIndex = boostingMoveIndex;
                    } else if (moves.get(weakAttackIndex).getPP() > 0) {
                        selectedMoveIndex = weakAttackIndex; // Use a weak attack if boosting is not needed
                    }
                } else {
                    // If stat boost move is not available, use a weak attack move or healing move
                    if (moves.get(weakAttackIndex).getPP() > 0) {
                        selectedMoveIndex = weakAttackIndex;
                    } else if (moves.get(healingMoveIndex).getPP() > 0) {
                        selectedMoveIndex = healingMoveIndex;
                    }
                }
            }
        }
    
        // If no valid move is selected yet, choose the first available move with PP
        if (selectedMoveIndex == -1) {
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).getPP() > 0) {
                    selectedMoveIndex = i;
                    break;
                }
            }
        }
    
        return selectedMoveIndex;
    }
    
}
