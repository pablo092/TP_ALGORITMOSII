package nicole;

import java.util.ArrayList;
import java.util.List;

public class Configuracion {
	private String nombre;
	private List<Parametro> parametros=new ArrayList();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}
}
