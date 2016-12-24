package dad.gesaula.ui;

import dad.gesaula.ui.alumnos.AlumnosController;
import dad.gesaula.ui.grupo.GrupoController;
import dad.gesaula.ui.model.Grupo;
import dad.gesaula.ui.toolbar.ToolbarController;
import javafx.beans.property.ObjectProperty;

public class RootController {
	
	private GesAulaApp app;

	private RootView view;
	
	private ToolbarController toolbarController;
	private GrupoController grupoController;
	private AlumnosController alumnosController;
	
	public RootController() {
		toolbarController = new ToolbarController();
		grupoController = new GrupoController();
		alumnosController = new AlumnosController();
		
		view = new RootView();
		view.setTop(toolbarController.getView());
		view.getGrupoTab().setContent(grupoController.getView());
		view.getAlumnosTab().setContent(alumnosController.getView());
	}

	public void bind(ObjectProperty<Grupo> grupo) {
		toolbarController.bind(grupo);
		grupoController.bind(grupo.get());
		alumnosController.bind(grupo.get().alumnosProperty());
	}
	
	public void setApp(GesAulaApp app) {
		this.app = app;
		this.toolbarController.setApp(app);
		this.alumnosController.setApp(app);
	}

	public GesAulaApp getApp() {
		return app;
	}

	public RootView getView() {
		return view;
	}
	
}
