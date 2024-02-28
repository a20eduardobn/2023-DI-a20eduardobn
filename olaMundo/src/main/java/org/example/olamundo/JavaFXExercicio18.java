package org.example.olamundo;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXExercicio18 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Slider sl = new Slider(0,1,0);

        ProgressBar pb = new ProgressBar(0);
        pb.setPrefWidth(200);
        pb.progressProperty().bindBidirectional(sl.valueProperty());
        VBox vbox = new VBox(sl,pb);
        stage.setScene(new Scene(vbox,300,200));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
