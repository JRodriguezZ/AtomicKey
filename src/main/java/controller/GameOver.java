package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameOver implements Initializable {
    @FXML Button botonGuardarSalir;
    @FXML AnchorPane gameAnchorPane;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void guardarSalir(ActionEvent actionEvent) {
//        DIALOG AMIGO HASLO
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menuWindow.fxml"));
            AnchorPane anchorPane = loader.load();
            gameAnchorPane.getChildren().add(anchorPane);

            Menu menu = loader.getController();
            menu.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) botonGuardarSalir.getScene().getWindow();
        stage.close();
    }
}
