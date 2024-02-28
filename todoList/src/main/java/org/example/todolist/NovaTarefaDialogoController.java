package org.example.todolist;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.todolist.datamodel.Tarefa;
import org.example.todolist.datamodel.TarefasFicheiro;

public class NovaTarefaDialogoController {
    @FXML
    private TextField descricionField;
    @FXML
    private TextArea detallesArea;
    @FXML
    private DatePicker deadlineDate;

    public Tarefa procesarResultados(){
        Tarefa tarefa = new Tarefa(descricionField.getText(),detallesArea.getText(),deadlineDate.getValue());
        TarefasFicheiro.getInstance().engadirTarefa(tarefa);
        return tarefa;
    }
    public void initialize(){

    }
}
