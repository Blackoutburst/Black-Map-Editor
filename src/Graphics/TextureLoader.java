package Graphics;

import org.newdawn.slick.opengl.*;
import Engine.*;

public class TextureLoader
{
    public static Texture texture;
    public static Texture none;
    public static Texture defaults;
    public static Texture option;
    public static Texture addSize;
    public static Texture removeSize;
    public static Texture rotationLeft;
    public static Texture rotationRight;
    
    public static void load() {
        TextureLoader.texture = Loader.loadPNG("res/texture");
        TextureLoader.none = Loader.loadPNG("res/null");
        TextureLoader.defaults = Loader.loadPNG("res/tile");
        TextureLoader.option = Loader.loadPNG("res/option");
        TextureLoader.addSize = Loader.loadPNG("res/addSize");
        TextureLoader.removeSize = Loader.loadPNG("res/removeSize");
        TextureLoader.rotationLeft = Loader.loadPNG("res/rotationLeft");
        TextureLoader.rotationRight = Loader.loadPNG("res/rotationRight");
    }
}
