package Geometriapp;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;

public class ModeloRectangulo {
	private DoubleProperty ancho;
	private DoubleProperty alto;
	private ReadOnlyDoubleWrapper area;
	
	public ModeloRectangulo(){
		ancho = new SimpleDoubleProperty(this, "ancho",50);
		alto = new SimpleDoubleProperty(this, "alto",50);
		area = new ReadOnlyDoubleWrapper(this, "area",0);
		area.bind(ancho.multiply(alto));
	}

	public final DoubleProperty anchoProperty() {
		return this.ancho;
	}

	public final double getAncho() {
		return this.anchoProperty().get();
	}
	

	public final void setAncho(final double ancho) {
		this.anchoProperty().set(ancho);
	}
	

	public final DoubleProperty altoProperty() {
		return this.alto;
	}
	

	public final double getAlto() {
		return this.altoProperty().get();
	}
	

	public final void setAlto(final double alto) {
		this.altoProperty().set(alto);
	}
	

	public final javafx.beans.property.ReadOnlyDoubleProperty areaProperty() {
		return this.area.getReadOnlyProperty();
	}
	

	public final double getArea() {
		return this.areaProperty().get();
	}
	
	
	
	
}



