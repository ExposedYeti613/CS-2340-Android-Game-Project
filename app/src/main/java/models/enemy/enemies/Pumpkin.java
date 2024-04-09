package models.enemy.enemies;
import java.util.Random;
import models.enemy.Enemy;

public class Pumpkin extends Enemy {
    private int health;
    private int moveSpeed;
    private int attackSpeed;
    private int damage;
    private String sprite;
    private int xPosition;
    private int yPosition;
    Random rand = new Random();

    // values are on a scale of 0-10
    public Pumpkin() {
        this.health = 5;
        this.moveSpeed = 10;
        this.attackSpeed = 4;
        this.damage = 2;
        this.sprite = "pumpkin";
        this.xPosition = rand.nextInt(2120) + 50;
        this.yPosition = rand.nextInt(848) + 50;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int health) {this.health = health;}

    @Override
    public int getMoveSpeed() {
        return this.moveSpeed;
    }

    @Override
    public int getAttackSpeed() {
        return this.attackSpeed;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public String getSprite() {
        return this.sprite;
    }

    @Override
    public int getXPosition() {
        return this.xPosition;
    }

    @Override
    public int getYPosition() {
        return this.yPosition;
    }

    @Override
    public void setPosition(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }
}
