package dad.micv.modelo;


import java.time.LocalDate;

import dad.sub.scenes.FormacionScene;
import javafx.beans.property.ListProperty;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableRow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FormacionController {
	private FormacionView view;
	private FormacionScene subSceneView;
	private Stage miNuevoStage;
	private ListProperty<Titulo> modelo;

	public FormacionController(){
		view = new FormacionView();
		
		view.getAnadirBtn().setOnAction(e->onAnadirTitulo());
		view.getBorrarBtn().setOnAction(e->onBorrarTitulo());
		
	}
	
	private void onBorrarTitulo() {
		int pos= view.getFormacionTable().getSelectionModel().getSelectedIndex();
		modelo.remove(pos);
		
	}

	private void onAnadirTitulo() {
		
		subSceneView = new FormacionScene();
		subSceneView.getAnadirBtn().setOnAction(e->onAnadirTituloScene());
		subSceneView.getCerrarBtn().setOnAction(e->miNuevoStage.close());
		
		miNuevoStage = new Stage(StageStyle.DECORATED);

		Scene scene = new Scene(subSceneView, 320, 200);
		scene.setFill(null);
		
		miNuevoStage.setTitle("Añadir Titulación");
		miNuevoStage.setScene(scene);
		miNuevoStage.show();
	}
	
	private void onAnadirTituloScene() {
		
		Titulo titulo = new Titulo();
		
		titulo.setDesde(subSceneView.getDesdeDate().getValue());
		titulo.setHasta(subSceneView.getHastaDate().getValue());
		titulo.setDenominacion(subSceneView.getDenominacionText().getText());
		titulo.setOrganizador(subSceneView.getOrganizadorText().getText());
		modelo.add(titulo);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informacion");
		alert.setHeaderText(null);
		alert.setContentText("TITULO INSERTADO!!");	
		alert.showAndWait();
		
		
		subSceneView.getDesdeDate().setValue(null);
		subSceneView.getHastaDate().setValue(null);
		subSceneView.getDenominacionText().setText("");
		subSceneView.getOrganizadorText().setText("");
	}

	public void bind(ListProperty<Titulo> modeloTitulo){
		this.modelo = modeloTitulo;
		view.getFormacionTable().itemsProperty().bindBidirectional(modelo);
	}
	public void unbind(ListProperty<Titulo> modeloTitulo) {
		view.getFormacionTable().itemsProperty().unbindBidirectional(modeloTitulo);
		
	}
	
	public FormacionView getRoot(){
		return view;
	}

	
}
