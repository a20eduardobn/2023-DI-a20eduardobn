package org.example.olamundo;

import javafx.application.Application;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class JavaFXExercicio20 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Slider sl = new Slider(0,100,0);
        sl.showTickLabelsProperty();
        sl.showTickMarksProperty();
        String[] images = new String[4];
        images[0] = this.getClass().getResource("/mute.png").toString();
        images[1] = this.getClass().getResource("/volumeLow.png").toString();
        images[2] = this.getClass().getResource("/volumeMid.png").toString();
        images[3] = this.getClass().getResource("/volumeHigh.png").toString();

        ImageView iv = new ImageView();
    }

    public static void main(String[] args) {
        launch();
    }
}
