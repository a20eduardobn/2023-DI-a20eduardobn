package org.example.olamundo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFXExercicio6 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gp = new GridPane();

        TextField txtName = new TextField();
        TextField txtAddress = new TextField();
        TextField txtOccup = new TextField();

        Label lblName = new Label("_Nome:");
        lblName.setMnemonicParsing(true);
        lblName.setLabelFor(txtName);
        Label lblAddress = new Label("_Enderezo:");
        lblAddress.setMnemonicParsing(true);
        lblAddress.setLabelFor(txtAddress);
        Label lblOccup = new Label("_Ocupación:");
        lblOccup.setMnemonicParsing(true);
        lblOccup.setLabelFor(txtOccup);

        gp.add(lblName,0,0);
        gp.add(lblAddress,0,1);
        gp.add(lblOccup,0,2);
        gp.add(txtName,1,0);
        gp.add(txtAddress,1,1);
        gp.add(txtOccup,1,2);
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(10,10,10,10));
        Scene sc = new Scene(gp,300,200);
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
