package dad.gesaula.ui.toolbar;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;

public class ToolbarView extends ToolBar {

	private Button nuevoButton;
	private Button guardarButton;
	private TextField ficheroText;

	public ToolbarView() {
		super();

		nuevoButton = new Button("Nuevo");
		guardarButton = new Button("Guardar");

		ficheroText = new TextField();
		ficheroText.setPromptText("Nombre del fichero");

		getItems().addAll(nuevoButton, ficheroText, guardarButton);
	}

	public Button getNuevoButton() {
		return nuevoButton;
	}

	public Button getGuardarButton() {
		return guardarButton;
	}

	public TextField getFicheroText() {
		return ficheroText;
	}

}
