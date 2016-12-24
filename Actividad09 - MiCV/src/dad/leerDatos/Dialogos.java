package dad.leerDatos;

import java.util.ArrayList;

import dad.micv.modelo.Conocimiento;
import dad.micv.modelo.Nivel;
import dad.micv.modelo.Telefono;
import dad.micv.modelo.TipoTelefono;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;

public class Dialogos {
	
	public static ChoiceDialog<String> nacionalidades(ArrayList<String> leerNacionalidaes){
		
		ChoiceDialog<String> dialog = new ChoiceDialog<>("afgano",leerNacionalidaes);
		dialog.setTitle("Nueva nacionalidad");
		dialog.setHeaderText("Aañadir nacionalidad");
		dialog.setContentText("Seleccione una nacionalidad:");
		
		return dialog;
	}
	
	public static Dialog<Telefono> telefonos(){
		
		Dialog<Telefono> telfDialg = new Dialog<Telefono>();
		telfDialg.setTitle("Nuevo Telefono");
		telfDialg.setHeaderText("Crear nuevo telefono");
		
		ButtonType acepetarButtonType = new ButtonType("Aceptar", ButtonData.OK_DONE);
		telfDialg.getDialogPane().getButtonTypes().addAll(acepetarButtonType, ButtonType.CANCEL);
		
		TextField numero = new TextField();
		ComboBox<TipoTelefono> tipo = new ComboBox<>();
		tipo.setValue(TipoTelefono.DOMICILIO);
		tipo.getItems().addAll(TipoTelefono.values());
		
		GridPane telefonoGrid = new GridPane();
		telefonoGrid.setPadding(new Insets(5));
		telefonoGrid.setHgap(5);
		telefonoGrid.setVgap(5);
		telefonoGrid.addColumn(0, new Label("nuevo telefono:"),numero);
		telefonoGrid.addColumn(1, new Label("Tipo telefono:"),tipo);

		telfDialg.getDialogPane().setContent(telefonoGrid);
		
		telfDialg.setResultConverter(dialogButton -> {
		    if (dialogButton == acepetarButtonType) {
		    	Telefono telefonoNuevo = new Telefono();
		    	telefonoNuevo.setNumero(numero.getText());
		    	telefonoNuevo.setTipo(tipo.getValue());
		        return telefonoNuevo;
		    }
		    return null;
		});
		
		return telfDialg;
	}
	
	public static TextInputDialog emails(){
		
		TextInputDialog emailDialog = new TextInputDialog("Email");
		emailDialog.setTitle("Añadir email");
		emailDialog.setHeaderText("Insertar E-mail");
		emailDialog.setContentText("Emai:");

		return emailDialog;
	}
	
	public static TextInputDialog webs(){
		
		TextInputDialog webDialog = new TextInputDialog("Web");
		webDialog.setTitle("Añadir web");
		webDialog.setHeaderText("Insertar web");
		webDialog.setContentText("web:");

		return webDialog;
	}
	
	public static Dialog<Conocimiento> conocimiento(){
		
		Dialog<Conocimiento> conoDialg = new Dialog<Conocimiento>();
		conoDialg.setTitle("Nuevo conocimiento");
		conoDialg.setHeaderText("Añade tu conocimiento");
		
		ButtonType acepetarButtonType = new ButtonType("Aceptar", ButtonData.OK_DONE);
		conoDialg.getDialogPane().getButtonTypes().addAll(acepetarButtonType, ButtonType.CANCEL);
		
		TextField conocimientoText = new TextField();
		ComboBox<Nivel> nivel = new ComboBox<>();
		nivel.setValue(Nivel.BASICO);
		nivel.getItems().addAll(Nivel.values());
		
		GridPane conocimientoGrid = new GridPane();
		conocimientoGrid.setPadding(new Insets(5));
		conocimientoGrid.setHgap(5);
		conocimientoGrid.setVgap(5);
		conocimientoGrid.addColumn(0, new Label("Nuevo Conocimiento:"),conocimientoText);
		conocimientoGrid.addColumn(1, new Label("Tipo telefono:"),nivel);

		conoDialg.getDialogPane().setContent(conocimientoGrid);
		
		conoDialg.setResultConverter(dialogButton -> {
		    if (dialogButton == acepetarButtonType) {
		    	Conocimiento nuevoConocimiento = new Conocimiento();
		    	nuevoConocimiento.setDenominacion(conocimientoText.getText());
		    	nuevoConocimiento.setNivel(nivel.getValue());
		        return nuevoConocimiento;
		    }
		    return null;
		});
		
		return conoDialg;
	}
	
	
}
