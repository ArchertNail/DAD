package dad.agenda;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contacto {
	private StringProperty nombre;
	private ObjectProperty<LocalDate> fechaNacimiento;
	private StringProperty movil;
	private StringProperty fijo;
	
	public Contacto(){
		nombre = new SimpleStringProperty();
		fechaNacimiento = new SimpleObjectProperty<LocalDate>(this, "fechaNacimiento");
		movil = new SimpleStringProperty();
		fijo = new SimpleStringProperty();
	}

	public StringProperty nombreProperty() {
		return this.nombre;
	}
	

	public String getNombre() {
		return this.nombreProperty().get();
	}
	

	public void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}
	

	public ObjectProperty<LocalDate> fechaNacimientoProperty() {
		return this.fechaNacimiento;
	}
	

	public LocalDate getFechaNacimiento() {
		return this.fechaNacimientoProperty().get();
	}
	

	public void setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimientoProperty().set(fechaNacimiento);
	}
	

	public StringProperty movilProperty() {
		return this.movil;
	}
	

	public String getMovil() {
		return this.movilProperty().get();
	}
	

	public void setMovil(final String movil) {
		this.movilProperty().set(movil);
	}
	

	public StringProperty fijoProperty() {
		return this.fijo;
	}
	

	public String getFijo() {
		return this.fijoProperty().get();
	}
	

	public void setFijo(final String fijo) {
		this.fijoProperty().set(fijo);
	}
	public String toString(){
		return getNombre();
	}
	

}
