package valores;

public class CochePuntos {
	private Coche coche;
	private int puntos;

	public CochePuntos(Coche coche, int puntos) {
		this.coche = coche;
		this.puntos = puntos;
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
