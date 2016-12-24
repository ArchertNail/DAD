package dad.AsistenteAlumnos;

import javafx.beans.binding.NumberBinding;
import javafx.event.ActionEvent;
import javafx.util.converter.NumberStringConverter;

public class DomicilioController {
	
	private DomicilioView domicilioV;
	private AsistenteAlumnosApp app;
	
	public DomicilioController(){
		domicilioV = new DomicilioView();

	}
	public void bind(AsistenteAlumnosModelo alumno) {
		domicilioV.getAtrasBtn().setOnAction(e -> onVolverButtonAction(e));
		domicilioV.getSiguienteBtn().setOnAction(e -> onSiguienteButtonAction(e));
		alumno.direccionProperty().bind(domicilioV.getDireccionArea().textProperty());
		alumno.codigoPostaProperty().bind(domicilioV.getCodPostalText().textProperty());
		alumno.ciudadProperty().bind(domicilioV.getCiudadText().textProperty());
	}
	private void onVolverButtonAction(ActionEvent e) {
		app.irAPersonal();
	}
	private void onSiguienteButtonAction(ActionEvent e) {
		app.irAContactos();
	}
	
	public AsistenteAlumnosApp getApp() {
		return app;
	}
	public void setApp(AsistenteAlumnosApp app) {
		this.app = app;
	}
	public DomicilioView getRoot(){
		return domicilioV;
	}
}
