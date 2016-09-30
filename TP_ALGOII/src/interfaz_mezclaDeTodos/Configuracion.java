package interfaz_mezclaDeTodos;

import java.util.ArrayList;
import java.util.List;

public class Configuracion {
	public String nombre;
	private List<Control> controls =new ArrayList();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Control> getControls() {
		return controls;
	}

	public void setControls(List<Control> controls) {
		this.controls = controls;
	}
}
