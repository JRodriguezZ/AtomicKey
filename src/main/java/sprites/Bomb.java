package sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

public class Bomb extends Sprite{
    private double velY;
    private String valor;
//    private Image image = new Image("images/bomb.png");

    public Bomb(double velocidad) {
        setX(Math.random()*600);
        setY(-10);
        Random r = new Random();
        char c = (char)(r.nextInt('Z' - 'A') + 'A');
//        setImage(image);
        bombImage(c);
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
        return getPosY() > 460;
    }

    public String getValor() {
        return valor;
    }

    public void bombImage(char c) {
        switch (c) {
            case 'A':
                setImage(new Image("images/bombA.png"));
                break;
            case 'B':
                setImage(new Image("images/bombB.png"));
                break;
            case 'C':
                setImage(new Image("images/bombC.png"));
                break;
            case 'D':
                setImage(new Image("images/bombD.png"));
                break;
            case 'E':
                setImage(new Image("images/bombE.png"));
                break;
            case 'F':
                setImage(new Image("images/bombF.png"));
                break;
            case 'G':
                setImage(new Image("images/bombG.png"));
                break;
            case 'H':
                setImage(new Image("images/bombH.png"));
                break;
            case 'I':
                setImage(new Image("images/bombI.png"));
                break;
            case 'J':
                setImage(new Image("images/bombJ.png"));
                break;
            case 'K':
                setImage(new Image("images/bombK.png"));
                break;
            case 'L':
                setImage(new Image("images/bombL.png"));
                break;
            case 'M':
                setImage(new Image("images/bombM.png"));
                break;
            case 'N':
                setImage(new Image("images/bombN.png"));
                break;
            case 'O':
                setImage(new Image("images/bombO.png"));
                break;
            case 'P':
                setImage(new Image("images/bombP.png"));
                break;
            case 'Q':
                setImage(new Image("images/bombQ.png"));
                break;
            case 'R':
                setImage(new Image("images/bombR.png"));
                break;
            case 'S':
                setImage(new Image("images/bombS.png"));
                break;
            case 'T':
                setImage(new Image("images/bombT.png"));
                break;
            case 'U':
                setImage(new Image("images/bombU.png"));
                break;
            case 'V':
                setImage(new Image("images/bomb.png"));
                break;
            case 'W':
                setImage(new Image("images/bombW.png"));
                break;
            case 'X':
                setImage(new Image("images/bombX.png"));
                break;
            case 'Y':
                setImage(new Image("images/bombY.png"));
                break;
            case 'Z':
                setImage(new Image("images/bombZ.png"));
                break;
        }
    }
}
