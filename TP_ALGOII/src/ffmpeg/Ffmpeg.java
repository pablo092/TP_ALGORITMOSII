package ffmpeg;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ffmpeg {
	public static void main(String[] args) {
		try {			
			
//			ESTA COMANDO IMPRIME LA VERSION DE FFMPEG
			File fichero = new File("ffmpeg.exe");
			String comando = "-version";
			
			Process p = Runtime.getRuntime().exec(fichero.getPath() + " " + comando);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String line = "";
			
			while ((line = br.readLine())!= null) {
//				EN VEZ DEL SYSTEM.OUT.PINTLN SE TENDRIA QUE MANDAR AL CUADRO DE TEXTO DE LA MODAL
				System.out.println(line);
			}
		} catch (IOException ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
