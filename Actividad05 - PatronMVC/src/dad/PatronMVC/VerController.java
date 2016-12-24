package dad.PatronMVC;

import javafx.beans.property.SimpleStringProperty;

public class VerController {
	
	private VerView verView;
	
	public VerController(DatosModelo datosModel){
		this.verView = new VerView();
		bind(datosModel);
	}
	
	public VerController(){
		this(null);
	}
	public void bind(DatosModelo datosModel){
		if(datosModel != null){
			this.verView.getProgresoBar().progressProperty().bind(datosModel.valorProperty().divide(100.0));
			this.verView.getValorLabel().textProperty().bind(new SimpleStringProperty("valor Actual: ").concat(datosModel.valorProperty()));
		}
	}
	
	public VerView getRoot(){
		return verView;
	}
}
