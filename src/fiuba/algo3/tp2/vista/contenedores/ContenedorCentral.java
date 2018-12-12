package fiuba.algo3.tp2.vista.contenedores;

import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class ContenedorCentral extends Pane {

	private Pane cursor;
	
	public ContenedorCentral (ContenedorMapa contenedorMapa) {
		
		setCursor(Cursor.NONE);
		
		cursor = new Pane();
		
		cursor.setPickOnBounds(false);
		cursor.setPrefHeight(50);
		cursor.setMaxHeight(50);
		cursor.setMinHeight(50);
		cursor.setPrefWidth(50);
		cursor.setMaxWidth(50);
		cursor.setMinWidth(50);
		
		
		cursor.setBackground(new Background(
								new BackgroundImage(
										new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cursor.png"), 
										BackgroundRepeat.NO_REPEAT, 
										BackgroundRepeat.NO_REPEAT, 
										BackgroundPosition.DEFAULT, 
										BackgroundSize.DEFAULT)));
		
		
		setOnMouseMoved(e -> cursor.relocate(e.getX(), e.getY()));
		setOnMouseExited(e -> cursor.setVisible(false));
		setOnMouseEntered(e -> cursor.setVisible(true));
		
		contenedorMapa.setContenedorPadre(this);
		getChildren().add(contenedorMapa);
		getChildren().add(cursor);		
	}
	
	public void setImagenCursor(Image imagen) {
		
		cursor.setBackground(new Background(
				new BackgroundImage(
						imagen, 
						BackgroundRepeat.NO_REPEAT, 
						BackgroundRepeat.NO_REPEAT, 
						BackgroundPosition.DEFAULT, 
						BackgroundSize.DEFAULT)));
	}

	public void setCursorDefault() {
		setImagenCursor(new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cursor.png"));
	}

	public void setCursorAtaque() {
		setImagenCursor(new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cursor-atacar.png"));
	}

	public void setCursorReparar() {
		setImagenCursor(new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cursor-construir.png"));
	}
}
