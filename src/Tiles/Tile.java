package Tiles;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import Engine.Camera;
import Engine.KeyboardShortcut;
import Graphics.Quads;
import Graphics.TextureLoader;

public class Tile extends Tiles
{
    public Tile(final Texture texture, final int x, final int y, final int w, final int h, final boolean solid, final boolean rclicked, final boolean lclicked, final boolean removed, final String textureName, final int rotation, final boolean hover) {
        super(texture, x, y, w, h, solid, rclicked, lclicked, removed, textureName, rotation, hover);
    }
    
    @Override
    protected void update() {
        if (this.isRClicked() && !KeyboardShortcut.light) {
            this.removed = true;
        }
    }
    
    @Override
    protected void render() {
        if (this.x + this.w > -Camera.ScrollX && this.x < -Camera.ScrollX + Display.getWidth() && this.y + this.h > -Camera.ScrollY && this.y < -Camera.ScrollY + Display.getHeight()) {
            try {
                this.texture.bind();
            }
            catch (Exception e) {
                TextureLoader.none.bind();
            }
            GL11.glTexParameteri(3553, 10241, 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
            Quads.quadSHighLight((float)this.x, (float)this.y, (float)this.w, (float)this.h, (float)this.rotation);
            if (this.solid) {
                if (KeyboardShortcut.hitbox) {
                    TextureLoader.defaults.bind();
                    GL11.glBegin(1);
                    GL11.glColor3f(1.0f, 0.0f, 0.0f);
                    GL11.glVertex2f((float)(this.x + 1), (float)(this.y + 1));
                    GL11.glVertex2f((float)(this.x + this.w - 1), (float)(this.y + 1));
                    GL11.glEnd();
                    GL11.glBegin(1);
                    GL11.glColor3f(1.0f, 0.0f, 0.0f);
                    GL11.glVertex2f((float)(this.x + this.w - 1), (float)(this.y + 1));
                    GL11.glVertex2f((float)(this.x + this.w - 1), (float)(this.y + this.h - 1));
                    GL11.glEnd();
                    GL11.glBegin(1);
                    GL11.glColor3f(1.0f, 0.0f, 0.0f);
                    GL11.glVertex2f((float)(this.x + this.w - 1), (float)(this.y + this.h - 1));
                    GL11.glVertex2f((float)(this.x + 1), (float)(this.y + this.h - 1));
                    GL11.glEnd();
                    GL11.glBegin(1);
                    GL11.glColor3f(1.0f, 0.0f, 0.0f);
                    GL11.glVertex2f((float)(this.x + 1), (float)(this.y + this.h - 1));
                    GL11.glVertex2f((float)(this.x + 1), (float)(this.y + 1));
                    GL11.glEnd();
                }
            }
            else if (KeyboardShortcut.hitbox) {
                TextureLoader.defaults.bind();
                GL11.glBegin(1);
                GL11.glColor3f(0.0f, 1.0f, 1.0f);
                GL11.glVertex2f((float)(this.x + 1), (float)(this.y + 1));
                GL11.glVertex2f((float)(this.x + this.w - 1), (float)(this.y + 1));
                GL11.glEnd();
                GL11.glBegin(1);
                GL11.glColor3f(0.0f, 1.0f, 1.0f);
                GL11.glVertex2f((float)(this.x + this.w - 1), (float)(this.y + 1));
                GL11.glVertex2f((float)(this.x + this.w - 1), (float)(this.y + this.h - 1));
                GL11.glEnd();
                GL11.glBegin(1);
                GL11.glColor3f(0.0f, 1.0f, 1.0f);
                GL11.glVertex2f((float)(this.x + this.w - 1), (float)(this.y + this.h - 1));
                GL11.glVertex2f((float)(this.x + 1), (float)(this.y + this.h - 1));
                GL11.glEnd();
                GL11.glBegin(1);
                GL11.glColor3f(0.0f, 1.0f, 1.0f);
                GL11.glVertex2f((float)(this.x + 1), (float)(this.y + this.h - 1));
                GL11.glVertex2f((float)(this.x + 1), (float)(this.y + 1));
                GL11.glEnd();
            }
        }
    }
}
