package kroryi.loginpage.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kroryi.loginpage.SceneManager;
import kroryi.loginpage.Service.CommService;
import kroryi.loginpage.Service.CommonServiceImpl;
import kroryi.loginpage.Dao.Member;
import kroryi.loginpage.Dao.MyDB;

import java.io.IOException;

public class RegisterController {
    @FXML private TextField tfNameField;
    @FXML private TextField tfIdField;
    @FXML private PasswordField pfPwField;
    @FXML private PasswordField pfPwReField;
    @FXML private TextField tfEmailField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setRoot(Parent root){
        this.root = root;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void onRegisterBtnClick(){
        System.out.println("회원가입 버튼 실행");
        String name = tfNameField.getText();
        String id = tfIdField.getText();
        String password = pfPwField.getText();
        String passwordRe = pfPwReField.getText();
        String email = tfEmailField.getText();

        if(name.isEmpty() || id.isEmpty() || password.isEmpty() || passwordRe.isEmpty() || email.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("검증 실패!!");
            alert.setContentText("빈 값을 채워 주세요.");
            alert.showAndWait();
        }


        if(!email.contains("@")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("검증 실패!!");
            alert.setContentText("메일 구성이 잘못 되었습니다.");
            alert.showAndWait();
        }

        Member newMember = new Member(name,id,password, email);
        System.out.println(newMember);

        MyDB.saveMember(newMember);

//        for(Member member:MyDB.getListMember()){
//            System.out.println(member.toString());
//        }

    }

    @FXML
    public void onGoToLoginBtnClick(ActionEvent event) throws IOException {
        System.out.println("로그인 페이지로 이동 클릭");
        SceneManager.switchScene("login-view.fxml","로그인 화면");
    }

    @FXML
    public void onGoToListBtnClick(ActionEvent event){
        System.out.println("목록 페이지로 이동 클릭");

        SceneManager.switchScene("list-view.fxml","목록보기 화면");


    }

}
