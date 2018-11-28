package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
import fiuba.algo3.tp2.formas.FormaArmaAsedioRectangulo;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;
import fiuba.algo3.tp2.movimiento.MovimientoNulo;

public class ArmaAsedio extends Unidad implements Atacador {
	
	private static final int VIDA_MAXIMA = 150;
	private static final int COSTO_GENERACION = 200;
	
	boolean montada;
	private Ataque ataque;
	
	public ArmaAsedio(Posicion posicion, Mapa mapa)
			throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, mapa, new MovimientoBasico(), new FormaArmaAsedioRectangulo(), VIDA_MAXIMA, COSTO_GENERACION );
		ataque = new AtaqueArmaAsedio();
	}

	public void montar() {
		this.movimiento = new MovimientoNulo();
		this.ataque = new AtaqueArmaAsedio();
		this.montada = true;
	}

	public void desmontar() {
		this.movimiento = new MovimientoBasico();
		this.ataque = new AtaqueNulo();
	}

	@Override
	public void actualizarEstadoParaNuevoTurno() {
		if(montada) {
			this.movimiento = new MovimientoNulo();
			this.ataque = new AtaqueArmaAsedio();
		}else {
			this.movimiento = new MovimientoBasico();
			this.ataque = new AtaqueNulo();	
		}
	}

	@Override
	public void atacar(Atacable atacable) throws AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException, AtaqueInvalidoException {
		ataque.atacar(this, atacable);
		ataque = new AtaqueNulo();
	}

	@Override
	public int obtenerCosto() {
		// TODO Auto-generated method stub
		return 0;
	}
}
