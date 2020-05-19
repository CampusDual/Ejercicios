package funciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerOpcion {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	//Comprueba que la opción insertada es un numerico y no está fuera de rango
	public static int comprobarOpcion(int valormaximo) {
		String valorUsuario = null;
		try {
			valorUsuario = reader.readLine();
		}catch(IOException e) {
			return 0;
		}
		int valor = StringToInt(valorUsuario);
		if(valor < valormaximo) {
			return valor;
		}else {
			return 0;
		}
	}

	//devuel el valor integer de la opcion insertada
	private static int StringToInt(String valorUsuario) {
		try {
			return Integer.parseInt(valorUsuario);
		}catch(NumberFormatException e) {
			return 0;
		}
	}
}
