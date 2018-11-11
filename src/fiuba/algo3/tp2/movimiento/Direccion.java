package fiuba.algo3.tp2.movimiento;

import fiuba.algo3.tp2.mapa.Posicion;

public class Direccion extends Posicion {

	public Direccion(Integer coordenadaX, Integer coordenadaY) {
		super(coordenadaX, coordenadaY);
		// TODO Auto-generated constructor stub
	}

	public Posicion multiplicar(int velocidadMovimiento) {
		
		int coordenadaX = this.coordenadaX * velocidadMovimiento;
		int coordenadaY = this.coordenadaY * velocidadMovimiento;
		
		return new Posicion(coordenadaX, coordenadaY);
	}
}
