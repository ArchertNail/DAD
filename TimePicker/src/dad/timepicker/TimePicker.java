package dad.timepicker;

import java.io.IOException;
import java.time.LocalTime;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;

public class TimePicker extends HBox {
	
	private ObjectProperty<LocalTime> tiempo;
	
	private ObjectProperty<Integer> hora, minutos, segundos;
	
	@FXML
	private Spinner<Integer> horaSpinner, minutosSpinner, segundosSpinner;

	public TimePicker() {
		super();
		
		// cargamos la vista 
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("TimePicker.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// inicializamos vista
		horaSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23));
		minutosSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59));
		segundosSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59));

		// creamos el modelo
		tiempo = new SimpleObjectProperty<LocalTime>(this, "tiempo", LocalTime.of(0, 0, 0));
		tiempo.addListener((observable, oldValue, newValue) -> {
			if (!oldValue.equals(newValue)) {
				hora.set(newValue.getHour());
				minutos.set(newValue.getMinute());
				segundos.set(newValue.getSecond());
			}
		});
		
		ChangeListener<Integer> listener = (observable, oldValue, newValue) -> {
			if (!oldValue.equals(newValue)) {
				tiempo.set(
						LocalTime.of(hora.get(), minutos.get(), segundos.get())
					);
			}
		}; 
		
		hora = new SimpleObjectProperty<>(this, "hora", 0);
		hora.addListener(listener);
		
		minutos = new SimpleObjectProperty<>(this, "minutos", 0);
		minutos.addListener(listener);
		
		segundos = new SimpleObjectProperty<>(this, "segundos", 0);
		segundos.addListener(listener);
		
		// bindeamos
		horaSpinner.getValueFactory().valueProperty().bindBidirectional(hora);
		minutosSpinner.getValueFactory().valueProperty().bindBidirectional(minutos);
		segundosSpinner.getValueFactory().valueProperty().bindBidirectional(segundos);
	}

	public ObjectProperty<LocalTime> tiempoProperty() {
		return this.tiempo;
	}
	

	public LocalTime getTiempo() {
		return this.tiempoProperty().get();
	}
	

	public void setTiempo(final LocalTime tiempo) {
		this.tiempoProperty().set(tiempo);
	}
	

	public ObjectProperty<Integer> horaProperty() {
		return this.hora;
	}
	

	public Integer getHora() {
		return this.horaProperty().get();
	}
	

	public void setHora(final Integer hora) {
		this.horaProperty().set(hora);
	}
	

	public ObjectProperty<Integer> minutosProperty() {
		return this.minutos;
	}
	

	public Integer getMinutos() {
		return this.minutosProperty().get();
	}
	

	public void setMinutos(final Integer minutos) {
		this.minutosProperty().set(minutos);
	}
	

	public ObjectProperty<Integer> segundosProperty() {
		return this.segundos;
	}
	

	public Integer getSegundos() {
		return this.segundosProperty().get();
	}
	

	public void setSegundos(final Integer segundos) {
		this.segundosProperty().set(segundos);
	}
	
}
