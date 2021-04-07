import controller.Menu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/menuWindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Anele saves the village");

        stage.setResizable(false);

        Scene sc = new Scene(root);

        Menu menu = loader.getController();
        menu.setScene(sc);
        stage.setScene(sc);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

