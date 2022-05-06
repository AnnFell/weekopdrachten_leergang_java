package nl.duo.weekopdrachten.kermis;

public class Attraction {
    private final double price;
    private final String name;
    private final int roundsBeforeInspection;
    private int rounds;

    private double revenue;

    public Attraction(String name, double price, int roundsBeforeInspection) {
        this.name = name;
        this.price = price;
        this.roundsBeforeInspection = roundsBeforeInspection;
    }

    public void perform() {
        addRound();
        System.out.println(name + " is performing!");
        revenue += price;
    }

    private void addRound() {
        if (rounds < roundsBeforeInspection) {
            rounds++;
        } else {
            inspect();
        }
    }

    private void inspect() {
        System.out.printf("Please stand by, %s is being inspected and will resume shortly%n", name);
        rounds = 0;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    public double getRevenue(){
        return revenue;
    }
}
