package valores;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
	private String nom_premio;
	private List<Coche> participantes;

	public Carrera() {
		
	}
	
	public Carrera(String nom_premio, List<Coche> participantes) {
		this.nom_premio = nom_premio;
		this.participantes = new ArrayList<Coche>();
		this.participantes.addAll(participantes);
	}

	public String getNom_premio() {
		return nom_premio;
	}

	public void setNom_premio(String nom_premio) {
		this.nom_premio = nom_premio;
	}

	public List<Coche> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Coche> participantes) {
		this.participantes = participantes;
	}

}
