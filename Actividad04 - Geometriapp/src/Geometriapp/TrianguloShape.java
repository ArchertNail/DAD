package Geometriapp;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Polygon;

public class TrianguloShape extends Polygon {
	
	private DoubleProperty base;
	private DoubleProperty altura;
	
	
	public TrianguloShape(double base, double altura){
		super();
		getPoints().setAll(base/2,0.0, base,altura, 0.0, altura);
		
		this.base = new SimpleDoubleProperty(this,"base",base);
		this.altura = new SimpleDoubleProperty(this,"altura",altura);
		
		this.base.addListener((observable,oldValue,newValue) -> {
			getPoints().set(0, newValue.doubleValue() /2);
			getPoints().set(2, newValue.doubleValue());
		});
		
		this.altura.addListener((observable,oldValue,newValue) -> {
			getPoints().set(3, newValue.doubleValue());
			getPoints().set(5, newValue.doubleValue());
		});
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
	
	
	
	
}
