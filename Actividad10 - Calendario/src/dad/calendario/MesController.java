package dad.calendario;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import dad.calendario.utils.DateUtils;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class MesController extends GridPane{
	
	private GridPane mesesView;

	private static final DateFormat FORMATTER = new SimpleDateFormat("MMMM"); 
	private static final String [] WEEK_DAYS = {"L", "M", "X", "J", "V", "S", "D"};			

	// model
	private IntegerProperty month;
	private IntegerProperty year;
	
	// view
	@FXML
	private Label monthNameLabel; 
	
	@FXML
	private ArrayList<Label> diasLabel;
	
	@FXML
	private ArrayList<Label> diasSemanaLabel;
	
	
	int diaActual;
	
	public MesController() {
		super();
		
		month = new SimpleIntegerProperty(this, "month", 0);
		month.addListener((observable, oldValue, newValue) -> {
			onModelChanged();
		});
		year = new SimpleIntegerProperty(this, "year", 0);
		year.addListener((observable, oldValue, newValue) -> {
			onModelChanged();
		});
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MonthCalendar.fxml"));
			loader.setController(this);			
			loader.setRoot(this);
			loader.load();
			getStylesheets().add(getClass().getResource("CalendarioCss.css").toExternalForm());
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		for (int i = 0; i < diasSemanaLabel.size(); i++) {
			diasSemanaLabel.get(i).setText(WEEK_DAYS[i]);
			diasSemanaLabel.get(i).getStyleClass().add("diasSemana");
			if(i==6){
				diasSemanaLabel.get(i).getStyleClass().add("domingo");
			}

		};
	
		
		for (int i = 0; i < diasLabel.size(); i++) {
			diasLabel.get(i).setText("" + i);
			diasLabel.get(i).getStyleClass().add("dias");
		
			if(i%7 ==0){
				if(i!=0){
					int j=i-1;
					diasLabel.get(j).getStyleClass().add("domingo");
				}
			}
		};
		
	}
	
	private void onModelChanged() {
		
		int first = DateUtils.firstDay(year.get(), month.get()) - 1;
		int last = DateUtils.lastDay(year.get(), month.get());
		
		for (int i = 0; i < first; i++) {
			diasLabel.get(i).setText("");
		}
		for (int i = first, j = 1; i < first + last; i++, j++) {
			diasLabel.get(i).setText("" + j);
		}
		for (int i = first + last; i < diasLabel.size(); i++) {
			diasLabel.get(i).setText("");
		}
		Date day = DateUtils.day(year.get(), month.get(), 1);
		monthNameLabel.setText(FORMATTER.format(day));
		
		if(month.get()==LocalDate.now().getMonthValue() && year.get() == LocalDate.now().getYear()){
			diasLabel.get(LocalDate.now().getDayOfMonth()+first-1).getStyleClass().add("diaActual");
		}
		else{
			diasLabel.get(LocalDate.now().getDayOfMonth()+2).getStyleClass().remove("diaActual");
		}
	
			
		
		
	}
	
	public IntegerProperty monthProperty() {
		return this.month;
	}

	public int getMonth() {
		return this.monthProperty().get();
	}

	public void setMonth(final int month) {
		this.monthProperty().set(month);
	}

	public IntegerProperty yearProperty() {
		return this.year;
	}

	public int getYear() {
		return this.yearProperty().get();
	}

	public void setYear(final int year) {
		this.yearProperty().set(year);
	}

	public void fechaActual(int diaActual) {
		this.diaActual = diaActual;
		
	}
}
