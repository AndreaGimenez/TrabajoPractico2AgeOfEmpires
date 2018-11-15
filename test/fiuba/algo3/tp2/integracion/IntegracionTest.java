package fiuba.algo3.tp2.integracion;

import org.junit.Test;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;

public class IntegracionTest {

	@Test
	public void testCrearMapaTamanio250x250ConDosCastillosDosPlazasCentralesY6Aldeanos() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		new Castillo(new Posicion(0,0), mapa);
		new PlazaCentral(new Posicion(5,0), mapa);
		new Aldeano(new Posicion(5,2), mapa);
		new Aldeano(new Posicion(6,2), mapa);
		new Aldeano(new Posicion(7,2), mapa);
		
		new Castillo(new Posicion(246,246), mapa);
		new PlazaCentral(new Posicion(243,248), mapa);
		new Aldeano(new Posicion(244,247), mapa);
		new Aldeano(new Posicion(243,247), mapa);
		new Aldeano(new Posicion(242,247), mapa);
	}
}
