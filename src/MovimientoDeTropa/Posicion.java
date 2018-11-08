package MovimientoDeTropa;

public class Posicion {

    private int posX;
    private int posY;

    public Posicion(int x, int y) {

        this.posX = x;
        this.posY = y;

    }

    public int getPosX(){

        return this.posX;

    }

    public int getPosY(){

        return this.posY;

    }


    public void cambiarPosicion(int x, int y) {

        this.posX = x;

        this.posY = y;

    }

    public void ejecutarMovimiento(Posicion first) {

        this.posX = first.getPosX();

        this.posY = first.getPosY();

    }
}
