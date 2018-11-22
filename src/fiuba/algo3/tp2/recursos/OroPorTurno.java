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
	
	public int recolectarOroDelTurno() {
		int oro = oroDisponible;
		oroDisponible = 0;
		desactivarRecolector();
		return oro;
	}
}
