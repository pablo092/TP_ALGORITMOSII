package interfaz_mezclaDeTodos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorLayout implements ActionListener {
	Layout l = new Layout();
	List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();

	Aplicacion app = new Aplicacion();
	Boolean tieneConfigsCargadas = false;

	public ControladorLayout(Layout l) {
		this.cargarAplicaciones();
		this.l = l;
		this.loadAPIs();

		l.getComboAPIs().addActionListener(this);
		l.getComboConfigs().addActionListener(this);
		// l.getBtnDestino().addActionListener(this);
		// l.getBtnComenzar().addActionListener(this);

	}

	public void actionPerformed(ActionEvent event) {
		if (!tieneConfigsCargadas) {
			for (Aplicacion a : aplicaciones) {
				if (l.getComboAPIs().getSelectedItem().equals(a.getName())
						&& l.getComboConfigs().getSelectedItem() == null) {
					app = a;
					l.getF().setTitle(app.getName());
					l.loadConfigs(app.getConfiguraciones());
					tieneConfigsCargadas = true;
				}
			}
		}
		if (tieneConfigsCargadas) {
			if (l.getComboAPIs().getSelectedItem().equals(app.getName())) {
				for (Configuracion c : app.getConfiguraciones()) {
					if (l.getComboConfigs().getSelectedItem().equals(c.getNombre())) {
						l.mostrarControles(c.getControls());
					}
				}
			} else {
				for (Aplicacion a : aplicaciones) {
					if (l.getComboAPIs().getSelectedItem().equals(a.getName())
							&& l.getComboConfigs().getSelectedItem() != null) {
						app = a;
						l.getF().setTitle(app.getName());
						l.getComboConfigs().removeActionListener(this);
						l.loadConfigs(app.getConfiguraciones());
						l.getComboConfigs().addActionListener(this);
						l.mostrarControles(app.getConfiguraciones().get(0).getControls());
					}
				}
			}
		}
	}


	public void loadAPIs() {
		l.getComboAPIs().removeAllItems();
		for (Aplicacion a : aplicaciones) {
			l.getComboAPIs().addItem(a.getName());
		}
	}

	public void cargarAplicaciones() {
		new ParseoXML().parseoXMLs(aplicaciones);
	}

	public List<Aplicacion> getAplicaciones() {
		return aplicaciones;
	}

	public void setAplicaciones(List<Aplicacion> aplicaciones) {
		this.aplicaciones = aplicaciones;
	}

}
