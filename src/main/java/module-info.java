module kroryi.loginpage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens kroryi.loginpage to javafx.fxml;
    exports kroryi.loginpage;
    exports kroryi.loginpage.Controller;
    opens kroryi.loginpage.Controller to javafx.fxml;
    exports kroryi.loginpage.Service;
    opens kroryi.loginpage.Service to javafx.fxml;
    exports kroryi.loginpage.Dao;
    opens kroryi.loginpage.Dao to javafx.fxml;
}