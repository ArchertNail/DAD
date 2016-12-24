package dad.micv.modelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
@XmlType
public class Email {
	private StringProperty direccion;
	public Email(){
		direccion = new SimpleStringProperty(this, "direccion");
	}
	public StringProperty direccionProperty() {
		return this.direccion;
	}
	@XmlElement
	public String getDireccion() {
		return this.direccionProperty().get();
	}
	
	public void setDireccion(final String direccion) {
		this.direccionProperty().set(direccion);
	}
	
	
	
}
