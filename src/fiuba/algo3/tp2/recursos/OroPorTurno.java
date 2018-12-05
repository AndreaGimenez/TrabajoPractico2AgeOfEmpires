package fiuba.algo3.tp2.recursos;

public class OroPorTurno {
	
	private static final int ORO_POR_TURNO = 20;
	
	private Boolean recolectorOroActivado;
	private int oroDisponible;
	
	public OroPorTurno() {
		this.oroDisponible = 0;
		desactivarRecolector();
	}

	public void activarRecolector() {
		recolectorOroActivado = true ;
		sumarOroEnTurno();
	}
	
	/*Se encarga de sumar en oroDisponible el oro del turno inmediatamente despues que se activo el recolector de oro
	 * Luego desactiva el recolector para que no se pueda sumar dos veces en el turno
	 */
	public void sumarOroEnTurno() {
		
		if(recolectorOroActivado) {
			this.oroDisponible += ORO_POR_TURNO;
			desactivarRecolector();
		}
		else{
			oroDisponible = 0;
		}
	}
	
	public void desactivarRecolector() {
		recolectorOroActivado = false ;
	}
	
	/*Devuelve la cantidad de oro que se recolecto en el turno.
	 * Luego deja en cero oroDisponible para que no pueda volver a sumaroro
	 * en ese turno
	 */
	public int recolectarOroDelTurno() {
		int oro = oroDisponible;
		oroDisponible = 0;
		return oro;
	}
}
