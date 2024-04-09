package models;

public class HealPowerUp extends PlayerDecorator{
    public HealPowerUp() {
        super();
    }
    @Override
    public void setHealth(int health) {
        player5.setHealth(player5.getHealth() + health);
    }
}
