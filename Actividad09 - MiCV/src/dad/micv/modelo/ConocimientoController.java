package dad.micv.modelo;

import java.util.Optional;

import dad.leerDatos.Dialogos;
import dad.sub.scenes.IdiomaScene;
import javafx.beans.property.ListProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConocimientoController {
	private ConocimientoView view;
	private ListProperty<Conocimiento> modelo;
	private IdiomaScene idiomaSceneView;
	private Stage nuevoStage;
	
	public ConocimientoController(){
		view = new ConocimientoView();
		view.getAnadirConoBtn().setOnAction(e->onAnadirConocimiento());
		view.getAnadirIdiomaBtn().setOnAction(e->onAnadirStage());
		view.getBorrarBtn().setOnAction(e->onBorrarConocimiento());
	}
	
	private void onAnadirStage() {
		
		idiomaSceneView = new IdiomaScene();
		idiomaSceneView.getAnadirBtn().setOnAction(e->onAnadirIdioma());
		idiomaSceneView.getCerrarBtn().setOnAction(e->nuevoStage.close());
		
		Scene scene = new Scene(idiomaSceneView,320,200);
		scene.setFill(null);
		
		nuevoStage = new Stage(StageStyle.DECORATED);
		nuevoStage.setTitle("Añadir idioma");
		nuevoStage.setScene(scene);
		nuevoStage.show();
		
		
	}

	private void onAnadirIdioma() {
		Idioma idioma = new Idioma();
		idioma.setCertificacion(idiomaSceneView.getCertificacionText().getText());
		idioma.setDenominacion(idiomaSceneView.getDenominacionText().getText());
		idioma.setNivel(idiomaSceneView.getNivelCombo().getValue());
		modelo.add(idioma);
		
		
		idiomaSceneView.getCertificacionText().setText("");
		idiomaSceneView.getDenominacionText().setText("");
	}

	private void onBorrarConocimiento() {
		int pos = view.getConocimientoTable().getSelectionModel().getSelectedIndex();
		modelo.remove(pos);
	}

	private void onAnadirConocimiento() {
		Optional<Conocimiento> result = Dialogos.conocimiento().showAndWait();
		if(result.isPresent()){
			modelo.add(result.get());
		}
		
	}

	public void bind(ListProperty<Conocimiento> conocimientoModelo){
		this.modelo = conocimientoModelo;
		
		view.getConocimientoTable().itemsProperty().bindBidirectional(modelo);
	}
	
	public void unbind(ListProperty<Conocimiento> conocimientoModelo) {
		view.getConocimientoTable().itemsProperty().unbindBidirectional(conocimientoModelo);
		
	}
	
	public ConocimientoView getRoot(){
		return view;
	}
}
