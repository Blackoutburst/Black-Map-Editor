package Tiles;

import org.newdawn.slick.opengl.*;
import org.lwjgl.util.vector.*;
import org.lwjgl.input.*;
import org.lwjgl.opengl.*;
import Engine.*;

public abstract class Tiles
{
    private static boolean click;
    private static int xMouse;
    private static int yMouse;
    protected Texture texture;
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected boolean solid;
    protected boolean rclicked;
    protected boolean lclicked;
    protected boolean removed;
    protected String textureName;
    protected int rotation;
    protected boolean hover;
    
    public Vector2f[] getVertices() {
        return new Vector2f[] { new Vector2f((float)this.x, (float)this.y), new Vector2f((float)this.x, (float)(this.y + this.h)), new Vector2f((float)(this.x + this.w), (float)(this.y + this.h)), new Vector2f((float)(this.x + this.w), (float)this.y) };
    }
    
    public Tiles(final Texture texture, final int x, final int y, final int w, final int h, final boolean solid, final boolean rclicked, final boolean lclicked, final boolean removed, final String textureName, final int rotation, final boolean hover) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.solid = solid;
        this.rclicked = rclicked;
        this.lclicked = lclicked;
        this.removed = removed;
        this.textureName = textureName;
        this.rotation = rotation;
        this.hover = hover;
    }
    
    public String getTextureName() {
        return this.textureName;
    }
    
    public void setTextureName(final String textureName) {
        this.textureName = textureName;
    }
    
    public static void getMousePositionAndButtons() {
        Tiles.xMouse = Mouse.getX() - Camera.ScrollX;
        Tiles.yMouse = Display.getHeight() - Mouse.getY() - Camera.ScrollY;
        if (!Update.drag) {
            if (Mouse.isButtonDown(0)) {
                Tiles.click = true;
            }
            else {
                Tiles.click = false;
            }
            if (Mouse.isButtonDown(1)) {
                Tiles.click = true;
            }
            else {
                Tiles.click = false;
            }
        }
    }
    
    protected abstract void update();
    
    protected abstract void render();
    
    public Texture getTexture() {
        return this.texture;
    }
    
    public void setTexture(final Texture texture) {
        this.texture = texture;
    }
    
    public int getX() {
        return this.x;
    }
    
    public void setX(final int x) {
        this.x = x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setY(final int y) {
        this.y = y;
    }
    
    public boolean isSolid() {
        return this.solid;
    }
    
    public void setSolid(final boolean solid) {
        this.solid = solid;
    }
    
    public boolean isRClicked() {
        if (Tiles.xMouse >= this.x && Tiles.xMouse <= this.x + this.w && Tiles.yMouse >= this.y && Tiles.yMouse <= this.y + this.h && Mouse.isButtonDown(1) && !Tiles.click) {
            return !this.rclicked;
        }
        return this.rclicked;
    }
    
    public boolean isLclicked() {
        if (Tiles.xMouse >= this.x && Tiles.xMouse <= this.x + this.w && Tiles.yMouse >= this.y && Tiles.yMouse <= this.y + this.h && Mouse.isButtonDown(0) && !Tiles.click) {
            return !this.lclicked;
        }
        return this.lclicked;
    }
    
    public void setLclicked(final boolean lclicked) {
        this.lclicked = lclicked;
    }
    
    public boolean isRemoved() {
        return this.removed;
    }
    
    public void setRemoved(final boolean removed) {
        this.removed = removed;
    }
    
    public int getW() {
        return this.w;
    }
    
    public void setW(final int w) {
        this.w = w;
    }
    
    public int getRotation() {
        return this.rotation;
    }
    
    public void setRotation(final int rotation) {
        this.rotation = rotation;
    }
    
    public boolean isHover() {
        if (Tiles.xMouse >= this.x && Tiles.xMouse <= this.x + this.w && Tiles.yMouse >= this.y && Tiles.yMouse <= this.y + this.h) {
            return !this.hover;
        }
        return this.hover;
    }
    
    public void setHover(final boolean hover) {
        this.hover = hover;
    }
    
    public int getH() {
        return this.h;
    }
    
    public void setH(final int h) {
        this.h = h;
    }
}
