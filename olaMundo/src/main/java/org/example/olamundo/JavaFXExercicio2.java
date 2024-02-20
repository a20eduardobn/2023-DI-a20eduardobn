package org.example.olamundo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXExercicio2 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane fp = new FlowPane();
        fp.setHgap(5);
        fp.setVgap(5);
        for (int i = 1; i < 21; i++) {
            Button btn = new Button(""+i);
            fp.getChildren().add(btn);
        }
        Scene sc = new Scene(fp, 300, 200);
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
