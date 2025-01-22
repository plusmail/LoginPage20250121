package kroryi.loginpage;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;

public class MenuManager {
    private static MenuBar menuBar;

    public static MenuBar getMenuBar(){
        if(menuBar == null){
            try{
                FXMLLoader loader = new FXMLLoader(MenuManager.class.getResource("menu-bar.fxml"));
                menuBar = loader.load();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return menuBar;
    }
}
