package dad.micv.modelo;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ContactoView extends SplitPane{
	private Button anadirTelfBtn, borrarTelfBtn, anadirEmailBtn, borrarEmailBtn, anadirWebBtn, borrarWebBtn;
	private TableView<Telefono> telefonosTable;
	private TableView<Email> emailTable;
	private TableView<Web> webTable;
	public ContactoView(){
		
		anadirTelfBtn = new Button("Añadir");
		anadirTelfBtn.setMaxWidth(Double.MAX_VALUE);
		borrarTelfBtn = new Button("Eliminar");
		borrarTelfBtn.setMaxWidth(Double.MAX_VALUE);
		anadirEmailBtn = new Button("Añadir");
		anadirEmailBtn.setMaxWidth(Double.MAX_VALUE);
		borrarEmailBtn = new Button("Eliminar");
		borrarEmailBtn.setMaxWidth(Double.MAX_VALUE);
		anadirWebBtn = new Button("Añadir");
		anadirWebBtn.setMaxWidth(Double.MAX_VALUE);
		borrarWebBtn = new Button("Eliminar");
		borrarWebBtn.setMaxWidth(Double.MAX_VALUE);

		//TELEFONOS	
		
		telefonosTable = new TableView<>();
		telefonosTable.setEditable(true);
		TableColumn<Telefono, String> numeroColumn = new TableColumn<>("Número");
		numeroColumn.setCellValueFactory(cellData -> cellData.getValue().numeroProperty());
		numeroColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		TableColumn<Telefono, TipoTelefono> tipoColum = new TableColumn<>("Tipo");
		tipoColum.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
		tipoColum.setCellFactory(ComboBoxTableCell.forTableColumn(TipoTelefono.values()));
		telefonosTable.getColumns().add(numeroColumn);
		telefonosTable.getColumns().add(tipoColum);
		
		VBox telfBotones = new VBox(5,anadirTelfBtn,borrarTelfBtn);
		
		GridPane telefonoPanel = new GridPane();
		telefonoPanel.setPadding(new Insets(10));
		telefonoPanel.setHgap(5);
		telefonoPanel.setVgap(5);
		telefonoPanel.addRow(0,telefonosTable, telfBotones);
		
		ColumnConstraints colTelf1 = new ColumnConstraints();
		colTelf1.setHgrow(Priority.ALWAYS);
		
		ColumnConstraints colTelf2 = new ColumnConstraints();
		colTelf2.setHgrow(Priority.NEVER);
		
		telefonoPanel.getColumnConstraints().setAll(colTelf1, colTelf2);
		
		//EMAIL
		
		emailTable = new TableView<>();
		TableColumn<Email, String> emailColum = new TableColumn<>("E-mail");
		emailColum.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());
		emailColum.setPrefWidth(300);
		emailTable.getColumns().add(emailColum);
		
		VBox emailBotones = new VBox(5,anadirEmailBtn,borrarEmailBtn);
		
		GridPane emailPanel = new GridPane();
		emailPanel.setPadding(new Insets(10));
		emailPanel.setHgap(5);
		emailPanel.setVgap(5);
		emailPanel.addRow(0,emailTable, emailBotones);
		
		ColumnConstraints colEmail1 = new ColumnConstraints();
		colEmail1.setHgrow(Priority.ALWAYS);
		
		ColumnConstraints colEmail2 = new ColumnConstraints();
		colEmail2.setHgrow(Priority.NEVER);
		
		emailPanel.getColumnConstraints().setAll(colEmail1, colEmail2);
		
		//WEBS
		
		webTable = new TableView<>();
		TableColumn<Web, String> urlColum = new TableColumn<>("URL");
		urlColum.setCellValueFactory(cellData -> cellData.getValue().urlProperty());
		urlColum.setPrefWidth(300);
		webTable.getColumns().add(urlColum);
		
		VBox webBotones = new VBox(5,anadirWebBtn,borrarWebBtn);
		
		GridPane webPanel = new GridPane();
		webPanel.setPadding(new Insets(10));
		webPanel.setHgap(5);
		webPanel.setVgap(5);
		webPanel.addRow(0,webTable, webBotones);
		
		ColumnConstraints colWeb1 = new ColumnConstraints();
		colWeb1.setHgrow(Priority.ALWAYS);
		
		ColumnConstraints colWeb2 = new ColumnConstraints();
		colWeb2.setHgrow(Priority.NEVER);
		
		webPanel.getColumnConstraints().setAll(colWeb1, colWeb2);
		
		//TITLES PANEL
		
		TitledPane tpTelf = new TitledPane("Teléfono",telefonoPanel);
		tpTelf.setCollapsible(false);
		tpTelf.setPadding(new Insets(5));
		
		TitledPane tpEmail = new TitledPane("Dirección de Correos",emailPanel);
		tpEmail.setCollapsible(false);
		tpEmail.setPadding(new Insets(5));
		
		TitledPane tpWeb= new TitledPane("Webs",webPanel);
		tpWeb.setCollapsible(false);
		tpWeb.setPadding(new Insets(5));
		
		setOrientation(Orientation.VERTICAL);
		setDividerPositions(0.5);
		//root.setDividerPositions(0.25, 0.8);
		getItems().addAll(tpTelf,tpEmail,tpWeb);
	}
	
	public Button getAnadirTelfBtn() {
		return anadirTelfBtn;
	}
	public Button getBorrarTelfBtn() {
		return borrarTelfBtn;
	}
	public Button getAnadirEmailBtn() {
		return anadirEmailBtn;
	}
	public Button getBorrarEmailBtn() {
		return borrarEmailBtn;
	}
	public Button getAnadirWebBtn() {
		return anadirWebBtn;
	}
	public Button getBorrarWebBtn() {
		return borrarWebBtn;
	}

	public TableView<Telefono> getTelefonosTable() {
		return telefonosTable;
	}

	public void setTelefonosTable(TableView<Telefono> telefonosTable) {
		this.telefonosTable = telefonosTable;
	}

	public TableView<Web> getWebTable() {
		return webTable;
	}

	public void setWebTable(TableView<Web> webTable) {
		this.webTable = webTable;
	}

	public TableView<Email> getEmailTable() {
		return emailTable;
	}

	public void setEmailTable(TableView<Email> emailTable) {
		this.emailTable = emailTable;
	}
	
	
}
