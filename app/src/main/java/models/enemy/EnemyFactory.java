package models.enemy;

import models.enemy.enemies.Demon;
import models.enemy.enemies.Ogre;
import models.enemy.enemies.Pumpkin;
import models.enemy.enemies.Skeleton;

public class EnemyFactory {
    public static Enemy getEnemy(String type) {
        if ("demon".equalsIgnoreCase(type)) {
            return new Demon();
        } else if ("ogre".equalsIgnoreCase(type)) {
            return new Ogre();
        } else if ("pumpkin".equalsIgnoreCase(type)) {
            return new Pumpkin();
        } else if ("skeleton".equalsIgnoreCase(type)) {
            return new Skeleton();
        } else {
            // if the name does not match any of the enemies
            return null;
        }
    }
}
