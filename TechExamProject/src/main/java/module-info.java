module com.techexamproject.techexamproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.techexamproject.techexamproject to javafx.fxml;
    exports com.techexamproject.techexamproject;
}