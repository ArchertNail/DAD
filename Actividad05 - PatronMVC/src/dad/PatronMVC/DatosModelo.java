package dad.PatronMVC;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class DatosModelo {
	private IntegerProperty valor;
	
	public DatosModelo(){
		valor = new SimpleIntegerProperty(this, "valor",0);
	}

	public IntegerProperty valorProperty() {
		return this.valor;
	}
	

	public int getValor() {
		return this.valorProperty().get();
	}
	

	public void setValor(final int valor) {
		this.valorProperty().set(valor);
	}
	
	
	
}
