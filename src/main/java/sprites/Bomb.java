package sprites;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bomb extends Sprite{
    private double velY;
    private Image image = new Image("images/bomb.png");

    public Bomb() {
        setX(Math.random()*600);
        setY(0);
        setImage(image);
        this.velY = 0.2f;
    }

    @Override
    public void move() {
        setY(getPosY() + velY);
//        if (getPosY()==460) setY(0);
    }
}
