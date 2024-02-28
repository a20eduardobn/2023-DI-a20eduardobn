module org.example.exerciciosjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.exerciciosjavafx to javafx.fxml;
    exports org.example.exerciciosjavafx;
}