package interfaz_mezclaDeTodos;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

public class Control {

	private String name;
	private String clase;
	private String label;
	public List<ParametroDeControl> parametrosDeControl;
	
	public Control() {
		this.name = "";
		this.clase = "";
		this.label = "";
		this.parametrosDeControl = new ArrayList<ParametroDeControl>();
	}


	
	public List<ParametroDeControl> getParametrosDeControl() {
		return parametrosDeControl;
	}
	public void setParametrosDeControl(List<ParametroDeControl> parametrosDeControl) {
		this.parametrosDeControl = parametrosDeControl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}


}
