package dad.recetario.modificar;

import java.io.IOException;

import dad.recetario.model.Ingrediente;
import dad.recetario.model.Instruccion;
import dad.recetario.model.Medida;
import dad.recetario.model.Receta;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class RecetaModificarController {

	
	private BorderPane view;
	
	@FXML
	private TextField nombreReceta;
	@FXML
	private Spinner<Integer> duracionReceta;
	@FXML
	private Spinner<Integer> comensalesReceta;
	@FXML
	private TextField descripcionReceta;
	@FXML
	private ListView<Instruccion> instruccionesLista;
	@FXML
	private TextField nombreIngrediente,cantidadIngrediente;
	@FXML 
	private ComboBox<Medida> medidaIngrediente;
	@FXML
	private TableView<Ingrediente> ingredienteTable;
	@FXML
	private TableColumn<Ingrediente, String>nombreIngredienteColum;
	@FXML
	private TableColumn<Ingrediente, Number>cantidadIngredienteColum;
	@FXML
	private TableColumn<Ingrediente, Medida>medidaIngredienteColum;
	@FXML
	public Button cerrarStage;
	
	
	private StringProperty descripcion,nombreIngredienteProp,cantidadIngredienteProp;
	private ObjectProperty<Medida>medidaIngredientProp;
	
	private Receta receta;
	
	public RecetaModificarController() {
		
		descripcion = new SimpleStringProperty(this,"descripcion");
		nombreIngredienteProp = new SimpleStringProperty(this, "nombreIngredienteProp");
		cantidadIngredienteProp = new SimpleStringProperty(this, "cantidadIngredienteProp");
		medidaIngredientProp = new SimpleObjectProperty<>(this, "medidaIngrediente");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RecetaModificarView.fxml"));
			loader.setController(this);
			view = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		medidaIngrediente.getItems().addAll(Medida.values());
		
		duracionReceta.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60));
		comensalesReceta.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60));
		
		nombreIngredienteColum.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
		cantidadIngredienteColum.setCellValueFactory(cellData -> cellData.getValue().cantidadProperty());
		medidaIngredienteColum.setCellValueFactory(cellData -> cellData.getValue().medidaProperty());
	}
	
	@FXML
	public void onAnadirInstruccion(){
		
		Instruccion instruccion = new Instruccion();
		instruccion.setDescripcion(descripcion.get());
		receta.instruccionesProperty().add(instruccion);
	}
	@FXML 
	public void onEliminarInstruccion(){
		receta.instruccionesProperty().remove(instruccionesLista.getSelectionModel().getSelectedItem());
	}
	
	
	@FXML
	public void onAnadirIngrediente(){
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setNombre(nombreIngredienteProp.get());
		ingrediente.setCantidad(Integer.parseInt(cantidadIngredienteProp.get()));
		ingrediente.setMedida(medidaIngredientProp.get());
		receta.ingredientesProperty().add(ingrediente);
	}
	
	@FXML
	public void onEliminarIngrediente(){
		receta.ingredientesProperty().remove(ingredienteTable.getSelectionModel().getSelectedItem());
	}
	
	public void bind(Receta receta) {
		this.receta = receta;
		nombreReceta.textProperty().bindBidirectional(receta.nombreProperty());
		duracionReceta.getValueFactory().valueProperty().bindBidirectional(receta.duracionProperty().asObject());
		comensalesReceta.getValueFactory().valueProperty().bindBidirectional(receta.comensalesProperty().asObject());
		instruccionesLista.itemsProperty().bindBidirectional(receta.instruccionesProperty());
		ingredienteTable.itemsProperty().bindBidirectional(receta.ingredientesProperty());
		
		descripcion.bind(descripcionReceta.textProperty());
		nombreIngredienteProp.bind(nombreIngrediente.textProperty());
		cantidadIngredienteProp.bind(cantidadIngrediente.textProperty());
		medidaIngredientProp.bind(medidaIngrediente.valueProperty());
	}
	
	
	
	public BorderPane getView() {
		return view;
	}

	
	
}
