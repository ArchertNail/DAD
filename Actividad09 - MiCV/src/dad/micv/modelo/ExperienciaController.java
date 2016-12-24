package dad.micv.modelo;

import dad.sub.scenes.ExperienciaScene;
import javafx.beans.property.ListProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ExperienciaController {
	private ExperienciaView view;
	private ListProperty<Experiencia> modelo;
	private ExperienciaScene experienciaSceneView;
	private Stage nuevoStage;
	
	public ExperienciaController(){
		view = new ExperienciaView();
		view.getAnadirBtn().setOnAction(e->onAnadirStage());
		view.getBorrarBtn().setOnAction(e->onBorrarExperiencia());
	}
	
	private void onBorrarExperiencia() {
		int pos = view.getExperienciaTable().getSelectionModel().getSelectedIndex();
		modelo.remove(pos);
	}

	private void onAnadirStage() {
		 experienciaSceneView = new ExperienciaScene();
		 experienciaSceneView.getAnadirBtn().setOnAction(e->onAnadirExperiencia());
		 experienciaSceneView.getCerrarBtn().setOnAction(e->nuevoStage.close());
		 
		 Scene scene = new Scene(experienciaSceneView,320,200);
		 scene.setFill(null);
		 
		 
		 nuevoStage = new Stage(StageStyle.DECORATED);
		 nuevoStage.setTitle("Añadir Experiencia");
		 nuevoStage.setScene(scene);
		 nuevoStage.show();
	}
	
	private void onAnadirExperiencia() {
		Experiencia experiencia = new Experiencia();
		experiencia.setDesde(experienciaSceneView.getDesdeDate().getValue());
		experiencia.setHasta(experienciaSceneView.getHastaDate().getValue());
		experiencia.setDenominacion(experienciaSceneView.getDenominacionText().getText());
		experiencia.setEmpleador(experienciaSceneView.getEmpleadorText().getText());
		modelo.add(experiencia);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informacion");
		alert.setHeaderText(null);
		alert.setContentText("EXPERIENCIA INSERTADA!!");	
		alert.showAndWait();
		
		experienciaSceneView.getDesdeDate().setValue(null);
		experienciaSceneView.getHastaDate().setValue(null);
		experienciaSceneView.getDenominacionText().setText("");
		experienciaSceneView.getEmpleadorText().setText("");
	}
	
	
	public void bind(ListProperty<Experiencia> experienciaModelo){
		this.modelo = experienciaModelo;
		view.getExperienciaTable().itemsProperty().bindBidirectional(modelo);
	}
	
	public void unbind(ListProperty<Experiencia> experienciaModelo) {
		view.getExperienciaTable().itemsProperty().unbindBidirectional(experienciaModelo);
		
	}
	
	public ExperienciaView getRoot(){
		return view;
	}

	
}
