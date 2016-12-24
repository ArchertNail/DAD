package dad.gesaula.ui.toolbar;

import java.io.File;
import java.util.Optional;

import dad.gesaula.ui.GesAulaApp;
import dad.gesaula.ui.model.Grupo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class ToolbarController {

	private GesAulaApp app;
	
	private ToolbarView view;

	private StringProperty nombreFichero;
	private ObjectProperty<Grupo> grupo;

	public ToolbarController() {
		view = new ToolbarView();

		nombreFichero = new SimpleStringProperty(this, "nombreFichero");
		nombreFichero.bind(view.getFicheroText().textProperty());
		
		view.getNuevoButton().setOnAction(e -> onNuevoButtonClicked(e));
		view.getGuardarButton().setOnAction(e -> onGuardarButtonClicked(e));
	}

	public ToolbarView getView() {
		return view;
	}
	
	public void bind(ObjectProperty<Grupo> grupo) {
		this.grupo = grupo;
	}

	public GesAulaApp getApp() {
		return app;
	}

	public void setApp(GesAulaApp app) {
		this.app = app;
	}

	private void onNuevoButtonClicked(ActionEvent e) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.initOwner(app.getPrimaryStage());
		alert.setTitle("Nuevo grupo");
		alert.setHeaderText("Va a crear un grupo nuevo.");
		alert.setContentText("¿Está seguro?");
		Optional<ButtonType> opcion = alert.showAndWait();
		if (opcion.get().equals(ButtonType.OK)) {
			grupo.set(new Grupo());
		}
	}

	private void onGuardarButtonClicked(ActionEvent e) {
		String ruta = nombreFichero.get();
		if (ruta != null && !ruta.isEmpty()) {
			try {
				grupo.get().save(new File(ruta));
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.initOwner(app.getPrimaryStage());
				alert.setTitle("Guardar grupo");
				alert.setHeaderText("Se ha guardado el grupo correctamente.");
				alert.setContentText("El grupo " + grupo.get().getDenominacion() + " se ha guardado en el fichero '" + ruta + "'.");
				alert.showAndWait();
				
			} catch (Exception ex) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.initOwner(app.getPrimaryStage());
				alert.setTitle("Guardar grupo");
				alert.setHeaderText("Error al guardar el grupo.");
				alert.setContentText(ex.getMessage());
				alert.showAndWait();
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("Guardar grupo");
			alert.setHeaderText("Error al guardar el grupo.");
			alert.setContentText("Debe especificar la ruta del fichero donde se guardará el grupo.");
			alert.showAndWait();
		}	
	}

}
