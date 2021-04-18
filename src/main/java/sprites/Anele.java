package sprites;

import javafx.scene.image.Image;

public class Anele extends Sprite {
    public int vidas;

    public Anele(Image image) {
        //Se pone las vidas al jugador y la imagen en una posición concreta.
        super(image);
        setY(311);
        setX(320);
        this.vidas = 3;
        System.out.println("Current HP: " + this.vidas);
    }

    //Compara la vida del jugador con 0 y devuelve true o false dependiendo de si está con vida o no.
    public boolean conVida(int hp){
        return hp != 0;
    }
}
