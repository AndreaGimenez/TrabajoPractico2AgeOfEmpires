package fiuba.algo3.tp2.unidad;

public class GestionadorMontajeArmaAsedio {
	
	private static final int TURNOS_QUE_TARDA_EN_MONTARSE = 1;
	private static final int TURNOS_QUE_TARDA_EN_DESMONTARSE = 1;
	private static final int NO_SE_ESTA_MONTANDO = -1;
	private static final int NO_SE_ESTA_DESMONTANDO = -1;
	
	private ArmaAsedio armaAsedio;
	private int turnosDesdeSuMontaje;
	private int turnosDesdeSuDesmontaje;
	private boolean montada;
	
	public GestionadorMontajeArmaAsedio(ArmaAsedio armaAsedio) {
		
		this.armaAsedio = armaAsedio;
		this.montada = false;
		this.turnosDesdeSuMontaje = NO_SE_ESTA_MONTANDO;
		this.turnosDesdeSuDesmontaje = NO_SE_ESTA_DESMONTANDO;
	}
	
	public boolean estaMontada() {
		return montada;
	}
	
	public void montar() {
		this.turnosDesdeSuMontaje = 0;
	}
	
	public void desmontar() {
		this.turnosDesdeSuDesmontaje = 0;
	}


	public boolean montajeFinalizado() {
		return turnosDesdeSuMontaje == TURNOS_QUE_TARDA_EN_MONTARSE;
	}

	public boolean desmontajeFinalizado() {
		return turnosDesdeSuDesmontaje == TURNOS_QUE_TARDA_EN_DESMONTARSE;
	}

	public void finalizarMontaje() {
		this.montada = true;
		this.turnosDesdeSuMontaje = NO_SE_ESTA_MONTANDO;
		
	}

	public void finalizarDesmontaje() {
		this.montada = false;
		this.turnosDesdeSuDesmontaje = NO_SE_ESTA_DESMONTANDO;
	}
	
	public boolean montajeEnCurso() {
		return this.turnosDesdeSuMontaje >= 0;
	}
	
	public boolean desmontajeEnCurso() {
		return this.turnosDesdeSuDesmontaje >= 0;
	}
	
	public void actualizarMontajeParaSiguienteTurno() {
		if(montajeEnCurso()) {
			this.turnosDesdeSuMontaje += 1;
		}
		
		if(desmontajeEnCurso()) {
			this.turnosDesdeSuDesmontaje += 1;
		}
	}

}
