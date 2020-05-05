package Engine;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import Buttons.AddHeightSizeButton;
import Buttons.AddWidthSizeButton;
import Buttons.Button;
import Buttons.ButtonManager;
import Buttons.LeftRotationButton;
import Buttons.OptionButton;
import Buttons.RemoveHeightSizeButton;
import Buttons.RemoveWidthSizeButton;
import Buttons.RightRotationButton;
import Display.DisplayManager;
import Graphics.Colors;
import Graphics.Light;
import Graphics.Quads;
import Graphics.TextureLoader;
import Tiles.Tile;
import Tiles.Tiles;
import Tiles.TilesButton;
import Tiles.TilesButtonManager;
import Tiles.TilesManager;

public class Update
{
    public static boolean activate;
    public static boolean pressT;
    public static boolean solid;
    public static boolean pressS;
    public static boolean drag;
    public static boolean pressD;
    public static boolean press;
    public static boolean tilePressed;
    public static boolean skyActivate;
    public static boolean pressB;
    public static int lastFrame;
    public static int lastFPS;
    public static int fps;
    public static int trueFPS;
    public static String texture;
    public static Texture skybox;
    public static Texture tileTexture;
    public static int tileWidth;
    public static int tileHeight;
    public static int tileRotation;
    
    static {
        Update.activate = true;
        Update.skyActivate = true;
        Update.texture = "null";
        Update.tileWidth = 100;
        Update.tileHeight = 100;
        Update.tileRotation = 0;
    }
    
    public static long getTime() {
        return System.nanoTime() / 1000000L;
    }
    
    public static int getDelta() {
        final long time = getTime();
        final int delta = (int)(time - Update.lastFrame);
        Update.lastFrame = (int)time;
        return delta;
    }
    
    public static void updateFPS() {
        if (getTime() - Update.lastFPS > 1000L) {
            Update.trueFPS = Update.fps;
            Update.fps = 0;
            Update.lastFPS += 1000;
        }
        ++Update.fps;
    }
    
