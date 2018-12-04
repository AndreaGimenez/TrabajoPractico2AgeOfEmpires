package fiuba.algo3.tp2.vista;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Musica {
	MediaPlayer mediaPlayer;
	Media cancion;
	
	public Musica(String cancionInicioJuego) {
		//String cancionInicioJuego = "src/fiuba/algo3/tp2/vista/MusicaDeInicio.mp3";
		this.cancion = new Media(new File(cancionInicioJuego).toURI().toString());
		this.mediaPlayer = new MediaPlayer(cancion);
	}
	
	public MediaPlayer iniciarReproduccionMusica() {
        mediaPlayer.play();
        return mediaPlayer;
	}
	
	public void detenerReproduccionMusica() {
		mediaPlayer.stop();
	}
}
