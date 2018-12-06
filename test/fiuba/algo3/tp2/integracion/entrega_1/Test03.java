/*package fiuba.algo3.tp2.integracion.entrega_1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.excepciones.EdificioEnConstruccionException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.excepciones.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.edificio.GestionarConstruccion;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.excepciones.UnidadNoSoportadaException;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class Test03 {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	//PLAZA CENTRAL
	
	@Test
	public void test_DadaUnaPlazaCentral_CrearUnAldeanoEnLaPosicionElegidaDeberidaSerValido() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(1, 1), mapa);
		GestionarConstruccion gestorPlaza = new GestionarConstruccion(plazaCentral);
		
		Aldeano aldeano = gestorPlaza.crearAldeano(new Posicion(3, 1), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(3,1), mapa);
	}
	
	@Test
	public void test_DadaUnaPlazaCentral_NoDeberiaPoderCrearEspadachin_DeberiaLazarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(1, 1), mapa);
		GestionarConstruccion gestorPlaza = new GestionarConstruccion(plazaCentral);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		Espadachin espadachin = gestorPlaza.crearEspadachin(new Posicion(4, 4), mapa);
	}
	
	@Test
	public void test_DadaUnaPlazaCentral_NoDeberiaPoderCrearArquero_DeberiaLanzarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(1, 1), mapa);
		GestionarConstruccion gestorPlaza = new GestionarConstruccion(plazaCentral);
		exceptionRule.expect(UnidadNoSoportadaException.class);
		Arquero arquero = gestorPlaza.crearArquero(new Posicion(3, 1), mapa);
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnLaPosicionX3Y3_AlCrearUnAldeanoEnUnaPosicionYaOcupadaDeberiaDarError() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(3, 3), mapa);
		Aldeano unAldeano = new Aldeano(new Posicion(7, 7), mapa);
		GestionarConstruccion gestorPlaza = new GestionarConstruccion(plazaCentral);
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano otroAldeano = gestorPlaza.crearAldeano(new Posicion(7, 7), mapa);
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnLaPosicionX3Y3_AlCrearUnAldeanoEnUnaPosicionFueraDelMapaDeberiaDarError() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(3, 3), mapa);
		GestionarConstruccion gestorPlaza = new GestionarConstruccion(plazaCentral);
		exceptionRule.expect(CeldaInexistenteException.class);
		Aldeano unAldeano = gestorPlaza.crearAldeano(new Posicion(300, 300), mapa);
	}
	
	//CASTILLO
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_DebePoderCrearUnArmaDeAsedioEnLaPosicionSolicitada() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		GestionarConstruccion gestorCastillo = new GestionarConstruccion(castillo);
		ArmaAsedio armaAsedio = gestorCastillo.crearArmaAsedio(new Posicion(5, 5), mapa);
		
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_AlCrearUnArmaDeAsedioEnLaPosicionX3Y3_DebeLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		GestionarConstruccion gestorCastillo = new GestionarConstruccion(castillo);
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio armaAsedio = gestorCastillo.crearArmaAsedio(new Posicion(3,3), mapa);
		
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_NoDebePoderCrearUnAldeano_DebeLanzarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		GestionarConstruccion gestorCastillo = new GestionarConstruccion(castillo);
		exceptionRule.expect(UnidadNoSoportadaException.class);
		Aldeano aldeano = gestorCastillo.crearAldeano(new Posicion(6,6), mapa);
		
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_NoDebePoderCrearUnEspadachin_DebeLanzarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		GestionarConstruccion gestorCastillo = new GestionarConstruccion(castillo);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		Espadachin espadachin = gestorCastillo.crearEspadachin(new Posicion(6,6), mapa);	
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_NoDebePoderCrearUnArquero_DebeLanzarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		GestionarConstruccion gestorCastillo = new GestionarConstruccion(castillo);

		exceptionRule.expect(UnidadNoSoportadaException.class);
		Arquero arquero = gestorCastillo.crearArquero(new Posicion(6,6), mapa);
		
	}
	
	@Test 
	public void test_DadoUnCastillo_AlQuererCrearUnArmaDeAsedioEnUnaPosicionYaOcupada_DebeLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		Cuartel cuartel = new Cuartel(new Posicion(6, 4), mapa);
		GestionarConstruccion gestorCastillo = new GestionarConstruccion(castillo);
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio armaAsedio = gestorCastillo.crearArmaAsedio(new Posicion(6,4), mapa);
	}
	
	//CUARTEL

	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1_SeDebePoderCrearUnEspadachinEnLaPosicionIndicada()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdificioEnConstruccionException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(250, 250);
		Jugador jugador = new Jugador("Ana", mapa);
		
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);
		
		jugador.agregarEdificio(cuartel, false);
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);
		
		Espadachin espadachin = gestorCuartel.crearEspadachin(new Posicion(4, 4), mapa);
	}
	
	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1_SeDebePoderCrearUnArqueroEnLaPosicionIndicada()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);
		GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);
		
		Arquero arquero = gestorCuartel.crearArquero(new Posicion(4, 4), mapa);	
	}
	
	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1_NoDebePoderCrearAldeano()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);
		GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);

		exceptionRule.expect(UnidadNoSoportadaException.class);
		Aldeano aldeano = gestorCuartel.crearAldeano(new Posicion(4, 4), mapa);	
	}
	
	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1_NoDebePoderCrearArmaAsedio()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);
		GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);

		exceptionRule.expect(UnidadNoSoportadaException.class);
		ArmaAsedio armaAsedio = gestorCuartel.crearArmaAsedio(new Posicion(4,4), mapa);	
	}
	
	@Test
	public void test_DadoUnCuartel_AlCrearUnEspadachinEnUnaPosicionYaOcupada_DebeLanzarCeldaOcupadaException()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
		Cuartel cuartel = new Cuartel(new Posicion(2,2), mapa);
		GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);

		exceptionRule.expect(CeldaOcupadaException.class);
		gestorCuartel.crearEspadachin(new Posicion(5, 5), mapa);
	}
}*/
