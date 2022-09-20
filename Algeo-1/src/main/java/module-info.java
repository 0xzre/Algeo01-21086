module com.example.algeo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.algeo1 to javafx.fxml;
    exports com.example.algeo1;
}