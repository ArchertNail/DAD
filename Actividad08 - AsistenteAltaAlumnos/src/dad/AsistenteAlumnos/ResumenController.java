package dad.AsistenteAlumnos;

import javafx.event.ActionEvent;

public class ResumenController {
	private ResumenView resumenView;
	private AsistenteAlumnosApp app;
	
	public ResumenController(){
		resumenView = new ResumenView();
	}
	
	public void bind(AsistenteAlumnosModelo alumno) {
		resumenView.getResumenArea().textProperty().bind(alumno.resumenProperty());
		resumenView.getAtrasBtn().setOnAction(e -> onVolverButtonAction(e));
		resumenView.getSiguienteBtn().setOnAction(e -> onSiguienteButtonAction(alumno));
	}
	
	private void onSiguienteButtonAction(AsistenteAlumnosModelo alumno) {
		alumno.crearFichero();
		app.cerrarAsistente();
	}

	private void onVolverButtonAction(ActionEvent e) {
		app.irAContactos();
	}
	
	public ResumenView getResumenView() {
		return resumenView;
	}

	public void setResumenView(ResumenView resumenView) {
		this.resumenView = resumenView;
	}

	public ResumenView getRoot(){
		return resumenView;
	}

	public AsistenteAlumnosApp getApp() {
		return app;
	}

	public void setApp(AsistenteAlumnosApp app) {
		this.app = app;
	}
}
