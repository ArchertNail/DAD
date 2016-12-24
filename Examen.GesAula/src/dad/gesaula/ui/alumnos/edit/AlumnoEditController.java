package dad.gesaula.ui.alumnos.edit;

import dad.gesaula.ui.model.Alumno;
import dad.gesaula.ui.model.Sexo;

public class AlumnoEditController {

	private AlumnoEditView view;

	public AlumnoEditController() {
		view = new AlumnoEditView();
		view.getSexoCombo().getItems().addAll(Sexo.values());
	}
	
	public AlumnoEditView getView() {
		return view;
	}

	public void bind(Alumno alumno) {
		view.getNombreText().textProperty().bindBidirectional(alumno.nombreProperty());
		view.getApellidosText().textProperty().bindBidirectional(alumno.apellidosProperty());
		view.getFechaNacimientoDatePicker().valueProperty().bindBidirectional(alumno.fechaNacimientoProperty());		
		view.getSexoCombo().valueProperty().bindBidirectional(alumno.sexoProperty());		
		view.getRepiteCheck().selectedProperty().bindBidirectional(alumno.repiteProperty());		
	}

	public void unbind(Alumno alumno) {
		if (alumno == null) return;
		view.getNombreText().textProperty().unbindBidirectional(alumno.nombreProperty());
		view.getApellidosText().textProperty().unbindBidirectional(alumno.apellidosProperty());
		view.getFechaNacimientoDatePicker().valueProperty().unbindBidirectional(alumno.fechaNacimientoProperty());
		view.getSexoCombo().valueProperty().unbindBidirectional(alumno.sexoProperty());		
		view.getRepiteCheck().selectedProperty().unbindBidirectional(alumno.repiteProperty());		
	}
	
}
