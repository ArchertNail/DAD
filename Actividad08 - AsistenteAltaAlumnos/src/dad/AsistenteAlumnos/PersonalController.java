package dad.AsistenteAlumnos;

import javafx.event.ActionEvent;

public class PersonalController {
	
	private PersonalView personalV;
	private AsistenteAlumnosApp app;
	
	public PersonalController(){
		personalV = new PersonalView();
	}
	
	public void bind(AsistenteAlumnosModelo alumno) {
		alumno.nombreProperty().bind(personalV.getNombreText().textProperty());
		alumno.apellido1Property().bind(personalV.getPrimerApellidoText().textProperty());
		alumno.apellido2Property().bind(personalV.getSegundoApellidoText().textProperty());
		alumno.fechaNacimientoProperty().bind(personalV.getFechaDatePicker().valueProperty());
		personalV.getEdad().textProperty().bind(alumno.edadProperty().asString().concat(" años"));
		personalV.getSiguienteBtn().setOnAction(e -> onSiguienteButtonAction(alumno));
	}
	
	public void onSiguienteButtonAction(AsistenteAlumnosModelo alumno) {
		app.irADomicilio();
	}

	public AsistenteAlumnosApp getApp() {
		return app;
	}

	public void setApp(AsistenteAlumnosApp app) {
		this.app = app;
	}

	public PersonalView getRoot(){
		return personalV;
	}
}
