package fiuba.algo3.tp2.integracion.entrega_2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Ataque.Atacador;
import fiuba.algo3.tp2.edificio.AtacadorZona;
import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.unidad.UnidadMuertaException;
import fiuba.algo3.tp2.unidad.UnidadNoAtacableException;

/**
 * Tests de Ataques de unidades y castillo
 *
 */
public class Test03 {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	// ESPADACHIN
	
	@Test
	public void testUnEspadachinAtacaAUnAldeanoDentroDeSuRangoHastaMatarlo() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadMuertaException, EdificioDestruidoException, AtaqueFueraDeRangoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador espadachin = new Espadachin(new Posicion(1,1), mapa);
		Atacable aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		espadachin.atacar(aldeano);
		espadachin.atacar(aldeano);
		
		exceptionRule.expect(UnidadMuertaException.class);
		espadachin.atacar(aldeano);
	}
	
	@Test
	public void testUnEspadachinAtacaUnCuartelHastaDestruirlo() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador espadachin = new Espadachin(new Posicion(1,1), mapa);
		Atacable cuartel = new Cuartel(new Posicion(2,1), mapa);
		
		for(int i = 0; i < 17; i++) {
			espadachin.atacar(cuartel);
		}
		
		exceptionRule.expect(EdificioDestruidoException.class);
		espadachin.atacar(cuartel);
	}
	
	@Test
	public void testUnEspadachinAtacaUnAldeanoFueraDeSuRango() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador espadachin = new Espadachin(new Posicion(1,1), mapa);
		Atacable aldeano = new Aldeano(new Posicion(3,1), mapa);
		
		exceptionRule.expect(AtaqueFueraDeRangoException.class);
		espadachin.atacar(aldeano);
	}
	
	//ARQUERO
	
	@Test
	public void testUnArqueroAtacaUnAldeanoFueraDeSuRango() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador arquero = new Arquero(new Posicion(1,1), mapa);
		Atacable aldeano = new Aldeano(new Posicion(5,1), mapa);
		
		exceptionRule.expect(AtaqueFueraDeRangoException.class);
		arquero.atacar(aldeano);
	}
	
	@Test
	public void testUnArqueroAtacaUnAldeanoHastaMatarlo() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador arquero = new Arquero(new Posicion(1,1), mapa);
		Atacable aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		arquero.atacar(aldeano);
		arquero.atacar(aldeano);
		arquero.atacar(aldeano);
		arquero.atacar(aldeano);
		
		exceptionRule.expect(UnidadMuertaException.class);
		arquero.atacar(aldeano);
	}
	
	@Test
	public void testUnArqueroAtacaUnCuartelHastaDestruirlo() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador arquero = new Arquero(new Posicion(1,1), mapa);
		Atacable cuartel = new Cuartel(new Posicion(4,1), mapa);
		
		for(int i = 1; i < 26; i++) {
			arquero.atacar(cuartel);
		}
		
		exceptionRule.expect(EdificioDestruidoException.class);
		arquero.atacar(cuartel);
	}
	
	// ARMA DE ASEDIO
	
	@Test
	public void testUnArmaDeAsedioAtacaUnAldeano() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		Atacable aldeano = new Aldeano(new Posicion(5,1), mapa);
		
		exceptionRule.expect(UnidadNoAtacableException.class);
		armaAsedio.atacar(aldeano);
	}

	@Test
	public void testUnArmaDeAsedioAtacaUnCuartelFueraDeSuRango() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		Atacable cuartel = new Cuartel(new Posicion(7,1), mapa);
		
		exceptionRule.expect(AtaqueFueraDeRangoException.class);
		armaAsedio.atacar(cuartel);
	}
	
	@Test
	public void testUnArmaDeAsedioAtacaUnCuartelHastaDestruirlo() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		Atacable cuartel = new Cuartel(new Posicion(2,1), mapa);
		
		armaAsedio.atacar(cuartel);
		armaAsedio.atacar(cuartel);
		armaAsedio.atacar(cuartel);
		armaAsedio.atacar(cuartel);
		
		exceptionRule.expect(EdificioDestruidoException.class);
		armaAsedio.atacar(cuartel);
	}
	
	// CASTILLO
	
	@Test
	public void testUnCastilloAtacaUnaZonaEnLaQueHayUnAldeanoHastaMatarlo() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = new Mapa(250, 250);
		AtacadorZona castillo = new Castillo(new Posicion(5,5), mapa);
		Atacador espadachin = new Espadachin(new Posicion(9,5), mapa);
		Atacable aldeano = new Aldeano(new Posicion(10,5), mapa);
		
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		
		exceptionRule.expect(UnidadMuertaException.class);
		espadachin.atacar(aldeano);
	}
	
	@Test
	public void testUnCastilloAtacaUnaZonaEnLaQueHayUnAldeanoHastaMatarloYContinuaAtacando() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = new Mapa(250, 250);
		AtacadorZona castillo = new Castillo(new Posicion(5,5), mapa);
		Atacador espadachin = new Espadachin(new Posicion(9,5), mapa);
		Atacable aldeano = new Aldeano(new Posicion(10,5), mapa);
		
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		
		exceptionRule.expect(UnidadMuertaException.class);
		espadachin.atacar(aldeano);
	}
	
	@Test
	public void testUnCastilloAtacaUnaZonaConUnAldeanoFueraDeLaZonaAldeanoFueraDeLaZonaDeAtaque() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = new Mapa(250, 250);
		AtacadorZona castillo = new Castillo(new Posicion(5,5), mapa);
		Atacador espadachin = new Espadachin(new Posicion(11,5), mapa);
		Atacable aldeano = new Aldeano(new Posicion(12,5), mapa);
		
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		
		espadachin.atacar(aldeano);
		espadachin.atacar(aldeano);
		exceptionRule.expect(UnidadMuertaException.class);
		espadachin.atacar(aldeano);
	}
	
	@Test
	public void testUnCastilloAtacaUnCuartelQueSeEncuentraEnLaZonaDeAtaque() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = new Mapa(250, 250);
		AtacadorZona castillo = new Castillo(new Posicion(5,5), mapa);
		Atacador espadachin = new Espadachin(new Posicion(10,5), mapa);
		Atacable cuartel = new Cuartel(new Posicion(11,5), mapa);
		
		for(int i = 1; i <= 14; i++) {
			castillo.atacar();
		}
		
		exceptionRule.expect(EdificioDestruidoException.class);
		espadachin.atacar(cuartel);
	}
	
	@Test
	public void testUnCastilloAtacaCuandoHayUnCuartelFueraDeLaZonaDeAtaque() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = new Mapa(250, 250);
		AtacadorZona castillo = new Castillo(new Posicion(5,5), mapa);
		Atacador espadachin = new Espadachin(new Posicion(11,5), mapa);
		Atacable cuartel = new Cuartel(new Posicion(12,5), mapa);
		
		for(int i = 1; i <= 14; i++) {
			castillo.atacar();
		}
		
		for(int i = 1; i <= 17; i++) {
			espadachin.atacar(cuartel);
		}
		exceptionRule.expect(EdificioDestruidoException.class);
		espadachin.atacar(cuartel);
	}
}