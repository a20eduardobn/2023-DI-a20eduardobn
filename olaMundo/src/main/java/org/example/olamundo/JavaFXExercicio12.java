package org.example.olamundo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFXExercicio12 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label lbl = new Label("Escolle unha opcion");
        RadioButton rb1 = new RadioButton("Opcion 1");
        RadioButton rb2 = new RadioButton("Opcion 2");
        RadioButton rb3 = new RadioButton("Opcion 3");
        ToggleGroup tgroup = new ToggleGroup();
        tgroup.getToggles().addAll(rb1,rb2,rb3);
        tgroup.selectedToggleProperty().addListener((obs,oldT,newT) -> {
            if (newT!=null){
                lbl.setText("Escolliches a opcion "+((RadioButton) newT).getText());
            }
        });

        ToggleButton tbRojo = new ToggleButton("Vermello");
        ToggleButton tbVerde = new ToggleButton("Verde");
        ToggleButton tbAzul = new ToggleButton("Azul");
        ToggleGroup tgroupButtons = new ToggleGroup();
        tgroupButtons.getToggles().addAll(tbRojo,tbVerde,tbAzul);
        Rectangle rtc = new Rectangle(100,100, Color.WHITE);
        tgroupButtons.selectedToggleProperty().addListener((obs,oldT,newT) -> {
            if (newT!=null){
                switch (((ToggleButton)newT).getText()){
                    case "Vermello" ->rtc.setFill(Color.RED);
                    case "Verde"->rtc.setFill(Color.GREEN);
                    case "Azul"->rtc.setFill(Color.BLUE);
                    default -> rtc.setFill(Color.WHITE);
                }
            } else {
                rtc.setFill(Color.WHITE);
            }
        });
        Menu menu1 = new Menu("FirstMenu");
        menu1.getItems().add(new MenuItem("Funcion1"));
        Menu menu2 = new Menu("SecondMenu");
        menu2.getItems().add(new MenuItem("Funcion2"));
        MenuBar mbar = new MenuBar(menu1,menu2);
        VBox vbox = new VBox(lbl,rb1,rb2,rb3);
        HBox hbox = new HBox(rtc,tbRojo,tbAzul,tbVerde);
        Tab tb1 = new Tab("First");
        tb1.setContent(vbox);
        Tab tb2 = new Tab("Second");
        tb2.setContent(hbox);
        TabPane tbpane = new TabPane(tb1,tb2);
        VBox vboxOuter = new VBox();
        vboxOuter.getChildren().add(mbar);
        vboxOuter.getChildren().add(tbpane);
        Scene sc = new Scene(vboxOuter,300,200);
        stage.setScene(sc);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
