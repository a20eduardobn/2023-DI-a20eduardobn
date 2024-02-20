package org.example.olamundo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class JavaFXExercicio5 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));
        gp.setPrefHeight(400);
        gp.setPrefWidth(275);
        gp.setAlignment(Pos.CENTER);

        Label lbl = new Label("Welcome");
        lbl.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,24));
        gp.add(lbl, 0,0);

        Label lbl1 = new Label("User name:");
        gp.add(lbl1,0,1);

        Label lbl2 = new Label("Password:");
        gp.add(lbl2,0,2);

        TextField tf = new TextField();
        gp.add(tf,1,1);

        TextField tf1 = new TextField();
        gp.add(tf1,1,2);

        HBox hb = new HBox();
        hb.setAlignment(Pos.BOTTOM_RIGHT);
        Button btnLogin = new Button("Login");
        btnLogin.setOnAction(actionEvent -> tf.setText("Pulsaches o boton"));
        hb.getChildren().add(btnLogin);

        gp.add(hb,0,3,2,1);

        Scene sc = new Scene(gp,400,300);
        stage.setScene(sc);
        stage.setTitle("Login");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
