package interfaz_mezclaDeTodos;

import java.io.*;
import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvocarComando {

	public static void invocarComando(FrameConsola frameConsola, String directorioDelComando, String lineaAEjecutar, List<Parametro> inputs) {
		try {
			String lineaComando = parsearComando(lineaAEjecutar, inputs);
			Process p = Runtime.getRuntime().exec(directorioDelComando + " " + lineaComando);

			// muestra resultados de la ejecucion
			InputStream input = p.getInputStream();
			int caracter;

				//INICIO FRUTA COPIADA DE INTERNET
				ByteArrayOutputStream result = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int length;
				while ((length = input.read(buffer)) != -1) {
					result.write(buffer, 0, length);
				}
				String linea = result.toString("UTF-8");
				frameConsola.getTextArea().append(linea);
				//FIN Fruta de inet

			input.close();
			frameConsola.getButton().setText("Cerrar");

		} catch (IOException ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static String parsearComando(String comandoOriginal, List<Parametro> inputs) {
		// mete los inputs de la interfaz dentro del comando del XML
		String comando = "";
		String[] s = comandoOriginal.split(" ");
		

		for (String s2 : s){
			
			System.out.println(s2);
			
			 
			 if (s2.contains("[")){
				 
				 
				 for (Parametro p : inputs){
					 
					 if((s2.equals("["+p.getNombreParametro()+"]"))|(s2.contains(p.getNombreParametro()))){
						 
						
							 
							 comando += s2.replace("["+p.getNombreParametro()+"]", p.getParametro());
						 }
					 
				 }
				 
			 }else{
				 comando += " " + s2 + " ";
			 }
				
				}
			
		
		System.out.println(comando);
				
		return comando;
	}
}
