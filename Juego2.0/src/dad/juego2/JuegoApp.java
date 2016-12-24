package dad.juego2;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JuegoApp extends Application {

	
	public static Pane juegoRoot = new Pane();
	public static Pane appRoot = new Pane();
	
	
	public static final int TAMANIO_BLOQUE = 30;
	
	public Protagonista protagonista;
	
	
	private void cargarJuego(){
		
		System.out.println(NivelesDatos.NIVEL1.length);
		
		
		for(int i=0; i<NivelesDatos.NIVEL1.length; i++){
			String columnas = NivelesDatos.NIVEL1[i];
			for(int j=0; j<columnas.length(); j++){
				
				System.out.println("fila: "+ i + "columna: " + j);
				switch (columnas.charAt(j)) {
				case '0':
					break;
				case '1':
					Bloques suelo = new Bloques(Bloques.tipoBloque.SUELO, j*TAMANIO_BLOQUE, i * TAMANIO_BLOQUE);
					juegoRoot.getChildren().add(suelo);
					break;
				case '3':
					Bloques muro = new Bloques(Bloques.tipoBloque.MURO, j*TAMANIO_BLOQUE, i*TAMANIO_BLOQUE);
					juegoRoot.getChildren().add(muro);
					break;
				}
			}
		}
		
		
		
		protagonista = new Protagonista();
		protagonista.setTranslateX(10);
		protagonista.setTranslateY(280);
		
		juegoRoot.getChildren().add(protagonista);
		
		appRoot.getChildren().add(juegoRoot);
		
	}
	
	
	
	private void update() {
		
	}
	
	
	public void start(Stage primaryStage) throws Exception {
		
		cargarJuego();
		
		Scene scene = new Scene(appRoot,640,440);
		
		
		primaryStage.setTitle("juego2.0");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		AnimationTimer timer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				update();
				
			}
		};
		//timer.start();
		
		
	}
	

	public static void main(String[] args) {
		launch(args);

	}

}
