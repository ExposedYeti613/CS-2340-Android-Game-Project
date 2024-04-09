package models;

public class AttackPowerUp extends PlayerDecorator{
    public AttackPowerUp() {
        super();
    }
    @Override
    public int getDamage() {
        return player5.getDamage() * 2;
    }
}
