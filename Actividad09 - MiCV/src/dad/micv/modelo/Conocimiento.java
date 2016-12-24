package dad.micv.modelo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

@XmlType
@XmlSeeAlso({Idioma.class})
public class Conocimiento {
	
	private StringProperty denominacion;
	private ObjectProperty<Nivel> nivel;
	
	public Conocimiento(){
		nivel = new SimpleObjectProperty<Nivel>(this,"nivel", Nivel.BASICO);
		denominacion = new SimpleStringProperty(this, "denominacion");
	}

	public StringProperty denominacionProperty() {
		return this.denominacion;
	}
	@XmlElement
	public String getDenominacion() {
		return this.denominacionProperty().get();
	}
	public void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}
	
	
	public ObjectProperty<Nivel> nivelProperty() {
		return this.nivel;
	}
	@XmlAttribute
	public Nivel getNivel() {
		return this.nivelProperty().get();
	}
	public void setNivel(final Nivel nivel) {
		this.nivelProperty().set(nivel);
	}
		
	
}
