package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sprites.Bomb;
import sprites.Gandhi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class Village implements Initializable {
    private Scene scene;
    private GraphicsContext gc;
    private Gandhi gandhi;
    private List<Bomb> bombList;
    private int contador;

    @FXML Canvas mainCanvas;
    @FXML ImageView background;

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.0017), new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            gandhi.clear(gc);
            gandhi.render(gc);

            if (contador % 1000 == 0) bombList.add(new Bomb());
            for (Bomb bomb : bombList) {
                bomb.clear(gc);
                bomb.move();
                bomb.render(gc);
                if (bomb.getPosY() == 460) {
                    bomb.clear(gc);
                    gandhi.vidas--;

                }
            }

            contador++;

            if (gandhi.vidas == 0) {
                System.out.println("HAS PERDIDO");
            }

        }
    })
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.setImage(new Image("images/villageBackground.gif"));

        bombList = new ArrayList<>();

        gandhi = new Gandhi(new Image("images/allah.png"));

        gc = mainCanvas.getGraphicsContext2D();
        gandhi.render(gc);

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void setScene(Scene sc) {
        scene = sc;
        scene.setOnKeyPressed(keyEvent -> {
            System.out.println(keyEvent.getCode().toString());
            for (Bomb bomb : bombList) {
                if (bomb.getValor().equals(keyEvent.getCode().toString())) {
                    bomb.isPressed(keyEvent.getCode().toString(), gc);
                }
            }
            System.out.println(gandhi.vidas);
            bombList.removeIf(bomb -> bomb.getValor().equals(keyEvent.getCode().toString()));
        });

    }
}
