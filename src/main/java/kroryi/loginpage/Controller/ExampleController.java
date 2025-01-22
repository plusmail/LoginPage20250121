package kroryi.loginpage.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import kroryi.loginpage.Service.CommService;
import kroryi.loginpage.Service.CommonServiceImpl;
import kroryi.loginpage.Service.LoginService;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ExampleController implements Initializable {

    @FXML private ImageView dogImageView;
    @FXML private Button dogChangeBtn;

    @FXML private ColorPicker colorPicker;
    @FXML private Circle circle;
    @FXML private Slider slider;
    @FXML private Label valueLabel;

    @FXML private TextArea textArea;
    @FXML private ScrollBar vScrollBar;


    private List<Image> images;
    private Timeline timeline;

    private boolean isImage1 = true;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private CommService commService;
    private LoginService loginService;

    private int currentIndex = 0;

    public void setRoot(Parent root) {
        this.root = root;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        images = new ArrayList<>();
        images.add(new Image(Objects.requireNonNull(getClass().getResource("/images/dog1.jpg")).toExternalForm()));
        images.add(new Image(Objects.requireNonNull(getClass().getResource("/images/dog2.jpg")).toExternalForm()));
        images.add(new Image(Objects.requireNonNull(getClass().getResource("/images/dog3.jpg")).toExternalForm()));
        images.add(new Image(Objects.requireNonNull(getClass().getResource("/images/dog4.jpg")).toExternalForm()));
//        URL resource = getClass().getResource("/images/dog1.jpg");
//        if (resource == null) {
//            System.err.println("Resource not found: /images/dog1.jpg");
//        }
//        images.add(new Image(Objects.requireNonNull(resource).toExternalForm()));


        dogImageView.setImage(images.get(0));
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> switchImage())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        circle.setFill(Color.BLUE);

        colorPicker.setOnAction(event -> {
            Color selectedColor = colorPicker.getValue();
            circle.setFill(selectedColor);
        });

        slider.setValue(50);
        circle.setRadius(slider.getValue());

        valueLabel.setText(String.format("%.1f", slider.getValue()));

        slider.valueProperty().addListener( (observable, oldValue, newValue    )->{
            circle.setRadius(newValue.doubleValue());
            valueLabel.setText(String.format("%.1f", newValue.doubleValue()));
        } );
/// //

        Bounds sceneBounds = textArea.localToScene(textArea.getBoundsInLocal());
        System.out.println("TextArea Scene X: " + sceneBounds.getMinX());
        System.out.println("TextArea Scene Y: " + sceneBounds.getMinY());

        vScrollBar.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
//                dogImageView.setLayoutY(-new_val.doubleValue());
//                circle.setLayoutY(-new_val.doubleValue());
//                textArea.setLayoutY(sceneBounds.getMinY()-new_val.doubleValue());
                root.setLayoutY(-new_val.doubleValue());
            }
        });
    }




    private void switchImage(){
        currentIndex = (currentIndex + 1) % images.size();
        dogImageView.setImage(images.get(currentIndex));
    }


    @FXML
    private void handleChangeImage(){
        System.out.println("이미지 변경 실행");
        String imagePath = isImage1 ? "images/dog1.jpg" : "images/dog2.jpg";

//        getClass().getResource(imagePath) 현재의 클래스를 로딩 지정된 경로를 문자열로 넣어준다. 리소스(이미지)를 찾는다.
//        Objects.requireNonNull( xxxxxx  ) xxxxx가 값이 Null인지 체크 해준다.
//        toExternalForm() 파일의 시스템 실제 경로롤 반환 file://C:/User/xxxxx/xxxxxx/xxxx/images/dog1.jpg
//        Image newImage = new Image(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());

        loadImage(imagePath);
        isImage1 = !isImage1;
    }

    private void loadImage(String imagePath){
        URL resource = getClass().getResource(imagePath);
        if(resource == null){
//            throw new IllegalArgumentException("리소스 자원 못찾음" + imagePath);
            System.err.println("이미지 없음. 경로 확인:" + imagePath);
        }
        assert resource != null;
        Image newImage = new Image(resource.toExternalForm());
        dogImageView.setImage(newImage);
    }


    @FXML
    public void handlerStartAnimation(){
        System.out.println("시작 에니!!");

        if(timeline != null){
            timeline.play();
        }

    }

    @FXML
    public void handlerStopAnimation(){
        System.out.println("중지 에니!!");
        if(timeline != null){
            timeline.stop();
        }

    }

    @FXML
    public void handlerBoardListAction(){
        System.out.println("메뉴->목록보기 실행");
        try{
            CommService commService = new CommonServiceImpl(stage);
            commService.showListPage("list-view.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
