package kroryi.loginpage;

import javafx.stage.Stage;
import kroryi.loginpage.Dao.MyDB;
import kroryi.loginpage.Service.CommService;
import kroryi.loginpage.Service.CommonServiceImpl;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage){
        MyDB myDB = new MyDB(); // 단일 인스턴스 사용

        try{
//            CommService commService = new CommonServiceImpl(stage);
//            commService.showExamplePage("example.fxml");;
//            commService.showLoginPage("login-view.fxml");
//            commService.showListPage("list-view.fxml");
            SceneManager.setPrimaryStage(stage);
//            SceneManager.switchScene("example.fxml","셈플");
            SceneManager.switchScene("login-view.fxml","셈플");


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}