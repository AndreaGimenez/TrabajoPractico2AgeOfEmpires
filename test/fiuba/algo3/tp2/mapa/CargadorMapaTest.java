package fiuba.algo3.tp2.mapa;

import org.junit.Test;

import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.unidad.Aldeano;

public class CargadorMapaTest {

	@Test
	public void test_cargarMapaDe250x250Con2PlazasCentrales2CastillosY6Aldeanos() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Aldeano aldeano = new Aldeano();
		aldeano.posicionar(new Coordenada(5, 2), mapa);
		
		aldeano = new Aldeano();
		aldeano.posicionar(new Coordenada(6, 2), mapa);
		
		aldeano = new Aldeano();
		aldeano.posicionar(new Coordenada(7, 2), mapa);
		
		Castillo castillo = new Castillo();
		castillo.posicionar(new Coordenada(0, 0), mapa);
		
		PlazaCentral plazaCentral = new PlazaCentral();
		plazaCentral.posicionar(new Coordenada(5,0), mapa);
		
		
	}
}
