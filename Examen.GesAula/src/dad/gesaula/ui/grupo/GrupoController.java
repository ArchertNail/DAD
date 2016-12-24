package dad.gesaula.ui.grupo;

import dad.gesaula.ui.model.Grupo;

public class GrupoController {

	private GrupoView view;

	public GrupoController() {
		view = new GrupoView();
	}
	
	public GrupoView getView() {
		return view;
	}

	public void bind(Grupo grupo) {
		view.getDenominacionText().textProperty().bindBidirectional(grupo.denominacionProperty());
		view.getInicioCursoDatePicker().valueProperty().bindBidirectional(grupo.iniCursoProperty());
		view.getFinCursoDatePicker().valueProperty().bindBidirectional(grupo.finCursoProperty());
		view.getExamenesSlider().valueProperty().bindBidirectional(grupo.getPesos().examenesProperty());
		view.getPracticasSlider().valueProperty().bindBidirectional(grupo.getPesos().practicasProperty());
		view.getActitudSlider().valueProperty().bindBidirectional(grupo.getPesos().actitudProperty());
	}

}
