package dad.AsistenteAlumnos;

import javafx.event.ActionEvent;

public class ContactosController {
	private ContactoView contactoView;
	private AsistenteAlumnosApp app;
	
	public ContactosController(){
		contactoView = new ContactoView();
	}
	
	public void bind(AsistenteAlumnosModelo alumno) {
		contactoView.getAtrasBtn().setOnAction(e -> onVolverButtonAction(e));
		contactoView.getSiguienteBtn().setOnAction(e -> onSiguienteButtonAction(e));
		
		alumno.movilProperty().bind(contactoView.getMovilText().textProperty());
		alumno.fijoProperty().bind(contactoView.getFijoText().textProperty());
		alumno.emailProperty().bind(contactoView.getEmailText().textProperty());
	}
	
	private void onVolverButtonAction(ActionEvent e) {
		app.irADomicilio();
	}
	private void onSiguienteButtonAction(ActionEvent e) {
		app.irAResumen();
	}
	
	public AsistenteAlumnosApp getApp() {
		return app;
	}

	public void setApp(AsistenteAlumnosApp app) {
		this.app = app;
	}

	public ContactoView getRoot(){
		return contactoView;
	}
}
