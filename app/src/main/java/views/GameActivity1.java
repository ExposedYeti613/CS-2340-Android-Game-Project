package views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.game.R;

import models.AttackPowerUp;
import models.HealPowerUp;
import models.Player;
import models.PlayerInterface;
import models.SpeedPowerUp;
import models.Wall;
import models.enemy.Enemy;
import models.enemy.EnemyFactory;
import models.enemy.EnemyView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameActivity1 extends AppCompatActivity {
    private TextView nameText;
    private TextView difficultyText;
    private TextView healthText;
    private ImageView playerSprite;
    private PlayerInterface player;
    private TextView scoreText;
    private Handler handler = new Handler();
    private Runnable runnable;
    private ImageView exitSprite;
    private List<Wall> walls;
    private int[] playerLocation = new int[2];
    ConstraintLayout gameLayout;
    private int enemySteps;
    private int playerAnimation;
    private Map<Enemy, EnemyView> enemyMap = new HashMap<>();
    private ImageView speedBuff;
    private ImageView attackBuff;
    private ImageView heal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen1);

        gameLayout = findViewById(R.id.gameLayout);

        player = Player.getPlayerInstance();
        player.setScore(1000);

        scoreText = findViewById(R.id.scoreText);
        scoreText.setText("Score: " + player.getScore());

        exitSprite = findViewById(R.id.exit1);

        speedBuff = findViewById(R.id.speedBuff);

        attackBuff = findViewById(R.id.attackBuff);

        heal = findViewById(R.id.heal);

        int[] healLocation = new int[2];

        int[] attackLocation = new int[2];

        int[] speedLocation = new int[2];

        int[] doorLocation = new int[2];

        playerSprite = findViewById(R.id.playerSprite);
        playerSprite.setX(20);  // Set initial X position
        playerSprite.setY(20);  // Set initial Y position

        // Initialize walls
        walls = createWalls();

        // Create enemies
        // Demon
        Enemy demon = EnemyFactory.getEnemy("demon");
        EnemyView demonView = new EnemyView(this, demon);
        gameLayout.addView(demonView);
        enemyMap.put(demon, demonView);
        // Ogre
        Enemy ogre = EnemyFactory.getEnemy("ogre");
        EnemyView ogreView = new EnemyView(this, ogre);
        gameLayout.addView(ogreView);
        enemyMap.put(ogre, ogreView);
        // Pumpkin
        Enemy pumpkin = EnemyFactory.getEnemy("pumpkin");
        EnemyView pumpkinView = new EnemyView(this, pumpkin);
        gameLayout.addView(pumpkinView);
        enemyMap.put(pumpkin, pumpkinView);
        // Skeleton
        Enemy skeleton = EnemyFactory.getEnemy("skeleton");
        EnemyView skeletonView = new EnemyView(this, skeleton);
        gameLayout.addView(skeletonView);
        enemyMap.put(skeleton, skeletonView);
        enemySteps = 0;
        playerAnimation = 0;

        // Runs every frame
        handler.postDelayed(runnable = () -> {
            handler.postDelayed(runnable, 750);
            if (player.getScore() > 0) {
                player.setScore(player.getScore() - 1);
                scoreText.setText("Score: " + player.getScore());
            }
            // Checking for player's health
            if (player.getHealth() <= 0) {
                launchEndScreenActivity(false); // Player lost
                return;
            }

            //animate the player
            if (playerAnimation == 4) {
                playerAnimation = 0;
            }
            if (player.getSprite().equals("Elf")) {
                switch (playerAnimation) {
                case 0:
                    playerSprite.setImageResource(R.drawable.elf_m_idle_anim_f0);
                    break;
                case 1:
                    playerSprite.setImageResource(R.drawable.elf_m_idle_anim_f1);
                    break;
                case 2:
                    playerSprite.setImageResource(R.drawable.elf_m_idle_anim_f2);
                    break;
                case 3:
                    playerSprite.setImageResource(R.drawable.elf_m_idle_anim_f3);
                    break;
                }
            } else if (player.getSprite().equals("Paladin")) {
                switch (playerAnimation) {
                case 0:
                    playerSprite.setImageResource(R.drawable.knight_m_idle_anim_f0);
                    break;
                case 1:
                    playerSprite.setImageResource(R.drawable.knight_m_idle_anim_f1);
                    break;
                case 2:
                    playerSprite.setImageResource(R.drawable.knight_m_idle_anim_f2);
                    break;
                case 3:
                    playerSprite.setImageResource(R.drawable.knight_m_idle_anim_f3);
                    break;
                }
            } else if (player.getSprite().equals("Wizard")) {
                switch (playerAnimation) {
                case 0:
                    playerSprite.setImageResource(R.drawable.wizzard_m_idle_anim_f0);
                    break;
                case 1:
                    playerSprite.setImageResource(R.drawable.wizzard_m_idle_anim_f1);
                    break;
                case 2:
                    playerSprite.setImageResource(R.drawable.wizzard_m_idle_anim_f2);
                    break;
                case 3:
                    playerSprite.setImageResource(R.drawable.wizzard_m_idle_anim_f3);
                    break;
                }
            }
            playerAnimation++;

            // Get current player location
            playerSprite.getLocationOnScreen(playerLocation);
            // Check for wall collisions and adjust player position if necessary
            if (isCollidingWithWall(playerLocation, walls)) {
                // Assume each wall is an axis-aligned rectangle
                for (Wall wall : walls) {
                    // ... collision resolution logic ...
                }
            }
            // Move enemies in an alternating pattern
            if (enemySteps >= 1) {
                skeletonView.setX(skeletonView.getX() - 20);
                pumpkinView.setY(pumpkinView.getY() - 20);
                demonView.setX(demonView.getX() - 20);
                demonView.setY(demonView.getY() - 20);
                ogreView.setX(demonView.getX() - 20);
                ogreView.setY(demonView.getY() + 20);
                enemySteps--;
            } else {
                skeletonView.setX(skeletonView.getX() + 20);
                pumpkinView.setY(pumpkinView.getY() + 20);
                demonView.setX(demonView.getX() + 20);
                demonView.setY(demonView.getY() + 20);
                ogreView.setX(demonView.getX() + 20);
                ogreView.setY(demonView.getY() - 20);
                enemySteps++;
            }
            exitSprite.getLocationOnScreen(doorLocation);
            // Check collision
            if (player.isColliding(playerLocation, doorLocation)) {
                launchGameActivity2();
            }
            for (Enemy enemy : enemyMap.keySet()) {
                if (player.isColliding(playerLocation, enemyMap.get(enemy).getPosition())) {
                    //enemy attacking player
                    if (player.getDifficulty() == "Easy") {
                        player.setHealth(player.getHealth() - 1);
                    } else if (player.getDifficulty() == "Medium") {
                        player.setHealth(player.getHealth() - 2);
                    } else {
                        player.setHealth(player.getHealth() - 5);
                    }
                    System.out.println("Player collided with: " + enemy.getSprite());
                    // Decrease score by 15 points when player touches an enemy
                    player.setScore(player.getScore() - 20);
                    scoreText.setText("Score: " + player.getScore());
                    healthText = findViewById(R.id.health);
                    healthText.setText("Health: " + player.getHealth());
                }
                if (enemy.getHealth() <= 0) {
                    enemyMap.get(enemy).setVisibility(View.GONE);

                }
            }

            speedBuff.getLocationOnScreen(speedLocation);

            attackBuff.getLocationOnScreen(attackLocation);

            heal.getLocationOnScreen(healLocation);

            // Power up and score increase
            if (player.isColliding(playerLocation, speedLocation)) {
                speedBuff.setVisibility(View.GONE);
                player = new SpeedPowerUp();
                player.setScore(player.getScore() + 200);
                scoreText.setText("Score: " + player.getScore());
            }

            // Power up and score increase
            if (player.isColliding(playerLocation, attackLocation)) {
                attackBuff.setVisibility(View.GONE);
                player = new AttackPowerUp();
                player.setScore(player.getScore() + 200);
                scoreText.setText("Score: " + player.getScore());
            }

            // Power up and score increase
            if (player.isColliding(playerLocation, healLocation)) {
                heal.setVisibility(View.GONE);
                player = new HealPowerUp();
                player.setHealth(1);
                player.setScore(player.getScore() + 200);
                scoreText.setText("Score: " + player.getScore());
            }

        }, 750);
        // Code for Name being displayed
        nameText = findViewById(R.id.name);
        nameText.setText("Name: " + player.getName());

        // Code for Difficulty being displayed
        difficultyText = findViewById(R.id.difficulty);
        difficultyText.setText("Difficulty: " + player.getDifficulty());

        // Code for Health being displayed
        healthText = findViewById(R.id.health);
        healthText.setText("Health: " + player.getHealth());

        // Code for Sprite being displayed
        String sprite = player.getSprite();
        playerSprite = findViewById(R.id.playerSprite);

        if (sprite.equals("Elf")) {
            playerSprite.setImageResource(R.drawable.npc_elf);
        } else if (sprite.equals("Wizard")) {
            playerSprite.setImageResource(R.drawable.npc_wizzard);
        } else if (sprite.equals("Paladin")) {
            playerSprite.setImageResource(R.drawable.npc_paladin);
        }
    }

    // Private method to launch the endGame Screen if player health reaches or goes below 0
    private void launchEndScreenActivity(boolean playerWon) {
        Intent nextScreen3 = new Intent(GameActivity1.this, EndScreenActivity.class);
        nextScreen3.putExtra("playerWon", playerWon); // Passing win/lose status
        startActivity(nextScreen3);
        handler.removeCallbacks(runnable); // Stop the game loop
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        // Left Wall
        walls.add(new Wall(this, 5, 0, 10, 930));
        // Right wall
        walls.add(new Wall(this, 2200, 0, 10, 930));
        // Top wall
        walls.add(new Wall(this, 5, 0, 2200, 10));
        // Bottom wall
        walls.add(new Wall(this, 5, 930, 2200, 10));
        ViewGroup layout = findViewById(R.id.gameLayout);
        for (Wall wall : walls) {
            View wallView = wall.getView();
            layout.addView(wallView);
            wallView.setX(wall.getX());
            wallView.setY(wall.getY());
        }
        return walls;
    }

    public boolean isCollidingWithWall(int[] playerLocation, List<Wall> walls) {
        int playerWidth = playerSprite.getWidth();
        for (Wall wall : walls) {
            if ((playerLocation[0] + playerWidth > wall.getX()
                    && playerLocation[0] < wall.getX() + wall.getWidth())
                    && ((playerLocation[1] > wall.getY()
                    && playerLocation[1] < wall.getY() + wall.getHeight())
                    || (playerLocation[1] + 100 > wall.getY()
                    && playerLocation[1] + 100 < wall.getY()
                    + wall.getHeight()))) {
                return true;  // Collision detected
            }
        }
        return false;  // No collision
    }

    // Player Movement
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        move(keyCode);
        return true;
    }

    public void move(int keyCode) {
        float newX = playerSprite.getX();
        float newY = playerSprite.getY();
        int playerWidth = playerSprite.getWidth();
        int playerHeight = playerSprite.getHeight();
        if (keyCode == KeyEvent.KEYCODE_W) {
            newY -= player.getSpeed();
        } else if (keyCode == KeyEvent.KEYCODE_A) {
            newX -= player.getSpeed();
        } else if (keyCode == KeyEvent.KEYCODE_S) {
            newY += player.getSpeed();
        } else if (keyCode == KeyEvent.KEYCODE_D) {
            newX += player.getSpeed();
        } else if (keyCode == KeyEvent.KEYCODE_SPACE) {
            attack();
        }
        // Check if the new position would cause a collision
        int[] newPlayerLocation = {(int) newX, (int) newY};
        if (!isCollidingWithWall(newPlayerLocation, walls)) {
            // If not colliding, update the player's position
            playerSprite.setX(newX);
            playerSprite.setY(newY);
        }
    }

    private void launchGameActivity2() {
        Intent nextScreen1 = new Intent(GameActivity1.this,
                GameActivity2.class);
        handler.removeCallbacks(runnable);
        startActivity(nextScreen1);
    }

    private void attack() {
        for (Enemy enemy : enemyMap.keySet()) {
            if (player.isColliding(playerLocation, enemyMap.get(enemy).getPosition())) {
                enemy.setHealth(enemy.getHealth() - player.getDamage());
                System.out.println("Enemy attacked");
                if (enemy.getHealth() <= 0) {
                    enemy.setPosition(0, 0);
                }
            }
        }
    }
}
