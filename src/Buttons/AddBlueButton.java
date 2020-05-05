package Buttons;

import org.newdawn.slick.opengl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import Tiles.*;
import Engine.*;
import org.newdawn.slick.*;
import Graphics.*;
import Graphics.TextureLoader;

public class AddBlueButton extends Button
{
    public static boolean imHover;
    
    public AddBlueButton(final Texture texture, final float x, final float y, final float w, final float h, final float[] color, final float rotation, final boolean clicked, final boolean hover) {
        super(texture, x, y, w, h, color, rotation, clicked, hover);
    }
    
    @Override
    protected void init() {
    }
    
    @Override
    protected void update() {
        if (KeyboardShortcut.light) {
            if (this.isHover()) {
                AddBlueButton.imHover = true;
                this.color = Colors.gray;
            }
            else {
                AddBlueButton.imHover = false;
                this.color = new float[] { 0.5f, 0.5f, 0.5f, 0.5f };
            }
            if (Update.activate) {
                this.x = (float)(Display.getWidth() / 6 + 300);
            }
            else {
                this.x = 300.0f;
            }
            if (this.isClicked()) {
                if (Keyboard.isKeyDown(42)) {
                    TilesManager.b += (float)0.05;
                }
                else {
                    TilesManager.b += (float)0.1;
                }
                if (TilesManager.b > 1.0f) {
                    TilesManager.b = 1.0f;
                }
            }
        }
    }
    
    @Override
    protected void render() {
        if (KeyboardShortcut.light) {
            Loader.text.drawString(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y - Loader.text.getHeight(), "Bleu : " + TilesManager.b, Color.white);
            TextureLoader.addSize.bind();
            Quads.QuadS(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y, this.w, this.h, this.color, 0.0f);
        }
    }
}
