package fiuba.algo3.tp2.vista;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Age of Empires");
        
        String cancionInicioJuego = "src/fiuba/algo3/tp2/vista/MusicaDeInicio.mp3";
        Media musica = new Media(new File(cancionInicioJuego).toURI().toString());
        
        MediaPlayer mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.play();
        
        ContenedorIngresoJugadores contenedorIngresoJugadores = new ContenedorIngresoJugadores(stage);
        Scene escenaIngresoJugadores = new Scene(contenedorIngresoJugadores, 640, 480);

        ContenedorInicio contenedorBienvenidos = new ContenedorInicio(stage, escenaIngresoJugadores);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();

    }
}