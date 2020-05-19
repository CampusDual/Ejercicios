package funciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

import valores.Coche;
import valores.CochePuntos;

public class FuncionesCarreras {
	
	public static List<Coche> participantes = GenerarParticipantes.cochesParticipantes;
	public static List<String> premios = MovimientoFicheros.premios;
	public static List<Coche> posiciones;
	
	public static List<CochePuntos> cochePuntos = new ArrayList<CochePuntos>();
	
	private final static  int NUMPARTICIPANTES = participantes.size();
	private static int duracion_estandar = 180;		//3h = 180 min
	private static int intervalo_tiempo = 15;		//cada cuanto tiempo te muestra los cambios en carrera estandar
	private final static int  num_vueltas_eliminacion = NUMPARTICIPANTES - 1;
	
	private final static int NUMTORNEO = 10;

	public static void crearCarrera(int valor,Scanner entrada,boolean torneo){
		String nom_premio = seleccionarPremio();
		if (torneo) {
			llenarCochePuntos();
			for(int i = 0; i < NUMTORNEO - 1; i++) {
				nom_premio = seleccionarPremio();
				if (valor == 1)
					System.out.println("\t\tCarrera Estandar: " + nom_premio);
				else
					System.out.println("\n\t\tCarrera Eliminacion: " + nom_premio);
				System.out.println("\n\t\t\tCalculando resultados .......");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if (valor == 1)
					procesoCarreraEstandar();
				else
					procesoCarreraEliminacion();
				
				almacenarResultados();
				
				calcularPodio();
				
				//volvemos a poner la velocidad de los coches que participaron en 500
				for(int j = 0; j < participantes.size(); j++) {
					participantes.get(j).resetVelocidad();
				}
			}
			calcularPodio();
		}else {
			if (valor == 1)
				System.out.println("\t\tCarrera Estandar: " + nom_premio);
			else
				System.out.println("\n\t\tCarrera Eliminacion: " + nom_premio);
			System.out.println("\n\t\t\tCalculando resultados .......");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (valor == 1) {
				procesoCarreraEstandar();
				System.out.println("\n\t\t\tPosiciones Finales \n\t\t\t---------- --------");
				mostrarPosiciones();
			}else {
				procesoCarreraEliminacion();
				System.out.println("\n\t\t\tGanador \n\t\t\t-------");
				participantes.get(0).mostrarDatos(2);
			}
			//volvemos a poner la velocidad de los coches que participaron en 500
			for(int j = 0; j < participantes.size(); j++) {
				participantes.get(j).resetVelocidad();
			}
		}
	}
	
	private static void calcularPodio() {
		Collections.sort(cochePuntos, (coche1,coche2) -> Integer.compare(coche1.getPuntos(),coche2.getPuntos()));
		System.out.println("\n\t\t\tPodio Final \n\t\t\t----- -----");
		for(int i = 0; i < 3 ; i++) {
			System.out.println("\n\t\t\t" + (i + 1) +"º Puesto:");
			cochePuntos.get(i).getCoche().mostrarDatos(2);
			System.out.print("\t\t\tcon " + cochePuntos.get(i).getPuntos() + " puntos\n");
		}
	}

	//Creamos una lista de resultado a cero puntos, donde luego iremos sumando puntos
	private static void llenarCochePuntos() {
		for(int i = 0; i < NUMPARTICIPANTES; i++) {
			CochePuntos cocheañadir = new CochePuntos(participantes.get(i),0);
			cochePuntos.add(cocheañadir);
		}
	}

	private static void almacenarResultados() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < participantes.size(); j++) {
				if(participantes.get(i) == cochePuntos.get(j).getCoche()) {
					if(i == 0) {
						cochePuntos.get(j).setPuntos(cochePuntos.get(j).getPuntos() + 15);
					}else if(i == 1) {
						cochePuntos.get(j).setPuntos(cochePuntos.get(j).getPuntos() + 10);
					}else {
						cochePuntos.get(j).setPuntos(cochePuntos.get(j).getPuntos() + 5);
					}
				}
			}
		}
		
	}

	//Metodo para realizar todo el proceso de la carrera de Eliminacion
	private static void procesoCarreraEliminacion() {
		for(int i = 0; i < num_vueltas_eliminacion; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			modificarVelocidad();
			modificarPosiciones();
		}
	}

	//Metodo para realizar todo el proceso de la carrera Estandar
	private static void procesoCarreraEstandar() {
		for(int i = 0; i < duracion_estandar; i = i + intervalo_tiempo) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			modificarVelocidad();
			modificarPosiciones();
		}
	}

	//Metodo para guardar los resultados y participantes de la carrera en un archivo de texto
	//private static void guardarDatos() {
		
	//}

	//Metodo que muestra el podio final de la carrera
	private static void mostrarPosiciones() {
		if(participantes.size() == 2) {						//si solo participan dos coches
			System.out.println("\n\t\t\tPrimer puesto: ");
			participantes.get(0).mostrarDatos(2);
			System.out.println("\n\t\t\tSegundo puesto: ");
			participantes.get(1).mostrarDatos(2);			
		}else {												//si participan más de dos
			System.out.println("\n\t\t\tPrimer puesto: ");
			participantes.get(0).mostrarDatos(2);
			System.out.println("\n\t\t\tSegundo puesto: ");
			participantes.get(1).mostrarDatos(2);
			System.out.println("\n\t\t\tTercer puesto: ");
			participantes.get(2).mostrarDatos(2);
		}
	}
	
	//Metodo que calcula las posiciones de los coches despues de modificar su velocidad
	private static void modificarPosiciones() {
		Collections.sort(participantes, (coche1,coche2) -> Integer.compare(coche1.distanciaRecorrida(),coche2.distanciaRecorrida()));
	}

	//Metodo que modifica la velocidad de los coches de forma aleatoria
	private static void modificarVelocidad() {
		for(int i = 0; i < NUMPARTICIPANTES; i++ ) {
			int valor =(int) (Math.random() * 10);
			if(valor >= 5) {
				participantes.get(i).acelerar();
			}else {
				participantes.get(i).frenar();
			}
			participantes.get(i).distanciaRecorrida();
		}
	}

	//Metodo que devuelve un premio aleatorio de una lista
	public static String seleccionarPremio() {			
		int longitud = premios.size();
		int num_random =(int)(Math.random() * (longitud - 1));
		String valor_premio = premios.get(num_random);
		return valor_premio;
	}
	
}
