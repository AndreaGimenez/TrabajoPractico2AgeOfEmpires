package fiuba.algo3.tp2.unidad;

import Ataque.Atacador;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
import fiuba.algo3.tp2.formas.FormaArmaAsedioRectangulo;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;
import fiuba.algo3.tp2.movimiento.MovimientoNulo;

public class ArmaAsedio extends Unidad implements Atacador {
	
	private static final int VIDA_MAXIMA = 150;
	boolean montada;
	private Ataque ataque;
	
	public ArmaAsedio(Posicion posicion, Mapa mapa)
			throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, mapa, new MovimientoBasico(), new FormaArmaAsedioRectangulo(), VIDA_MAXIMA);
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

	}

	@Override
	public void atacar(Unidad unidad) throws AtaqueFueraDeRangoException, UnidadMuertaException {
		ataque.atacar(this, unidad);
	}

	@Override
	public void atacar(Edificio edificio) throws AtaqueFueraDeRangoException, EdificioDestruidoException {
		ataque.atacar(this, edificio);
	}
}
