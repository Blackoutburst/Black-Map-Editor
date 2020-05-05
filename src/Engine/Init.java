package Engine;

import java.io.*;
import Display.*;
import org.lwjgl.opengl.*;
import Graphics.*;
import Buttons.*;
import Tiles.*;
import java.util.*;

public class Init
{
    public static List<String> Textures;
    public static List<String> skyBox;
    
    static {
        Init.Textures = new ArrayList<String>();
        Init.skyBox = new ArrayList<String>();
    }
    
    public static void init() {
        new File("Editeur/Textures/Tiles").mkdirs();
        new File("Editeur/Textures/SkyBox").mkdirs();
        new File("Editeur/Export").mkdirs();
        DisplayManager.create();
        final File folder = new File("Editeur/Textures/Tiles");
        final File[] listOfFiles = folder.listFiles();
        final File skyFolder = new File("Editeur/Textures/SkyBox");
        final File[] SkyBoxFile = skyFolder.listFiles();
        for (int i = 0; i < listOfFiles.length; ++i) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().toLowerCase().contains(".png")) {
                Init.Textures.add(String.valueOf(listOfFiles[i].getName()));
            }
        }
        for (int i = 0; i < SkyBoxFile.length; ++i) {
            if (SkyBoxFile[i].isFile() && listOfFiles[i].getName().toLowerCase().contains(".png")) {
                Init.skyBox.add(String.valueOf(SkyBoxFile[i].getName()));
            }
        }
        int x = 0;
        int y = 0;
        for (final String str : Init.Textures) {
            TilesButtonManager.Tbut.add(new TilesBut(Loader.loadPNG("Editeur/Textures/Tiles/" + str.substring(0, str.length() - 4)), (float)x, (float)(Display.getHeight() / 50 + y), 50.0f, 50.0f, Colors.white, 0.0f, false, false, str.substring(0, str.length() - 4)));
            x += 50;
            if (x + 50 > Display.getWidth() / 6) {
                x = 0;
                y += 50;
            }
        }
        y = 0;
        for (final String str : Init.skyBox) {
            TilesButtonManager.skyBoxbut.add(new SkyBoxBut(Loader.loadPNG("Editeur/Textures/SkyBox/" + str.substring(0, str.length() - 4)), (float)(Display.getWidth() - 80), (float)(Display.getHeight() / 50 + y), 70.0f, 70.0f, Colors.white, 0.0f, false, false, str.substring(0, str.length() - 4)));
            y += 70;
        }
        TextureLoader.load();
        Loader.loadDefaultFont();
        ButtonManager.init();
        TilesManager.init();
        Update.update();
    }
}
