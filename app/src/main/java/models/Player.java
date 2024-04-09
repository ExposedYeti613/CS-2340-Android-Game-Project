package models;

import java.util.List;

public class Player implements PlayerInterface{
    private String name;
    private int health;
    private String difficulty;
    private String sprite;
    private int score;
    private static Player player;
    private float speed = 7;
    private int damage = 7;

    private Player() {
        this.name = "";
        this.health = 75;
        this.difficulty = "Medium";
        this.sprite = "Elf";
    }

    public static synchronized Player getPlayerInstance() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    private int xDif;
    private int yDif;
    @Override
    public boolean isColliding(int[] playerLocation, int[] otherLocation) {
        xDif = playerLocation[0] - otherLocation[0];
        yDif = playerLocation[1] - otherLocation[1];
        return (xDif * xDif + yDif * yDif) < 15000;
    }

    // Getter methods
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getHealth() {
        return health;
    }
    @Override
    public String getDifficulty() {
        return difficulty;
    }
    @Override
    public String getSprite() {
        return sprite;
    }
    @Override
    public int getScore() {
        return score;
    }
    @Override
    public float getSpeed() {
        return speed;
    }
    @Override
    public int getDamage() { return damage; }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDamage(int damage) { this.damage = damage; }
}
