module org.example.exerciciotableview {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.exerciciotableview to javafx.fxml;
    exports org.example.exerciciotableview;
}