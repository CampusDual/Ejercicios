package carrera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entidades.Coche;
import entidades.Garaje;
import entidades.Resultados;
import funciones.GuardarDatos;

public abstract class Carrera {
	
	protected static final int PRIMERA_POSICION = 0;
	protected static final int SEGUNDA_POSICION = 1;
	protected static final int TERCERA_POSICION = 2;
	
	
	protected   String nombrePremio;
	protected   List<Coche> coches;
	protected static 	List<Garaje> garajes;
	protected   int longitudVuelta;
	protected int vueltaActual;
	
	
	
	public Carrera(String nombrePremio) {
		this.nombrePremio = nombrePremio;
		this.longitudVuelta = 400;
		this.coches = new ArrayList<Coche>();
		this.vueltaActual = 1;
	}
	
	public Carrera(String nombrePremio,List<Coche> coches) {
		this(nombrePremio);
		this.coches.addAll(coches);
	}
	
	public abstract Resultados empezarCarrera();
	
	//calculamos la distancia que recorre cada coche
	protected void setCochesDistancia() {
		for(Coche coche : coches) {
			coche.conducir();
		}
	}
	
	//ordenamos los coches
	protected void ordenarCoches() {
		Collections.sort(coches,compararPorDistancias);
	}
	
	//ordenamos los coches en funcion de la diferencia de la distancia recorrrida
	private Comparator<Coche> compararPorDistancias = new Comparator<Coche>() {
		public int compare(Coche coche1, Coche coche2) {
			return (coche1.getContadorDistancia() - coche2.getContadorDistancia()) * -1;
		}
	};

	//creamos un listado de coches con un coche random de cada garaje
	public static List<Coche> seleccionarCoches() {
		System.out.println("\n\t\t\tPARTICIPANTES: \n\t\t\t--------------");
		garajes = GuardarDatos.garajes;
		List <Coche> cochesRandom = new ArrayList<Coche>();
		for(Garaje garaje : garajes) {
			cochesRandom.add(escogerCocheRandom(garaje));
		}
		return cochesRandom;
	}
	
	//devolvemos un coche random del garaje
	public static Coche escogerCocheRandom(Garaje garaje) {
		int totalCochesGaraje = garaje.getCoches().size();
		int valorRandom = (int)(Math.random() * totalCochesGaraje);
		System.out.println("\t\t" + garaje.getCoches().get(valorRandom).toString());
		return garaje.getCoches().get(valorRandom);
	}
	
	//Seleccionamos un nombre de premio aleatorio 
	public static String seleccionarNombre() {
		List<String> premios = GuardarDatos.premios;
		int valorRandom = (int)(Math.random() * premios.size());
		return premios.get(valorRandom);
		
	}
	
	
	
	
}
