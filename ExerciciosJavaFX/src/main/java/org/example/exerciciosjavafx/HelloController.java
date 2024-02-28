package org.example.exerciciosjavafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public TextField userField;
    @FXML
    public TextField passwdField;
    @FXML
    private Label welcomeText;
    @FXML
    private Label userText;
    @FXML
    private Label passwdText;
    @FXML
    private Button buttonLogin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,24));
    }
}