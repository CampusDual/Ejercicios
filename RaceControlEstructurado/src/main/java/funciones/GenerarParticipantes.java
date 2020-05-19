package funciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import valores.Coche;
import valores.Garaje;

public class GenerarParticipantes {
	
	public static List<Coche> cochesParticipantes = new ArrayList<Coche>();
	public static List<Garaje> garajesParticipantes = new ArrayList<Garaje>();
	public static List<Garaje> garajes =  MovimientoFicheros.garajes;
	
	//Metodo para escoger si participan todos los garajes o solo unos en concreto
	public static void seleccionarParticipantes(Scanner entrada) {
		int valor = 0;
		int contador = 0;
		boolean repetido = false;
		
		//control para que no se metan dos veces un garaje
		do {
			do {
				System.out.println("\n\t\t\t\tSELECCIONAR GARAJES \n\t\t\t\t----------- -------");
				for(Garaje garaje: garajes) {
					contador++;
					for(Garaje garajesParticipante: garajesParticipantes) {
						if(garaje.getEscuderia().equalsIgnoreCase(garajesParticipante.getEscuderia())) {
							repetido = true;
						}
					}
					if (repetido){
						System.out.println("\t\t\t"+contador + ".- " + garaje.getEscuderia() + " - REGISTRADO");
					}else {
						System.out.println("\t\t\t"+contador + ".- " + garaje.getEscuderia());
					}
					repetido = false;
				}
				
				System.out.println("\nSelecciona que garejes quieres que participen: (0 para salir)");
				valor = entrada.nextInt();
				
				
				if(valor != 0) {
					for(Garaje garajesParticipante: garajesParticipantes) {
						if(garajesParticipante.getEscuderia().equalsIgnoreCase(garajes.get(valor - 1).getEscuderia())) {
							repetido = true;
						}
					}
					if (repetido){
						System.out.println("El garaje ya está registrado");
					}else {
						garajesParticipantes.add(garajes.get(valor - 1));
					}
				}
				repetido = false;
				contador = 0;
				
			}while(valor != 0);
			
			if(garajesParticipantes.size() == 0) {
				System.out.println("\nSelecciona como mínimo un garaje");
			}
		}while(garajesParticipantes.size() == 0);

		if(garajesParticipantes.size() == 1) {			
			//si solo se selecciona un garaje se meten todos los coches de ese garaje
			generarTodos();
		}else {
			//si se meten dos o más, se añade uno de los coches de cada garaje de forma aleatoria
			generarAleatorio();
		}
		mostrarParticipantes();
	}

	//Si solo participa un garaje, añadimos todos sus coches
	private static void generarTodos() {
		List<Coche> listaCoches = garajesParticipantes.get(0).getCoches();
		for(Coche listaCoche: listaCoches) {
			cochesParticipantes.add(listaCoche);
		}
	}

	//Mostramos los coches guardados en participantes
	private static void mostrarParticipantes() {
		System.out.println("\n\t\t\tPARTICIPANTES \n\t\t\t-------------\n");
		for(Coche cochesParticipante: cochesParticipantes) {
			cochesParticipante.mostrarDatos(1);
		}
		
	}

	//escogemos de forma aleatoria un coche de cada garaje
	private static void generarAleatorio() {
		int valor;
		for(Garaje garajesParticipante: garajesParticipantes) {
			valor =(int)(Math.random() * (garajesParticipante.getCoches().size()));
			cochesParticipantes.add(garajesParticipante.getCoches().get(valor));
		}
	}

}
