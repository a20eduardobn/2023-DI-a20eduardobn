package org.example.olamundo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXExercicio19 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        tf1.textProperty().bindBidirectional(tf2.textProperty());
        VBox vbox = new VBox(tf1,tf2);
        stage.setScene(new Scene(vbox,300,200));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
