package Engine;

import java.util.*;
import org.lwjgl.opengl.*;

public class Grid
{
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    public static List<Grid> linesH;
    public static List<Grid> linesV;
    
    static {
        Grid.linesH = new ArrayList<Grid>();
        Grid.linesV = new ArrayList<Grid>();
    }
    
    public Grid(final int x, final int y, final int w, final int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    public static void render() {
        if (KeyboardShortcut.grid) {
            int y = 0;
            for (int i = -Camera.ScrollY / Update.tileHeight * Update.tileHeight; i < -Camera.ScrollY + Display.getHeight(); i += Update.tileHeight) {
                y = 0;
                if (i < -Camera.ScrollY) {
                    y += Update.tileHeight * (Display.getHeight() / Update.tileHeight);
                }
                GL11.glBindTexture(3553, 0);
                GL11.glBegin(1);
                GL11.glColor3f(0.25f, 0.25f, 0.25f);
                GL11.glVertex2f((float)(-Camera.ScrollX), (float)(i + y));
                GL11.glVertex2f((float)(-Camera.ScrollX + Display.getWidth()), (float)(i + y));
                GL11.glEnd();
            }
            int x = 0;
            for (int j = -Camera.ScrollX / Update.tileWidth * Update.tileWidth; j < -Camera.ScrollX + Display.getWidth(); j += Update.tileWidth) {
                x = 0;
                if (j < -Camera.ScrollX) {
                    x += Update.tileWidth * (Display.getWidth() / Update.tileWidth);
                }
                GL11.glBindTexture(3553, 0);
                GL11.glBegin(1);
                GL11.glColor3f(0.25f, 0.25f, 0.25f);
                GL11.glVertex2f((float)(j + x), (float)(-Camera.ScrollY));
                GL11.glVertex2f((float)(j + x), (float)(-Camera.ScrollY + Display.getHeight()));
                GL11.glEnd();
            }
        }
    }
}
