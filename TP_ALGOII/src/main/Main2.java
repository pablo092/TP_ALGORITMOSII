package main;

import controlador.ControladorAbstracto;
import controlador.ControladorSetup;

public class Main2 {
	public static void main(String[] args) {
		ControladorAbstracto cp = new ControladorSetup();
		((ControladorSetup) cp).iniciar();
	}
}
