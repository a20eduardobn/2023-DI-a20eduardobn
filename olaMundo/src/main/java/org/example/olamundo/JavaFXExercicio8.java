package org.example.olamundo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXExercicio8 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox vbox = new VBox();
        Label lblSelected = new Label("Selecciona un valor");
        ChoiceBox<String> choice = new ChoiceBox<>();
        choice.getItems().add("Opcion 1");
        choice.getItems().add("Opcion 2");
        choice.getItems().add("Opcion 3");
        choice.setOnAction(action -> lblSelected.setText(choice.getValue()));
        Scene sc = new Scene(vbox, 300, 200);
        vbox.getChildren().add(lblSelected);
        vbox.getChildren().add(choice);
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
