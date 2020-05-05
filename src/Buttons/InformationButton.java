package Buttons;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import Engine.Camera;
import Engine.KeyboardShortcut;
import Engine.Loader;
import Graphics.Colors;
import Graphics.Quads;
import Graphics.TextureLoader;

public class InformationButton extends Button
{
    public InformationButton(final Texture texture, final float x, final float y, final float w, final float h, final float[] color, final float rotation, final boolean clicked, final boolean hover) {
        super(texture, x, y, w, h, color, rotation, clicked, hover);
    }
    
    @Override
    protected void init() {
    }
    
    @Override
    protected void update() {
        if (this.isHover()) {
            this.color = Colors.gray;
        }
        else {
            this.color = Colors.dgray;
        }
        if (this.isClicked()) {
            if (KeyboardShortcut.info) {
                KeyboardShortcut.info = false;
            }
            else {
                KeyboardShortcut.info = true;
            }
        }
    }
    
    @Override
    protected void render() {
        TextureLoader.defaults.bind();
        Quads.QuadS(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y, this.w, this.h, this.color, 0.0f);
        if (this.isHover()) {
            Loader.text.drawString(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, "Info : ", Color.black);
        }
        else {
            Loader.text.drawString(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, "Info : ", Color.white);
        }
        if (KeyboardShortcut.info) {
            Loader.text.drawString(-Camera.ScrollX + this.x + this.w - Loader.text.getWidth(String.valueOf(KeyboardShortcut.info)), -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, String.valueOf(KeyboardShortcut.info), Color.green);
        }
        else {
            Loader.text.drawString(-Camera.ScrollX + this.x + this.w - Loader.text.getWidth(String.valueOf(KeyboardShortcut.info)), -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, String.valueOf(KeyboardShortcut.info), Color.red);
        }
    }
}
