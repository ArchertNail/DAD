package dad.micv.modelo;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;

public class mainView extends BorderPane {
	
	private MenuBar menuBar;
	private Menu archivo;
	private Tab personalTab,contactoTab,formacionTab,experienciaTab,conocimientoTab;
	
	public mainView(){
	
		menuBar = new MenuBar();
		
		archivo = new Menu("Archivo");
		MenuItem nuevoItm = new MenuItem("Nuevo");
		nuevoItm.setGraphic(new ImageView(new Image("/res/nuevo.gif")));
		nuevoItm.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
		MenuItem abrirItm = new MenuItem("Abrir");
		abrirItm.setGraphic(new ImageView(new Image("/res/abrir.gif")));
		abrirItm.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
		MenuItem guardarItm = new MenuItem("Guardar");
		guardarItm.setGraphic(new ImageView(new Image("/res/guardar.gif")));
		guardarItm.setAccelerator(new KeyCodeCombination(KeyCode.G, KeyCombination.CONTROL_DOWN));
		MenuItem guardarComoItm = new MenuItem("Guardar como");
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem salirItm = new MenuItem("Salir");
		salirItm.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
		archivo.getItems().addAll(nuevoItm,abrirItm,guardarItm,guardarComoItm, separatorMenuItem,salirItm);
		
		Menu ayuda = new Menu("Ayuda");
		MenuItem acercaItm = new MenuItem("Acerca de...");
		ayuda.getItems().add(acercaItm);
		
		menuBar.getMenus().addAll(archivo,ayuda);
		
		
		personalTab = new Tab("Personal");
		personalTab.setClosable(false);
		
		contactoTab = new Tab("Conctacto");
		contactoTab.setClosable(false);
		
		formacionTab = new Tab("Formación");
		formacionTab.setClosable(false);
		
		experienciaTab = new Tab("Experiencia");
		experienciaTab.setClosable(false);
		
		conocimientoTab = new Tab("Conocimiento");
		conocimientoTab.setClosable(false);
		
		TabPane root = new TabPane();
		root.getTabs().addAll(personalTab,contactoTab,formacionTab,experienciaTab,conocimientoTab);
		
		setTop(menuBar);
		setCenter(root);
	}


	public Tab getPersonalTab() {
		return personalTab;
	}
	public Tab getContactoTab() {
		return contactoTab;
	}
	public Tab getFormacionTab() {
		return formacionTab;
	}
	public Tab getExperienciaTab() {
		return experienciaTab;
	}
	public Tab getConocimientoTab() {
		return conocimientoTab;
	}

	public Menu getArchivo() {
		return archivo;
	}


	public MenuBar getMenuBar() {
		return menuBar;
	}
	
	
	
}
