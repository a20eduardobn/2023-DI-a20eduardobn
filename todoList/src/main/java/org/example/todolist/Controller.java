package org.example.todolist;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import org.example.todolist.datamodel.Tarefa;
import org.example.todolist.datamodel.TarefasFicheiro;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private TextArea areaInfoTarefa;
    @FXML
    private Label labelTextoData;
    @FXML
    private Label labelDataLimite;
    @FXML
    private ListView<Tarefa> tarefasListView;
    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private void mostrarTarefa() {
        Tarefa tarefa = tarefasListView.getSelectionModel().getSelectedItem();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String dataFormateada = dtf.format(tarefa.getDataLimite());
        labelDataLimite.setText(dataFormateada);
        areaInfoTarefa.setText(tarefa.getDetalles());
    }

    @FXML
    private void mostrarDialogoNovaTarefa() {
        Dialog<ButtonType> dialog = new Dialog<>();
        // por defecto, un diálogo é modal
        // polo que non permitirá interaccionar con outras ventá
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        // engade o código para establecer o título “Engadir nova tarefa” ao diálogo
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("novaTarefaDialogo.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Non se puido cargar o diálogo");
            e.printStackTrace();
            return;
        }
        // engadir os botóns
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            NovaTarefaDialogoController controladorDialogo = fxmlLoader.getController();
            Tarefa tarefa = controladorDialogo.procesarResultados();
            tarefasListView.getItems().setAll(TarefasFicheiro.getInstance().getTarefas());
            tarefasListView.getSelectionModel().select(tarefa);
        }
    }


    @FXML
    private void sairAplicacion() {
        Platform.exit();
    }

    public void initialize() {
        tarefasListView.getItems().setAll(TarefasFicheiro.getInstance().getTarefas());
        areaInfoTarefa.setWrapText(true);
        tarefasListView.getSelectionModel().selectedItemProperty().addListener(observable -> mostrarTarefa());
        tarefasListView.getSelectionModel().select(0);
    }


}