package fiuba.algo3.tp2.unidades;

import fiuba.algo3.tp2.edificios.Edificio;
import fiuba.algo3.tp2.espacio.punto.Punto;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.movimiento.Movimiento;


public class Aldeano extends Unidad implements Movible{
	
	private Movimiento movimiento;
	
	public Aldeano(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	@Override
	public void mover(Direccion direccion) {
		movimiento.mover(posicion, direccion);
	}
	
	public void construir(Edificio edificio, Punto punto) {
		// TODO Auto-generated method stub
		
	}
}
