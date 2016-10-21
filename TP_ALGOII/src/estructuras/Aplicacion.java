package estructuras;

import java.util.ArrayList;
import java.util.List;


public class Aplicacion {
	private String name="";
	private List<Configuracion> configuraciones=new ArrayList<Configuracion>();
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Configuracion> getConfiguraciones() {
		return configuraciones;
	}

	public void setConfiguraciones(List<Configuracion> configuraciones) {
		this.configuraciones = configuraciones;
	}

}
