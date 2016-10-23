package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.swing.JOptionPane;

import estructuras.Parametro;
import vistas.FrameConsola;

public class InvocarComando {

	public static void invocarComando(String directorioDelComando, String lineaAEjecutar, List<Parametro> inputs) {

		String lineaComando = parsearComando(lineaAEjecutar, inputs);
		new Thread(new Runnable() {
			public void run() {
				Process p;
				String line;
				try {
					p = Runtime.getRuntime().exec(directorioDelComando + " " + lineaComando);
					FrameConsola fc = new FrameConsola();
					BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
					BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
					while ((line = error.readLine()) != null && !fc.isInterrumpir()) {
						fc.agregarLineas(line + '\n');
					}
					if(!fc.isInterrumpir()){
						while ((line = input.readLine()) != null && !fc.isInterrumpir()) {
							fc.agregarLineas(line + '\n');
						}
					}
					p.destroy();
					fc.procesoTerminado();
					input.close();
					JOptionPane.showMessageDialog(null, "Se ha realizado la operación con éxito", "Error", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "No se han cargado los parámetros correspondiente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}).start();

	}

	public static String parsearComando(String comandoOriginal, List<Parametro> inputs) {
		// mete los inputs de la interfaz dentro del comando del XML
		String comando = "";
		String[] s = comandoOriginal.split(" ");
		if(inputs.isEmpty() || inputs.size() == 0) {
			return comando;
		} else {

			for (String s2 : s) {
	
				System.out.println(s2);
	
				if (s2.contains("[")) {
	
					for (Parametro p : inputs) {
	
						if ((s2.equals("[" + p.getNombreParametro() + "]")) | (s2.contains(p.getNombreParametro()))) {
	
							comando += s2.replace("[" + p.getNombreParametro() + "]", p.getParametro());
							comando += " ";
						}
	
					}
	
				} else {
					comando += " " + s2 + " ";
				}
	
			}
			System.out.println(comando);

			return comando;
		}
	}
}
