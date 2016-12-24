package dad.gesaula.ui;

import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;

public class RootView extends BorderPane {

	private Tab grupoTab;
	private Tab alumnosTab;

	public RootView() {
		super();
		grupoTab = new Tab("Grupo");
		alumnosTab = new Tab("Alumnos");

		TabPane tabPane = new TabPane();
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tabPane.setSide(Side.LEFT);
		tabPane.getTabs().addAll(grupoTab, alumnosTab);

		setCenter(tabPane);
	}

	public Tab getGrupoTab() {
		return grupoTab;
	}

	public Tab getAlumnosTab() {
		return alumnosTab;
	}

}
