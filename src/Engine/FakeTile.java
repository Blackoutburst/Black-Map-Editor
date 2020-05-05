package Engine;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import Buttons.AddHeightSizeButton;
import Buttons.AddWidthSizeButton;
import Buttons.LeftRotationButton;
import Buttons.OptionButton;
import Buttons.RemoveHeightSizeButton;
import Buttons.RemoveWidthSizeButton;
import Buttons.RightRotationButton;
import Graphics.Colors;
import Graphics.Quads;
import Graphics.TextureLoader;

public class FakeTile
{
    public static int x;
    public static int y;
    private static boolean pressed;
    public static Texture texture;
    
    static {
        FakeTile.texture = TextureLoader.none;
    }
    
    public static void update() {
        if (Keyboard.isKeyDown(42)) {
            FakeTile.pressed = true;
            if (Mouse.getX() - Camera.ScrollX > FakeTile.x + Update.tileWidth / 2) {
                FakeTile.x += 10;
            }
            if (Mouse.getX() - Camera.ScrollX < FakeTile.x + Update.tileWidth / 2) {
                FakeTile.x -= 10;
            }
            if (Display.getHeight() - Mouse.getY() - Camera.ScrollY > FakeTile.y + Update.tileHeight / 2) {
                FakeTile.y += 10;
            }
            if (Display.getHeight() - Mouse.getY() - Camera.ScrollY < FakeTile.y + Update.tileHeight / 2) {
                FakeTile.y -= 10;
            }
        }
        else {
            if (Mouse.getX() - Camera.ScrollX > FakeTile.x + Update.tileWidth) {
                FakeTile.x += Update.tileWidth;
            }
            if (Mouse.getX() - Camera.ScrollX < FakeTile.x) {
                FakeTile.x -= Update.tileWidth;
            }
            if (Display.getHeight() - Mouse.getY() - Camera.ScrollY > FakeTile.y + Update.tileHeight) {
                FakeTile.y += Update.tileHeight;
            }
            if (Display.getHeight() - Mouse.getY() - Camera.ScrollY < FakeTile.y) {
                FakeTile.y -= Update.tileHeight;
            }
        }
        if (!Keyboard.isKeyDown(42) && FakeTile.pressed) {
            FakeTile.x = 0;
            FakeTile.y = 0;
            FakeTile.pressed = false;
        }
        if (Display.getHeight() - Mouse.getY() < Display.getHeight() - Display.getHeight() / 50 && Display.getHeight() - Mouse.getY() > Display.getHeight() / 50 && !OptionButton.imHover && !AddWidthSizeButton.imHover && !RemoveWidthSizeButton.imHover && !AddHeightSizeButton.imHover && !RemoveHeightSizeButton.imHover && !LeftRotationButton.imHover && !RightRotationButton.imHover && !KeyboardShortcut.light && ((Update.activate && Mouse.getX() >= Display.getWidth() / 6) || !Update.activate)) {
            if (!Update.skyActivate || Mouse.getX() > Display.getWidth() - 90) {
                if (Update.skyActivate) {
                    return;
                }
            }
            try {
                FakeTile.texture.bind();
            }
            catch (Exception e) {
                TextureLoader.none.bind();
            }
            GL11.glTexParameteri(3553, 10241, 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
            Quads.QuadS((float)FakeTile.x, (float)FakeTile.y, (float)Update.tileWidth, (float)Update.tileHeight, Colors.white50, (float)Update.tileRotation);
        }
    }
}
