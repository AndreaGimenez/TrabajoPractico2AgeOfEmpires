package fiuba.algo3.tp2.unidad;

import Ataque.Atacador;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
import fiuba.algo3.tp2.formas.FormaArqueroRectangulo;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;

public class Arquero extends Unidad implements Atacador {
	
	private static final int VIDA_MAXIMA = 75;
	private Ataque ataque;
	
	public Arquero(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		super(posicion, mapa, new MovimientoBasico(), new FormaArqueroRectangulo(), VIDA_MAXIMA);
		ataque = new AtaqueArquero();
	}

	@Override
	public void siguienteAccion() {

	}

	@Override
	public void atacar(Edificio edificio) throws AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		ataque.atacar(this, edificio);
	}

	@Override
	public void atacar(Unidad unidad) throws AtaqueFueraDeRangoException, UnidadMuertaException {
		
		ataque.atacar(this, unidad);
	}
}
