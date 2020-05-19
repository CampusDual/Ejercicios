package carrera;

import java.util.List;

import entidades.Coche;
import entidades.Resultados;

public class CarreraEliminacion extends Carrera{

	public CarreraEliminacion(String nombrePremio) {
		super(nombrePremio);
		
	}

	public CarreraEliminacion(String nombrePremio,List<Coche> coches) {
		super(nombrePremio,coches);
		
		
	}
	
	@Override
	//Realizamos X vueltas segun el numero de participantes de la carrera
	public Resultados empezarCarrera() {
		while(coches.size() > 3) {		//hacer hasta que solo queden tres coches, que serán los ganadores
			vuelta();
		}
		Resultados resultadoCarrera = new Resultados(coches.get(PRIMERA_POSICION),coches.get(SEGUNDA_POSICION),coches.get(TERCERA_POSICION));
		return resultadoCarrera;
	}
	
	//Por cada vuetla se recorre una distancia, se ordena la lista segun la distancia y se devuelve esa lista ordenada
	protected List<Coche> vuelta(){
		setCochesDistancia();
		ordenarCoches();
		//despues de cada vuelta eliminamos el ultimo coche de la lista
		borrarUltimo();
		return this.coches;
	}
	
	//buscamos la posicion del ultimo cohe, miramos si ya termino la vuelta y si lo ha hecho, lo borramos de la lista
	public void borrarUltimo() {
		Coche ultimoCoche = coches.get(coches.size() - 1);		//posicion del ultimo coche
		int vueltaUltimoCoche = ultimoCoche.getContadorDistancia() / this.longitudVuelta;
		if (vueltaUltimoCoche == this.vueltaActual && vueltaUltimoCoche > 0) {
			coches.remove(coches.size() - 1);
			this.vueltaActual++;
		}
	}
}
