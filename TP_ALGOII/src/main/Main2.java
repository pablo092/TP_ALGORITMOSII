package main;

import controlador.ControladorAbstracto;
import controlador.ControladorSetup;

import anto.parseoXML;



public class Main2 {
	public static void main(String[] args) {
		ControladorAbstracto cp = new ControladorSetup();
		((ControladorSetup) cp).iniciar();
		
		//(Probar el parseo)
		parseoXML parseo = new parseoXML();
		
		parseo.parseoXMLs();
		
	}
}
