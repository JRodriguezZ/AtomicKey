package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {
    @FXML ImageView menubackground;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menubackground.setImage(new Image("images/villa.png"));
    }

    public void playaction(ActionEvent actionEvent) {
    }

    public void marcadoraction(ActionEvent actionEvent) {
    }

    public void saliraction(ActionEvent actionEvent) {
    }

    public void setScene(Scene sc) {

    }
}
