package dad.micv.modelo;

import java.io.File;

import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

public class mainController {
	
	private mainView view;
	private cvApp cvapp;
	private ObjectProperty<CV> modelo;
	private PersonalController personalController;
	private ContactoController contactoController;
	private FormacionController formacionController;
	private ExperienciaController experienciaController;
	private ConocimientoController conocimientoController;
	private File file;
	
	public mainController(){
		personalController = new PersonalController();
		contactoController = new ContactoController();
		formacionController = new FormacionController();
		experienciaController = new ExperienciaController();
		conocimientoController = new ConocimientoController();
		
		view = new mainView();
		view.getPersonalTab().setContent(personalController.getRoot());
		view.getContactoTab().setContent(contactoController.getRoot());
		view.getFormacionTab().setContent(formacionController.getRoot());
		view.getExperienciaTab().setContent(experienciaController.getRoot());
		view.getConocimientoTab().setContent(conocimientoController.getRoot());
		
		EventHandler<ActionEvent> action = onChangeItemMenu();
		for(int i=0; i<view.getArchivo().getItems().size(); i++){
			view.getArchivo().getItems().get(i).setOnAction(action);
		}
	}


	private EventHandler<ActionEvent> onChangeItemMenu() {
		return new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                MenuItem mItem = (MenuItem) event.getSource();
                String side = mItem.getText();
                if ("Nuevo".equalsIgnoreCase(side)) {
                	file=null;
                	modelo.set(new CV());
                	
                } else if ("Abrir".equalsIgnoreCase(side)) {
                	abrirXML();
                } else if ("Guardar".equalsIgnoreCase(side)) {
                	try {
                		guardarArchivo();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
                    System.out.println("Archivo Guardado");
                } 
                else if("Guardar como".equalsIgnoreCase(side)){
                	guardarComo();
                }
                
                else if ("Salir".equalsIgnoreCase(side)) {
                    cvapp.getPrimaryStage2().close();
                }
            }

			
        };
	}
	private void guardarArchivo() {
		if(file==null){
			guardarComo();
		}
		else{
			try {
				modelo.get().save(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
				
		}
	
	public void guardarComo() {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("."));
		
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fc.getExtensionFilters().add(extFilter);
		file = fc.showSaveDialog(cvapp.getPrimaryStage2());
		
		try {
			modelo.get().save(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("guardao");
	}
	
	
	public void abrirXML() {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("."));
		file = fc.showOpenDialog(cvapp.getPrimaryStage2());
		
		CV nuevoCV;
		try {
			nuevoCV = CV.read(file);
			modelo.set(nuevoCV);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void bind(ObjectProperty<CV> cv){
		this.modelo = cv;
		personalController.bind(cv.get().getPersonal());
		contactoController.bind(cv.get().getContacto());
		formacionController.bind(cv.get().formacionProperty());
		experienciaController.bind(cv.get().experienciasProperty());
		conocimientoController.bind(cv.get().habilidadesProperty());
	}
	
	public void unbind(CV cv){
		this.modelo = null;
		personalController.unbind(cv.getPersonal());
		contactoController.unbind(cv.getContacto());
		formacionController.unbind(cv.formacionProperty());
		experienciaController.unbind(cv.experienciasProperty());
		conocimientoController.unbind(cv.habilidadesProperty());
	}
	
	public mainView getRoot(){
		return view;
	}
	
	public void setApp(cvApp cvApp) {
		this.cvapp = cvApp;
		
	}
}
