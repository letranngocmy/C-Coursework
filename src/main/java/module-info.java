module com.mycompany.assignment3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.assignment3 to javafx.fxml;
    exports com.mycompany.assignment3;
}
