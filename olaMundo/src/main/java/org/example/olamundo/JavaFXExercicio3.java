package org.example.olamundo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXExercicio3 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox hb = new HBox();
        hb.getChildren().add(new Button("Un"));
        hb.getChildren().add(new Button("Dous"));
        hb.getChildren().add(new Button("Tres"));
        hb.getChildren().add(new Button("Catro"));
        hb.setAlignment(Pos.TOP_CENTER);
        Scene sc = new Scene(hb, 300, 200);
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
