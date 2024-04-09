package models;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class Wall {
    private int x;
    private int y;
    private int width;
    private int height;
    private View view;

    public Wall(Context context, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        // Create a new View to represent this wall
        view = new View(context);
        // Set the color of the wall
        view.setBackgroundColor(android.graphics.Color.BLACK);
        RelativeLayout.LayoutParams params = new RelativeLayout.
                LayoutParams(width, height);
        params.leftMargin = x;
        params.topMargin = y;
        view.setLayoutParams(params);
    }

    public static Wall createWall(Context context, int x, int y, int width,
                                  int height, ViewGroup layout) {
        Wall wall = new Wall(context, x, y, width, height);
        View wallView = wall.getView();
        layout.addView(wallView);
        RelativeLayout.LayoutParams params = new RelativeLayout.
                LayoutParams(width, height);
        params.leftMargin = x;
        params.topMargin = y;
        wallView.setLayoutParams(params);
        return wall;
    }

    public View getView() {
        return view;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
