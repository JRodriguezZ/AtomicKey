import controller.Menu;
import controller.Village;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader;
        //loader = new FXMLLoader(getClass().getResource("fxml/gameWindow.fxml"));
        loader = new FXMLLoader(getClass().getResource("fxml/menuWindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Hello World");

        stage.setResizable(false);

        Scene sc = new Scene(root);

        //Village village = loader.getController();
        //village.setScene(sc);
        Menu menu = loader.getController();
        menu.setScene(sc);
        stage.setScene(sc);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

