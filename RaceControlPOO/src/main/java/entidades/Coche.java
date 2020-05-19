package entidades;

public class Coche {
	
	private String marca;
	private String modelo;
	private String garaje;
	private int contadorDistancia;
	private int ultimaDistancia;
	private static int maxVelocidad = 500;

	public Coche(String marca, String modelo,String garaje) {
		this.marca = marca;
		this.modelo = modelo;
		this.garaje = garaje;
		this.contadorDistancia = 0;
	}

	@Override
	public String toString() {
		return this.marca + " , " + this.modelo + " , " + this.garaje;
	}
	
	public String getGaraje() {
		return garaje;
	}
	
	//Los coches se mueven y recorre una distancia
	public void conducir() {
		ultimaDistancia = generarRandomDistancia(maxVelocidad);
		contadorDistancia += ultimaDistancia;
	}

	//Generamos una distancia random recorrida por cada coche
	private int generarRandomDistancia(int valormaximo) {
		Double distanciaRandom = new Double(Math.random() * valormaximo);
		int nuevaDistancia = distanciaRandom.intValue();
		return nuevaDistancia;
	}
	
	//Reseteamos la distancia de los coches despues de cada carrera
	public void resetearContador() {
		contadorDistancia = 0;
	}
	
	public int getContadorDistancia() {
		return contadorDistancia;
	}
}
