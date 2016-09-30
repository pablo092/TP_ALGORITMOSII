package main;


import controlador.ControladorAbstracto;


import controlador.ControladorSetup;
import interfaz_mezclaDeTodos.Aplicacion;
import interfaz_mezclaDeTodos.Configuracion;
import interfaz_mezclaDeTodos.ParseoXML;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vista.VistaSetup;


public class Main2 {
	
	static public List<Aplicacion> Aplicaciones= new ArrayList<Aplicacion>();
	
	public static void main(String[] args) {
		
		
		ParseoXML parseo = new ParseoXML();
		
		parseo.parseoXMLs(Aplicaciones);
		
		
		ControladorAbstracto cp = new ControladorSetup();
		((ControladorSetup) cp).iniciar();
		
		//(Probar el parseo)
		
		
		MostrarTodasLasConfig();
		
			
		
	}
	
	
	public static void MostrarTodasLasConfig(){
	
		for(int i =0; i<Aplicaciones.size();i++){
			
		Aplicacion App = Aplicaciones.get(i);
		Iterator< Configuracion> itConf = App.getConfiguraciones().iterator();
        while (itConf.hasNext()){
            Configuracion Config = itConf.next();
            
            System.out.println(Config.getNombre());
          
		
	}
	
}
		
	}
}
