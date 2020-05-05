package Engine;

import org.lwjgl.input.*;

public class KeyboardShortcut
{
    private static boolean f1;
    private static boolean f2;
    private static boolean f3;
    private static boolean l;
    public static boolean grid;
    public static boolean hitbox;
    public static boolean info;
    public static boolean light;
    
    public static void update() {
        if (Keyboard.isKeyDown(59) && !KeyboardShortcut.f1) {
            KeyboardShortcut.f1 = true;
            if (KeyboardShortcut.grid) {
                KeyboardShortcut.grid = false;
            }
            else {
                KeyboardShortcut.grid = true;
            }
        }
        if (Keyboard.isKeyDown(59)) {
            KeyboardShortcut.f1 = true;
        }
        else {
            KeyboardShortcut.f1 = false;
        }
        if (Keyboard.isKeyDown(60) && !KeyboardShortcut.f2) {
            KeyboardShortcut.f2 = true;
            if (KeyboardShortcut.hitbox) {
                KeyboardShortcut.hitbox = false;
            }
            else {
                KeyboardShortcut.hitbox = true;
            }
        }
        if (Keyboard.isKeyDown(60)) {
            KeyboardShortcut.f2 = true;
        }
        else {
            KeyboardShortcut.f2 = false;
        }
        if (Keyboard.isKeyDown(61) && !KeyboardShortcut.f3) {
            KeyboardShortcut.f3 = true;
            if (KeyboardShortcut.info) {
                KeyboardShortcut.info = false;
            }
            else {
                KeyboardShortcut.info = true;
            }
        }
        if (Keyboard.isKeyDown(61)) {
            KeyboardShortcut.f3 = true;
        }
        else {
            KeyboardShortcut.f3 = false;
        }
        if (Keyboard.isKeyDown(38) && !KeyboardShortcut.l) {
            KeyboardShortcut.l = true;
            if (KeyboardShortcut.light) {
                KeyboardShortcut.light = false;
            }
            else {
                KeyboardShortcut.light = true;
            }
        }
        if (Keyboard.isKeyDown(38)) {
            KeyboardShortcut.l = true;
        }
        else {
            KeyboardShortcut.l = false;
        }
    }
}
