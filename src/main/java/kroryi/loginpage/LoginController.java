package kroryi.loginpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    @FXML
    private TextField tfIdField;
    @FXML
    private PasswordField tfPwField;
    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private CommService commService;
    private LoginService loginService;

    public void setRoot(Parent root) {
        this.root = root;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void onLoginBtnClick(ActionEvent event) {
        System.out.println("로그인 버튼 실행");
        loginService = new LoginServiceImpl();

        switch (loginService.LoginProc(root)) {
            case 0:
                System.out.println("id가 없는 경우");
                break;
            case 1:
                System.out.println("아이디는 맞다");
                break;

            case 2:
                System.out.println("id,pw가 맞다.");
                break;

        }


    }


    @FXML
    protected void onRegisterBtnClick(ActionEvent event) throws IOException {
        System.out.println("회원가입 버튼 실행");
        commService = new CommonServiceImpl(stage);
        commService.showRegisterPage("register-view.fxml");

//        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register-view.fxml")));
//        stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
}