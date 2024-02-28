package org.example.olamundo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXExercicio15 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox hbox = new HBox();
        MenuItem mi1 = new MenuItem("Opcion1");
        MenuItem mi2 = new MenuItem("Opcion2");
        ContextMenu cm = new ContextMenu(mi1,mi2);
        EventHandler<MouseEvent> ev = mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                cm.show((Node) mouseEvent.getSource(), mouseEvent.getScreenX(), mouseEvent.getScreenY());
            } else {
                cm.hide();
            }
        };
        hbox.addEventHandler(MouseEvent.MOUSE_CLICKED,ev);
        stage.setScene(new Scene(hbox,300,200));
        stage.show();
    }
}
