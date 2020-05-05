package Buttons;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import Engine.Camera;
import Engine.Loader;
import Graphics.Colors;
import Graphics.Quads;
import Graphics.TextureLoader;

public class ExitButton extends Button
{
    public ExitButton(final Texture texture, final float x, final float y, final float w, final float h, final float[] color, final float rotation, final boolean clicked, final boolean hover) {
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
            Display.destroy();
            System.exit(0);
        }
    }
    
    @Override
    protected void render() {
        TextureLoader.defaults.bind();
        Quads.QuadS(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y, this.w, this.h, this.color, 0.0f);
        if (this.isHover()) {
            Loader.text.drawString(-Camera.ScrollX + this.x + this.w / 2.0f - Loader.text.getWidth("Quitter") / 2, -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, "Quitter", Color.black);
        }
        else {
            Loader.text.drawString(-Camera.ScrollX + this.x + this.w / 2.0f - Loader.text.getWidth("Quitter") / 2, -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, "Quitter", Color.white);
        }
    }
}
