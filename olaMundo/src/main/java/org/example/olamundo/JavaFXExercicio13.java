package org.example.olamundo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFXExercicio13 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Rectangle rtg = new Rectangle(100,150, Color.AQUA);
        VBox vBox = new VBox(rtg);
        Pane pane = new Pane(rtg);
        
        Scene sc = new Scene(vBox,300,200);
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
