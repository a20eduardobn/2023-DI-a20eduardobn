package org.example.todolist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.todolist.datamodel.TarefasFicheiro;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ventaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 360);
        stage.setTitle("Lista tarefas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() {
        try {
            TarefasFicheiro.getInstance().gardarTarefas();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() {
        try {
            TarefasFicheiro.getInstance().lerTarefas();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}