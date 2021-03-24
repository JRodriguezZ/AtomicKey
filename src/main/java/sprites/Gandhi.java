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

    public void comprovarVida(int hp){
        if (hp == 0) System.out.println("-- HAS PERDIDO --");
    }
}
