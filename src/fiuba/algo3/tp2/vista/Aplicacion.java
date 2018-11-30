package fiuba.algo3.tp2.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Age of Empires");
        
        ContenedorIngresoJugadores contenedorIngresoJugadores = new ContenedorIngresoJugadores(stage);
        Scene escenaIngresoJugadores = new Scene(contenedorIngresoJugadores, 640, 480);

        ContenedorInicio contenedorBienvenidos = new ContenedorInicio(stage, escenaIngresoJugadores);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();

    }
}