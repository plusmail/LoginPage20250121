package kroryi.loginpage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage){
        MyDB myDB = new MyDB(); // 단일 인스턴스 사용

        try{
            CommService commService = new CommonServiceImpl(stage);
            commService.showLoginPage("login-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}