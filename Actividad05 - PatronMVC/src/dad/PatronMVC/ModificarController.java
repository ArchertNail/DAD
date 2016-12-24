package dad.PatronMVC;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.util.converter.NumberStringConverter;

public class ModificarController {
	private ModificarView modificarView;
	private DatosModelo datosModel;
	
	public ModificarController(DatosModelo datosModel){
		this.modificarView = new ModificarView();
		bind(datosModel);
	}

	private void bind(DatosModelo datosModel) {
		this.datosModel = datosModel;
		//Bindings.bindBidirectional(this.modificarView.getValorText().textProperty(), datosModel.valorProperty(), new NumberStringConverter());
		this.modificarView.getEstablecerButton().setOnAction(e->onEstablecerButtonAction(e));
		this.modificarView.getIncButton().setOnAction(e->onIncButtonAction(e));
		this.modificarView.getDecButton().setOnAction(e->onDecButtonAction(e));
		
		this.modificarView.getIncButton().disableProperty().bind(
				this.datosModel.valorProperty().greaterThanOrEqualTo(100)
				);
		
		this.modificarView.getDecButton().disableProperty().bind(
				this.datosModel.valorProperty().lessThanOrEqualTo(0)
				);
	}

	private void onIncButtonAction(ActionEvent e) {
		this.datosModel.setValor(this.datosModel.getValor()+1);
	}
	
	private void onDecButtonAction(ActionEvent e) {
		this.datosModel.setValor(this.datosModel.getValor()-1);
	}

	private void onEstablecerButtonAction(ActionEvent e) {
		
		try{
			Integer valor = Integer.parseInt(this.modificarView.getValorText().getText());
			if(valor <0 || valor >100){
				throw new IllegalArgumentException("El valor esta fuera del rango");
			}
			this.datosModel.setValor(valor);
		}
		catch(IllegalArgumentException ex){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(ex.getLocalizedMessage());
			alert.showAndWait();
			this.modificarView.getValorText().requestFocus();
		}
	}
	
	
	public ModificarView getRoot2(){
		return modificarView;
	}
	
	
}
