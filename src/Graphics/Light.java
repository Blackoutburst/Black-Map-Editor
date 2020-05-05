package Graphics;

import org.lwjgl.util.vector.*;
import org.lwjgl.input.*;
import org.lwjgl.opengl.*;
import Engine.*;

public class Light
{
    private static boolean click;
    private static int xMouse;
    private static int yMouse;
    public Vector2f location;
    public float red;
    public float green;
    public float blue;
    public float scale;
    public boolean removed;
    public boolean rclicked;
    
    public Light(final Vector2f location, final float red, final float green, final float blue, final float scale, final boolean removed, final boolean rclicked) {
        this.location = location;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.scale = scale;
        this.removed = removed;
        this.rclicked = rclicked;
    }
    
    public static void getMousePositionAndButtons() {
        Light.xMouse = Mouse.getX() - Camera.ScrollX;
        Light.yMouse = Display.getHeight() - Mouse.getY() - Camera.ScrollY;
        if (!Update.drag) {
            if (Mouse.isButtonDown(0)) {
                Light.click = true;
            }
            else {
                Light.click = false;
            }
            if (Mouse.isButtonDown(1)) {
                Light.click = true;
            }
            else {
                Light.click = false;
            }
        }
    }
    
    public Vector2f getLocation() {
        return this.location;
    }
    
    public boolean isRClicked() {
        if (Light.xMouse >= this.location.x - 20.0f && Light.xMouse <= this.location.x + 20.0f && Light.yMouse >= this.location.y - 20.0f && Light.yMouse <= this.location.y + 20.0f && Mouse.isButtonDown(1) && !Light.click) {
            return !this.rclicked;
        }
        return this.rclicked;
    }
}
