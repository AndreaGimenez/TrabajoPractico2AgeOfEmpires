package fiuba.algo3.tp2.mapa;

import javafx.geometry.Pos;

public class Posicion {

	protected int coordenadaX;
	protected int coordenadaY;
	
	public Posicion(Integer coordenadaX, Integer coordenadaY) {
		
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}

	public int getX() {
		return coordenadaX;
	}

	public int getY() {
		return coordenadaY;
	}

	public Posicion sumar(Posicion posicion) {
		
		Integer coordenadaX = this.coordenadaX + posicion.getX();
		Integer coordenadaY = this.coordenadaY + posicion.getY();
		
		return new Posicion(coordenadaX, coordenadaY);
	}
	
	public Posicion restar(Posicion posicion) {
		
		Integer coordenadaX = this.coordenadaX - posicion.getX();
		Integer coordenadaY = this.coordenadaY - posicion.getY();
		
		return new Posicion(coordenadaX, coordenadaY);
	}

	public void setX(Integer tamanioX) {
		
		this.coordenadaX = tamanioX;
	}

	public void setY(Integer tamanioY) {

		this.coordenadaY = tamanioY;
	}

    public Posicion desplazarHorizontalmente(int i) {

		return new Posicion(this.coordenadaX+i, this.coordenadaY);

    }

	public Posicion desplazarVerticalmente(int i) {

		return new Posicion(this.coordenadaX, this.coordenadaY+i);
	}

	public boolean esIgualA(Posicion otraPosicion) {
		
		return (this.coordenadaX == otraPosicion.getX()
				&& this.coordenadaY == otraPosicion.getY());
	}
	
	public String toString() {
		return String.valueOf(this.getX()) + this.getY();
	}
}
