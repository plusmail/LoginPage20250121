package kroryi.loginpage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SceneManager {

    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage){
        primaryStage = stage;
    }

    public static void switchScene(String fxmlPath, String title){
        try{
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlPath));
            Parent root = loader.load();

//            root.setTop(MenuManager.getMenuBar()); 지원 않함.
            // BorderPane로 대체해서 사용
            if( root instanceof BorderPane){
                BorderPane borderPane = (BorderPane) root;
                borderPane.setTop(MenuManager.getMenuBar());
            }

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle(title);
            primaryStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
