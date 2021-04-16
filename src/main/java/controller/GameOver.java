package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameOver implements Initializable {
    @FXML Button botonGuardarSalir;
    @FXML AnchorPane gameOverAnchorPane;
    @FXML Text puntuacionid,nivelid;
    private Scene scene;
    private String rutaGameOverTheme;
    private Media mediaGameOverTheme;
    private MediaPlayer playerGameOverTheme;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        puntuacionid.setText(String.valueOf(Village.puntuacionJugador));
        nivelid.setText(String.valueOf(Village.nivel));
        Menu.playerMainTheme.stop();
        rutaGameOverTheme = getClass().getClassLoader().getResource("music/GameOverTheme.mp3").toExternalForm();
        mediaGameOverTheme = new Media(rutaGameOverTheme);
        playerGameOverTheme = new MediaPlayer(mediaGameOverTheme);
        playerGameOverTheme.setVolume(0.2);
        playerGameOverTheme.play();

    }

    public void guardarSalir(ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menuWindow.fxml"));
            AnchorPane anchorPane = loader.load();
            gameOverAnchorPane.getChildren().add(anchorPane);

            Menu menu = loader.getController();
            menu.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setScene(Scene sc) {
        scene = sc;
    }
}
