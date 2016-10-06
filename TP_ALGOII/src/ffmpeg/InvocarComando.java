package ffmpeg;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvocarComando {
	public static void ffmpeg(String comandoOriginal,List<String> inputs) {
		try {
			File fichero = new File("src/ffmpeg/bin/ffmpeg.exe");
			
			//EJEMPLO JOIN WAVS:
			//ejemplo inputs:
			//List<String> inputs =new ArrayList<String>();
			//inputs.add("resources/Audio.wav");
			//inputs.add("resources/Audio.wav");
			//inputs.add("output/output.wav");
			//ejemplo comandoOriginal = "-i [AUDIO1] -i [AUDIO2] -filter_complex amerge [OUTAUDIO]";
			
			String comando=parsearComando(comandoOriginal,inputs);

			//ejecuto FFMPEG con el comando
			Process p = Runtime.getRuntime().exec(fichero.getPath() + " " + comando);
			
			
			//muestra resultados de la ejecucion
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
	
	public static String parsearComando(String comandoOriginal,List<String> inputs){
		//mete los inputs de la interfaz dentro del comando del XML
		int j=0;
		String comando="";
		String[] s=comandoOriginal.split(" ");
		for(int i=0;i<s.length;i++){
			if(s[i].startsWith("[")){
				comando+=" "+inputs.get(j);
				j++;
			}
			else{
				comando+=" "+s[i];
			}
		}
		return comando;
	}
}