module org.example.olamundo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.olamundo to javafx.fxml;
    exports org.example.olamundo;
}