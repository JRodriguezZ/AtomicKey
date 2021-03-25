package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {
    @FXML Button playbutton, marcadorbutton, salirbutton;
    @FXML AnchorPane menuAnchorPane;
    @FXML ImageView menubackground;
    private Scene scene;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menubackground.setImage(new Image("images/villa.png"));
    }

    public void playaction(ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/gameWindow.fxml"));
            AnchorPane anchorPane = loader.load();
            menuAnchorPane.getChildren().add(anchorPane);

            Village village = loader.getController();
            village.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void marcadoraction(ActionEvent actionEvent) {
    }

    public void saliraction(ActionEvent actionEvent) {
        Stage stage = (Stage) salirbutton.getScene().getWindow();
        stage.close();
    }

    public void setScene(Scene sc) {
        scene = sc;
    }
}
