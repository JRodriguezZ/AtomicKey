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
    public void start(Stage primaryStage) throws Exception{
        AnchorPane root = FXMLLoader.load(getClass().getResource("fxml/gameWindow.fxml"));
        primaryStage.setTitle("Hello World");

        ImageView imageView = new ImageView();
        root.getChildren().add(imageView);
//        imageView.setImage(new Image("images/villageBackground.gif"));
        primaryStage.setResizable(false);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {

        Random r = new Random();
        char c = (char)(r.nextInt('z' - 'a') + 'a');

        launch(args);
    }
}

