package CalculadoraCompleja;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {
	private DoubleProperty real;
	private DoubleProperty imaginario;
	
	public Complejo(){
		real = new SimpleDoubleProperty(this, "real",0);
		imaginario = new SimpleDoubleProperty(this, "imaginario",0);
	}

	public final DoubleProperty realProperty() {
		return this.real;
	}
	

	public final double getReal() {
		return this.realProperty().get();
	}
	

	public final DoubleProperty imaginarioProperty() {
		return this.imaginario;
	}
	

	public final double getImaginario() {
		return this.imaginarioProperty().get();
	}
	
	
	
}
