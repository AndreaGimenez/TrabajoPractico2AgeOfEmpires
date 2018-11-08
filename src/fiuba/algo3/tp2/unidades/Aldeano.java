package fiuba.algo3.tp2.unidades;

import fiuba.algo3.tp2.edificios.Edificio;
import fiuba.algo3.tp2.espacio.punto.Punto;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.movimiento.Movimiento;
import fiuba.algo3.tp2.movimiento.Posicionable;


public class Aldeano extends Unidad implements Movible,Posicionable{
	
	private Movimiento movimiento;
	
	public Aldeano(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public Aldeano() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mover(Direccion direccion) {
		movimiento.mover(posicion, direccion);
	}
	
	public void construir(Edificio edificio, Punto punto) {
		// TODO Auto-generated method stub
		
	}
}
