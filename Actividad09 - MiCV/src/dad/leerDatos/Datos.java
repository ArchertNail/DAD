package dad.leerDatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Datos {

	public static ArrayList<String> leerPaises(){
		ArrayList<String> nombrePaises = new ArrayList<>();
		String nombrePais ="";
		BufferedReader paisesLeer = null;
		try{
			FileReader paisesFile = new FileReader("paises.csv");
			paisesLeer = new BufferedReader(paisesFile);
			while ((nombrePais = paisesLeer.readLine()) != null) {
				nombrePaises.add(nombrePais);
			}
			paisesLeer.close();
			paisesFile.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		return nombrePaises;
	}
	
	public static ArrayList<String> leerNacionalidades(){
		ArrayList<String> choices = new ArrayList<>();
		String nombreNacionalidad ="";
		BufferedReader nacionalidadLeer = null;
		try{
			FileReader nacionalidadesFile = new FileReader("nacionalidades.csv");
			nacionalidadLeer = new BufferedReader(nacionalidadesFile);
			while ((nombreNacionalidad = nacionalidadLeer.readLine()) != null) {
				choices.add(nombreNacionalidad);
			}
			nacionalidadLeer.close();
			nacionalidadesFile.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		return choices;
	}
 	
	
}
