package org.example.olamundo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFXExercicio14 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Rectangle rec = new Rectangle(50,100, Color.AQUA);
        EventHandler<MouseEvent> evH = mouseEvent -> {
            System.out.println(mouseEvent.getTarget());
            System.out.println(mouseEvent.getSource());
            System.out.println(mouseEvent.getEventType());
            System.out.println(mouseEvent.getSceneX());
            System.out.println(mouseEvent.getSceneY());
        };
        rec.addEventHandler(MouseEvent.MOUSE_CLICKED,evH);
        VBox vbox = new VBox(rec);
        vbox.addEventHandler(MouseEvent.MOUSE_CLICKED,evH);
        stage.setScene(new Scene(vbox,300,200));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
