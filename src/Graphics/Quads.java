package Graphics;

import Tiles.*;
import Math.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import Buttons.*;
import Engine.*;

public class Quads
{
    public static float[] ambiantLight;
    public static int lightPower;
    
    static {
        Quads.ambiantLight = new float[] { 1, 1, 1 };
        Quads.lightPower = 50;
    }
    
    public static void quadSHighLight(final float x, final float y, final float w, final float h, final float rotation) {
        float r = 0.0f;
        float g = 0.0f;
        float b = 0.0f;
        float rp = 0.0f;
        float gp = 0.0f;
        float bp = 0.0f;
        GL11.glPushMatrix();
        GL11.glTranslatef(x + w / 2.0f, y + h / 2.0f, 0.0f);
        GL11.glRotatef(rotation, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-x - w / 2.0f, -y - h / 2.0f, 0.0f);
        GL11.glBegin(7);
        GL11.glColor4f(Quads.ambiantLight[0], Quads.ambiantLight[1], Quads.ambiantLight[2], 1.0f);
        for (final Light l : TilesManager.light) {
            final Vector2f vector = new Vector2f(x - l.location.getX(), y - l.location.getY());
            rp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.red;
            gp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.green;
            bp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.blue;
            if (rp < 0.0f) {
                rp = 0.0f;
            }
            if (gp < 0.0f) {
                gp = 0.0f;
            }
            if (bp < 0.0f) {
                bp = 0.0f;
            }
            r += rp;
            g += gp;
            b += bp;
        }
        if (KeyboardShortcut.light && Display.getHeight() - Mouse.getY() < Display.getHeight() - Display.getHeight() / 50 && Display.getHeight() - Mouse.getY() > Display.getHeight() / 50 && !OptionButton.imHover && !AddRedButton.imHover && !RemoveRedButton.imHover && !AddGreenButton.imHover && !RemoveGreenButton.imHover && !AddBlueButton.imHover && !RemoveBlueButton.imHover && !AddLightSizeButton.imHover && !RemoveLightSizeButton.imHover && ((Update.activate && Mouse.getX() >= Display.getWidth() / 6) || !Update.activate) && ((Update.skyActivate && Mouse.getX() <= Display.getWidth() - 90) || !Update.skyActivate)) {
            final Vector2f vector = new Vector2f(x - (-Camera.ScrollX + Mouse.getX()), y - (-Camera.ScrollY + Display.getHeight() - Mouse.getY()));
            rp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.r;
            gp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.g;
            bp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.b;
            if (rp < 0.0f) {
                rp = 0.0f;
            }
            if (gp < 0.0f) {
                gp = 0.0f;
            }
            if (bp < 0.0f) {
                bp = 0.0f;
            }
            r += rp;
            g += gp;
            b += bp;
        }
        r += Quads.ambiantLight[0];
        g += Quads.ambiantLight[1];
        b += Quads.ambiantLight[2];
        GL11.glColor4f(r, g, b, 1.0f);
        rp = 0.0f;
        gp = 0.0f;
        bp = 0.0f;
        r = 0.0f;
        g = 0.0f;
        b = 0.0f;
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex2f(x, y);
        GL11.glColor4f(Quads.ambiantLight[0], Quads.ambiantLight[1], Quads.ambiantLight[2], 1.0f);
        for (final Light l : TilesManager.light) {
            final Vector2f vector = new Vector2f(x + w - l.location.getX(), y - l.location.getY());
            rp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.red;
            gp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.green;
            bp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.blue;
            if (rp < 0.0f) {
                rp = 0.0f;
            }
            if (gp < 0.0f) {
                gp = 0.0f;
            }
            if (bp < 0.0f) {
                bp = 0.0f;
            }
            r += rp;
            g += gp;
            b += bp;
        }
        if (KeyboardShortcut.light && Display.getHeight() - Mouse.getY() < Display.getHeight() - Display.getHeight() / 50 && Display.getHeight() - Mouse.getY() > Display.getHeight() / 50 && !OptionButton.imHover && !AddRedButton.imHover && !RemoveRedButton.imHover && !AddGreenButton.imHover && !RemoveGreenButton.imHover && !AddBlueButton.imHover && !RemoveBlueButton.imHover && !AddLightSizeButton.imHover && !RemoveLightSizeButton.imHover && ((Update.activate && Mouse.getX() >= Display.getWidth() / 6) || !Update.activate) && ((Update.skyActivate && Mouse.getX() <= Display.getWidth() - 90) || !Update.skyActivate)) {
            final Vector2f vector = new Vector2f(x + w - (-Camera.ScrollX + Mouse.getX()), y - (-Camera.ScrollY + Display.getHeight() - Mouse.getY()));
            rp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.r;
            gp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.g;
            bp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.b;
            if (rp < 0.0f) {
                rp = 0.0f;
            }
            if (gp < 0.0f) {
                gp = 0.0f;
            }
            if (bp < 0.0f) {
                bp = 0.0f;
            }
            r += rp;
            g += gp;
            b += bp;
        }
        r += Quads.ambiantLight[0];
        g += Quads.ambiantLight[1];
        b += Quads.ambiantLight[2];
        GL11.glColor4f(r, g, b, 1.0f);
        rp = 0.0f;
        gp = 0.0f;
        bp = 0.0f;
        r = 0.0f;
        g = 0.0f;
        b = 0.0f;
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex2f(x + w, y);
        GL11.glColor4f(Quads.ambiantLight[0], Quads.ambiantLight[1], Quads.ambiantLight[2], 1.0f);
        for (final Light l : TilesManager.light) {
            final Vector2f vector = new Vector2f(x + w - l.location.getX(), y + h - l.location.getY());
            rp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.red;
            gp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.green;
            bp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.blue;
            if (rp < 0.0f) {
                rp = 0.0f;
            }
            if (gp < 0.0f) {
                gp = 0.0f;
            }
            if (bp < 0.0f) {
                bp = 0.0f;
            }
            r += rp;
            g += gp;
            b += bp;
        }
        if (KeyboardShortcut.light && Display.getHeight() - Mouse.getY() < Display.getHeight() - Display.getHeight() / 50 && Display.getHeight() - Mouse.getY() > Display.getHeight() / 50 && !OptionButton.imHover && !AddRedButton.imHover && !RemoveRedButton.imHover && !AddGreenButton.imHover && !RemoveGreenButton.imHover && !AddBlueButton.imHover && !RemoveBlueButton.imHover && !AddLightSizeButton.imHover && !RemoveLightSizeButton.imHover && ((Update.activate && Mouse.getX() >= Display.getWidth() / 6) || !Update.activate) && ((Update.skyActivate && Mouse.getX() <= Display.getWidth() - 90) || !Update.skyActivate)) {
            final Vector2f vector = new Vector2f(x + w - (-Camera.ScrollX + Mouse.getX()), y + h - (-Camera.ScrollY + Display.getHeight() - Mouse.getY()));
            rp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.r;
            gp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.g;
            bp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.b;
            if (rp < 0.0f) {
                rp = 0.0f;
            }
            if (gp < 0.0f) {
                gp = 0.0f;
            }
            if (bp < 0.0f) {
                bp = 0.0f;
            }
            r += rp;
            g += gp;
            b += bp;
        }
        r += Quads.ambiantLight[0];
        g += Quads.ambiantLight[1];
        b += Quads.ambiantLight[2];
        GL11.glColor4f(r, g, b, 1.0f);
        rp = 0.0f;
        gp = 0.0f;
        bp = 0.0f;
        r = 0.0f;
        g = 0.0f;
        b = 0.0f;
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex2f(x + w, y + h);
        for (final Light l : TilesManager.light) {
            final Vector2f vector = new Vector2f(x - l.location.getX(), y + h - l.location.getY());
            rp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.red;
            gp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.green;
            bp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.blue;
            if (rp < 0.0f) {
                rp = 0.0f;
            }
            if (gp < 0.0f) {
                gp = 0.0f;
            }
            if (bp < 0.0f) {
                bp = 0.0f;
            }
            r += rp;
            g += gp;
            b += bp;
        }
        if (KeyboardShortcut.light && Display.getHeight() - Mouse.getY() < Display.getHeight() - Display.getHeight() / 50 && Display.getHeight() - Mouse.getY() > Display.getHeight() / 50 && !OptionButton.imHover && !AddRedButton.imHover && !RemoveRedButton.imHover && !AddGreenButton.imHover && !RemoveGreenButton.imHover && !AddBlueButton.imHover && !RemoveBlueButton.imHover && !AddLightSizeButton.imHover && !RemoveLightSizeButton.imHover && ((Update.activate && Mouse.getX() >= Display.getWidth() / 6) || !Update.activate) && ((Update.skyActivate && Mouse.getX() <= Display.getWidth() - 90) || !Update.skyActivate)) {
            final Vector2f vector = new Vector2f(x - (-Camera.ScrollX + Mouse.getX()), y + h - (-Camera.ScrollY + Display.getHeight() - Mouse.getY()));
            rp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.r;
            gp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.g;
            bp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.b;
            if (rp < 0.0f) {
                rp = 0.0f;
            }
            if (gp < 0.0f) {
                gp = 0.0f;
            }
            if (bp < 0.0f) {
                bp = 0.0f;
            }
            r += rp;
            g += gp;
            b += bp;
        }
        r += Quads.ambiantLight[0];
        g += Quads.ambiantLight[1];
        b += Quads.ambiantLight[2];
        GL11.glColor4f(r, g, b, 1.0f);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex2f(x, y + h);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
    
    public static void QuadSLowLight(final float x, final float y, final float w, final float h, final float rotation) {
        float r = 0.0f;
        float g = 0.0f;
        float b = 0.0f;
        float rp = 0.0f;
        float gp = 0.0f;
        float bp = 0.0f;
        GL11.glPushMatrix();
        GL11.glTranslatef(x + w / 2.0f, y + h / 2.0f, 0.0f);
        GL11.glRotatef(rotation, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-x - w / 2.0f, -y - h / 2.0f, 0.0f);
        GL11.glBegin(7);
        GL11.glColor4f(Quads.ambiantLight[0], Quads.ambiantLight[1], Quads.ambiantLight[2], 1.0f);
        for (final Light l : TilesManager.light) {
            final Vector2f vector = new Vector2f(x + w / 2.0f - l.location.getX(), y + h / 2.0f - l.location.getY());
            rp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.red;
            gp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.green;
            bp += (Quads.lightPower * l.scale - vector.length()) / (Quads.lightPower * l.scale) * l.blue;
            if (rp < 0.0f) {
                rp = 0.0f;
            }
            if (gp < 0.0f) {
                gp = 0.0f;
            }
            if (bp < 0.0f) {
                bp = 0.0f;
            }
            r += rp;
            g += gp;
            b += bp;
        }
        if (KeyboardShortcut.light && Display.getHeight() - Mouse.getY() < Display.getHeight() - Display.getHeight() / 50 && Display.getHeight() - Mouse.getY() > Display.getHeight() / 50 && !OptionButton.imHover && !AddRedButton.imHover && !RemoveRedButton.imHover && !AddGreenButton.imHover && !RemoveGreenButton.imHover && !AddBlueButton.imHover && !RemoveBlueButton.imHover && !AddLightSizeButton.imHover && !RemoveLightSizeButton.imHover && ((Update.activate && Mouse.getX() >= Display.getWidth() / 6) || !Update.activate) && ((Update.skyActivate && Mouse.getX() <= Display.getWidth() - 90) || !Update.skyActivate)) {
            final Vector2f vector = new Vector2f(x + w / 2.0f - (-Camera.ScrollX + Mouse.getX()), y + h / 2.0f - (-Camera.ScrollY + Display.getHeight() - Mouse.getY()));
            rp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.r;
            gp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.g;
            bp += (Quads.lightPower * TilesManager.Lscale - vector.length()) / (Quads.lightPower * TilesManager.Lscale) * TilesManager.b;
            if (rp < 0.0f) {
                rp = 0.0f;
            }
            if (gp < 0.0f) {
                gp = 0.0f;
            }
            if (bp < 0.0f) {
                bp = 0.0f;
            }
            r += rp;
            g += gp;
            b += bp;
        }
        r += Quads.ambiantLight[0];
        g += Quads.ambiantLight[1];
        b += Quads.ambiantLight[2];
        GL11.glColor4f(r, g, b, 1.0f);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex2f(x, y);
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex2f(x + w, y);
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex2f(x + w, y + h);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex2f(x, y + h);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
    
    public static void QuadS(final float x, final float y, final float w, final float h, final float[] color, final float rotation) {
        GL11.glPushMatrix();
        GL11.glTranslatef(x + w / 2.0f, y + h / 2.0f, 0.0f);
        GL11.glRotatef(-rotation, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-x - w / 2.0f, -y - h / 2.0f, 0.0f);
        GL11.glBegin(7);
        GL11.glColor4f(color[0], color[1], color[2], color[3]);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex2f(x, y);
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex2f(x + w, y);
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex2f(x + w, y + h);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex2f(x, y + h);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
    
    public static void QuadSprite(final float x, final float y, final float w, final float h, final float[] color, final float rotation, final int xo, final int yo) {
        GL11.glPushMatrix();
        GL11.glTranslatef(x + w / 2.0f, y + h / 2.0f, 0.0f);
        GL11.glRotatef(-rotation, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-x - w / 2.0f, -y - h / 2.0f, 0.0f);
        GL11.glBegin(7);
        GL11.glColor4f(color[0], color[1], color[2], color[3]);
        GL11.glTexCoord2f((0 + xo) / 8.0f, (0 + yo) / 5.2f);
        GL11.glVertex2f(x, y);
        GL11.glTexCoord2f((1 + xo) / 8.0f, (0 + yo) / 5.2f);
        GL11.glVertex2f(x + w, y);
        GL11.glTexCoord2f((1 + xo) / 8.0f, (1 + yo) / 5.2f);
        GL11.glVertex2f(x + w, y + h);
        GL11.glTexCoord2f((0 + xo) / 8.0f, (1 + yo) / 5.2f);
        GL11.glVertex2f(x, y + h);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
}
