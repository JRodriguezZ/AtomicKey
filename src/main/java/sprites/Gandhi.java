package sprites;

import javafx.scene.image.Image;

public class Gandhi extends Sprite {
    public int vidas;

    public Gandhi(Image image) {
        super(image);
        setY(311);
        setX(300);
        this.vidas = 3;
        System.out.println("Current HP: " + this.vidas);
    }

    public boolean conVida(int hp){
        return hp != 0;
    }
}
