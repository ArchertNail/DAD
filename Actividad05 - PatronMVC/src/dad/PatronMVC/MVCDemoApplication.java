package dad.PatronMVC;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVCDemoApplication extends Application {
	
	private DatosModelo datosModel;
	private VerController verController;
	private ModificarController modificarController;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Modelo
		datosModel = new DatosModelo();
		
		//Ventana Ver
		verController = new VerController(datosModel);
		Scene verScene = new Scene(verController.getRoot(),320,200);
		primaryStage.setScene(verScene);
		primaryStage.setOnCloseRequest(e-> Platform.exit());
		primaryStage.show();
		
		//Ventana Modificar
		modificarController = new ModificarController(datosModel);
		Stage secondaryStage = new Stage();
		Scene modificarScene = new Scene(modificarController.getRoot2(),320,200);
		secondaryStage.setScene(modificarScene);
		secondaryStage.setX(primaryStage.getX() + primaryStage.getWidth() + 5);
		secondaryStage.setY(primaryStage.getY());
		secondaryStage.setOnCloseRequest(e-> Platform.exit());
		secondaryStage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
