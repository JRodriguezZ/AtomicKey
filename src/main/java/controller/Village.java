package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import sprites.Bomb;
import sprites.Gandhi;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Village implements Initializable {
    private Scene scene;
    private GraphicsContext gc;
    private Gandhi gandhi;
    private List<Bomb> bombList;
    private int time, dropRate;
    private int bombasLanzadas;
    private int puntuacionJugador;
    private float velocidad;
    private int nivel;

    @FXML Canvas mainCanvas;
    @FXML ImageView background, imageCorazon;
    @FXML AnchorPane gameAnchorPane;
    @FXML Text textPuntuacionJugador, textNivel, textVidas;


    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.0017), new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            gandhi.clear(gc);


            textVidas.setText(String.valueOf(gandhi.vidas));

//            drawText("Puntuacion: ", 500, 25);
//            drawText(String.valueOf(puntuacionJugador),450,50);

            if (time % dropRate == 0){
                bombList.add(new Bomb(velocidad));
                bombasLanzadas++;
            }

            for (Bomb bomb : bombList) {
                bomb.clear(gc);
                bomb.move();
                bomb.render(gc);

                if (bomb.touchFloor()) {
                    bomb.clear(gc);
                    gandhi.vidas--;
                    System.out.println("Current HP: " + gandhi.vidas);
                }
            }

            bombList.removeIf(Bomb::touchFloor);


            comprovarNivel();
            comprovarVida();


            time++;

            gandhi.render(gc);
        }
    })
    );

    private void drawText(String s, int posX, int posY) {
        gc.strokeText(s, posX, posY);
        gc.clearRect(posX,posY,1000,50);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.setImage(new Image("images/villageBackground.gif"));
        gandhi = new Gandhi(new Image("images/allah.png"));
        imageCorazon.setImage(new Image("images/corazon.png"));

        bombList = new ArrayList<>();

        gc = mainCanvas.getGraphicsContext2D();

        velocidad = 0.2f;
        nivel = 0;
        dropRate = 1000;

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
                    puntuacionJugador += 10;
                    textPuntuacionJugador.setText(String.valueOf(puntuacionJugador));
                }
            }

            bombList.removeIf(bomb -> bomb.getValor().equals(keyEvent.getCode().toString()));
        });
    }

    public void comprovarVida(){
        if (!gandhi.conVida(gandhi.vidas)) {
            System.out.println("-- HAS PERDIDO --");
            timeline.stop();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/gameOver.fxml"));
                AnchorPane anchorPane = loader.load();
                gameAnchorPane.getChildren().add(anchorPane);

                GameOver gameOver = loader.getController();
                gameOver.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void comprovarNivel() {
        if (bombasLanzadas % 10 == 0) {
            velocidad *= 1.3;
            if (velocidad > 2) velocidad = 2;

            dropRate *= 0.8;
            if (dropRate < 200) dropRate = 200;

            nivel++;
            textNivel.setText(String.valueOf(nivel));
            bombasLanzadas++;
        }
    }
}
