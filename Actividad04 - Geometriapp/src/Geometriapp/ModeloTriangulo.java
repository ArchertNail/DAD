package Geometriapp;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;

public class ModeloTriangulo {
	private DoubleProperty base;
	private DoubleProperty altura;
	private ReadOnlyDoubleWrapper area;
	
	public ModeloTriangulo(){
		base = new SimpleDoubleProperty(this,"base",0);
		altura = new SimpleDoubleProperty(this,"altura",0);
		area = new ReadOnlyDoubleWrapper(this,"area",0);
		area.bind(base.multiply(altura).divide(2));
	}

	public DoubleProperty baseProperty() {
		return this.base;
	}
	

	public double getBase() {
		return this.baseProperty().get();
	}
	

	public void setBase(final double base) {
		this.baseProperty().set(base);
	}
	

	public DoubleProperty alturaProperty() {
		return this.altura;
	}
	

	public double getAltura() {
		return this.alturaProperty().get();
	}
	

	public void setAltura(final double altura) {
		this.alturaProperty().set(altura);
	}
	

	public javafx.beans.property.ReadOnlyDoubleProperty areaProperty() {
		return this.area.getReadOnlyProperty();
	}
	

	public double getArea() {
		return this.areaProperty().get();
	}
	
}
