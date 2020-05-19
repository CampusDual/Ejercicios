package carrera;

import java.util.List;
import entidades.Coche;
import entidades.Resultados;


public class CarreraEstandar extends Carrera{
	
	private int totalVueltas;
	
	public CarreraEstandar(String nombrePremio, int totalVueltas) {
		super(nombrePremio);
		this.totalVueltas = totalVueltas;
		
	}

	public CarreraEstandar(String nombrePremio, int totalVueltas,List<Coche> coches) {
		super(nombrePremio,coches);
		this.totalVueltas = totalVueltas;
	}

	@Override
	//Realizamos X vueltas segun si es una sola carrera o es un torneo
	public Resultados empezarCarrera() {
		while(vueltaActual < totalVueltas) {
			vuelta();
			//si el primer coche ya termino la vuelta, se le suma una vuelta al contador de vueltas actual
			if(vueltaActual == devolverVueltaPrimerCoche()) {
				vueltaActual++;
			}
		}
		Resultados resultadoCarrera = new Resultados(coches.get(PRIMERA_POSICION),coches.get(SEGUNDA_POSICION),coches.get(TERCERA_POSICION));
		return resultadoCarrera;
	}
	
	//Por cada vuetla se recorre una distancia, se ordena la lista segun la distancia y se devuelve esa lista ordenada
	protected List<Coche> vuelta(){
		setCochesDistancia();
		ordenarCoches();
		return this.coches;
	}
	
	//calculamos si el primer coche ya termino la vuelta entera
	private int devolverVueltaPrimerCoche() {
		Coche primeraPosicion = coches.get(0);
		return primeraPosicion.getContadorDistancia() / this.longitudVuelta;
	}
	

}
