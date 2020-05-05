package Tiles;

import Engine.*;
import java.util.*;

public class TilesButtonManager
{
    public static List<TilesButton> Tbut;
    public static List<SkyBoxBut> skyBoxbut;
    
    static {
        TilesButtonManager.Tbut = new ArrayList<TilesButton>();
        TilesButtonManager.skyBoxbut = new ArrayList<SkyBoxBut>();
    }
    
    public static void update() {
        for (final TilesButton t : TilesButtonManager.Tbut) {
            if (Update.activate) {
                t.update();
                t.render();
            }
        }
        for (final SkyBoxBut t2 : TilesButtonManager.skyBoxbut) {
            if (Update.skyActivate) {
                t2.update();
                t2.render();
            }
        }
    }
}
