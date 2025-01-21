package kroryi.loginpage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommonServiceImpl implements CommService{
    private Stage stage;

    public CommonServiceImpl(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void showLoginPage(String fxmlURL) {
        Parent root;

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlURL));
        try{
            root = loader.load(); // fxml -> java 클래스로 변환
            LoginController loginController;
            loginController = loader.getController(); // fxml에서 로딩된 요소들을 제어 할 수 있도록 연결
            loginController.setRoot(root);
            loginController.setStage(stage);
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void showRegisterPage(String fxmlURL) {
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlURL));
        RegisterController registerController;
        try{
            root = loader.load();
            registerController = loader.getController();
            registerController.setRoot(root);
            registerController.setStage(stage);
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void showListPage(String fxmlURL) {
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlURL));
        ListController controller;
        try{
            root = loader.load();
            controller = loader.getController();
            controller.setRoot(root);
            controller.setStage(stage);
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
