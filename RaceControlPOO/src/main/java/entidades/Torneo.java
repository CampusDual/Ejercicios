package entidades;

import java.util.Collections;
import java.util.List;

import carrera.Carrera;
import carrera.CarreraEstandar;

public class Torneo {

	public List<Carrera> carreras;
	public List<Coche> coches;
	public List<String> premios;
	public List<CochePuntos> puntos;
	
	public Torneo(List<Coche> coches, List<String> premios, List<CochePuntos> puntos) {
		this.coches = coches;
		this.premios = premios;
		this.puntos = puntos;
	}
	
	
	//Realizamos todas la carreras del torneo en bucle
	public void empezarTorneo() {
		
		for(int i = 0; i < premios.size(); i++) {
			System.out.println("\n\t\t\tCarrera " + (i + 1) + " terminada . . . .");
			CarreraEstandar carrera = new CarreraEstandar(premios.get(i), 10, coches);
			Resultados podio = carrera.empezarCarrera();
			sumarResultados(podio);
		}
		ordenarResultados();
		mostrarResultado();
	}

	//Mostramos el podio dinal del torneo
	private void mostrarResultado() {
		System.out.println("\n\t\t\tRESULTADOS FINALES: \n\t\t\t---------- --------");
		System.out.println("\n\t\t" +
				"1.- " + puntos.get(0).toString() + "\n\t\t" +
				"2.- " + puntos.get(1).toString() + "\n\t\t" +
				"3.- " + puntos.get(2).toString());
		
	}

	//Ordenamos los resultados finales del torneo
	private void ordenarResultados() {
		Collections.sort(puntos,(coche2,coche1) -> Integer.compare(coche1.getPuntos(),coche2.getPuntos()));
	}

	//sumamos los puntos a los ganadores de la carrera
	private void sumarResultados(Resultados podio) {
		for(CochePuntos punto : puntos) {
			if(punto.getCoche() == podio.getPrimerPuesto()) {
				punto.setPuntos(punto.getPuntos() + 15);
			}else if(punto.getCoche() == podio.getSegundoPuesto()) {
				punto.setPuntos(punto.getPuntos() + 10);
			}else if(punto.getCoche() == podio.getTercerPuesto()) {
				punto.setPuntos(punto.getPuntos() + 5);
			}
		}
		
	}

	
}
