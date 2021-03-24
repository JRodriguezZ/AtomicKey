package sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Bomb extends Sprite{
    private double velY;
    private String valor;
    private Image image = new Image("images/bomb.png");

    public Bomb(double velocidad) {
        setX(Math.random()*600);
        setY(-10);
        Random r = new Random();
        char c = (char)(r.nextInt('Z' - 'A') + 'A');
        setImage(image);
        this.valor = String.valueOf(c);
        velY = velocidad;
        System.out.println("Bomb letter: " + getValor());
    }

    @Override
    public void move() {
        setY(getPosY() + velY);
    }

    public void isPressed(String s, GraphicsContext gc) {
        if (s.equals(valor)) {
            clear(gc);
        }
    }

    public boolean touchFloor(){
        return getPosY() == 460;
    }

    public String getValor() {
        return valor;
    }

//    public void bombImage(char c) {
//        switch (c) {
//            case 'A' -> setImage(new Image("images/bombA.png"));
//            case 'B' -> setImage(new Image("images/bombB.png"));
//            case 'C' -> setImage(new Image("images/bombC.png"));
//            case 'D' -> setImage(new Image("images/bombD.png"));
//            case 'E' -> setImage(new Image("images/bombE.png"));
//            case 'F' -> setImage(new Image("images/bombF.png"));
//            case 'G' -> setImage(new Image("images/bombG.png"));
//            case 'H' -> setImage(new Image("images/bombH.png"));
//            case 'I' -> setImage(new Image("images/bombI.png"));
//            case 'J' -> setImage(new Image("images/bombJ.png"));
//            case 'K' -> setImage(new Image("images/bombK.png"));
//            case 'L' -> setImage(new Image("images/bombL.png"));
//            case 'M' -> setImage(new Image("images/bombM.png"));
//            case 'N' -> setImage(new Image("images/bombN.png"));
//            case 'O' -> setImage(new Image("images/bombO.png"));
//            case 'P' -> setImage(new Image("images/bombP.png"));
//            case 'Q' -> setImage(new Image("images/bombQ.png"));
//            case 'R' -> setImage(new Image("images/bombR.png"));
//            case 'S' -> setImage(new Image("images/bombS.png"));
//            case 'T' -> setImage(new Image("images/bombT.png"));
//            case 'U' -> setImage(new Image("images/bombU.png"));
//            case 'V' -> setImage(new Image("images/bombV.png"));
//            case 'W' -> setImage(new Image("images/bombW.png"));
//            case 'X' -> setImage(new Image("images/bombX.png"));
//            case 'Y' -> setImage(new Image("images/bombY.png"));
//            case 'Z' -> setImage(new Image("images/bombZ.png"));
//        }
//    }
}
