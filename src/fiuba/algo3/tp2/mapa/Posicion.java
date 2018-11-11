package fiuba.algo3.tp2.mapa;

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

	public Posicion sumar(Posicion coordenadaOrigen) {
		
		Integer coordenadaX = this.coordenadaX + coordenadaOrigen.getX();
		Integer coordenadaY = this.coordenadaY + coordenadaOrigen.getY();
		
		return new Posicion(coordenadaX, coordenadaY);
	}
}
