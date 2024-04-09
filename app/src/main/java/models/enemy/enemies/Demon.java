package models.enemy.enemies;
import models.enemy.Enemy;
import java.util.Random;

public class Demon extends Enemy {
    private int health;
    private int moveSpeed;
    private int attackSpeed;
    private int damage;
    private String sprite;
    private int xPosition;
    private int yPosition;
    Random rand = new Random();

    // values are on a scale of 0-10
    public Demon() {
        this.health = 7;
        this.moveSpeed = 4;
        this.attackSpeed = 3;
        this.damage = 5;
        this.sprite = "demon";
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
