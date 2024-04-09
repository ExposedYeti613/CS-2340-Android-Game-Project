package com.example.game;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import models.AttackPowerUp;
import models.Player;
import models.SpeedPowerUp;
import models.PlayerDecorator;
import models.enemy.Enemy;
import models.enemy.EnemyFactory;
import models.enemy.EnemyView;
import views.EndScreenActivity;
public class Sprint5Tests {
    @Test
    public void speedPowerUpTest() {
        Player player2 = Player.getPlayerInstance();
        SpeedPowerUp speed = new SpeedPowerUp();
        float speed1 = speed.getSpeed();
        float playerSpeed = player2.getSpeed() + 2;
        assertEquals(playerSpeed, speed1, 0);
    }

    @Test
    public void attackPowerUpTest() {
        Player player2 = Player.getPlayerInstance();
        AttackPowerUp attack = new AttackPowerUp();
        int attack1 = attack.getDamage();
        int playerDamage = player2.getDamage() * 2;
        assertEquals(playerDamage, attack1);
    }
     @Test
    public void testHealthZero() {
        Enemy demon = EnemyFactory.getEnemy("demon");
        demon.setHealth(0);

        assertTrue(demon.getHealth() == 0);
    }

    @Test
    public void testEnemyPosition() {
        Enemy demon = EnemyFactory.getEnemy("demon");
        demon.setPosition(0,0);
        assertTrue(demon.getXPosition() >= 0);
        assertTrue(demon.getYPosition() >= 0);

    @Before
    public void setUp() {
        player = Player.getPlayerInstance();
        player.setScore(1000); // Set a known initial score for testing
    }

    @Test
    public void testIncreaseScore() {
        int initialScore = player.getScore();
        int scoreIncrease = 100; // Assuming the score increases by 100 points

        player.setScore(initialScore + scoreIncrease);

        assertEquals("Score should increase by 100 points",
                initialScore + scoreIncrease, player.getScore());
    }

    @Test
    public void testDecreaseScore() {
        int initialScore = player.getScore();
        int scoreDecrease = 50; // Assuming the score decreases by 50 points

        player.setScore(initialScore - scoreDecrease);

        assertEquals("Score should decrease by 50 points",

    }
}
