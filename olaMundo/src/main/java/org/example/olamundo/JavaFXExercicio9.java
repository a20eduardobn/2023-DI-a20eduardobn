package org.example.olamundo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXExercicio9 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        HBox hbox = new HBox();
        ProgressBar pg = new ProgressBar();
        Button btnUp = new Button("Aumentar");
        Button btnDown = new Button("Disminuir");
        pg.setProgress(0);
        btnUp.setOnAction(actionEvent -> {if (pg.getProgress()<0.9)pg.setProgress(pg.getProgress()+0.1);});
        btnDown.setOnAction(actionEvent -> {if (pg.getProgress()>0.0)pg.setProgress(pg.getProgress()-0.1);});
        hbox.getChildren().add(pg);
        hbox.getChildren().add(btnUp);
        hbox.getChildren().add(btnDown);
        Scene sc = new Scene(hbox,300,200);
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
