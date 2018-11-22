package fiuba.algo3.tp2.edificio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.movimiento.MovimientoInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class PlazaCentralTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_DadaUnaPlazaCentralEnlaPosicionX5Y2CuandoSePosicionaUnAldeanoEnLaPosicionX5Y2_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(5, 2), mapa);
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnlaPosicionX5Y2CuandoSePosicionaUnAldeanoEnLaPosicionX6Y2_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(6, 2), mapa);
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnlaPosicionX5Y2CuandoSePosicionaUnAldeanoEnLaPosicionX6Y3_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(6, 3), mapa);
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnlaPosicionX5Y2CuandoSePosicionaUnAldeanoEnLaPosicionX5Y3_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(5, 3), mapa);
	}

	@Test
	public void test_DadaUnaPlazaCentral_CrearUnAldeanoEnLaPosicionElegidaDeberidaDarBien() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(1, 1), mapa);
		
		Aldeano aldeano = (Aldeano)plazaCentral.crear(TipoUnidad.ALDEANO, new Posicion(3, 1));
		
	}
	
	@Test
	public void test_DadaUnaPlazaCentral_NoDeberiaPoderCrearEspadachin_DeberiaLazarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		Espadachin espadachin = (Espadachin)plazaCentral.crear(TipoUnidad.ESPADACHIN, new Posicion(3, 1));
	}
	
	@Test
	public void test_DadaUnaPlazaCentral_NoDeberiaPoderCrearArquero_DeberiaLanzarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		Arquero arquero = (Arquero)plazaCentral.crear(TipoUnidad.ARQUERO, new Posicion(3, 1));
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnLaPosicionX3Y3_AlCrearUnAldeanoEnUnaPosicionYaOcupadaDeberiaDarError() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(3, 3), mapa);
		Aldeano unAldeano = new Aldeano(new Posicion(7, 7), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano otroAldeano = (Aldeano)plazaCentral.crear(TipoUnidad.ALDEANO, new Posicion(7, 7));
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnLaPosicionX3Y3_AlCrearUnAldeanoEnUnaPosicionFueraDelMapaDeberiaDarError() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(3, 3), mapa);
		
		exceptionRule.expect(CeldaInexistenteException.class);
		Aldeano unAldeano = (Aldeano)plazaCentral.crear(TipoUnidad.ALDEANO, new Posicion(300, 300));
	}
	
	@Test
	public void test_AlPosicionarUnaPlazaCentral_DebeEstarEnConstruccion() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5, 5), mapa);
		GestionarConstruccion gestionarPlazaCentral = new GestionarConstruccion(plazaCentral);

		assertTrue(gestionarPlazaCentral.estaEnConstruccion());
	}
	
	@Test
	public void test_AlEstarUnaPlazaCentralEnConstruccion_NoPuedeCrearUnidades()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(3, 3), mapa);
		GestionarConstruccion gestionarPlazaCentral = new GestionarConstruccion(plazaCentral);

		exceptionRule.expect(EdificioEnConstruccionException.class);
		Aldeano unAldeano = (Aldeano) gestionarPlazaCentral.crear(TipoUnidad.ALDEANO, new Posicion(10, 10));
	}
}
