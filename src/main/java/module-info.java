module kroryi.loginpage {
    requires javafx.controls;
    requires javafx.fxml;


    opens kroryi.loginpage to javafx.fxml;
    exports kroryi.loginpage;
}