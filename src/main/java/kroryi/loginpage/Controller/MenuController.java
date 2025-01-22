package kroryi.loginpage.Controller;

import javafx.fxml.FXML;
import kroryi.loginpage.SceneManager;

public class MenuController {

    @FXML
    public void handlerBoardListAction(){
        System.out.println("게시판 목록보기");
        SceneManager.switchScene("list-view.fxml","목록보기 화면");

    }

    @FXML
    public void handlerExitAction(){
        System.out.println("프로그램 종료");
        System.exit(0);
    }
}
