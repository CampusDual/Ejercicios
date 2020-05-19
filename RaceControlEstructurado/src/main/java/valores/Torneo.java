package valores;

import java.util.ArrayList;
import java.util.List;

public class Torneo {
	public final int num_carreras = 10;
	
	private List<Coche> participantes;
	private List<Integer> resultados;
	
	public Torneo(List<Coche> participantes, List<Integer> resultados) {
		this.participantes = new ArrayList<Coche>();
		this.participantes.addAll(participantes);
		this.resultados = resultados;
	}

	public List<Coche> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Coche> participantes) {
		this.participantes = participantes;
	}

	public List<Integer> getResultados() {
		return resultados;
	}

	public void setResultados(List<Integer> resultados) {
		this.resultados = resultados;
	}
	
	
}
