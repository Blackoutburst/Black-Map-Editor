package Buttons;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import Engine.Camera;
import Engine.KeyboardShortcut;
import Engine.Loader;
import Graphics.Colors;
import Graphics.Quads;
import Graphics.TextureLoader;

public class HitboxButton extends Button
{
    public HitboxButton(final Texture texture, final float x, final float y, final float w, final float h, final float[] color, final float rotation, final boolean clicked, final boolean hover) {
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
            if (KeyboardShortcut.hitbox) {
                KeyboardShortcut.hitbox = false;
            }
            else {
                KeyboardShortcut.hitbox = true;
            }
        }
    }
    
    @Override
    protected void render() {
        TextureLoader.defaults.bind();
        Quads.QuadS(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y, this.w, this.h, this.color, 0.0f);
        if (this.isHover()) {
            Loader.text.drawString(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, "Hitbox : ", Color.black);
        }
        else {
            Loader.text.drawString(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, "Hitbox : ", Color.white);
        }
        if (KeyboardShortcut.hitbox) {
            Loader.text.drawString(-Camera.ScrollX + this.x + this.w - Loader.text.getWidth(String.valueOf(KeyboardShortcut.hitbox)), -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, String.valueOf(KeyboardShortcut.hitbox), Color.green);
        }
        else {
            Loader.text.drawString(-Camera.ScrollX + this.x + this.w - Loader.text.getWidth(String.valueOf(KeyboardShortcut.hitbox)), -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, String.valueOf(KeyboardShortcut.hitbox), Color.red);
        }
    }
}
