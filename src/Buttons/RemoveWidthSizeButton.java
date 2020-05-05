package Buttons;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import Engine.Camera;
import Engine.KeyboardShortcut;
import Engine.Update;
import Graphics.Colors;
import Graphics.Quads;
import Graphics.TextureLoader;

public class RemoveWidthSizeButton extends Button
{
    public static boolean imHover;
    
    public RemoveWidthSizeButton(final Texture texture, final float x, final float y, final float w, final float h, final float[] color, final float rotation, final boolean clicked, final boolean hover) {
        super(texture, x, y, w, h, color, rotation, clicked, hover);
    }
    
    @Override
    protected void init() {
    }
    
    @Override
    protected void update() {
        if (!KeyboardShortcut.light) {
            if (this.isHover()) {
                RemoveWidthSizeButton.imHover = true;
                this.color = Colors.gray;
            }
            else {
                RemoveWidthSizeButton.imHover = false;
                this.color = new float[] { 0.5f, 0.5f, 0.5f, 0.5f };
            }
            if (Update.activate) {
                this.x = (float)(Display.getWidth() / 6 + 50);
            }
            else {
                this.x = 50.0f;
            }
            if (this.isClicked()) {
                if (Keyboard.isKeyDown(42) && Update.tileWidth > 5) {
                    Update.tileWidth -= 5;
                }
                else if (Update.tileWidth > 10) {
                    Update.tileWidth -= 10;
                }
            }
        }
    }
    
    @Override
    protected void render() {
        if (!KeyboardShortcut.light) {
            TextureLoader.removeSize.bind();
            Quads.QuadS(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y, this.w, this.h, this.color, 0.0f);
        }
    }
}
