package top.xinsin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;
/**
 * Created On 7/11/22 7:56 AM
 *
 * @author xinsin
 * @version 1.0.0
 */
public class ApplicationLaunch extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainView.fxml"))),600,250));
        stage.setTitle("xinsin auto card");
        stage.getIcons().add(new Image("/icon.png"));
        stage.show();
    }
}
