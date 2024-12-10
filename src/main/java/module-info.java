module org.example.command {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.command to javafx.fxml;
    exports org.example.command;
}