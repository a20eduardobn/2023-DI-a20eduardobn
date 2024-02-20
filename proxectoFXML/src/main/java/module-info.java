module org.example.proxectofxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.proxectofxml to javafx.fxml;
    exports org.example.proxectofxml;
}