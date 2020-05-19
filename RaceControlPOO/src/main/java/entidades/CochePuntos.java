package entidades;

import java.util.ArrayList;
import java.util.List;

public class CochePuntos {

	public Coche coche;
	public int puntos;
	
	public CochePuntos(Coche coche, int puntos){
		this.coche = coche;
		this.puntos = puntos;
	}
	
	
	public static List<CochePuntos > iniciarLista(List<Coche> coches) {
		List<CochePuntos> cochePuntos = new ArrayList<CochePuntos>();
		for(Coche coche : coches) {
			CochePuntos cocheValor = new CochePuntos(coche,0);
			cochePuntos.add(cocheValor);
		}
		return cochePuntos;
	}

	public String toString() {
		return coche.toString() + "\t" + puntos;
	}

	public Coche getCoche() {
		return coche;
	}


	public void setCoche(Coche coche) {
		this.coche = coche;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	
}
