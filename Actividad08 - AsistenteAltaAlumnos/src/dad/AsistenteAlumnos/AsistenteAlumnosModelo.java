package dad.AsistenteAlumnos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AsistenteAlumnosModelo {
	
	//Datos Personal
	private	StringProperty nombre;
	private StringProperty apellido1;
	private StringProperty apellido2;
	private ObjectProperty<LocalDate> fechaNacimiento;
	private ReadOnlyIntegerWrapper edad;
	//Datos Domicilio
	private	StringProperty direccion;
	private	StringProperty codigoPosta;
	private	StringProperty ciudad;
	//Datos Contactos
	private	StringProperty movil;
	private	StringProperty fijo;
	private	StringProperty email;
	
	private StringProperty resumen;
	
	private String resultado;
	
	public AsistenteAlumnosModelo() {
		nombre = new SimpleStringProperty(this,"nombre","");
		apellido1 = new SimpleStringProperty(this,"apellido1","");
		apellido2 = new SimpleStringProperty(this,"apellido2","");
		fechaNacimiento = new SimpleObjectProperty<>(this, "Fehca Nacimiento");
		edad = new ReadOnlyIntegerWrapper(this, "edad");
		fechaNacimiento.addListener((observable, oldValue, newValue) -> {
			edad.set(Period.between(newValue,LocalDate.now()).getYears());
		});
		
		direccion = new SimpleStringProperty(this,"direccion","");
		codigoPosta = new SimpleStringProperty(this,"codigoPosta","");
		ciudad = new SimpleStringProperty(this,"ciudad","");
		
		movil = new SimpleStringProperty(this,"movil","");
		fijo = new SimpleStringProperty(this,"fijo","");
		email = new SimpleStringProperty(this,"email","");
		
		resumen = new SimpleStringProperty(this,"resumen","");
		
		resumen.bind(Bindings.concat(
								"Nombre: ", nombre,
								"\nApellido1:",apellido1,
								"\nApellido2:",apellido2,
								"\nFecha Nacimiento:",fechaNacimiento,
								"\nEdad:",edad,
								"\nDireccion:",direccion,
								"\nCodigo Postal:",codigoPosta,
								"\nCiudad:",ciudad,
								"\nMovil:",movil,
								"\nFijo:",fijo,
								"\nE-mail:",email));
	}
	
	public void crearFichero(){
		
		File archivo = new File("alumnos.csv");
		if(!archivo.exists()){
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			try {

				BufferedWriter bw = new BufferedWriter(new FileWriter(archivo,true));
				String alumnodatos = nombre.get()+ ";" + 
						  apellido1.get() + ";" +
						  apellido2.get() + ";" + 
						  fechaNacimiento.get() + ";" + 
						  edad.get() + ";" + 
						  direccion.get() + ";" +
						  codigoPosta.get() + ";" + 
						  ciudad.get() + ";" + 
						  movil.get() + ";" + 
						  fijo.get() + ";" + 
						  email.get() + ";";
				
				bw.append(alumnodatos+"\n");
				
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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

	public StringProperty apellido1Property() {
		return this.apellido1;
	}
	

	public String getApellido1() {
		return this.apellido1Property().get();
	}
	

	public void setApellido1(final String apellido1) {
		this.apellido1Property().set(apellido1);
	}
	

	public StringProperty apellido2Property() {
		return this.apellido2;
	}
	

	public String getApellido2() {
		return this.apellido2Property().get();
	}
	

	public void setApellido2(final String apellido2) {
		this.apellido2Property().set(apellido2);
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
	

	public javafx.beans.property.ReadOnlyIntegerProperty edadProperty() {
		return this.edad.getReadOnlyProperty();
	}
	

	public int getEdad() {
		return this.edadProperty().get();
	}

	public StringProperty direccionProperty() {
		return this.direccion;
	}
	

	public String getDireccion() {
		return this.direccionProperty().get();
	}
	

	public void setDireccion(final String direccion) {
		this.direccionProperty().set(direccion);
	}
	

	public StringProperty codigoPostaProperty() {
		return this.codigoPosta;
	}
	

	public String getCodigoPosta() {
		return this.codigoPostaProperty().get();
	}
	

	public void setCodigoPosta(final String codigoPosta) {
		this.codigoPostaProperty().set(codigoPosta);
	}
	

	public StringProperty ciudadProperty() {
		return this.ciudad;
	}
	

	public String getCiudad() {
		return this.ciudadProperty().get();
	}
	

	public void setCiudad(final String ciudad) {
		this.ciudadProperty().set(ciudad);
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
	

	public StringProperty emailProperty() {
		return this.email;
	}
	

	public String getEmail() {
		return this.emailProperty().get();
	}
	

	public void setEmail(final String email) {
		this.emailProperty().set(email);
	}

	public StringProperty resumenProperty() {
		return this.resumen;
	}
	

	public String getResumen() {
		return this.resumenProperty().get();
	}
	

	public void setResumen(final String resumen) {
		this.resumenProperty().set(resumen);
	}
	
	
	
	
}
