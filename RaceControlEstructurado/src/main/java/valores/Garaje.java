package valores;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
	private String escuderia;
	private List<Coche> coches;
	
	public Garaje() {
		
	}
	
	public Garaje(String escuderia, List<Coche> coches) {
		this.escuderia = escuderia;
		this.coches =  new ArrayList<Coche>();
		this.coches.addAll(coches);
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}

	public List<Coche> getCoches() {
		return coches;
	}

	public void setCoches(List<Coche> coches) {
		this.coches = coches;
	}
	
}
