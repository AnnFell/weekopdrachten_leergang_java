package nl.duo.weekopdrachten.carcase.domain;

public class PetrolTank {
    private final int maxLevel;
    private final int minLevel;
    private int currentLevel;

    public PetrolTank(int maxLevel, int minLevel) {
        this.maxLevel = maxLevel;
        this.minLevel = minLevel;
    }

    public void decrease(int amount) {
        currentLevel -= amount;
    }

    public void increase(int amount) {
        currentLevel += amount;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void fill() throws TankOverfillException {
        if (this.getCurrentLevel() < this.getMaxLevel()) {
            this.increase(1);
        } else {
            throw new TankOverfillException();
        }
    }

}
