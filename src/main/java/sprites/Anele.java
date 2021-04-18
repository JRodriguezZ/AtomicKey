package sprites;

import javafx.scene.image.Image;

public class Anele extends Sprite {
    public int vidas;

    public Anele(Image image) {
        super(image);
        setY(311);
        setX(320);
        this.vidas = 3;
        System.out.println("Current HP: " + this.vidas);
    }

    public boolean conVida(int hp){
        return hp != 0;
    }
}
