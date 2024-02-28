package org.example.olamundo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXExercicio17 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button btn1 = new Button("ChoiceDialog");
        ChoiceDialog<String> cd = new ChoiceDialog<>("Amarelo","Vermello","Azul","Verde");
        btn1.setOnAction(actionEvent -> {
            cd.show();
            cd.setOnCloseRequest(dialogEvent -> System.out.println(cd.getSelectedItem()));
        });
        ImageView iv = new ImageView(this.getClass().getResource("/warning.png").toString());
        iv.setFitHeight(80);
        iv.setFitWidth(80);
        cd.setGraphic(iv);
        Button btn2 = new Button("Error");
        Alert alertError = new Alert(Alert.AlertType.ERROR);
        alertError.setContentText("Texto do contido");
        alertError.setHeaderText("Texto da cabeceira");
        alertError.setTitle("Titulo");
        btn2.setOnAction(actionEvent -> alertError.show());
        Button btn3 = new Button("Information");
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION, "Esta é unha alerta informativa.");
        btn3.setOnAction(actionEvent -> alertInfo.show());
        Button btn4 = new Button("Warning");
        Alert alertWarning = new Alert(Alert.AlertType.WARNING, "Esta é unha advertencia");
        btn4.setOnAction(actionEvent -> alertWarning.show());
        Button btn5 = new Button("TextInputDialog");
        TextInputDialog tid = new TextInputDialog("Escribe un texto");
        btn5.setOnAction(actionEvent -> {
            tid.show();
            tid.setOnCloseRequest(dialogEvent -> System.out.println(tid.getEditor().getText()));
        });
        VBox vbox = new VBox(btn1,btn2,btn3,btn4,btn5);
        stage.setScene(new Scene(vbox,300,200));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
