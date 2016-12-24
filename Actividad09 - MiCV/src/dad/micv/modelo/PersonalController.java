package dad.micv.modelo;

import java.util.ArrayList;
import java.util.Optional;
import dad.leerDatos.Datos;
import dad.leerDatos.Dialogos;

public class PersonalController {
	
	private PersonalView view;
	private Personal personal;
	private ArrayList<String> leerPaises,leerNacionalidaes;
	
	public PersonalController(){
		view = new PersonalView();
		leerPaises = Datos.leerPaises();
		leerNacionalidaes = Datos.leerNacionalidades();
		
		view.getPaisesCombo().getItems().addAll(leerPaises);
		view.getMasBtn().setOnAction(e->onAnadirNacionalidad());
		view.getMenosBtn().setOnAction(e->onQuitarNacionalidad());
	}
	
	private void onQuitarNacionalidad() {
		int indice=view.getNacionalidadList().getSelectionModel().getSelectedIndex();
		
		try{
			personal.nacionalidadesProperty().remove(indice);
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		System.out.println(personal.getNacionalidades());
	}

	private void onAnadirNacionalidad() {
		
		Optional<String> result = Dialogos.nacionalidades(leerNacionalidaes).showAndWait();
		
		if (result.isPresent()){
			
			Nacionalidad nacionalidad = new Nacionalidad();
			nacionalidad.setDenominacion(result.get());
			personal.getNacionalidades().add(nacionalidad);	
		}
	}
	
	public void bind(Personal personal){
		this.personal=personal;
		
		view.getNacionalidadList().itemsProperty().bindBidirectional(personal.nacionalidadesProperty());
		view.getPaisesCombo().valueProperty().bindBidirectional(personal.paisProperty());
		view.getDniText().textProperty().bindBidirectional(personal.identificacionProperty());
		view.getNombreText().textProperty().bindBidirectional(personal.nombreProperty());
		view.getApellidosText().textProperty().bindBidirectional(personal.apellidosProperty());
		view.getFechaDatePicker().valueProperty().bindBidirectional(personal.fechaNacimientoProperty());
		view.getDireccionArea().textProperty().bindBidirectional(personal.direccionProperty());
		view.getCpText().textProperty().bindBidirectional(personal.codigoPostalProperty());
		view.getLocalidadText().textProperty().bindBidirectional(personal.localidadProperty());
	}
	
	
	public PersonalView getRoot(){
		return view;
	}

	public void unbind(Personal personal2) {
		view.getNacionalidadList().itemsProperty().unbindBidirectional(personal2.nacionalidadesProperty());
		view.getPaisesCombo().valueProperty().unbindBidirectional(personal2.paisProperty());
		view.getDniText().textProperty().unbindBidirectional(personal2.identificacionProperty());
		view.getNombreText().textProperty().unbindBidirectional(personal2.nombreProperty());
		view.getApellidosText().textProperty().unbindBidirectional(personal2.apellidosProperty());
		view.getFechaDatePicker().valueProperty().unbindBidirectional(personal2.fechaNacimientoProperty());
		view.getDireccionArea().textProperty().unbindBidirectional(personal2.direccionProperty());
		view.getCpText().textProperty().unbindBidirectional(personal2.codigoPostalProperty());
		view.getLocalidadText().textProperty().unbindBidirectional(personal2.localidadProperty());
	}
	
}
