package ffmpeg;

import java.io.*;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import interfaz_mezclaDeTodos.PanelYControl;
import interfaz_mezclaDeTodos.Parametro;

public class InvocarComando {

	public static void invocarComando(String directorioDelComando, String lineaAEjecutar, List<Parametro> inputs) {
		try {
			String lineaComando = parsearComando(lineaAEjecutar, inputs);
			Process process = new ProcessBuilder(directorioDelComando, lineaComando).start();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public static String parsearComando(String comandoOriginal, List<Parametro> inputs) {
		// mete los inputs de la interfaz dentro del comando del XML
		String comando = "";
		String[] s = comandoOriginal.split(" ");
		for (int i = 0; i < s.length; i++) {
			if (s[i].startsWith("[")) {

				for (Parametro p:inputs) {

					if (s[i].contains(p.getNombreParametro())) {

						comando += " "+'"'+p.getParametro()+'"';
					}
				}

			} else {
				comando += " " + s[i];
			}
		}

		System.out.println(comando);
		return comando;
	}
/*   ESTE METODO DEBERIA BORRARSE, Y USAR EL DE ABAJO

	public static void ffmpeg(String comandoOriginal, List<Parametro> inputs) {
		try {
			File fichero = new File("src/ffmpeg/bin/ffmpeg.exe");

			// EJEMPLO JOIN WAVS:
			// ejemplo inputs:
			// List<String> inputs =new ArrayList<String>();
			// inputs.add("resources/Audio.wav");
			// inputs.add("resources/Audio.wav");
			// inputs.add("output/output.wav");
			// ejemplo comandoOriginal = "-i [AUDIO1] -i [AUDIO2]
			// -filter_complex amerge [OUTAUDIO]";

			String comando = parsearComando(comandoOriginal, inputs);

			// ejecuto FFMPEG con el comando
			Process p = Runtime.getRuntime().exec(fichero.getPath() + " " + comando);

			// muestra resultados de la ejecucion
			InputStream input = p.getErrorStream();
			int caracter;
			while ((caracter = input.read()) != -1) {
				System.out.print((char) caracter);
			}
			input.close();

		} catch (IOException ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
*/

}
