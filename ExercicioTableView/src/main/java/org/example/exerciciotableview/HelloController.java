package org.example.exerciciotableview;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Optional;

public class HelloController {
    public TextArea notaTextArea;
    public TextField nomeTextField;
    public TextField apelidosTextField;
    public TextField telefonoTextField;
    public void mostrarDialogoCrearContacto() {
        Dialog<ButtonType> dialog = new Dialog<>();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("dialogoNovoContacto.fxml"));
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
            ListaContactos.listaContactos.add(procesarResultados());
        }
    }
    public Contacto procesarResultados(){
        return new Contacto(nomeTextField.getText(), apelidosTextField.getText(),telefonoTextField.getText(),notaTextArea.getText());
    }
}