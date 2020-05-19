package entidades;

public class Resultados {
	private Coche primerPuesto;
	private Coche segundoPuesto;
	private Coche tercerPuesto;
	
	public Resultados(Coche primerPuesto, Coche segundoPuesto, Coche tercerPuesto) {
		this.primerPuesto = primerPuesto;
		this.segundoPuesto = segundoPuesto;
		this.tercerPuesto = tercerPuesto;
	}

	
	public String toString() {
		 return "\n\t\t\tRESULTADOS: \n\t\t\t----------- \n\t\t" +
				 "1.- " + this.primerPuesto.toString() +"\n\t\t" +
				 "2.- " + this.segundoPuesto.toString() + "\n\t\t" +
				 "3.- " + this.tercerPuesto.toString();
				 
	}


	public Coche getPrimerPuesto() {
		return primerPuesto;
	}


	public void setPrimerPuesto(Coche primerPuesto) {
		this.primerPuesto = primerPuesto;
	}


	public Coche getSegundoPuesto() {
		return segundoPuesto;
	}


	public void setSegundoPuesto(Coche segundoPuesto) {
		this.segundoPuesto = segundoPuesto;
	}


	public Coche getTercerPuesto() {
		return tercerPuesto;
	}


	public void setTercerPuesto(Coche tercerPuesto) {
		this.tercerPuesto = tercerPuesto;
	}
	
	
}
