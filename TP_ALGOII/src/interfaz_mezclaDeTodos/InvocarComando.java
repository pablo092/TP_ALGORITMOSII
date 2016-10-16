package interfaz_mezclaDeTodos;

import java.io.*;
import java.util.List;

public class InvocarComando {

	public static void invocarComando(String directorioDelComando, String lineaAEjecutar, List<Parametro> inputs) {

		String lineaComando = parsearComando(lineaAEjecutar, inputs);
		new Thread(new Runnable() {
			public void run() {
				Process p;
				String line;
				try {
					p = Runtime.getRuntime().exec(directorioDelComando + " " + lineaComando);
					FrameConsola fc=new FrameConsola();
					BufferedReader input = new BufferedReader(new InputStreamReader(p.getErrorStream()));
					while ((line = input.readLine()) != null) {
						fc.agregarLineas(line);
					}
					input.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

	public static String parsearComando(String comandoOriginal, List<Parametro> inputs) {
		// mete los inputs de la interfaz dentro del comando del XML
		String comando = "";
		String[] s = comandoOriginal.split(" ");

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
