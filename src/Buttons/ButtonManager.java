package Buttons;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.Display;

import Engine.Camera;
import Graphics.Colors;
import Graphics.Quads;
import Graphics.TextureLoader;

public class ButtonManager
{
    protected static List<Button> buttons;
    
    static {
        ButtonManager.buttons = new ArrayList<Button>();
    }
    
    public static void init() {
        ButtonManager.buttons.add(new ExitButton(null, (float)(Display.getWidth() - Display.getWidth() / 12), 0.0f, (float)(Display.getWidth() / 12), (float)(Display.getHeight() / 50), null, 0.0f, false, false));
        ButtonManager.buttons.add(new GridButton(null, 0.0f, 0.0f, (float)(Display.getWidth() / 12), (float)(Display.getHeight() / 50), null, 0.0f, false, false));
        ButtonManager.buttons.add(new HitboxButton(null, (float)(0 + Display.getWidth() / 12), 0.0f, (float)(Display.getWidth() / 12), (float)(Display.getHeight() / 50), null, 0.0f, false, false));
        ButtonManager.buttons.add(new InformationButton(null, (float)(0 + Display.getWidth() / 12 * 2), 0.0f, (float)(Display.getWidth() / 12), (float)(Display.getHeight() / 50), null, 0.0f, false, false));
        ButtonManager.buttons.add(new SolidButton(null, (float)(0 + Display.getWidth() / 12 * 3), 0.0f, (float)(Display.getWidth() / 12), (float)(Display.getHeight() / 50), null, 0.0f, false, false));
        ButtonManager.buttons.add(new DragButton(null, (float)(0 + Display.getWidth() / 12 * 4), 0.0f, (float)(Display.getWidth() / 12), (float)(Display.getHeight() / 50), null, 0.0f, false, false));
        ButtonManager.buttons.add(new TextureButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50), (float)(Display.getWidth() / 12), (float)(Display.getHeight() / 50), null, 0.0f, false, false));
        ButtonManager.buttons.add(new SkyBoxButton(null, (float)(Display.getWidth() / 12), (float)(Display.getHeight() - Display.getHeight() / 50), (float)(Display.getWidth() / 12), (float)(Display.getHeight() / 50), null, 0.0f, false, false));
        ButtonManager.buttons.add(new ExportButton(null, (float)(0 + Display.getWidth() / 12 * 5), 0.0f, (float)(Display.getWidth() / 12), (float)(Display.getHeight() / 50), null, 0.0f, false, false));
        ButtonManager.buttons.add(new LoadButton(null, (float)(Display.getWidth() - Display.getWidth() / 12), (float)(Display.getHeight() - Display.getHeight() / 50), (float)(Display.getWidth() / 12), (float)(Display.getHeight() / 50), null, 0.0f, false, false));
        ButtonManager.buttons.add(new OptionButton(TextureLoader.option, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new AddWidthSizeButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new RemoveWidthSizeButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new LeftRotationButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new RightRotationButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new AddHeightSizeButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new RemoveHeightSizeButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new LightButton(null, (float)(Display.getWidth() / 12 * 2), (float)(Display.getHeight() - Display.getHeight() / 50), (float)(Display.getWidth() / 12), (float)(Display.getHeight() / 50), null, 0.0f, false, false));
        ButtonManager.buttons.add(new AddRedButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new RemoveRedButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new AddGreenButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new RemoveGreenButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new AddBlueButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new RemoveBlueButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new AddLightSizeButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
        ButtonManager.buttons.add(new RemoveLightSizeButton(null, 0.0f, (float)(Display.getHeight() - Display.getHeight() / 50 - 50), 50.0f, 50.0f, null, 0.0f, false, false));
    }
    
    public static void update() {
        TextureLoader.defaults.bind();
        Quads.QuadS((float)(-Camera.ScrollX), (float)(-Camera.ScrollY), (float)Display.getWidth(), (float)(Display.getHeight() / 50), Colors.dgray, 0.0f);
        Quads.QuadS((float)(-Camera.ScrollX), (float)(-Camera.ScrollY + Display.getHeight() - Display.getHeight() / 50), (float)Display.getWidth(), (float)(Display.getHeight() / 50), Colors.dgray, 0.0f);
        for (final Button b : ButtonManager.buttons) {
            b.update();
            b.render();
        }
    }
}
