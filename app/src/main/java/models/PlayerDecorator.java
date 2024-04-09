package models;

public abstract class PlayerDecorator implements PlayerInterface{
    protected static Player player5;

    public PlayerDecorator() {
        this.player5 = Player.getPlayerInstance();
    }

    @Override
    public boolean isColliding(int[] playerLocation, int[] otherLocation) {
        return player5.isColliding(playerLocation, otherLocation);
    }

    // Getter methods
    @Override
    public String getName() {
        return player5.getName();
    }
    @Override
    public int getHealth() {
        return player5.getHealth();
    }
    @Override
    public String getDifficulty() {
        return player5.getDifficulty();
    }
    @Override
    public String getSprite() {
        return player5.getSprite();
    }
    @Override
    public int getScore() {
        return player5.getScore();
    }
    @Override
    public float getSpeed() {
        return player5.getSpeed();
    }
    @Override
    public int getDamage() {
        return player5.getDamage();
    }
    @Override
    public void setName(String name) {
        player5.setName(name);
    }
    @Override
    public void setHealth(int health) {
        player5.setHealth(health);
    }
    @Override
    public void setDifficulty(String difficulty) {
        player5.setDifficulty(difficulty);
    }
    @Override
    public void setSprite(String sprite) {
        player5.setSprite(sprite);
    }
    @Override
    public void setScore(int score) {
        player5.setScore(score);
    }
    @Override
    public void setDamage(int damage) {
        player5.setDamage(damage);
    }
}