    public static void update() {
        getTime();
        Update.lastFPS = (int)getTime();
        while (true) {
            updateFPS();
            DisplayManager.update();
            KeyboardShortcut.update();
            Camera.update();
            try {
                GL11.glTexParameteri(3553, 10241, 9728);
                GL11.glTexParameteri(3553, 10240, 9728);
                Update.skybox.bind();
                Quads.QuadS((float)(-Camera.ScrollX), (float)(-Camera.ScrollY), (float)Display.getWidth(), (float)Display.getHeight(), Colors.white, 0.0f);
            }
            catch (Exception ex) {}
            Grid.render();
            TilesManager.update();
            FakeTile.update();
            ButtonManager.update();
            Information.draw();
            TextureLoader.defaults.bind();
            if (Update.activate) {
                Quads.QuadS((float)(-Camera.ScrollX), (float)(-Camera.ScrollY + Display.getHeight() / 50), (float)(Display.getWidth() / 6), (float)(Display.getHeight() - Display.getHeight() / 50 * 2), Colors.dgrayP, 0.0f);
            }
            TextureLoader.defaults.bind();
            if (Update.skyActivate) {
                Quads.QuadS((float)(-Camera.ScrollX + Display.getWidth() - 90), (float)(-Camera.ScrollY + Display.getHeight() / 50), 90.0f, (float)(Display.getHeight() - Display.getHeight() / 50 * 2), Colors.dgrayP, 0.0f);
            }
            TilesButtonManager.update();
            Button.getMouse();
            Tiles.getMousePositionAndButtons();
            Light.getMousePositionAndButtons();
            TilesButton.getMouse();
            if (Keyboard.isKeyDown(20) && !Update.pressT) {
                Update.pressT = true;
                if (Update.activate) {
                    Update.activate = false;
                }
                else {
                    Update.activate = true;
                }
            }
            if (Keyboard.isKeyDown(20)) {
                Update.pressT = true;
            }
            else {
                Update.pressT = false;
            }
            if (Keyboard.isKeyDown(48) && !Update.pressB) {
                Update.pressB = true;
                if (Update.skyActivate) {
                    Update.skyActivate = false;
                }
                else {
                    Update.skyActivate = true;
                }
            }
            if (Keyboard.isKeyDown(48)) {
                Update.pressB = true;
            }
            else {
                Update.pressB = false;
            }
            if (Keyboard.isKeyDown(31) && !Update.pressS) {
                Update.pressS = true;
                if (Update.solid) {
                    Update.solid = false;
                }
                else {
                    Update.solid = true;
                }
            }
            if (Keyboard.isKeyDown(31)) {
                Update.pressS = true;
            }
            else {
                Update.pressS = false;
            }
            if (Keyboard.isKeyDown(32) && !Update.pressD) {
                Update.pressD = true;
                if (Update.drag) {
                    Update.drag = false;
                }
                else {
                    Update.drag = true;
                }
            }
            if (Keyboard.isKeyDown(32)) {
                Update.pressD = true;
            }
            else {
                Update.pressD = false;
            }
            if (!Update.drag) {
                if (Mouse.isButtonDown(0) && !Update.press && Display.getHeight() - Mouse.getY() < Display.getHeight() - Display.getHeight() / 50 && Display.getHeight() - Mouse.getY() > Display.getHeight() / 50 && !OptionButton.imHover && !AddWidthSizeButton.imHover && !RemoveWidthSizeButton.imHover && !AddHeightSizeButton.imHover && !RemoveHeightSizeButton.imHover && !LeftRotationButton.imHover && !RightRotationButton.imHover && !KeyboardShortcut.light && ((Update.activate && Mouse.getX() >= Display.getWidth() / 6) || !Update.activate) && ((Update.skyActivate && Mouse.getX() <= Display.getWidth() - 90) || !Update.skyActivate)) {
                    Update.press = true;
                    for (final Tiles t : TilesManager.tiles) {
                        if (t.isLclicked()) {
                            t.setSolid(Update.solid);
                            t.setTexture(Loader.loadPNG("Editeur/Textures/Tiles/" + Update.texture));
                            t.setTextureName(Update.texture);
                            Update.tilePressed = true;
                        }
                    }
                    if (!Update.tilePressed) {
                        TilesManager.tiles.add(new Tile(Loader.loadPNG("Editeur/Textures/Tiles/" + Update.texture), FakeTile.x, FakeTile.y, Update.tileWidth, Update.tileHeight, Update.solid, false, false, false, Update.texture, Update.tileRotation, false));
                    }
                }
            }
            else if (Mouse.isButtonDown(0) && Display.getHeight() - Mouse.getY() < Display.getHeight() - Display.getHeight() / 50 && Display.getHeight() - Mouse.getY() > Display.getHeight() / 50 && !OptionButton.imHover && !AddWidthSizeButton.imHover && !RemoveWidthSizeButton.imHover && !AddHeightSizeButton.imHover && !RemoveHeightSizeButton.imHover && !LeftRotationButton.imHover && !RightRotationButton.imHover && !KeyboardShortcut.light && ((Update.activate && Mouse.getX() >= Display.getWidth() / 6) || !Update.activate) && ((Update.skyActivate && Mouse.getX() <= Display.getWidth() - 90) || !Update.skyActivate)) {
                for (final Tiles t : TilesManager.tiles) {
                    if (t.isLclicked()) {
                        t.setSolid(Update.solid);
                        t.setTexture(Loader.loadPNG("Editeur/Textures/Tiles/" + Update.texture));
                        t.setTextureName(Update.texture);
                        Update.tilePressed = true;
                    }
                }
                if (!Update.tilePressed) {
                    TilesManager.tiles.add(new Tile(Loader.loadPNG("Editeur/Textures/Tiles/" + Update.texture), FakeTile.x, FakeTile.y, Update.tileWidth, Update.tileHeight, Update.solid, false, false, false, Update.texture, Update.tileRotation, false));
                }
            }
            Update.tilePressed = false;
            FakeTile.texture = Update.tileTexture;
            for (final Tiles t : TilesManager.tiles) {
                if (t.isHover()) {
                    Information.textureHover = t.getTextureName();
                    Information.solide = t.isSolid();
                    Information.width = t.getW();
                    Information.height = t.getH();
                    Information.rotation = t.getRotation();
                }
            }
            if (Mouse.isButtonDown(0)) {
                Update.press = true;
            }
            else {
                Update.press = false;
            }
        }
    }
}
