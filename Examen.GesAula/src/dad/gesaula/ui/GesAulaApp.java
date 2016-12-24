package dad.gesaula.ui;

import java.io.File;

import dad.gesaula.ui.model.Grupo;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GesAulaApp extends Application {
	
	private ObjectProperty<Grupo> grupo;

	private Stage primaryStage;

	private RootController rootController;

	@Override
	public void start(Stage primaryStage) throws Exception {
		grupo = new SimpleObjectProperty<>(this, "grupo", new Grupo());
		grupo.addListener((observable, viejoGrupo, nuevoGrupo) -> onNuevoGrupo());
		
		rootController = new RootController();
		rootController.setApp(this);
		rootController.bind(grupo);
		
		Scene scene = new Scene(rootController.getView(), 640, 480);
		
		this.primaryStage = primaryStage;
		this.primaryStage.getIcons().add(new Image(getClass().getResource("resources/app-icon-64x64.png").toExternalForm()));		
		this.primaryStage.setTitle("GesAula");
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
	}

	private void onNuevoGrupo() {
		rootController.bind(grupo);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void guardar(String ruta) {
		if (ruta != null && !ruta.isEmpty()) {
			try {
				grupo.get().save(new File(ruta));
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.initOwner(primaryStage);
				alert.setTitle("Guardar grupo");
				alert.setHeaderText("Se ha guardado el grupo correctamente.");
				alert.setContentText("El grupo " + grupo.get().getDenominacion() + " se ha guardado en el fichero '" + ruta + "'.");
				alert.showAndWait();
				
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.initOwner(primaryStage);
				alert.setTitle("Guardar grupo");
				alert.setHeaderText("Error al guardar el grupo.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(primaryStage);
			alert.setTitle("Guardar grupo");
			alert.setHeaderText("Error al guardar el grupo.");
			alert.setContentText("Debe especificar la ruta del fichero donde se guardará el grupo.");
			alert.showAndWait();
		}
	}
	
}
