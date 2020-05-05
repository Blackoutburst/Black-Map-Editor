package Buttons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import Engine.Camera;
import Engine.Loader;
import Graphics.Colors;
import Graphics.Light;
import Graphics.Quads;
import Graphics.TextureLoader;
import Start.Start;
import Tiles.Tile;
import Tiles.TilesManager;

public class LoadButton extends Button
{
    private boolean drawMsg;
    private boolean error;
    public static String path;
    
    static {
        LoadButton.path = "null";
    }
    
    public LoadButton(final Texture texture, final float x, final float y, final float w, final float h, final float[] color, final float rotation, final boolean clicked, final boolean hover) {
        super(texture, x, y, w, h, color, rotation, clicked, hover);
    }
    
    @Override
    protected void init() {
    }
    
    @Override
    protected void update() {
        if (this.isHover()) {
            this.color = Colors.gray;
        }
        else {
            this.color = Colors.dgray;
        }
        if (this.isClicked() && this.isClicked()) {
            Start.fileChooser = true;
        }
        if (!LoadButton.path.equals("null")) {
            TilesManager.tiles.clear();
            TilesManager.light.clear();
            try {
                final LineNumberReader lnr = new LineNumberReader(new FileReader(LoadButton.path));
                int lines = 0;
                while (lnr.readLine() != null) {
                    ++lines;
                }
                lnr.close();
                try {
                    Throwable t = null;
                    try {
                        final BufferedReader br = new BufferedReader(new FileReader(LoadButton.path));
                        try {
                            if (br.readLine().contains("1.2")) {
                                for (int i = 1; i < lines; ++i) {
                                    final String str = br.readLine();
                                    final String[] val = str.split(" ");
                                    if (str.startsWith("B")) {
                                        TilesManager.tiles.add(new Tile(Loader.loadPNG("Editeur/Textures/Tiles/" + String.valueOf(val[7])), Integer.valueOf(val[1]), Integer.valueOf(val[2]), Integer.valueOf(val[3]), Integer.valueOf(val[4]), Boolean.valueOf(val[5]), false, false, false, String.valueOf(val[7]), Integer.valueOf(val[6]), false));
                                    }
                                    else if (str.startsWith("L")) {
                                        TilesManager.light.add(new Light(new Vector2f(Float.valueOf(val[1]), Float.valueOf(val[2])), Float.valueOf(val[3]), Float.valueOf(val[4]), Float.valueOf(val[5]), Float.valueOf(val[6]), false, false));
                                    }
                                }
                                br.close();
                            }
                            else {
                                br.close();
                                final BufferedReader br2 = new BufferedReader(new FileReader(LoadButton.path));
                                for (int j = 0; j < lines; ++j) {
                                    final String str2 = br2.readLine();
                                    final String[] val2 = str2.split(" ");
                                    TilesManager.tiles.add(new Tile(Loader.loadPNG("Editeur/Textures/Tiles/" + String.valueOf(val2[3])), Integer.valueOf(val2[0]), Integer.valueOf(val2[1]), 100, 100, Boolean.valueOf(val2[2]), false, false, false, String.valueOf(val2[3]), 0, false));
                                }
                                br2.close();
                            }
                            LoadButton.path = "null";
                            this.drawMsg = true;
                        }
                        finally {
                            if (br != null) {
                                br.close();
                            }
                        }
                    }
                    finally {
                        if (t == null) {
                            final Throwable exception = null;
                            t = exception;
                        }
                        else {
                            final Throwable exception = null;
                            if (t != exception) {
                                t.addSuppressed(exception);
                            }
                        }
                    }
                }
                catch (Exception e1) {
                    this.error = true;
                    e1.printStackTrace();
                }
            }
            catch (Exception e2) {
                this.error = true;
                e2.printStackTrace();
            }
        }
        if (this.drawMsg) {
            Loader.text.drawString((float)(Display.getWidth() / 2 - Camera.ScrollX - Loader.text.getWidth("Map charger avec sucess") / 2), (float)(Display.getHeight() / 2 - Loader.text.getHeight() / 2 - Camera.ScrollY), "Map charger avec sucess", Color.green);
        }
        if (this.error) {
            Loader.text.drawString((float)(Display.getWidth() / 2 - Camera.ScrollX - Loader.text.getWidth("Impossible de charger la map !") / 2), (float)(Display.getHeight() / 2 - Loader.text.getHeight() / 2 - Camera.ScrollY), "Impossible de charger la map !", Color.red);
        }
        if ((!this.isHover() && Mouse.isButtonDown(0)) || (!this.isHover() && Mouse.isButtonDown(1))) {
            this.drawMsg = false;
            this.error = false;
        }
    }
    
    @Override
    protected void render() {
        TextureLoader.defaults.bind();
        Quads.QuadS(-Camera.ScrollX + this.x, -Camera.ScrollY + this.y, this.w, this.h, this.color, 0.0f);
        if (this.isHover()) {
            Loader.text.drawString(-Camera.ScrollX + this.x + this.w / 2.0f - Loader.text.getWidth("Charger") / 2, -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, "Charger", Color.black);
        }
        else {
            Loader.text.drawString(-Camera.ScrollX + this.x + this.w / 2.0f - Loader.text.getWidth("Charger") / 2, -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, "Charger", Color.white);
        }
    }
}
