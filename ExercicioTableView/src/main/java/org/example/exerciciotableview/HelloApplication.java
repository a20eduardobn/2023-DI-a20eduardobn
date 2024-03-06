package org.example.exerciciotableview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {

        final ObservableList<Contacto> listaContactos = FXCollections.observableArrayList(
                new Contacto("Juan","Gomez","62456753","Nota de prueba")
        );

        TableView tableView = new TableView();
        TableColumn<Contacto, String> column1 = new TableColumn<>("Nome");
        column1.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Contacto, String> column2 = new TableColumn<>("Apelidos");
        column2.setCellValueFactory(new PropertyValueFactory<>("apelidos"));
        TableColumn<Contacto, String> column3 = new TableColumn<>("Telefono");
        column3.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        TableColumn<Contacto, String> column4 = new TableColumn<>("Notas");
        column4.setCellValueFactory(new PropertyValueFactory<>("notas"));
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.setItems(listaContactos);

        MenuBar mb = new MenuBar();
        Menu menu = new Menu("Ficheiro");
        MenuItem menuitem = new MenuItem("Novo...");

        mb.getMenus().add(menu);
        menu.getItems().add(menuitem);
        BorderPane bp = new BorderPane();
        bp.setTop(mb);
        bp.setCenter(tableView);
        Scene scene = new Scene(bp, 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}