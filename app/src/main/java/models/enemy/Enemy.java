package models.enemy;

public abstract class Enemy {
    // returns enemy's health
    public abstract int getHealth();
    // returns enemy's movement speed
    public abstract void setHealth(int health);
    public abstract int getMoveSpeed();
    // returns the amount of damage the enemy deals to the player
    public abstract int getAttackSpeed();
    // returns enemy's attack speed
    public abstract int getDamage();
    // returns the name of the enemy's sprite
    public abstract String getSprite();
    // returns possible X positions
    public abstract int getXPosition();
    // returns possible Y positions
    public abstract int getYPosition();
    public abstract void setPosition(int x, int y);
}
