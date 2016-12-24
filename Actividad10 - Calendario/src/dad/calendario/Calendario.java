package dad.calendario;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Calendario {
	private IntegerProperty anyo;

	public Calendario() {
		anyo = new SimpleIntegerProperty(this, "anyo", LocalDate.now().getYear());
	}

	public IntegerProperty anyoProperty() {
		return this.anyo;
	}

	public int getAnyo() {
		return this.anyoProperty().get();
	}

	public void setAnyo(final int anyo) {
		this.anyoProperty().set(anyo);
	}
	
	public void anterior() {
		anyo.set(anyo.get()-1);
	}
	
	public void siguiente() {
		anyo.set(anyo.get()+1);
	}

}
