package CrearEdificiosConFactory.Productos;

public class Posicion {

    private int coordenadaX;

    private int coordenadaY;

    public Posicion(int x, int y) {

        this.coordenadaX = x;

        this.coordenadaY = y;

    }

    public int obtenerX(){

        return this.coordenadaX;

    }

    public int obtenerY(){

        return this.coordenadaY;

    }

    public boolean estaEntre(Posicion inicio, Posicion fin) {

        return (inicio.obtenerX() <= this.coordenadaX && inicio.obtenerY() <= this.coordenadaY
                && fin.obtenerX() >= this.coordenadaX && fin.obtenerY() >= this.coordenadaY );

    }

    public Posicion desplazarHorizontalmente(int x) {

        return new Posicion(this.coordenadaX+x, this.coordenadaY);

    }

    public Posicion desplazarVerticalmente(int y) {

        return new Posicion(this.coordenadaX, this.coordenadaY-y);

    }
}
