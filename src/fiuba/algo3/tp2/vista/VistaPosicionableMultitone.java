package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.vista.contenedores.ContenedorControles;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;

public class VistaPosicionableMultitone {	
	
	private static VistaPosicionableMultitone multitone;
	
	private VistaAldeano vistaAldeano;
	private VistaEspadachin vistaEspadachin;
	private VistaArquero vistaArquero;
	private VistaArmaAsedio vistaArmaAsedio;
	private VistaCuartel vistaCuartel;
	private VistaPlazaCentral vistaPlazaCentral;
	private VistaCastillo vistaCastillo;
	
	private VistaPosicionableMultitone(ContenedorControles contenedorControles,
									ContenedorMapa contenedorMapa,
									VistaSeleccionador vistaSeleccionador,
									VistaMapa vistaMapa,
									Mapa mapa,
									Juego juego) {
		
		//vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, vistaSeleccionador, vistaMapa, juego);
		//vistaEspadachin = new VistaEspadachin(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, vistaSeleccionador, vistaMapa, juego);
		//vistaArquero = new VistaArquero(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, vistaSeleccionador, vistaMapa, juego);
		vistaArmaAsedio = new VistaArmaAsedio(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, vistaSeleccionador, vistaMapa, juego);
		vistaCuartel = new VistaCuartel(ContenedorPartida.contenedorMapa, ContenedorPartida.contenedorControles, vistaMapa, vistaSeleccionador, juego, null);
		//vistaPlazaCentral = new VistaPlazaCentral(ContenedorPartida.contenedorMapa, ContenedorPartida.contenedorControles, vistaMapa, vistaSeleccionador, juego);
		vistaCastillo = new VistaCastillo(ContenedorPartida.contenedorMapa, ContenedorPartida.contenedorControles, vistaMapa, vistaSeleccionador, juego);
	}
	
	public static void init(ContenedorControles contenedorControles,
					 		ContenedorMapa contenedorMapa,
					 		VistaSeleccionador vistaSeleccionador,
					 		VistaMapa vistaMapa,
					 		Mapa mapa,
					 		Juego juego) {
		
		if(multitone == null) {
			multitone = new VistaPosicionableMultitone(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, vistaSeleccionador, vistaMapa, mapa, juego);
		}
		
	}
	
	public static VistaPosicionable getInstance(Posicionable posicionable) {
		if(multitone != null) {
			return multitone.obtenerVista(posicionable);
		}else {
			throw new RuntimeException("Debe inicializar antes de obtener una instancia");
		}
	}

	private VistaPosicionable obtenerVista(Posicionable posicionable) {
		
		VistaPosicionable vistaPosicionable = null;
		
		if(posicionable instanceof Aldeano) {
			
			vistaPosicionable = vistaAldeano;
	        
		} else if(posicionable instanceof Espadachin) {
			
			vistaPosicionable = vistaEspadachin;
			
		} else if(posicionable instanceof Arquero) {
			
			vistaPosicionable = vistaArquero;
			
		} else if(posicionable instanceof ArmaAsedio) {
			
			vistaPosicionable = vistaArmaAsedio;
			
		} else if(posicionable instanceof Cuartel) {
			
			vistaPosicionable = vistaCuartel;
			
		} else if(posicionable instanceof PlazaCentral) {
			
			vistaPosicionable = vistaPlazaCentral;
			
		} else if(posicionable instanceof Castillo) {
			
			vistaPosicionable = vistaCastillo;
		}
		
		return vistaPosicionable;
	}
}
