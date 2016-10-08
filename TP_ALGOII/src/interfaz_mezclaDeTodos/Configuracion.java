package interfaz_mezclaDeTodos;

import java.util.ArrayList;
import java.util.List;

public class Configuracion {
	public String nombre;
	private String command="";
	private String parametrosComando="";
	private List<Control> controls =new ArrayList<Control>();
	
	

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

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getParametrosComando() {
		return parametrosComando;
	}

	public void setParametrosComando(String parametrosComando) {
		this.parametrosComando = parametrosComando;
	}
}
