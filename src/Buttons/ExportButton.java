package Buttons;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import Engine.Camera;
import Engine.Loader;
import Graphics.Colors;
import Graphics.Light;
import Graphics.Quads;
import Graphics.TextureLoader;
import Tiles.Tiles;
import Tiles.TilesManager;

public class ExportButton extends Button
{
    private boolean drawMsg;
    private boolean error;
    private File map;
    private DateFormat dateFormat;
    private Date date;
    
    public ExportButton(final Texture texture, final float x, final float y, final float w, final float h, final float[] color, final float rotation, final boolean clicked, final boolean hover) {
        super(texture, x, y, w, h, color, rotation, clicked, hover);
        this.drawMsg = false;
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
        if (this.isClicked()) {
            this.dateFormat = new SimpleDateFormat("HH.mm.ss dd!MM!yyyy");
            this.date = new Date();
            try {
                final PrintWriter writer = new PrintWriter("Editeur/Export/map " + String.valueOf(this.dateFormat.format(this.date)) + ".dat", "UTF-8");
                writer.println("B.M.E 1.2");
                for (final Tiles tile : TilesManager.tiles) {
                    writer.println("B " + tile.getX() + " " + tile.getY() + " " + tile.getW() + " " + tile.getH() + " " + tile.isSolid() + " " + tile.getRotation() + " " + tile.getTextureName());
                    Loader.text.drawString((float)(Display.getWidth() / 2 - Camera.ScrollX - Loader.text.getWidth("Exportation de la carte en cours merci de patienter...") / 2), (float)(Display.getHeight() / 2 - Loader.text.getHeight() / 2 - Camera.ScrollY), "Exportation de la carte en cours merci de patienter...", Color.white);
                }
                for (final Light light : TilesManager.light) {
                    writer.println("L " + light.location.getX() + " " + light.location.getY() + " " + light.red + " " + light.green + " " + light.blue + " " + light.scale);
                }
                writer.close();
                this.drawMsg = true;
            }
            catch (Exception e) {
                this.error = true;
            }
            this.map = new File("Editeur/Export/map " + String.valueOf(this.dateFormat.format(this.date)) + ".dat");
        }
        if (this.drawMsg) {
            Loader.text.drawString((float)(Display.getWidth() / 2 - Camera.ScrollX - Loader.text.getWidth("Map export\u00ef¿½e avec sucess") / 2), (float)(Display.getHeight() / 2 - Loader.text.getHeight() / 2 - Camera.ScrollY), "Map export\u00ef¿½e avec sucess", Color.green);
            Loader.text.drawString((float)(Display.getWidth() / 2 - Camera.ScrollX - Loader.text.getWidth("(" + this.map.getAbsolutePath() + ")") / 2), (float)(Display.getHeight() / 2 + Loader.text.getHeight() / 2 - Camera.ScrollY), "(" + this.map.getAbsolutePath() + ")", Color.green);
        }
        if (this.error) {
            Loader.text.drawString((float)(Display.getWidth() / 2 - Camera.ScrollX - Loader.text.getWidth("Impossible d'exporter la map !") / 2), (float)(Display.getHeight() / 2 - Loader.text.getHeight() / 2 - Camera.ScrollY), "Impossible d'exporter la map !", Color.green);
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
            Loader.text.drawString(-Camera.ScrollX + this.x + this.w / 2.0f - Loader.text.getWidth("Exporter") / 2, -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, "Exporter", Color.black);
        }
        else {
            Loader.text.drawString(-Camera.ScrollX + this.x + this.w / 2.0f - Loader.text.getWidth("Exporter") / 2, -Camera.ScrollY + this.y + this.h / 2.0f - Loader.text.getHeight() / 2, "Exporter", Color.white);
        }
    }
}
