package Tiles;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import Engine.Camera;
import Engine.Update;
import Graphics.Quads;
import Graphics.TextureLoader;

public class SkyBoxBut extends TilesButton
{
    public SkyBoxBut(final Texture texture, final float x, final float y, final float w, final float h, final float[] color, final float rotation, final boolean clicked, final boolean hover, final String textureName) {
        super(texture, x, y, w, h, color, rotation, clicked, hover, textureName);
    }
    
    @Override
    protected void update() {
        if (this.isClicked()) {
            Update.skybox = this.texture;
        }
    }
    
    @Override
    protected void render() {
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        this.texture.bind();
        Quads.QuadS(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y, this.w, this.h, this.color, this.rotation);
        if (this.isHover()) {
            TextureLoader.defaults.bind();
            GL11.glBegin(1);
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + 1.0f, -Camera.ScrollY + this.y + 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + this.w - 1.0f, -Camera.ScrollY + this.y + 1.0f);
            GL11.glEnd();
            GL11.glBegin(1);
            GL11.glVertex2f(-Camera.ScrollX + this.x + this.w - 1.0f, -Camera.ScrollY + this.y + 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + this.w - 1.0f, -Camera.ScrollY + this.y + this.h - 1.0f);
            GL11.glEnd();
            GL11.glBegin(1);
            GL11.glVertex2f(-Camera.ScrollX + this.x + this.w - 1.0f, -Camera.ScrollY + this.y + this.h - 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + 1.0f, -Camera.ScrollY + this.y + this.h - 1.0f);
            GL11.glEnd();
            GL11.glBegin(1);
            GL11.glVertex2f(-Camera.ScrollX + this.x + 1.0f, -Camera.ScrollY + this.y + this.h - 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + 1.0f, -Camera.ScrollY + this.y + 1.0f);
            GL11.glEnd();
        }
        else {
            TextureLoader.defaults.bind();
            GL11.glBegin(1);
            GL11.glColor3f(0.5f, 0.5f, 0.5f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + 1.0f, -Camera.ScrollY + this.y + 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + this.w - 1.0f, -Camera.ScrollY + this.y + 1.0f);
            GL11.glEnd();
            GL11.glBegin(1);
            GL11.glVertex2f(-Camera.ScrollX + this.x + this.w - 1.0f, -Camera.ScrollY + this.y + 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + this.w - 1.0f, -Camera.ScrollY + this.y + this.h - 1.0f);
            GL11.glEnd();
            GL11.glBegin(1);
            GL11.glVertex2f(-Camera.ScrollX + this.x + this.w - 1.0f, -Camera.ScrollY + this.y + this.h - 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + 1.0f, -Camera.ScrollY + this.y + this.h - 1.0f);
            GL11.glEnd();
            GL11.glBegin(1);
            GL11.glVertex2f(-Camera.ScrollX + this.x + 1.0f, -Camera.ScrollY + this.y + this.h - 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + 1.0f, -Camera.ScrollY + this.y + 1.0f);
            GL11.glEnd();
        }
        if (Update.skybox == this.texture) {
            TextureLoader.defaults.bind();
            GL11.glBegin(1);
            GL11.glColor3f(1.0f, 0.0f, 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + 1.0f, -Camera.ScrollY + this.y + 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + this.w - 1.0f, -Camera.ScrollY + this.y + 1.0f);
            GL11.glEnd();
            GL11.glBegin(1);
            GL11.glVertex2f(-Camera.ScrollX + this.x + this.w - 1.0f, -Camera.ScrollY + this.y + 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + this.w - 1.0f, -Camera.ScrollY + this.y + this.h - 1.0f);
            GL11.glEnd();
            GL11.glBegin(1);
            GL11.glVertex2f(-Camera.ScrollX + this.x + this.w - 1.0f, -Camera.ScrollY + this.y + this.h - 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + 1.0f, -Camera.ScrollY + this.y + this.h - 1.0f);
            GL11.glEnd();
            GL11.glBegin(1);
            GL11.glVertex2f(-Camera.ScrollX + this.x + 1.0f, -Camera.ScrollY + this.y + this.h - 1.0f);
            GL11.glVertex2f(-Camera.ScrollX + this.x + 1.0f, -Camera.ScrollY + this.y + 1.0f);
            GL11.glEnd();
        }
    }
}
