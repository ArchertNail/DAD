package dad.CalculadoraMVC;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class CalculadoraControll {
	private CalculadoraView calView;
	private Calculadora calModel;
	private Button [] numeros;
	
	public CalculadoraControll(){
		this.calModel = new Calculadora();
		this.calView = new CalculadoraView();
		this.calView.getResultText().textProperty().bind(
				this.calModel.pantallaProperty()
			);
		operaciones();
	}
	
	private void operaciones(){
		
		numeros = new Button[10];
		numeros = this.calView.getNumerosBotones();
	
		for(int i=0; i<numeros.length;i++){
			String numero = numeros[i].getText();
			numeros[i].setOnAction(e->onOperacionMatematica(numero));
		}
		this.calView.getSumBoton().setOnAction(e->onOperadores("+"));
		this.calView.getRestBoton().setOnAction(e->onOperadores("-"));
		this.calView.getMultBoton().setOnAction(e->onOperadores("*"));
		this.calView.getDivBoton().setOnAction(e->onOperadores("/"));
		this.calView.getIgualBoton().setOnAction(e->onOperadores("="));
		
		this.calView.getPuntoBoton().setOnAction(e->onPunto(e));
		this.calView.getcBoton().setOnAction(e->onBorrar(e));
		this.calView.getCeBoton().setOnAction(e->onBorrarTodo(e));
	}
	
	private void onBorrarTodo(ActionEvent e) {
		this.calModel.borrarTodo();
	}

	private void onBorrar(ActionEvent e) {
		this.calModel.borrar();
	}

	private void onPunto(ActionEvent e) {
		
		this.calModel.insertarComa();
	}

	private void onOperadores(String signo) {
		char operador =signo.charAt(0);
		this.calModel.operar(operador);
	}

	private void onOperacionMatematica(String numero) {
		char numEntero =numero.charAt(0);
		this.calModel.insertar(numEntero);
	}

	public CalculadoraView getRoot(){
		return calView;
	}
}
