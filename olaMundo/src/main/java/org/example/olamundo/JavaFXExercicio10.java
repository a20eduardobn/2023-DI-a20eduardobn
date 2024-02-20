package org.example.olamundo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class JavaFXExercicio10 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        DatePicker dp = new DatePicker();
        Label lbl = new Label("Escolle unha data");
        dp.setOnAction(actionEvent -> lbl.setText(dp.getValue().format(DateTimeFormatter.ofPattern("dd / MMMM / yyyy"))));
        Scene sc = new Scene(new VBox(dp,lbl),300,200);
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
