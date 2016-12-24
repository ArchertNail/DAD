package dad.AsistenteAlumnos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AsistenteAlumnosApp extends Application {

	//private AsistenteAlumnosController AsistAlControl;
	
	private PersonalController personalController;
	private DomicilioController domicilioController;
	private ContactosController contactoController;
	private ResumenController resumenController;
	private Scene scene;
	private AsistenteAlumnosModelo asistenteModelo;
	private Stage primaryStage2;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage2 =  primaryStage;
		//AsistAlControl = new AsistenteAlumnosController();	
		asistenteModelo = new AsistenteAlumnosModelo();
		
		personalController = new PersonalController();		
		personalController.setApp(this);
		personalController.bind(asistenteModelo);
		
		domicilioController = new DomicilioController();
		domicilioController.setApp(this);
		domicilioController.bind(asistenteModelo);
		
		contactoController = new ContactosController();
		contactoController.setApp(this);
		contactoController.bind(asistenteModelo);
		
		resumenController = new ResumenController();
		resumenController.setApp(this);
		resumenController.bind(asistenteModelo);
		
		scene = new Scene(personalController.getRoot(),620, 420);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Asistente alta de alumnos");
		primaryStage.show();
	}

	public void irAPersonal() {
		scene.setRoot(personalController.getRoot());
	}

	public void irADomicilio() {
		scene.setRoot(domicilioController.getRoot());
	}
	
	public void irAContactos() {
		scene.setRoot(contactoController.getRoot());
	}
	public void irAResumen() {
		scene.setRoot(resumenController.getRoot());
	}
	public void cerrarAsistente() {
		primaryStage2.close();
	}
	

	public static void main(String[] args) {
		launch(args);
	}
	
	
}
