package funciones;

import java.util.Scanner;

import valores.Carrera;

public class Menu {

	public static Carrera carrera;
	
	public static void menuInicial()  {
		Scanner entrada = new Scanner(System.in);
		int valor = 0;
		do {
			System.out.println("\n\t\t\t\tRACE CONTROL \n\t\t\t\t---- -------");
			System.out.println("\t\t\t1.- Crear torneo \n\t\t\t2.- Crear carrera \n\t\t\t3.- Coches registrados \n\t\t\t4.- Salir ");
			do {
				System.out.println("\n¿Que opción quieres realizar? (1 - 4)");
				valor = entrada.nextInt();
			}while(valor <1 || valor > 4); 
			
			switch(valor) {
			case 1:
				GenerarParticipantes.seleccionarParticipantes(entrada);
				opcionTorneo(entrada);
				break;
			case 2:
				GenerarParticipantes.seleccionarParticipantes(entrada);
				opcionCarrera(entrada);
				break;
			case 3:
				listarCoches();
				break;
			default:
				System.out.println("\n\t\tFIN DE PROGRAMA \n\t\t--- -- --------");
				break;
			}
			GenerarParticipantes.cochesParticipantes.clear();
			GenerarParticipantes.garajesParticipantes.clear();
		}while(valor != 4);
		entrada.close();
	}

	//Opción para mostrar todo los coches diponibles para participar
	private static void listarCoches() {
		System.out.println("\t\t   COCHES REGISTRADOS");
		System.out.println("\t    -------------------------------");
		MovimientoFicheros.mostrarDatos();
	}

	//Opción para seleccionar el tipo de carrera que queremos realizar
	private static void opcionCarrera(Scanner entrada)  {
		int valor = 0;

		System.out.println("\n\t\t\t\tTIPO DE CARRERA \n\t\t\t\t---- -- -------");
		System.out.println("\t\t\t1.- Estandar \n\t\t\t2.- Eliminación");

		do {
			System.out.println("\n¿Que opción quieres realizar? (1 - 2)");
			valor = entrada.nextInt();
		}while(valor < 1 || valor > 2);
		
		if (valor == 1) {
			FuncionesCarreras.crearCarrera(1,entrada,false);			//Estandar
		}else {
			FuncionesCarreras.crearCarrera(2,entrada, false);			//Eliminacion
		}
	}

	//Opción para seleccionar el tipo de torneo que queremos realizar
	private static void opcionTorneo(Scanner entrada) {
		FuncionesCarreras.crearCarrera(1,entrada,true);
	}
	

	
	
	
}
