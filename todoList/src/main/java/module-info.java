module org.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.todolist to javafx.fxml;
    exports org.example.todolist;
    exports org.example.todolist.datamodel;
    opens org.example.todolist.datamodel to javafx.fxml;
}