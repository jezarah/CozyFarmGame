package model;

// Represents the Player with a name, extends an abstract Sprite

public class Player extends Sprite {
    public static final int PLAYER_SPEED = 2;

    private String name;

    // Constructs a new player with a name
    public Player(String name) {
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }
}
