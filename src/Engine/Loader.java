package Engine;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Loader
{
    public static Audio sound;
    public static TrueTypeFont text;
    public static TrueTypeFont textCustom;
    public static Clip clip;
    public static Music song;
    
    public static Texture loadPNG(final String filepath) {
        Texture texture = null;
        try {
            texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(String.valueOf(filepath) + ".png"));
        }
        catch (Exception ex) {}
        return texture;
    }
    
    public static void loadSongOGG(final String filepath) {
        try {
            (Loader.song = new Music(String.valueOf(filepath) + ".ogg")).play(1.0f, 1.0f);
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
    }
    
    public void loadSongWAV(final String filepath) {
        try {
            Throwable t = null;
            try {
                final InputStream in = this.getClass().getResourceAsStream(String.valueOf(filepath) + ".wav");
                try {
                    final InputStream bufferedIn = new BufferedInputStream(in);
                    try {
                        final AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn);
                        try {
                            final Clip clip = AudioSystem.getClip();
                            clip.open(audioIn);
                            clip.setFramePosition(0);
                            clip.start();
                        }
                        finally {
                            if (audioIn != null) {
                                audioIn.close();
                            }
                        }
                    }
                    finally {}
                }
                finally {
                    if (in != null) {
                        in.close();
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
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void playSoundOGG(final String filepath) {
        try {
            (Loader.sound = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream(String.valueOf(filepath) + ".ogg"))).playAsSoundEffect(1.0f, 1.0f, false);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void loadDefaultFont() {
        final Font awtFont = new Font("default", 1, 16);
        Loader.text = new TrueTypeFont(awtFont, true);
    }
    
    public static void loadFont(final String filepath) {
        try {
            final InputStream inputStream = ResourceLoader.getResourceAsStream(filepath);
            Font awtFont = Font.createFont(0, inputStream);
            awtFont = awtFont.deriveFont(50.0f);
            Loader.text = new TrueTypeFont(awtFont, true);
        }
        catch (Exception ex) {}
    }
}
