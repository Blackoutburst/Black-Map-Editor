package Tiles;

import org.lwjgl.opengl.*;
import java.io.*;
import Buttons.*;
import Engine.*;
import org.lwjgl.util.vector.*;
import org.lwjgl.input.*;
import Graphics.*;
import java.util.*;

public class TilesManager
{
    public static List<Tiles> tiles;
    public static List<Light> light;
    private static boolean click;
    private static int fragmentShader;
    private static int shaderProgram;
    public static int Lscale;
    public static float r;
    public static float g;
    public static float b;
    
    static {
        TilesManager.tiles = new ArrayList<Tiles>();
        TilesManager.light = new ArrayList<Light>();
        TilesManager.Lscale = 5;
        TilesManager.r = 1.0f;
        TilesManager.g = 1.0f;
        TilesManager.b = 1.0f;
    }
    
    public static void init() {
        TilesManager.shaderProgram = GL20.glCreateProgram();
        TilesManager.fragmentShader = GL20.glCreateShader(35632);
        final StringBuilder fragmentShaderSource = new StringBuilder();
        final InputStream in = TilesManager.class.getResourceAsStream("/shader.frag");
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                fragmentShaderSource.append(line).append("\n");
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
        GL20.glShaderSource(TilesManager.fragmentShader, fragmentShaderSource);
        GL20.glCompileShader(TilesManager.fragmentShader);
        if (GL20.glGetShaderi(TilesManager.fragmentShader, 35713) == 0) {
            System.err.println("Fragment shader not compiled!");
        }
        GL20.glAttachShader(TilesManager.shaderProgram, TilesManager.fragmentShader);
        GL20.glLinkProgram(TilesManager.shaderProgram);
        GL20.glValidateProgram(TilesManager.shaderProgram);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, Display.getWidth(), Display.getHeight(), 0.0, 1.0, -1.0);
        GL11.glMatrixMode(5888);
        GL11.glEnable(2960);
    }
    
    public static void update() {
        for (final Tiles t : TilesManager.tiles) {
            t.update();
            t.render();
        }
        try {
            for (final Tiles t : TilesManager.tiles) {
                if (t.removed) {
                    TilesManager.tiles.remove(t);
                }
            }
        }
        catch (Exception ex) {}
        final int dWheel = Mouse.getDWheel();
        if (KeyboardShortcut.light) {
            if (dWheel < 0) {
                if (TilesManager.Lscale > 0) {
                    --TilesManager.Lscale;
                }
            }
            else if (dWheel > 0) {
                ++TilesManager.Lscale;
            }
            if (Display.getHeight() - Mouse.getY() < Display.getHeight() - Display.getHeight() / 50 && Display.getHeight() - Mouse.getY() > Display.getHeight() / 50 && !OptionButton.imHover && !AddRedButton.imHover && !RemoveRedButton.imHover && !AddGreenButton.imHover && !RemoveGreenButton.imHover && !AddBlueButton.imHover && !RemoveBlueButton.imHover && !AddLightSizeButton.imHover && !RemoveLightSizeButton.imHover && ((Update.activate && Mouse.getX() >= Display.getWidth() / 6) || !Update.activate) && ((Update.skyActivate && Mouse.getX() <= Display.getWidth() - 90) || !Update.skyActivate)) {
                render((float)(-Camera.ScrollX + Mouse.getX()), (float)(-Camera.ScrollY + Display.getHeight() - Mouse.getY()), TilesManager.r, TilesManager.g, TilesManager.b, (float)TilesManager.Lscale);
            }
            if (!TilesManager.click && Mouse.isButtonDown(0) && Display.getHeight() - Mouse.getY() < Display.getHeight() - Display.getHeight() / 50 && Display.getHeight() - Mouse.getY() > Display.getHeight() / 50 && !OptionButton.imHover && !AddRedButton.imHover && !RemoveRedButton.imHover && !AddGreenButton.imHover && !RemoveGreenButton.imHover && !AddBlueButton.imHover && !RemoveBlueButton.imHover && !AddLightSizeButton.imHover && !RemoveLightSizeButton.imHover && ((Update.activate && Mouse.getX() >= Display.getWidth() / 6) || !Update.activate) && ((Update.skyActivate && Mouse.getX() <= Display.getWidth() - 90) || !Update.skyActivate)) {
                TilesManager.click = true;
                TilesManager.light.add(new Light(new Vector2f((float)(-Camera.ScrollX + Mouse.getX()), (float)(-Camera.ScrollY + Display.getHeight() - Mouse.getY())), TilesManager.r, TilesManager.g, TilesManager.b, (float)TilesManager.Lscale, false, false));
            }
            if (Mouse.isButtonDown(0)) {
                TilesManager.click = true;
            }
            else {
                TilesManager.click = false;
            }
        }
        else if (dWheel < 0) {
            if (Keyboard.isKeyDown(42)) {
                Update.tileRotation -= 5;
            }
            else if (Update.tileWidth > 5 && Update.tileHeight > 5) {
                Update.tileWidth -= 5;
                Update.tileHeight -= 5;
            }
        }
        else if (dWheel > 0) {
            if (Keyboard.isKeyDown(42)) {
                Update.tileRotation += 5;
            }
            else {
                Update.tileWidth += 5;
                Update.tileHeight += 5;
            }
        }
        for (final Light light : TilesManager.light) {
            if (light.location.getX() > -Camera.ScrollX && light.location.getX() < -Camera.ScrollX + Display.getWidth() && light.location.getY() > -Camera.ScrollY && light.location.getY() < -Camera.ScrollY + Display.getHeight()) {
                GL11.glColorMask(false, false, false, false);
                GL11.glStencilFunc(519, 1, 1);
                GL11.glStencilOp(7680, 7680, 7681);
                for (final Tiles block : TilesManager.tiles) {
                    if (block.isSolid()) {
                        final Vector2f[] vertices = block.getVertices();
                        for (int i = 0; i < vertices.length; ++i) {
                            final Vector2f currentVertex = vertices[i];
                            final Vector2f nextVertex = vertices[(i + 1) % vertices.length];
                            final Vector2f edge = Vector2f.sub(nextVertex, currentVertex, null);
                            final Vector2f normal = new Vector2f(edge.getY(), -edge.getX());
                            final Vector2f lightToCurrent = Vector2f.sub(currentVertex, light.location, null);
                            if (Vector2f.dot(normal, lightToCurrent) > 0.0f) {
                                final Vector2f point1 = Vector2f.add(currentVertex, (Vector2f)Vector2f.sub(currentVertex, light.location, null).scale(800.0f), null);
                                final Vector2f point2 = Vector2f.add(nextVertex, (Vector2f)Vector2f.sub(nextVertex, light.location, null).scale(800.0f), null);
                                GL11.glBegin(7);
                                GL11.glVertex2f(currentVertex.getX(), currentVertex.getY());
                                GL11.glVertex2f(point1.getX(), point1.getY());
                                GL11.glVertex2f(point2.getX(), point2.getY());
                                GL11.glVertex2f(nextVertex.getX(), nextVertex.getY());
                                GL11.glEnd();
                            }
                        }
                    }
                }
                GL11.glStencilOp(7680, 7680, 7680);
                GL11.glStencilFunc(514, 0, 1);
                GL11.glColorMask(true, true, true, true);
                GL20.glUseProgram(TilesManager.shaderProgram);
                GL20.glUniform2f(GL20.glGetUniformLocation(TilesManager.shaderProgram, "lightLocation"), light.location.getX() + Camera.ScrollX, Display.getHeight() - light.location.getY() - Camera.ScrollY);
                GL20.glUniform3f(GL20.glGetUniformLocation(TilesManager.shaderProgram, "lightColor"), light.red * light.scale, light.green * light.scale, light.blue * light.scale);
                GL11.glBlendFunc(1, 1);
                GL11.glBegin(7);
                GL11.glVertex2f((float)(-Camera.ScrollX), (float)(-Camera.ScrollY));
                GL11.glVertex2f((float)(-Camera.ScrollX), (float)(-Camera.ScrollY + Display.getHeight()));
                GL11.glVertex2f((float)(-Camera.ScrollX + Display.getWidth()), (float)(-Camera.ScrollY + Display.getHeight()));
                GL11.glVertex2f((float)(-Camera.ScrollX + Display.getWidth()), (float)(-Camera.ScrollY));
                GL11.glEnd();
                GL20.glUseProgram(0);
                GL11.glClear(1024);
                GL11.glBlendFunc(770, 771);
                if (KeyboardShortcut.hitbox) {
                    TextureLoader.defaults.bind();
                    GL11.glBegin(1);
                    GL11.glColor3f(0.0f, 1.0f, 0.0f);
                    GL11.glVertex2f(light.location.getX() - 20.0f, light.location.getY() - 20.0f);
                    GL11.glVertex2f(light.location.getX() + 20.0f, light.location.getY() - 20.0f);
                    GL11.glEnd();
                    GL11.glBegin(1);
                    GL11.glColor3f(0.0f, 1.0f, 0.0f);
                    GL11.glVertex2f(light.location.getX() + 20.0f, light.location.getY() - 20.0f);
                    GL11.glVertex2f(light.location.getX() + 20.0f, light.location.getY() + 20.0f);
                    GL11.glEnd();
                    GL11.glBegin(1);
                    GL11.glColor3f(0.0f, 1.0f, 0.0f);
                    GL11.glVertex2f(light.location.getX() + 20.0f, light.location.getY() + 20.0f);
                    GL11.glVertex2f(light.location.getX() - 20.0f, light.location.getY() + 20.0f);
                    GL11.glEnd();
                    GL11.glBegin(1);
                    GL11.glColor3f(0.0f, 1.0f, 0.0f);
                    GL11.glVertex2f(light.location.getX() - 20.0f, light.location.getY() + 20.0f);
                    GL11.glVertex2f(light.location.getX() - 20.0f, light.location.getY() - 20.0f);
                    GL11.glEnd();
                }
                if (!light.isRClicked() || !KeyboardShortcut.light) {
                    continue;
                }
                light.removed = true;
            }
        }
        try {
            for (final Light l : TilesManager.light) {
                if (l.removed) {
                    TilesManager.light.remove(l);
                }
            }
        }
        catch (Exception ex2) {}
    }
    
    public static void render(final float x, final float y, final float r, final float g, final float b, final float scale) {
        GL11.glColorMask(false, false, false, false);
        GL11.glStencilFunc(519, 1, 1);
        GL11.glStencilOp(7680, 7680, 7681);
        for (final Tiles block : TilesManager.tiles) {
            if (block.isSolid()) {
                final Vector2f[] vertices = block.getVertices();
                for (int i = 0; i < vertices.length; ++i) {
                    final Vector2f currentVertex = vertices[i];
                    final Vector2f nextVertex = vertices[(i + 1) % vertices.length];
                    final Vector2f edge = Vector2f.sub(nextVertex, currentVertex, null);
                    final Vector2f normal = new Vector2f(edge.getY(), -edge.getX());
                    final Vector2f lightToCurrent = Vector2f.sub(currentVertex, new Vector2f(x, y), null);
                    if (Vector2f.dot(normal, lightToCurrent) > 0.0f) {
                        final Vector2f point1 = Vector2f.add(currentVertex, (Vector2f)Vector2f.sub(currentVertex, new Vector2f(x, y), null).scale(800.0f), null);
                        final Vector2f point2 = Vector2f.add(nextVertex, (Vector2f)Vector2f.sub(nextVertex, new Vector2f(x, y), null).scale(800.0f), null);
                        GL11.glBegin(7);
                        GL11.glVertex2f(currentVertex.getX(), currentVertex.getY());
                        GL11.glVertex2f(point1.getX(), point1.getY());
                        GL11.glVertex2f(point2.getX(), point2.getY());
                        GL11.glVertex2f(nextVertex.getX(), nextVertex.getY());
                        GL11.glEnd();
                    }
                }
            }
        }
        GL11.glStencilOp(7680, 7680, 7680);
        GL11.glStencilFunc(514, 0, 1);
        GL11.glColorMask(true, true, true, true);
        GL20.glUseProgram(TilesManager.shaderProgram);
        GL20.glUniform2f(GL20.glGetUniformLocation(TilesManager.shaderProgram, "lightLocation"), x + Camera.ScrollX, Display.getHeight() - y - Camera.ScrollY);
        GL20.glUniform3f(GL20.glGetUniformLocation(TilesManager.shaderProgram, "lightColor"), r * scale, g * scale, b * scale);
        GL11.glBlendFunc(1, 1);
        GL11.glBegin(7);
        GL11.glVertex2f((float)(-Camera.ScrollX), (float)(-Camera.ScrollY));
        GL11.glVertex2f((float)(-Camera.ScrollX), (float)(-Camera.ScrollY + Display.getHeight()));
        GL11.glVertex2f((float)(-Camera.ScrollX + Display.getWidth()), (float)(-Camera.ScrollY + Display.getHeight()));
        GL11.glVertex2f((float)(-Camera.ScrollX + Display.getWidth()), (float)(-Camera.ScrollY));
        GL11.glEnd();
        GL20.glUseProgram(0);
        GL11.glClear(1024);
        GL11.glBlendFunc(770, 771);
    }
}
