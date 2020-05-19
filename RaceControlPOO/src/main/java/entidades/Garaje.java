package entidades;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
	private String nombre;
	private List<Coche> coches;
	
	public Garaje(String nombre, List<Coche> coches) {
		this.nombre = nombre;
		this.coches = new ArrayList<Coche>();
		this.coches.addAll(coches);
	}
	
	public String getNombre() {
		return nombre;
	}

	public List<Coche> getCoches() {
		return coches;
	}

	public void setCoches(List<Coche> coches) {
		this.coches = coches;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
