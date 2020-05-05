package Buttons;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import Engine.Camera;
import Engine.Update;
import Graphics.Colors;
import Graphics.Quads;
import Graphics.TextureLoader;

public class OptionButton extends Button
{
    int r;
    public static boolean imHover;
    
    public OptionButton(final Texture texture, final float x, final float y, final float w, final float h, final float[] color, final float rotation, final boolean clicked, final boolean hover) {
        super(texture, x, y, w, h, color, rotation, clicked, hover);
        this.r = 0;
    }
    
    @Override
    protected void init() {
    }
    
    @Override
    protected void update() {
        if (this.isHover()) {
            OptionButton.imHover = true;
            this.color = Colors.gray;
            ++this.r;
        }
        else {
            OptionButton.imHover = false;
            this.color = new float[] { 0.5f, 0.5f, 0.5f, 0.5f };
            this.r = 0;
        }
        if (Update.skyActivate) {
            this.x = (float)(Display.getWidth() - 50 - 90);
        }
        else {
            this.x = (float)(Display.getWidth() - 50);
        }
        this.isClicked();
    }
    
    @Override
    protected void render() {
        TextureLoader.option.bind();
        Quads.QuadS(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y, this.w, this.h, this.color, (float)this.r);
    }
}
