package Display;

import java.nio.*;
import org.newdawn.slick.util.*;
import org.newdawn.slick.opengl.*;
import org.lwjgl.input.*;
import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.*;

public class DisplayManager
{
    private static int w;
    private static int h;
    private static ByteBuffer icon16;
    private static ByteBuffer icon32;
    private static final String OSNAME;
    
    static {
        DisplayManager.icon16 = null;
        DisplayManager.icon32 = null;
        OSNAME = System.getProperty("os.name");
    }
    
    public static void create() {
        try {
            if (DisplayManager.OSNAME.toLowerCase().contains("windows")) {
                System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
            }
            else {
                Display.setFullscreen(true);
            }
            Display.create();
            try {
                DisplayManager.icon16 = ByteBuffer.wrap(TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/icon16.png")).getTextureData());
                DisplayManager.icon32 = ByteBuffer.wrap(TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/icon32.png")).getTextureData());
                Display.setIcon(new ByteBuffer[] { DisplayManager.icon16, DisplayManager.icon32 });
            }
            catch (Exception e2) {
                System.err.println("Icon not founds !");
            }
            Display.setResizable(false);
            Display.setTitle("B.M.E 1.2");
            Display.setVSyncEnabled(true);
            Mouse.setGrabbed(false);
        }
        catch (LWJGLException e) {
            e.printStackTrace();
        }
    }
    
    public static void update() {
        DisplayManager.w = Display.getWidth();
        DisplayManager.h = Display.getHeight();
        GL11.glViewport(0, 0, DisplayManager.w, DisplayManager.h);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GLU.gluOrtho2D(0.0f, (float)DisplayManager.w, (float)DisplayManager.h, 0.0f);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glEnable(3553);
        GL11.glEnable(3042);
        Display.update();
        GL11.glBlendFunc(770, 771);
        GL11.glClear(16384);
        GL11.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        if (Display.isCloseRequested()) {
            Display.destroy();
            System.exit(0);
        }
    }
}
