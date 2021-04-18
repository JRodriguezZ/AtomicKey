package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {
    private Scene scene;
    public static String rutaMainTheme;
    public static Media mediaMainTheme;
    public static MediaPlayer playerMainTheme;

    @FXML Button playbutton, marcadorbutton, salirbutton;
    @FXML AnchorPane menuAnchorPane;
    @FXML ImageView menubackground;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menubackground.setImage(new Image("images/villa.png"));
        playbutton.setDisable(false);

        //Se reproduce la musica en el menu y mientras se juega.
        rutaMainTheme = getClass().getClassLoader().getResource("music/AneleTheme.mp3").toExternalForm();
        mediaMainTheme = new Media(rutaMainTheme);
        playerMainTheme = new MediaPlayer(mediaMainTheme);
        playerMainTheme.setVolume(0.2);
        playerMainTheme.setAutoPlay(true);
        playerMainTheme.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void playaction(ActionEvent actionEvent) {

        //Cuando se da al boton "Jugar" pasa de pantalla y le da el controlador al juego.
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/gameWindow.fxml"));
            AnchorPane anchorPane = loader.load();
            menuAnchorPane.getChildren().add(anchorPane);
//            menuAnchorPane.getChildren().remove()

            Village village = loader.getController();
            village.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
        playbutton.setDisable(true);
    }

    public void marcadoraction(ActionEvent actionEvent) {

    }

    //Cuando se da al boton "Salir" cierra el juego.
    public void saliraction(ActionEvent actionEvent) {
        Stage stage = (Stage) salirbutton.getScene().getWindow();
        stage.close();
    }

    public void setScene(Scene sc) {
        scene = sc;
    }
}
