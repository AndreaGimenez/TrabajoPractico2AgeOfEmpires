package fiuba.algo3.tp2.edificio;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.movimiento.MovimientoInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;
import fiuba.algo3.tp2.unidad.UnidadMuertaException;

public class CastilloTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_DadoUnCastilloEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX5Y2_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano aldeano = new Aldeano(new Posicion(5, 2), mapa);
	}
	
	@Test
	public void test_DadoUnCastilloEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX8Y2_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano aldeano = new Aldeano(new Posicion(8, 2), mapa);
	}
	
	@Test
	public void test_DadoUnCastilloEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX8Y5_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano aldeano = new Aldeano(new Posicion(8, 5), mapa);
	}
	
	@Test
	public void test_DadoUnCastilloEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX5Y5_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_DebePoderCrearUnArmaDeAsedioEnLaPosicionSolicitada() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		
		ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(TipoUnidad.ARMA_ASEDIO, new Posicion(5, 5));
		
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_AlCrearUnArmaDeAsedioEnLaPosicionX3Y3_DebeLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(TipoUnidad.ARMA_ASEDIO, new Posicion(3, 3));
		
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_NoDebePoderCrearUnAldeano_DebeLanzarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(TipoUnidad.ALDEANO, new Posicion(5, 5));
		
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_NoDebePoderCrearUnEspadachin_DebeLanzarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(TipoUnidad.ESPADACHIN, new Posicion(5, 5));
		
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_NoDebePoderCrearUnArquero_DebeLanzarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(TipoUnidad.ARQUERO, new Posicion(5, 5));
		
	}
	
	@Test 
	public void test_DadoUnCastillo_AlQuererCrearUnArmaDeAsedioEnUnaPosicionYaOcupada_DebeLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		Cuartel cuartel = new Cuartel(new Posicion(6, 4), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(TipoUnidad.ARMA_ASEDIO, new Posicion(6, 4));
	}
	
	//ATAQUE
	
	@Test
	public void test_DadoUnAldeanoQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca3Veces_ElAldeanoDeberiaEstarMuerto() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = Mockito.mock(Mapa.class);
		Castillo castillo = new Castillo(new Posicion(1,1), mapa);
		Unidad aldeano = new Aldeano(new Posicion(4,1), mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(aldeano);
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		
		exceptionRule.expect(UnidadMuertaException.class);
		aldeano.recibirDanio(1);
	}
	
	@Test
	public void test_DadoUnAldeanoQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca4Veces_ElAldeanoDeberiaEstarMuerto() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = Mockito.mock(Mapa.class);
		Castillo castillo = new Castillo(new Posicion(1,1), mapa);
		Unidad aldeano = new Aldeano(new Posicion(4,1), mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(aldeano);
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		
		exceptionRule.expect(UnidadMuertaException.class);
		aldeano.recibirDanio(1);
	}
	
	@Test
	public void test_DadoUnAldeanoQueSeEncuentraFueraDeLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca3Veces_ElAldeanoDeberiaEstarVivo() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = Mockito.mock(Mapa.class);
		Castillo castillo = new Castillo(new Posicion(1,1), mapa);
		Unidad aldeano = new Aldeano(new Posicion(5,1), mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		
		aldeano.recibirDanio(50);
		exceptionRule.expect(UnidadMuertaException.class);
		aldeano.recibirDanio(1);
	}
	
	@Test
	public void test_DadoUnCuartelQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca14Veces_ElEdificioDeberiaEstarDestruido() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = Mockito.mock(Mapa.class);
		Castillo castillo = new Castillo(new Posicion(1,1), mapa);
		Edificio cuartel = new Cuartel(new Posicion(4,1), mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(cuartel);
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		for(int i = 1; i <= 14; i++) {
			castillo.atacar();
		}
		
		exceptionRule.expect(EdificioDestruidoException.class);
		cuartel.recibirDanio(1);
	}
	
	@Test
	public void test_DadoUnCuartelYUnAldeanoQueSeEncuentranEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca14Veces_ElEdificioDeberiaEstarDestruidoYElAldeanoMuerto() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = Mockito.mock(Mapa.class);
		Castillo castillo = new Castillo(new Posicion(1,1), mapa);
		Edificio cuartel = new Cuartel(new Posicion(4,1), mapa);
		Unidad aldeano = new Aldeano(new Posicion(4,0), mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(cuartel);
		posicionables.add(aldeano);
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		for(int i = 1; i <= 14; i++) {
			castillo.atacar();
		}
		
		exceptionRule.expect(EdificioDestruidoException.class);
		cuartel.recibirDanio(1);
		
		exceptionRule.expect(EdificioDestruidoException.class);
		aldeano.recibirDanio(1);
	}
}
