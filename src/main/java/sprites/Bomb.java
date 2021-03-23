package sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Bomb extends Sprite{
    private double velY;
    private Image image = new Image("images/bomb.png");
    private String valor;

    public Bomb() {
        setX(Math.random()*600);
        setY(-10);
        setImage(image);
        Random r = new Random();
        char c = (char)(r.nextInt('Z' - 'A') + 'A');
        this.valor = String.valueOf(c);
        this.velY = 0.2f;
        System.out.println("Bomb letter: " + getValor());
    }

    @Override
    public void move() {
        setY(getPosY() + velY);
//        if (getPosY()==460) setY(0);
    }

    public void isPressed(String s, GraphicsContext gc) {
        if (s.equals(valor)) {
            clear(gc);
        }

    }

    public String getValor() {
        return valor;
    }
}