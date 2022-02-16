module com.cashierapp.cashier {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;


    opens com.cashierapp.cashier to javafx.fxml;
    exports com.cashierapp.cashier;
}