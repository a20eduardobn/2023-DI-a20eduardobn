package org.example.olamundo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXExercicio16 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label lbl = new Label("Presiona un boton.");
        Button btn1 = new Button("Boton1");
        Button btn2 = new Button("Boton2");
        Button btn3 = new Button("Boton3");
        Button btn4 = new Button("Boton4");
        EventHandler<ActionEvent> evt = actionEvent -> lbl.setText(((Button)actionEvent.getSource()).getText()+" presionado.");
        btn1.addEventHandler(ActionEvent.ACTION,evt);
        btn2.addEventHandler(ActionEvent.ACTION,evt);
        btn3.addEventHandler(ActionEvent.ACTION,evt);
        btn4.addEventHandler(ActionEvent.ACTION,evt);
        VBox vbox = new VBox(lbl,btn1,btn2,btn3,btn4);
        vbox.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(vbox,300,200));
        stage.show();
    }
}
