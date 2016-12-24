package dad.micv.modelo;

import java.util.Optional;

import dad.leerDatos.Dialogos;

public class ContactoController {
	
	private ContactoView view;
	private Contacto contacto;
	
	public ContactoController(){
		view = new ContactoView();
		
		view.getAnadirTelfBtn().setOnAction(e->onAnadirTelefono());
		view.getBorrarTelfBtn().setOnAction(e->onBorrarTelefono());
		view.getAnadirEmailBtn().setOnAction(e->onAnadirEmail());
		view.getBorrarEmailBtn().setOnAction(e->onBorrarEmail());
		view.getAnadirWebBtn().setOnAction(e->onAnadirWeb());
		view.getBorrarWebBtn().setOnAction(e->onBorrarWeb());
	}

	//WEB
	private void onBorrarWeb() {
		int pos =view.getWebTable().getSelectionModel().getSelectedIndex();
		try{
			contacto.websProperty().remove(pos);
		}catch(ArrayIndexOutOfBoundsException e){
			
		}	
	}

	private void onAnadirWeb() {
		Optional<String> result = Dialogos.webs().showAndWait();
		if(result.isPresent()){
			Web web = new Web();
			web.setUrl(result.get());
			contacto.websProperty().add(web);
		}
	}
	
	//E-MAIL
	private void onBorrarEmail() {
		int pos = view.getEmailTable().getSelectionModel().getSelectedIndex();
		try{
			contacto.emailsProperty().remove(pos);
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
	
	}
	
	private void onAnadirEmail() {
		Optional<String> result = Dialogos.emails().showAndWait();
		if (result.isPresent()){
			Email email = new Email();
			email.setDireccion(result.get());
			contacto.emailsProperty().add(email);
		}
	}

	
	//TELEFONO
	private void onBorrarTelefono() {
		int pos = view.getTelefonosTable().getSelectionModel().getSelectedIndex();
		try{
			contacto.telefonosProperty().remove(pos);
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
	}
	private void onAnadirTelefono() {
		
		Optional<Telefono> result = Dialogos.telefonos().showAndWait();
		
		if (result.isPresent()){
			contacto.getTelefonos().add(result.get());
		}
	}

	//BINDINGS
	public void bind(Contacto contacto){
		this.contacto = contacto;
		
		view.getTelefonosTable().itemsProperty().bindBidirectional(contacto.telefonosProperty());
		view.getEmailTable().itemsProperty().bindBidirectional(contacto.emailsProperty());
		view.getWebTable().itemsProperty().bindBidirectional(contacto.websProperty());
		
	}
	
	
	public void unbind(Contacto contacto2) {
		view.getTelefonosTable().itemsProperty().unbindBidirectional(contacto2.telefonosProperty());
		view.getEmailTable().itemsProperty().unbindBidirectional(contacto2.emailsProperty());
		view.getWebTable().itemsProperty().unbindBidirectional(contacto2.websProperty());
		
	}
	
	//VISTA
	public ContactoView getRoot(){
		return view;
	}

	
}
