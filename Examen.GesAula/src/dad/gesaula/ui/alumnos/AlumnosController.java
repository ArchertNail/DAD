package dad.gesaula.ui.alumnos;

import java.util.Optional;

import dad.gesaula.ui.GesAulaApp;
import dad.gesaula.ui.model.Alumno;
import javafx.beans.property.ListProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class AlumnosController {
	
	private GesAulaApp app;
	private ListProperty<Alumno> alumnos;
	private AlumnosView view;

	public AlumnosController() {
		view = new AlumnosView();
		view.getNuevoButton().setOnAction(e -> onNuevoAction(e));
		view.getEliminarButton().setOnAction(e -> onEliminarAction(e));
		view.getAlumnosTable().getSelectionModel().selectedItemProperty().addListener(
				(observable, anterior, nuevo) -> onAlumnosTableItemSelected(anterior, nuevo)
			);
	}
	
	public AlumnosView getView() {
		return view;
	}

	public GesAulaApp getApp() {
		return app;
	}

	public void setApp(GesAulaApp app) {
		this.app = app;
	}

	public void bind(ListProperty<Alumno> alumnos) {
		this.alumnos = alumnos;
		view.getAlumnosTable().itemsProperty().bind(alumnos);
	}
	
	private void onAlumnosTableItemSelected(Alumno anterior, Alumno nuevo) {
		view.getEditPane().unbind(anterior);
		if (nuevo == null) {
			view.showInfoPane();
		} else {
			view.getEditPane().bind(nuevo);
			view.showEditPane();
		}
	}
	
	private void onNuevoAction(ActionEvent e) {
		Alumno nuevo = new Alumno();
		nuevo.setNombre("Sin nombre");
		nuevo.setApellidos("Sin apellidos");
		this.alumnos.add(nuevo);
	}
	
	private void onEliminarAction(ActionEvent e) {
		Alumno seleccionado = view.getAlumnosTable().getSelectionModel().getSelectedItem();
		if (seleccionado == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("Eliminar alumno");
			alert.setHeaderText("Error al intentar eliminar un alumno.");
			alert.setContentText("No se ha seleccionado ningún alumno.");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("Eliminar alumno");
			alert.setHeaderText("Se va a eliminar al alumno '" + seleccionado + "'.");
			alert.setContentText("¿Está seguro?");
			Optional<ButtonType> opcion = alert.showAndWait();
			if (opcion.get().equals(ButtonType.OK)) {
				this.alumnos.remove(seleccionado);				
			}
		}
	}
	
}
