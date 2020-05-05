package Start;

import javafx.application.*;
import javafx.util.*;
import javafx.event.*;
import javafx.animation.*;
import Engine.*;
import javafx.stage.*;
import Buttons.*;
import java.io.*;

public class Start extends Application
{
    private static Timeline timer;
    public static boolean fileChooser;
    
    static {
        Start.fileChooser = false;
    }
    
    public static void main(final String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(final Stage arg0) throws Exception {
        (Start.timer = new Timeline(new KeyFrame[] { new KeyFrame(Duration.seconds(0.029999999329447746), new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent event) {
                    if (Start.fileChooser) {
                        Start.this.chooseMap();
                    }
                }
            }, new KeyValue[0]) })).setCycleCount(-1);
        Start.timer.play();
        final Thread game = new Thread(() -> {
            Init.init();
            while (!Thread.currentThread().isInterrupted()) {
                Init.init();
            }
            return;
        });
        game.start();
    }
    
    public void chooseMap() {
        Start.fileChooser = false;
        final Stage stage = new Stage();
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une map");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("DAT", new String[] { "*.dat" }));
        final File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            LoadButton.path = file.getAbsolutePath();
        }
        stage.close();
        Start.timer.play();
    }
}
