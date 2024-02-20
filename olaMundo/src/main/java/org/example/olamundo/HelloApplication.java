package org.example.olamundo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private int clicks=0;
    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        Label lbl = new Label("Presiona o botón");
        lbl.setFont(Font.font("Arial",FontWeight.BOLD, FontPosture.REGULAR,19));
        lbl.setTextFill(Color.BLUE);
        Button btn = new Button("_Click");
        btn.setOnAction(actionEvent -> {
            clicks++;
            lbl.setText("Boton presionado "+clicks+" veces");}
        );

        Button exitBtn = new Button("_Salir");
        exitBtn.setTooltip(new Tooltip("Sair da aplicacion"));
        exitBtn.setOnAction(actionEvent -> Platform.exit());
        vbox.getChildren().add(lbl);
        vbox.getChildren().add(btn);
        vbox.getChildren().add(exitBtn);
        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Clicks");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}