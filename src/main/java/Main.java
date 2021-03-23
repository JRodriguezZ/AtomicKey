import controller.Village;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("fxml/gameWindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Hello World");

        stage.setResizable(false);

        Scene sc = new Scene(root);

        Village village = loader.getController();
        village.setScene(sc);
        stage.setScene(sc);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

