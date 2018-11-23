package fiuba.algo3.tp2.unidad;

import Ataque.Atacador;
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
	}

	public void desmontar() {
		this.movimiento = new MovimientoBasico();
	}

	@Override
	public void siguienteAccion() {
		
		if(!montada) {
			movimiento = new MovimientoBasico();
		}
	}

	@Override
	public void atacar(Atacable atacable) throws AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException {
		ataque.atacar(this, atacable);
	}

	@Override
	public int obtenerCosto() {
		// TODO Auto-generated method stub
		return 0;
	}
}
