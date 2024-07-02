import java.io.Serializable;

public class Move implements Serializable{
    private String name;
    private String description;
    private int power;
    private int pp;
    private int maxPP;

    public Move(String name, String description, int power, int pp) {
        this.name = name;
        this.description = description;
        this.power = power;
        this.pp = pp;
        this.maxPP = pp;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPower() {
        return power;
    }

    public int getPP() {
        return pp;
    }

    public int getMaxPP(){
        return maxPP;
    }    

    public void decrementPP() {
        if (pp > 0) {
            pp--;
        }
    }

    public boolean canUseMove() {
        return pp > 0;
    }
}
