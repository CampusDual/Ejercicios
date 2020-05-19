package funciones;

import java.util.List;
import java.util.Scanner;

import carrera.Carrera;
import carrera.CarreraEliminacion;
import carrera.CarreraEstandar;
import entidades.Coche;
import entidades.CochePuntos;
import entidades.Resultados;
import entidades.Torneo;

public class Menu {
	
	//Opciones iniciales
	public static void menuInicial()  {
		Scanner entrada = new Scanner(System.in);
		int valor = 0;
		do {
			System.out.println("\n\t\t\t\tRACE CONTROL \n\t\t\t\t---- -------");
			System.out.println("\t\t\t1.- Crear torneo \n\t\t\t2.- Crear carrera \n\t\t\t3.- Salir ");
			
			System.out.println("\n¿Que opción quieres realizar? (1 - 3)");
			valor = LeerOpcion.comprobarOpcion(4);
			opcionesMenu(valor);
		}while(valor != 3);
		entrada.close();
	}
	
	//Diferentes rutas según la opcion
	public static void opcionesMenu(int opcion) {
		int valor = 0;
		switch(opcion) {
		case 1:
			//crear torneo
			List<Coche> participantes = Carrera.seleccionarCoches();
			List<String> premios = GuardarDatos.premios;
			List<CochePuntos> cochePuntos = CochePuntos.iniciarLista(participantes);
			Torneo torneoActual = new Torneo(participantes,premios,cochePuntos);
			torneoActual.empezarTorneo();
			break;
		case 2:
			//crear carre
			System.out.println("\t\t\t1.- Carrera Estandar \n\t\t\t2.- Carrera Eliminacion");
			valor = LeerOpcion.comprobarOpcion(3);
			opcionesCarrera(valor);
			break;
		default:
			System.out.println("\n\t\tFIN DE PROGRAMA \n\t\t--- -- --------");
			break;
		}
	}
	
	//Según si es carrera Estandar o Eliminacion
	public static void opcionesCarrera(int opcion) {
		String nombreCarrera = Carrera.seleccionarNombre();
		if(opcion == 1) {
			//carrera Estandar
			List<Coche> participantes = Carrera.seleccionarCoches();
			CarreraEstandar carrera = new CarreraEstandar(nombreCarrera, 2, participantes);
			Resultados podio = carrera.empezarCarrera();
			System.out.println(podio);
		}else if(opcion == 2) {
			//carrera Eliminacion
			List<Coche> participantes = Carrera.seleccionarCoches();
			CarreraEliminacion carrera = new CarreraEliminacion(nombreCarrera,participantes);
			Resultados podio = carrera.empezarCarrera();
			System.out.println(podio);
		}else {
			System.out.println("Valor erroneo");
		}
	}
}
