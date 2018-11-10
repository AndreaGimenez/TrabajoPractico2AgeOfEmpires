package fiuba.algo3.tp2.movimiento;

import fiuba.algo3.tp2.mapa.Coordenada;

public class Direccion extends Coordenada {

	public Direccion(Integer coordenadaX, Integer coordenadaY) {
		super(coordenadaX, coordenadaY);
		// TODO Auto-generated constructor stub
	}

	public Coordenada multiplicar(int velocidadMovimiento) {
		
		int coordenadaX = this.coordenadaX * velocidadMovimiento;
		int coordenadaY = this.coordenadaY * velocidadMovimiento;
		
		return new Coordenada(coordenadaX, coordenadaY);
	}
}
