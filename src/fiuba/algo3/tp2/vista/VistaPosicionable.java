package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.Celda;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class VistaPosicionable {
	
	private Mapa mapa;

	private ContenedorMapa contenedorMapa;
	private ContenedorControles contenedorControles;
	
	private VistaAldeano vistaAldeano;
	private VistaEspadachin vistaEspadachin;
	private VistaArquero vistaArquero;
	private VistaArmaAsedio vistaArmaAsedio;
	private VistaCuartel vistaCuartel;
	private VistaPlazaCentral vistaPlazaCentral;
	private VistaCastillo vistaCastillo;
	
	
	public VistaPosicionable() {
		
		super();
		this.vistaAldeano = new VistaAldeano(this);
		this.vistaEspadachin = new VistaEspadachin();
		this.vistaArquero = new VistaArquero();
		this.vistaArmaAsedio = new VistaArmaAsedio();
		this.vistaCuartel = new VistaCuartel();
		this.vistaPlazaCentral = new VistaPlazaCentral();
		this.vistaCastillo = new VistaCastillo();
	}
	
	public void dibujarPosicionables() {
		
        for(Node nodo : contenedorMapa.getChildren()) {
			if(nodo instanceof Pane) {
				
				Pane pane = (Pane) nodo;
				int colIndex = contenedorMapa.obtenerColumnIndex(pane);
				int rowIndex = contenedorMapa.obtenerRowIndex(pane);
				Celda celda = mapa.obtenerCelda(new Posicion(colIndex, rowIndex));
				Posicionable posicionable = celda.obtenerPosicionable();
				
				dibujarPosicionable(posicionable, pane);
			}
        }
	}

	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		
		if(posicionable != null) {
			
    		if(posicionable instanceof Aldeano) {
    			
    			vistaAldeano.dibujar((Aldeano)posicionable, pane);
    	        
    		} else if(posicionable instanceof Espadachin) {
    			
    			vistaEspadachin.dibujar((Espadachin)posicionable, pane);
    			
    		} else if(posicionable instanceof Arquero) {
    			
    			vistaArquero.dibujar((Arquero)posicionable, pane);
    			
    		} else if(posicionable instanceof ArmaAsedio) {
    			
    			vistaArmaAsedio.dibujar((ArmaAsedio)posicionable, pane);
    			
    		} else if(posicionable instanceof Cuartel) {
    			
    			vistaCuartel.dibujar((Cuartel)posicionable, pane);
    			
    		} else if(posicionable instanceof PlazaCentral) {
    			
    			vistaPlazaCentral.dibujar((PlazaCentral)posicionable, pane);
    			
    		} else if(posicionable instanceof Castillo) {
    			
    			vistaCastillo.dibujar((Castillo)posicionable, pane);
    			
    		}
		}
	}

	public void dibujarPosicionable(Posicionable posicionable, Posicion posicionAnterior) {
		
		if(posicionable != null) {
			
    		if(posicionable instanceof Aldeano) {
    			
    			vistaAldeano.dibujar((Aldeano)posicionable, posicionAnterior);
    	        
    		} else if(posicionable instanceof Espadachin) {
    			
    			vistaEspadachin.dibujar((Espadachin)posicionable, posicionAnterior);
    			
    		} else if(posicionable instanceof Arquero) {
    			
    			vistaArquero.dibujar((Arquero)posicionable, posicionAnterior);
    			
    		} else if(posicionable instanceof ArmaAsedio) {
    			
    			vistaArmaAsedio.dibujar((ArmaAsedio)posicionable, posicionAnterior);
    			
    		} else if(posicionable instanceof Cuartel) {
    			
    			vistaCuartel.dibujar((Cuartel)posicionable, posicionAnterior);
    			
    		} else if(posicionable instanceof PlazaCentral) {
    			
    			vistaPlazaCentral.dibujar((PlazaCentral)posicionable, posicionAnterior);
    			
    		} else if(posicionable instanceof Castillo) {
    			
    			vistaCastillo.dibujar((Castillo)posicionable, posicionAnterior);
    			
    		}
		}
	}

	public void dibujarControles(Pane nodo) {
		
		int colIndex = contenedorMapa.obtenerColumnIndex(nodo);
		int rowIndex = contenedorMapa.obtenerRowIndex(nodo);
		
		Posicionable posicionable = mapa.obtenerPosicionable(new Posicion(colIndex, rowIndex));
		contenedorControles.clean();
		
		if(posicionable != null) {
    		if(posicionable instanceof Aldeano) {
    			vistaAldeano.dibujarControles((Aldeano)posicionable);
    		} else if(posicionable instanceof Castillo){
    			vistaCastillo.dibujarControles((Castillo)posicionable, mapa);
			} else if(posicionable instanceof Cuartel) {
				vistaCuartel.dibujarControles((Cuartel) posicionable, mapa);
			} else if(posicionable instanceof PlazaCentral){
    			vistaPlazaCentral.dibujarControles((PlazaCentral) posicionable);
			} else if(posicionable instanceof Arquero) {
				vistaArquero.dibujarControles((Arquero) posicionable);
			} else if(posicionable instanceof Espadachin){
    			vistaEspadachin.dibujarControles((Espadachin) posicionable);
			} else if(posicionable instanceof ArmaAsedio){
    			vistaArmaAsedio.dibujarControles((ArmaAsedio) posicionable);
			}
		}
	}

	public void setContenedorControles(ContenedorControles contenedorControles) {
		
		this.contenedorControles = contenedorControles;
		
		this.vistaAldeano.setContenedorControles(contenedorControles);

		this.vistaArmaAsedio.setContenedorControles(contenedorControles);

		this.vistaEspadachin.setContenedorControles(contenedorControles);

		this.vistaPlazaCentral.setContenedorControles(contenedorControles);

		this.vistaArquero.setContenedorControles(contenedorControles);

		this.vistaCastillo.setContenedorControles(contenedorControles);

		this.vistaCuartel.setContenedorControles(contenedorControles);
	}
	
	public void setContenedorMapa(ContenedorMapa contenedorMapa) {
		
		this.contenedorMapa = contenedorMapa;
		this.vistaAldeano.setContenedorMapa(contenedorMapa);
	}
	
	public void setVistaSeleccionador(VistaSeleccionador vistaSeleccionador) {
		
		this.vistaAldeano.setVistaSeleccionador(vistaSeleccionador);
	}
	
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public void limpiarControles() {
		contenedorControles.clean();
	}
}
