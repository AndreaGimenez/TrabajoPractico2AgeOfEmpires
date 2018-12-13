package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.formas.FormaCastilloRectangulo;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.reparacion.ReparacionDesactivada;

public class Castillo extends Edificio implements AtacadorZona {
	
	private static final int VIDA_MAXIMA = 1000;
	private static final int SALUD_RECUPERADA_POR_TURNO = 15;
	private static final int COSTO_CONSTRUCCION = 0;

	private AtaqueZona ataque;
	
	public Castillo(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, new FormaCastilloRectangulo(), new ReparacionDesactivada(), VIDA_MAXIMA, SALUD_RECUPERADA_POR_TURNO, COSTO_CONSTRUCCION, mapa);
		this.ataque = new AtaqueCastillo(this, mapa);
	}
	
	public void atacar(Collection<Posicionable> pocisionablesEnemigos) throws AtaqueInvalidoException {
		ataque.atacar(pocisionablesEnemigos);
		ataque = new AtaqueNuloCastillo();
		setChanged();
		notifyObservers(this.ataque);
	}
	 
    @Override
	public void actualizarEstadoParaSiguienteTurno() {
		this.generable = null;
		
		setChanged();
		notifyObservers(this.generable);
		
		this.ataque = new AtaqueCastillo(this, mapa);
		
		setChanged();
		notifyObservers(this.ataque);
	}

	@Override
	public void atacar() throws AtaqueInvalidoException {
		// TODO Auto-generated method stub
		
	}
}
