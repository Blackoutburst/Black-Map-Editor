package Engine;

import org.lwjgl.opengl.*;
import org.newdawn.slick.*;
import Tiles.*;
import org.lwjgl.input.*;

public class Information
{
    private static int x;
    public static String textureHover;
    public static boolean solide;
    public static int width;
    public static int height;
    public static int rotation;
    
    static {
        Information.x = 0;
        Information.textureHover = "";
    }
    
    public static void draw() {
        if (Update.skyActivate) {
            Information.x = 95;
        }
        else {
            Information.x = 0;
        }
        if (KeyboardShortcut.info) {
            if (Update.trueFPS >= 40) {
                Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("FPS : " + String.valueOf(Update.trueFPS)) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY), "FPS : " + String.valueOf(Update.trueFPS), Color.green);
            }
            else if (Update.trueFPS < 40 && Update.trueFPS >= 20) {
                Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("FPS : " + String.valueOf(Update.trueFPS)) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY), "FPS : " + String.valueOf(Update.trueFPS), Color.yellow);
            }
            else if (Update.trueFPS < 20 && Update.trueFPS >= 10) {
                Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("FPS : " + String.valueOf(Update.trueFPS)) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY), "FPS : " + String.valueOf(Update.trueFPS), Color.orange);
            }
            else if (Update.trueFPS < 10) {
                Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("FPS : " + String.valueOf(Update.trueFPS)) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY), "FPS : " + String.valueOf(Update.trueFPS), Color.red);
            }
            Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("G\u00e9n\u00e9ral : ") - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY + Loader.text.getHeight()), "G\u00e9n\u00e9ral : ", Color.gray);
            Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("Tiles : " + String.valueOf(TilesManager.tiles.size())) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY + Loader.text.getHeight() * 2), "Tiles : " + String.valueOf(TilesManager.tiles.size()), Color.white);
            Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("X Sourie : " + String.valueOf(Mouse.getX() - Camera.ScrollX)) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY + Loader.text.getHeight() * 3), "X Sourie : " + String.valueOf(Mouse.getX() - Camera.ScrollX), Color.white);
            Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("Y Sourie : " + String.valueOf(Display.getHeight() - Mouse.getY() - Camera.ScrollY)) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY + Loader.text.getHeight() * 4), "Y Sourie : " + String.valueOf(Display.getHeight() - Mouse.getY() - Camera.ScrollY), Color.white);
            Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("X Tiles : " + String.valueOf(FakeTile.x)) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY + Loader.text.getHeight() * 5), "X Tiles : " + String.valueOf(FakeTile.x), Color.white);
            Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("Y Tiles : " + String.valueOf(FakeTile.y)) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY + Loader.text.getHeight() * 6), "Y Tiles : " + String.valueOf(FakeTile.y), Color.white);
            Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("Texture : " + String.valueOf(Update.texture)) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY + Loader.text.getHeight() * 7), "Texture : " + String.valueOf(Update.texture), Color.white);
            Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("Suvroler : ") - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY + Loader.text.getHeight() * 9), "Survoler : ", Color.gray);
            Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("Texture : " + Information.textureHover) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY + Loader.text.getHeight() * 10), "Texture : " + Information.textureHover, Color.white);
            Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("Solide : " + Information.solide) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY + Loader.text.getHeight() * 11), "Solide : " + Information.solide, Color.white);
            Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("Largeur : " + Information.width) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY + Loader.text.getHeight() * 12), "Largeur : " + Information.width, Color.white);
            Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("Hauteur : " + Information.height) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY + Loader.text.getHeight() * 13), "Hauteur : " + Information.height, Color.white);
            Loader.text.drawString((float)(Display.getWidth() - Camera.ScrollX - Loader.text.getWidth("Rotation : " + Information.rotation) - Information.x), (float)(Display.getHeight() / 50 - Camera.ScrollY + Loader.text.getHeight() * 14), "Rotation : " + Information.rotation, Color.white);
            Information.textureHover = "";
            Information.solide = false;
            Information.width = 0;
            Information.height = 0;
            Information.rotation = 0;
        }
    }
}
