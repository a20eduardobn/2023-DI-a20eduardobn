package org.example.olamundo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXExercicio11 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ColorPicker cp = new ColorPicker();
        Label lbl = new Label("Texto de cor");
        cp.setOnAction(actionEvent -> lbl.setTextFill(cp.getValue()));
        VBox vbox = new VBox(cp,lbl);
        Scene sc = new Scene(vbox, 300, 200);
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
