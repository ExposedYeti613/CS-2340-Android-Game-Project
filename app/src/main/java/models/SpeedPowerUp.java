package models;

public class SpeedPowerUp extends PlayerDecorator{
    public SpeedPowerUp() {
        super();
    }

    @Override
    public float getSpeed() {
        return player5.getSpeed() + 2;
    }
}
