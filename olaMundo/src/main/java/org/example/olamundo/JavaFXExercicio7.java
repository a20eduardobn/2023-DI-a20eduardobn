package org.example.olamundo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXExercicio7 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox();
        CheckBox check = new CheckBox("Click");
        Label lbl = new Label("Deseleccionada");
        check.setOnAction(actionEvent -> {if (check.isSelected())lbl.setText("Seleccionada"); else lbl.setText("Deseleccionada");});
        Scene sc = new Scene(box, 300, 200);
        box.getChildren().add(check);
        box.getChildren().add(lbl);
        stage.setScene(sc);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10,10,10,10));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
