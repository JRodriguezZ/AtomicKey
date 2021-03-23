package sprites;

import javafx.scene.image.Image;

public class Gandhi extends Sprite {
    public int vidas;

    public Gandhi(Image image) {
        super(image);
        setY(311);
        setX(300);
        setHeight(100);
        setWidth(500);
        this.vidas = 3;
    }
}
