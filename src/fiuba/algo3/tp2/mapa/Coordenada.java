package fiuba.algo3.tp2.mapa;

public class Coordenada {

	protected int coordenadaX;
	protected int coordenadaY;
	
	public Coordenada(Integer coordenadaX, Integer coordenadaY) {
		
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}

	public int getX() {
		return coordenadaX;
	}

	public int getY() {
		return coordenadaY;
	}

	public Coordenada sumar(Coordenada coordenadaOrigen) {
		
		Integer coordenadaX = this.coordenadaX + coordenadaOrigen.getX();
		Integer coordenadaY = this.coordenadaY + coordenadaOrigen.getY();
		
		return new Coordenada(coordenadaX, coordenadaY);
	}
}
