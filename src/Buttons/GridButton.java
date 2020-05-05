package Buttons;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import Engine.Camera;
import Engine.KeyboardShortcut;
import Engine.Loader;
import Graphics.Colors;
import Graphics.Quads;
import Graphics.TextureLoader;

public class GridButton extends Button
{
    public GridButton(final Texture texture, final float x, final float y, final float w, final float h, final float[] color, final float rotation, final boolean clicked, final boolean hover) {
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
            if (KeyboardShortcut.grid) {
                KeyboardShortcut.grid = false;
            }
            else {
                KeyboardShortcut.grid = true;
            }
        }
    }
    
    @Override
    protected void render() {
        TextureLoader.defaults.bind();
        Quads.QuadS(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y, this.w, this.h, this.color, 0.0f);
        if (this.isHover()) {
            Loader.text.drawString(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, "Grille : ", Color.black);
        }
        else {
            Loader.text.drawString(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, "Grille : ", Color.white);
        }
        if (KeyboardShortcut.grid) {
            Loader.text.drawString(-Camera.ScrollX + this.x + this.w - Loader.text.getWidth(String.valueOf(KeyboardShortcut.grid)), -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, String.valueOf(KeyboardShortcut.grid), Color.green);
        }
        else {
            Loader.text.drawString(-Camera.ScrollX + this.x + this.w - Loader.text.getWidth(String.valueOf(KeyboardShortcut.grid)), -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, String.valueOf(KeyboardShortcut.grid), Color.red);
        }
    }
}
