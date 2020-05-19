package funciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import valores.Coche;
import valores.Garaje;

public class MovimientoFicheros {
	
	private final static String RUTA ="C:\\Users\\German\\eclipse-workspace\\RaceControl\\Archivos\\";
	
	public static final String SEPARADOR=";";
	
	public static List<Garaje> garajes =  new ArrayList<Garaje>();			//almacenamos los garajes con sus coches dentro
	public static List<Coche> coches =  new ArrayList<Coche>();				//almacenamos todos los coches
	public static List<String> premios = new ArrayList<String>();

	//Llenar la lista coches con todos los coches 
	public static void leerCoches() throws IOException {
		BufferedReader lec = null;	
		String linea ="";
		try {
			lec = new BufferedReader(new FileReader(RUTA +"coches.csv"));
		    while ((linea = lec.readLine()) != null) {                
		    	String[] datos = linea.split(SEPARADOR);
		    	coches.add(new Coche(datos[0],datos[1],Integer.valueOf(datos[2]),datos[3]));
		    }
		}catch(FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			lec.close();
		}
	}
	
	//Llenar la lista de garajes con los garajes con su escuderia y sus coches
	public static void leerGarajes() throws IOException {
		BufferedReader lec = null;	
		String linea ="";
		List<Coche> cochesGaraje = new ArrayList<Coche>();
		try {
			lec = new BufferedReader(new FileReader(RUTA +"garajes.csv"));
		    while ((linea = lec.readLine()) != null) {   
		    	String[] datos = linea.split(SEPARADOR);
		    	for(int i = 0; i < datos.length;i++) {
		    		for(Coche coche: coches) {
		    			if(datos[i].equalsIgnoreCase(coche.getGaraje())) {
		    				cochesGaraje.add(coche);
		    			}
		    		}
		    	}
		    	garajes.add(new Garaje(linea,cochesGaraje));
		    	cochesGaraje.clear();
		    }
		}catch(FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			lec.close();
		}
	}
	
	//LLenamos la lista de premios
	public static void leerPremios() throws IOException {
		BufferedReader lec = null;	
		String linea ="";
		try {
			lec = new BufferedReader(new FileReader(RUTA +"premios.csv"));
		    while ((linea = lec.readLine()) != null) {                
		    	String[] datos = linea.split(SEPARADOR);
		    	premios.add(datos[0]);
		    }
		}catch(FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			lec.close();
		}
	}
	
	//Metodo para mostrar los datos de cada garaje junto a los datos de sus coches
	public static void mostrarDatos() {
		for(Garaje garaje: garajes) {
			System.out.println("\n\t\t\t" + garaje.getEscuderia() + "\n\t\t-----------------------\n");
			for(int i = 0; i < garaje.getCoches().size();i++) {
				garaje.getCoches().get(i).mostrarDatos(1);	
			}
		}
	}
	
	
}
