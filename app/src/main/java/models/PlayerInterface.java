package models;

public interface PlayerInterface {
    String getName();
    int getHealth();
    String getDifficulty();
    String getSprite();
    int getScore();
    float getSpeed();
    int getDamage();
    boolean isColliding(int[] playerLocation, int[] otherLocation);
    void setName(String name);
    void setHealth(int health);
    void setDifficulty(String difficulty);
    void setSprite(String sprite);
    void setScore(int score);
    void setDamage(int damage);
}
