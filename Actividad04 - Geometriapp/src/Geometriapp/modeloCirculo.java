package Geometriapp;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;

public class modeloCirculo {
	
	private DoubleProperty radio;
	private ReadOnlyDoubleWrapper area;
	public modeloCirculo(){
		radio = new SimpleDoubleProperty(this, "radio",50);
		area = new ReadOnlyDoubleWrapper(this, "area",0);
		area.bind(radio.multiply(radio).multiply(Math.PI));
	}
	public final DoubleProperty radioProperty() {
		return this.radio;
	}
	
	public final double getRadio() {
		return this.radioProperty().get();
	}
	
	public final void setRadio(final double radio) {
		this.radioProperty().set(radio);
	}
	
	public final javafx.beans.property.ReadOnlyDoubleProperty areaProperty() {
		return this.area.getReadOnlyProperty();
	}
	
	public final double getArea() {
		return this.areaProperty().get();
	}
	
	
}
