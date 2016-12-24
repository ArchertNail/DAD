package dad.recetario;

import java.io.IOException;
import java.util.Optional;

import dad.recetario.model.Receta;
import dad.recetario.model.Recetario;
import dad.recetario.modificar.RecetaModificarController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class MainController {
	
	private BorderPane view;
	private Recetario recetario;
	private RecetaModificarController recetaModificarController;
	private Stage nuevoStage;
	@FXML
	private TableView<Receta>recetasTable;
	
	@FXML
	private TableColumn<Receta, String> nombreRecetaColum,duracionRecetaColum,comensalesRecetaColum;
	
	@FXML
	private Label cantidadRecetasLabel;
	
	//private StringProperty cantidadRecetasProp;
	
	public MainController() {
	
		//cantidadRecetasProp = new SimpleStringProperty(this, "cantidad");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
			loader.setController(this);
			view = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nombreRecetaColum.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
		duracionRecetaColum.setCellValueFactory(cellData -> cellData.getValue().duracionProperty().asString());
		comensalesRecetaColum.setCellValueFactory(cellData -> cellData.getValue().comensalesProperty().asString());
		
	}
	
	
	
	
	@FXML
	public void onAnadirRecetaAction(){
		Receta receta = new Receta();
		receta.setNombre("Nueva Receta");
		receta.setDuracion(0);
		receta.setComensales(1);
		recetario.recetasProperty().add(receta);
		//cantidadRecetasProp.set(cantidadRecetasProp.get()+1);
	}
	
	
	
	@FXML
	public void onModificarRecetaAction(){
		
		try{
			Receta recetaSelect = recetario.getRecetas().get(recetasTable.getSelectionModel().getSelectedIndex());
			
			recetaModificarController = new RecetaModificarController();
			recetaModificarController.bind(recetaSelect);
			recetaModificarController.cerrarStage.setOnAction(e->nuevoStage.close());
			 
			Scene scene = new Scene(recetaModificarController.getView(),680,440);
			scene.setFill(null);
			 
			nuevoStage = new Stage(StageStyle.DECORATED);
			nuevoStage.setTitle("Modificar receta:"+ recetaSelect.getNombre());
			nuevoStage.setScene(scene);
			nuevoStage.show();
			
		}catch (Exception e) {
			System.out.println("no selected object");
		}
	}
	
	@FXML
	public void onEliminarRecetaAction(){
		Alert nuevoAlert = new Alert(AlertType.CONFIRMATION);
		nuevoAlert.setTitle("Eliminar Recetas");
		nuevoAlert.setHeaderText("Eliminando Recetas");
		nuevoAlert.setContentText("¿Esta seguro que desea eliminar la receta seleccionada?");
		
		Optional<ButtonType> result = nuevoAlert.showAndWait();
		
		if(result.get()==ButtonType.OK){
			
			recetario.recetasProperty().remove(recetasTable.getSelectionModel().getSelectedIndex());
		}
		else{
			System.out.println("Operacion abortada");
		}
		
	}
	
	public BorderPane getView() {
		return view;
	}

	public void bind(Recetario recetario) {
		this.recetario = recetario;
		
		recetasTable.itemsProperty().bindBidirectional(recetario.recetasProperty());
		//cantidadRecetasLabel.textProperty().bind(cantidadRecetasProp);
	}

	
}
