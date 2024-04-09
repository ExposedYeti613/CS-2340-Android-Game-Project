package com.example.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.enemy.Enemy;
import models.enemy.EnemyFactory;
import models.enemy.EnemyView;
import views.EndScreenActivity;

public class Sprint4Tests {
    @Test
    public void testDemonDefaultValues() {
        Enemy demon = EnemyFactory.getEnemy("demon");
        assertTrue(demon.getHealth() == 7);
        assertTrue(demon.getMoveSpeed() == 4);
        assertTrue(demon.getAttackSpeed() == 3);
        assertTrue(demon.getDamage() == 5);
        assertTrue(demon.getSprite() == "demon");
    }

    @Test
    public void testOgreDefaultValues() {
        Enemy demon = EnemyFactory.getEnemy("ogre");
        assertTrue(demon.getHealth() == 10);
        assertTrue(demon.getMoveSpeed() == 2);
        assertTrue(demon.getAttackSpeed() == 1);
        assertTrue(demon.getDamage() == 8);
        assertTrue(demon.getSprite() == "ogre");
    }

    @Test
    public void testPumpkinDefaultValues() {
        Enemy demon = EnemyFactory.getEnemy("pumpkin");
        assertTrue(demon.getHealth() == 5);
        assertTrue(demon.getMoveSpeed() == 10);
        assertTrue(demon.getAttackSpeed() == 4);
        assertTrue(demon.getDamage() == 2);
        assertTrue(demon.getSprite() == "pumpkin");
    }

    @Test
    public void testSkeletonDefaultValues() {
        Enemy demon = EnemyFactory.getEnemy("skeleton");
        assertTrue(demon.getHealth() == 7);
        assertTrue(demon.getMoveSpeed() == 7);
        assertTrue(demon.getAttackSpeed() == 5);
        assertTrue(demon.getDamage() == 1);
        assertTrue(demon.getSprite() == "skeleton");
    }

    @Test
    public void testEnemiesDoNotGoOffScreenX() {
        Enemy skeleton = EnemyFactory.getEnemy("skeleton");
        Enemy ogre = EnemyFactory.getEnemy("ogre");
        Enemy demon = EnemyFactory.getEnemy("demon");
        Enemy pumpkin = EnemyFactory.getEnemy("pumpkin");
        assertTrue(skeleton.getXPosition() < 2220);
        assertTrue(ogre.getXPosition() < 2220);
        assertTrue(demon.getXPosition() < 2220);
        assertTrue(pumpkin.getXPosition() < 2220);
        assertTrue(skeleton.getXPosition() > 0);
        assertTrue(ogre.getXPosition() > 0);
        assertTrue(demon.getXPosition() > 0);
        assertTrue(pumpkin.getXPosition() > 0);
    }

    @Test
    public void testEnemiesDoNotGoOffScreenY() {
        Enemy skeleton = EnemyFactory.getEnemy("skeleton");
        Enemy ogre = EnemyFactory.getEnemy("ogre");
        Enemy demon = EnemyFactory.getEnemy("demon");
        Enemy pumpkin = EnemyFactory.getEnemy("pumpkin");
        assertTrue(skeleton.getYPosition() < 948);
        assertTrue(ogre.getYPosition() < 948);
        assertTrue(demon.getYPosition() < 948);
        assertTrue(pumpkin.getYPosition() < 948);
        assertTrue(skeleton.getYPosition() > 0);
        assertTrue(ogre.getYPosition() > 0);
        assertTrue(demon.getYPosition() > 0);
        assertTrue(pumpkin.getYPosition() > 0);
    }

    @Test
    public void testDemonPosition() {
        Enemy demon = EnemyFactory.getEnemy("demon");
        assertTrue(demon.getXPosition() >= 0);
        assertTrue(demon.getYPosition() >= 0);
    }

    @Test
    public void testOgrePosition() {
        Enemy ogre = EnemyFactory.getEnemy("ogre");
        assertTrue(ogre.getXPosition() >= 0);
        assertTrue(ogre.getYPosition() >= 0);
    }

}
