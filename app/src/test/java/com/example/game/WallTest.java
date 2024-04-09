package models;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WallTest {

    @Test
    public void testCreateWallWithValidInputs() {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        ViewGroup layout = new RelativeLayout(context);
        int x = 10, y = 20, width = 100, height = 200;
        Wall wall = Wall.createWall(context, x, y, width, height, layout);
        assertEquals(x, wall.getX());
        assertEquals(y, wall.getY());
        assertEquals(width, wall.getWidth());
        assertEquals(height, wall.getHeight());
        assertNotNull(wall.getView());
        assertEquals(1, layout.getChildCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateWallWithNegativeDimensions() {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        ViewGroup layout = new RelativeLayout(context);

        Wall.createWall(context, 10, 20, -100, -200, layout);
    }

    @Test
    public void testCreateWallWithZeroDimensions() {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        ViewGroup layout = new RelativeLayout(context);

        Wall wall = Wall.createWall(context, 10, 20, 0, 0, layout);

        assertEquals(0, wall.getWidth());
        assertEquals(0, wall.getHeight());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateWallWithNullContextOrLayout() {
        Wall.createWall(null, 10, 20, 100, 200, null);
    }
}