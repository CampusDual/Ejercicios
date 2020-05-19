package main;

import java.io.IOException;

import funciones.Menu;
import funciones.MovimientoFicheros;

public class RaceControlRunner {

	public static void main(String[] args) throws IOException{
		
		MovimientoFicheros.leerCoches();
		MovimientoFicheros.leerGarajes();
		MovimientoFicheros.leerPremios();
		
		Menu.menuInicial();
		
	}

}
