package nl.duo.weekopdrachten.gameofthegoose;

public class Player {
    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
        position = 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        this.position = newPosition;
    }
}
