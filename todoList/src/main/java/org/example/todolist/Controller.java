package org.example.todolist;

import javafx.application.Platform;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import org.example.todolist.datamodel.Tarefa;
import org.example.todolist.datamodel.TarefasFicheiro;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;


public class Controller {

    @FXML
    private Button btnToolbarNuevo;
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

    private ContextMenu listContextMenu;

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
            tarefasListView.getSelectionModel().select(tarefa);
        }
    }

    private void mostrarDialogoEditarTarefa(Tarefa tarefa) {
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
        NovaTarefaDialogoController controladorDialogo = fxmlLoader.getController();
        controladorDialogo.inicializarCampos(tarefa);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            TarefasFicheiro.getInstance().borrarTarefa(tarefa);
            tarefa = controladorDialogo.procesarResultados();
            tarefasListView.getSelectionModel().select(tarefa);
        }
    }


    @FXML
    private void sairAplicacion() {
        Platform.exit();
    }

    public void initialize() {
        SortedList<Tarefa> tarefasOrdenadas = new SortedList<>(TarefasFicheiro.getInstance().getTarefas());
        tarefasOrdenadas.setComparator(new Comparator<Tarefa>() {
            @Override
            public int compare(Tarefa tarefa, Tarefa t1) {
                if (tarefa.getDataLimite().isBefore(t1.getDataLimite())){
                    return -1;
                } else if (tarefa.getDataLimite().equals(t1.getDataLimite())){
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        tarefasListView.setItems(tarefasOrdenadas);
        areaInfoTarefa.setWrapText(true);
        tarefasListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        mostrarTarefa();
                    }
                });
        tarefasListView.getSelectionModel().select(0);
        tarefasListView.setCellFactory(new Callback<ListView<Tarefa>, ListCell<Tarefa>>() {
            @Override
            public ListCell<Tarefa> call(ListView<Tarefa> p) {
                ListCell<Tarefa> cela = new ListCell<>() {
                    // este método execútase cada vez que se repinta unha cela

                    @Override
                    protected void updateItem(Tarefa t, boolean empty) {
                        // execútase o método da clase ancestra para manter o estilo
                        // e comportamento por defecto
                        super.updateItem(t, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(t.getDescricion());
                            if (t.getDataLimite().isBefore(LocalDate.now()) || t.getDataLimite().equals(LocalDate.now())) {
                                setTextFill(Color.RED);
                            } else if (t.getDataLimite().equals(LocalDate.now().plusDays(1))){
                                setTextFill(Color.BLUE);
                            } else {
                                setTextFill(Color.BLACK);
                            }

                        }
                    }
                };

                cela.emptyProperty().addListener(((obs, wasEmpty, isNowEmpty) -> {
                    if (isNowEmpty) {
                        cela.setContextMenu(null);
                    } else {
                        cela.setContextMenu(listContextMenu);
                    }
                }));
                return cela;
            }
        });

        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Borrar");
        deleteMenuItem.setOnAction(actionEvent -> borrarTarefa(tarefasListView.getSelectionModel().getSelectedItem()));
        MenuItem editMenuItem = new MenuItem("Editar");
        editMenuItem.setOnAction(actionEvent -> mostrarDialogoEditarTarefa(tarefasListView.getSelectionModel().getSelectedItem()));
        listContextMenu.getItems().addAll(editMenuItem,deleteMenuItem);
        tarefasListView.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                borrarTarefa(tarefasListView.getSelectionModel().getSelectedItem());
            }
        });

        btnToolbarNuevo.setTooltip(new Tooltip("Crear unha nova tarefa"));

        Image img = new Image(getClass().getResourceAsStream("/images/New16.gif"));
        ImageView view = new ImageView(img);
        btnToolbarNuevo.setGraphic(view);
    }


    private void borrarTarefa(Tarefa tarefa) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Borrar tarefa");
        alert.setHeaderText("Borrar tarefa: " + tarefa.getDescricion());
        alert.setContentText("Desexa eliminar a tarefa? Pulse Ok para confirmar ou Cancel en caso contrario");
        Optional<ButtonType> resultado = alert.showAndWait();
        if (resultado.isPresent() && (resultado.get() == ButtonType.OK)) {
            TarefasFicheiro.getInstance().borrarTarefa(tarefa);
        }
    }
}