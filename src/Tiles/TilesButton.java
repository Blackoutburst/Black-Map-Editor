package Tiles;

import org.newdawn.slick.opengl.*;
import org.lwjgl.input.*;
import org.lwjgl.opengl.*;

public abstract class TilesButton
{
    private static float xMouse;
    private static float yMouse;
    private static boolean clic;
    protected Texture texture;
    protected float x;
    protected float y;
    protected float w;
    protected float h;
    protected float[] color;
    protected float rotation;
    protected boolean clicked;
    protected boolean hover;
    protected String textureName;
    
    public TilesButton(final Texture texture, final float x, final float y, final float w, final float h, final float[] color, final float rotation, final boolean clicked, final boolean hover, final String textureName) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
        this.rotation = rotation;
        this.clicked = clicked;
        this.hover = hover;
        this.textureName = textureName;
    }
    
    protected abstract void update();
    
    protected abstract void render();
    
    public static void getMouse() {
        TilesButton.xMouse = (float)Mouse.getX();
        TilesButton.yMouse = (float)(Display.getHeight() - Mouse.getY());
        if (Mouse.isButtonDown(0)) {
            TilesButton.clic = true;
        }
        else {
            TilesButton.clic = false;
        }
    }
    
    public Texture getTexture() {
        return this.texture;
    }
    
    public void setTexture(final Texture texture) {
        this.texture = texture;
    }
    
    public float getX() {
        return this.x;
    }
    
    public void setX(final float x) {
        this.x = x;
    }
    
    public float getY() {
        return this.y;
    }
    
    public void setY(final float y) {
        this.y = y;
    }
    
    public float getW() {
        return this.w;
    }
    
    public void setW(final float w) {
        this.w = w;
    }
    
    public float getH() {
        return this.h;
    }
    
    public void setH(final float h) {
        this.h = h;
    }
    
    public float[] getColor() {
        return this.color;
    }
    
    public void setColor(final float[] color) {
        this.color = color;
    }
    
    public float getRotation() {
        return this.rotation;
    }
    
    public void setRotation(final float rotation) {
        this.rotation = rotation;
    }
    
    public boolean isClicked() {
        if (TilesButton.xMouse >= this.x && TilesButton.xMouse <= this.x + this.w && TilesButton.yMouse >= this.y && TilesButton.yMouse <= this.y + this.h && Mouse.isButtonDown(0) && !TilesButton.clic) {
            return !this.clicked;
        }
        return this.clicked;
    }
    
    public void setClicked(final boolean clicked) {
        this.clicked = clicked;
    }
    
    public boolean isHover() {
        if (TilesButton.xMouse >= this.x && TilesButton.xMouse <= this.x + this.w && TilesButton.yMouse >= this.y && TilesButton.yMouse <= this.y + this.h) {
            return !this.hover;
        }
        return this.hover;
    }
    
    public void setHover(final boolean hover) {
        this.hover = hover;
    }
    
    public String getTextureName() {
        return this.textureName;
    }
    
    public void setTextureName(final String textureName) {
        this.textureName = textureName;
    }
}
