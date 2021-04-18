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
import sprites.Anele;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Village implements Initializable {
    private Scene scene;
    private GraphicsContext gc;
    private Anele anele;
    private List<Bomb> bombList;
    private int time, dropRate;
    private int bombasLanzadas;
    private float velocidad;
    public static int puntuacionJugador;
    public static int nivel;

    @FXML Canvas mainCanvas;
    @FXML ImageView background, imageCorazon;
    @FXML AnchorPane gameAnchorPane;
    @FXML Text textPuntuacionJugador, textNivel, textVidas;


    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.0017), new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            //Se renueva la imagen de Anele para que la imagen no desaparezca si una bomba pasa a traves suyo. Al final del metodo se vuelve a imprimir para que se vuelva a mostrar.
            anele.clear(gc);

            textVidas.setText(String.valueOf(anele.vidas));

            //Cada vez que el tiempo sea divisor del numero que contenga el drop rate se lanzara una bomba.
            if (time % dropRate == 0){
                bombList.add(new Bomb(velocidad));
                bombasLanzadas++;
            }

            //Renderiza las bombas cada frame.
            for (Bomb bomb : bombList) {
                bomb.clear(gc);
                bomb.move();
                bomb.render(gc);

                //Si la bomba activa el metodo que determina si ha tocado el suelo esta desaparece y resta una vida.
                if (bomb.touchFloor()) {
                    bomb.clear(gc);
                    anele.vidas--;
                    System.out.println("Current HP: " + anele.vidas);
                }
            }

            //Se elimina la bomba del array.
            bombList.removeIf(Bomb::touchFloor);

            comprovarNivel();
            comprovarVida();

            anele.render(gc);

            time++;
        }
    })
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.setImage(new Image("images/villageBackground.gif"));
        anele = new Anele(new Image("images/anele.png"));
        imageCorazon.setImage(new Image("images/corazon.png"));

        bombList = new ArrayList<>();

        gc = mainCanvas.getGraphicsContext2D();

        //Variable que determina la velocidad a la que bajan las bombas.
        velocidad = 0.2f;
        //Frecuencia en la que las bombas se lanzan.
        dropRate = 1000;

        puntuacionJugador = 0;
        nivel = 1;

        textNivel.setText(String.valueOf(nivel));
        textPuntuacionJugador.setText(String.valueOf(puntuacionJugador));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void setScene(Scene sc) {
        scene = sc;
        scene.setOnKeyPressed(keyEvent -> {
            System.out.println(keyEvent.getCode().toString());

            //Recorre el array...
            for (Bomb bomb : bombList) {
                //Y si la tecla pulsada coincide con una bomba que contiene esa letra activa el metodo que determina si la bomba ha sido ha sido pulsada y aumenta el marcador si esto ocurre.
                if (bomb.getValor().equals(keyEvent.getCode().toString())) {
                    bomb.isPressed(keyEvent.getCode().toString(), gc);
                    puntuacionJugador += 10;
                    textPuntuacionJugador.setText(String.valueOf(puntuacionJugador));
                }
            }

            //Elimina la bomba del array si esta ha sido pulsada.
            bombList.removeIf(bomb -> bomb.getValor().equals(keyEvent.getCode().toString()));
        });
    }

    public void comprovarVida(){
        //Si el metodo decide que Anele no esta con vida para el juego y carga la pantalla de Game Over.
        if (!anele.conVida(anele.vidas)) {
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
        //Cada vez que se lanzan 10 bombas el nivel aumenta.
        if (bombasLanzadas % 10 == 0) {
            //la velocidad a la que caen las bombas aumenta en 0.05 cada nivel.
            velocidad += 0.05f;
            //si se diese el caso de que la velocidad llega a 0.8, esta se quedara aqui ya que mas velocidad convertiria el juego en injugable.
            if (velocidad > 0.8f) velocidad = 0.8f;

            //la frecuencia en la que caen las bombas aumenta en 0.8 cada nivel.
            dropRate *= 0.8;
            //Lo mismo con la frecuencia en la que caen las bombas, no supera este limite porque sino se llena la pantalla.
            if (dropRate < 300) dropRate = 300;

            nivel++;
            bombasLanzadas++;
            textNivel.setText(String.valueOf(nivel));
        }
    }
}
