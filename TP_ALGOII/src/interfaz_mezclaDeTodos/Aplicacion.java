package interfaz_mezclaDeTodos;

import java.util.ArrayList;
import java.util.List;

import pack.TipoParametro;

public class Aplicacion {
	private String name="";
	private String command="";
	private String parametrosComando="";
	private List<Configuracion> configuraciones=new ArrayList();
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Configuracion> getConfiguraciones() {
		return configuraciones;
	}

	public void setConfiguraciones(List<Configuracion> configuraciones) {
		this.configuraciones = configuraciones;
	}

}
