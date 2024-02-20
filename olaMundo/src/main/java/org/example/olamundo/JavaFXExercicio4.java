package org.example.olamundo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFXExercicio4 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane ap = new AnchorPane();
        Button btn = new Button("Boton");
        ap.getChildren().add(btn);
        AnchorPane.setBottomAnchor(btn,10.0);
        AnchorPane.setRightAnchor(btn,10.0);
        Scene sc = new Scene(ap, 300, 200);
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
