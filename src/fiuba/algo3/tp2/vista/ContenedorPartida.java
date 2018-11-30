package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Celda;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.vista.eventos.ButtonAvanzarTurnoHandler;
import fiuba.algo3.tp2.vista.interfaces.AccionesDeAldeano;
import fiuba.algo3.tp2.vista.interfaces.AccionesDeCuartel;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContenedorPartida extends BorderPane {

    BarraDeMenu menuBar;
    VistaMapa vistaMapa;
    Canvas canvasCentral;
    GridPane contenedorCentral;
    AccionesDeAldeano accionesDeAldeano;
    AccionesDeCuartel accionesDeCuartel;
    AccionesDeCastillo accionesDeCastillo;

    public ContenedorPartida(Stage stage, Juego juego) throws CeldaOcupadaException, CeldaInexistenteException {
        this.setMenu(stage);
        this.setMapa(juego, stage);
        this.setControles(juego);
        this.setEstadoJugador(juego);
    }

    private void setControles(Juego juego) {

        //this.accionesDeAldeano = new AccionesDeAldeano();
        //this.accionesDeAldeano.mostrarAcciones(this);

        //this.accionesDeCuartel = new AccionesDeCuartel();
        //this.accionesDeCuartel.mostrarAcciones(this);

        //this.accionesDeCastillo = new AccionesDeCastillo();
        //this.accionesDeCastillo.mostrarAcciones(this);

    	Label labelNombreUnidad = new Label();
        labelNombreUnidad.setText("Aldeano");
        
        Label labelAcciones = new Label();
        labelAcciones.setText("Acciones");
        
        Button botonConstruir = new Button();
        botonConstruir.setText("Construir");
        /*
         * Agregar handler
         * BotonConstruirHandler botonConstruirHandler = new BotonConstruirHandler();
         * botonConstruir.setOnAction(botonConstruirHandler);
         */
        BotonEnter botonEnter = new BotonEnter();
        botonEnter.disparar(botonConstruir);

        VBox contenedorVertical = new VBox(labelNombreUnidad, labelAcciones, botonConstruir);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setStyle("-fx-background-color: brown;");
        contenedorVertical.setPrefWidth(200);
        
        this.setLeft(contenedorVertical);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setMapa(Juego juego, Stage stage) throws CeldaOcupadaException, CeldaInexistenteException {
    	
        vistaMapa = new VistaMapa(juego.obtenerMapa());
        vistaMapa.dibujar();
        
        Mapa mapa = juego.obtenerMapa();
        contenedorCentral = new GridPane();
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setGridLinesVisible(true);
        
        
        for (int i = 0; i < mapa.getTamanioX(); i++) {
            RowConstraints row = new RowConstraints(50);
            contenedorCentral.getRowConstraints().add(row);
        }
        for (int i = 0; i < mapa.getTamanioY(); i++) {
            ColumnConstraints col = new ColumnConstraints(50);
            contenedorCentral.getColumnConstraints().add(col);
        }
        
        for (int i = 0 ; i < mapa.getTamanioX() ; i++) {
            for (int j = 0; j < mapa.getTamanioY(); j++) {
            	
            	Celda celda = mapa.obtenerCelda(new Posicion(i, j));
            	Posicionable posicionable = celda.obtenerPosicionable();
            	
            	
            	Pane pane = new Pane();
            	if(posicionable != null) {
            		pane.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
            	}
                pane.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						int colIndex = GridPane.getColumnIndex((Pane)event.getSource());
						int rowIndex = Math.abs(GridPane.getRowIndex((Pane)event.getSource()) - (mapa.getTamanioY() - 1));
					}
				});
                contenedorCentral.add(pane, i, Math.abs(j - (mapa.getTamanioY() - 1)));
            }
        }
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(contenedorCentral);
        
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(scrollPane);
    }

    private void setEstadoJugador(Juego juego) {
    	
    	ContenedorEstadoJugador contenedorEstadoJugador = new ContenedorEstadoJugador();
        Button botonAvanzarTurno = new Button("Avanzar Turno");
        VistaEstadoJugador vistaEstadoJugador = new VistaEstadoJugador(juego, contenedorEstadoJugador);
        
        ButtonAvanzarTurnoHandler botonAvanzarTurnoHandler = new ButtonAvanzarTurnoHandler(vistaEstadoJugador, juego);
        botonAvanzarTurno.setOnAction(botonAvanzarTurnoHandler);
        contenedorEstadoJugador.getChildren().add(botonAvanzarTurno);
        
        botonAvanzarTurno.setOnKeyPressed(evento -> {if(evento.getCode() == KeyCode.ENTER) {
        	botonAvanzarTurno.fire();
	    	evento.consume();
	    	}
	    });
        
        vistaEstadoJugador.actualizar();
        
        this.setBottom(contenedorEstadoJugador);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}
