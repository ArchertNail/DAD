package dad.micv.modelo;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ConocimientoView extends SplitPane{

	private Button anadirConoBtn,anadirIdiomaBtn,borrarBtn;
	private TableView<Conocimiento> conocimientoTable;
	public ConocimientoView(){
		anadirConoBtn = new Button("Añadir conocimiento");
		anadirConoBtn.setMaxWidth(Double.MAX_VALUE);
		anadirIdiomaBtn = new Button("Añadir idioma");
		anadirIdiomaBtn.setMaxWidth(Double.MAX_VALUE);
		borrarBtn = new Button("Eliminar");
		borrarBtn.setMaxWidth(Double.MAX_VALUE);
		
		conocimientoTable = new TableView<>();
		TableColumn<Conocimiento, String> denominacionColum = new TableColumn<>("Denominación");
		denominacionColum.setCellValueFactory(cellDate -> cellDate.getValue().denominacionProperty());
		TableColumn<Conocimiento, String> nivelColum = new TableColumn<>("Nivel");
		nivelColum.setCellValueFactory(cellData -> cellData.getValue().nivelProperty().asString());
		conocimientoTable.getColumns().addAll(denominacionColum,nivelColum);
	
		VBox conocimientoBotones = new VBox(5,anadirConoBtn,anadirIdiomaBtn,borrarBtn);
		
		GridPane conocimientoPanel = new GridPane();
		conocimientoPanel.setPadding(new Insets(10));
		conocimientoPanel.setHgap(5);
		conocimientoPanel.setVgap(5);
		conocimientoPanel.addRow(0,conocimientoTable, conocimientoBotones);
		
		ColumnConstraints colCono1 = new ColumnConstraints();
		colCono1.setHgrow(Priority.ALWAYS);
		
		ColumnConstraints colCono2 = new ColumnConstraints();
		colCono2.setHgrow(Priority.NEVER);
		
		conocimientoPanel.getColumnConstraints().setAll(colCono1, colCono2);
		
		setOrientation(Orientation.VERTICAL);
		getItems().add(conocimientoPanel);
	}
	
	public Button getAnadirConoBtn() {
		return anadirConoBtn;
	}
	public void setAnadirConoBtn(Button anadirConoBtn) {
		this.anadirConoBtn = anadirConoBtn;
	}
	public Button getAnadirIdiomaBtn() {
		return anadirIdiomaBtn;
	}
	public void setAnadirIdiomaBtn(Button anadirIdiomaBtn) {
		this.anadirIdiomaBtn = anadirIdiomaBtn;
	}
	public Button getBorrarBtn() {
		return borrarBtn;
	}
	public void setBorrarBtn(Button borrarBtn) {
		this.borrarBtn = borrarBtn;
	}
	public TableView<Conocimiento> getConocimientoTable() {
		return conocimientoTable;
	}
	public void setConocimientoTable(TableView<Conocimiento> conocimientoTable) {
		this.conocimientoTable = conocimientoTable;
	}
	
	
}
