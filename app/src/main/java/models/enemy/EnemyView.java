package models.enemy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.example.game.R;

import java.util.Random;

public class EnemyView extends View {
    private Enemy enemy;
    private Drawable enemyDrawable;

    public EnemyView(Context context, Enemy enemy) {
        super(context);
        this.enemy = enemy;
        if (enemy.getSprite().equalsIgnoreCase("demon")) {
            enemyDrawable = ContextCompat.getDrawable(context, R.drawable.demon);
        } else if (enemy.getSprite().equalsIgnoreCase("ogre")) {
            enemyDrawable = ContextCompat.getDrawable(context, R.drawable.ogre);
        } else if (enemy.getSprite().equalsIgnoreCase("pumpkin")) {
            enemyDrawable = ContextCompat.getDrawable(context, R.drawable.pumpkin);
        } else {
            enemyDrawable = ContextCompat.getDrawable(context, R.drawable.skeleton);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Get the dimensions of the canvas
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();

        Random rand = new Random();

        int left = rand.nextInt(canvasWidth - 100) + 50;  // X-coordinate of the left side of the Drawable
        int top = rand.nextInt(canvasHeight - 100) + 50;   // Y-coordinate of the top of the Drawable
        int right = left + enemyDrawable.getIntrinsicWidth(); // Calculate the right coordinate
        int bottom = top + enemyDrawable.getIntrinsicHeight(); // Calculate the bottom coordinate

        // Set the bounds for the Drawable
        enemyDrawable.setBounds(left, top, right, bottom);

        enemyDrawable.draw(canvas);
    }

    public int[] getPosition() {
        int[] position = new int[2];

        position[0] = enemyDrawable.getBounds().centerX();
        position[1] = enemyDrawable.getBounds().centerY();

        return position;
    }
}
