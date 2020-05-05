package Engine;

import org.lwjgl.input.*;
import org.lwjgl.opengl.*;

public class Camera
{
    public static int ScrollX;
    public static int ScrollY;
    public static int ScrollZ;
    private static float DX;
    private static float DY;
    
    public void init() {
    }
    
    public static void update() {
        if (Keyboard.isKeyDown(203)) {
            Camera.ScrollX += 10;
        }
        if (Keyboard.isKeyDown(205)) {
            Camera.ScrollX -= 10;
        }
        if (Keyboard.isKeyDown(200)) {
            Camera.ScrollY += 10;
        }
        if (Keyboard.isKeyDown(208)) {
            Camera.ScrollY -= 10;
        }
        if (Mouse.isButtonDown(2)) {
            Camera.DX = (float)Mouse.getDX();
            Camera.DY = (float)Mouse.getDY();
            Camera.ScrollX += (int)Camera.DX;
            Camera.ScrollY += (int)(-Camera.DY);
        }
        else {
            Camera.ScrollX += (int)Camera.DX;
            Camera.DX /= 1.1f;
            Camera.ScrollY += (int)(-Camera.DY);
            Camera.DY /= 1.1f;
            if (Camera.DX < 1.0f && Camera.DX > -1.0f) {
                Camera.DX = 0.0f;
            }
            if (Camera.DY < 1.0f && Camera.DY > -1.0f) {
                Camera.DY = 0.0f;
            }
        }
        GL11.glTranslatef((float)Camera.ScrollX, (float)Camera.ScrollY, 0.0f);
    }
}
