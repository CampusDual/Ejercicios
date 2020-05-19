package valores;

public class Coche {
	private String marca;
	private String modelo;
	private String garaje;
	private int velocidad = 500;

	public Coche() {
		
	}
	
	public Coche(String marca, String modelo,int velocidad,String garaje) {
		this.marca = marca;
		this.modelo = modelo;
		this.velocidad = velocidad;
		this.garaje = garaje;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public String getGaraje() {
		return garaje;
	}

	public void setGaraje(String garaje) {
		this.garaje = garaje;
	}

	public void acelerar() {
		velocidad = velocidad + 10;
	}
	
	public void frenar() {
		velocidad = velocidad - 10;
	}
	
	public void mostrarDatos(int valor) {
		if (valor == 1) {
			if(garaje.length() < 8) {
				System.out.println("\t" + marca + "\t" + modelo + "\t" + garaje + "\t\t" + velocidad +" km/h");
			}else {
				System.out.println("\t" + marca + "\t" + modelo + "\t" + garaje + "\t" + velocidad +" km/h");
			}
		}else {
			System.out.println("\tCoche " + marca + " con modelo " + modelo + " de la escuderia " + garaje);
		}
	}
	
	public void resetVelocidad() {
		velocidad = 500;
	}
	
	public int distanciaRecorrida() {
		double tiempo = 0.6;										
		int distancia =(int)(tiempo * velocidad);
		return distancia;
		
	}
	
	
}
