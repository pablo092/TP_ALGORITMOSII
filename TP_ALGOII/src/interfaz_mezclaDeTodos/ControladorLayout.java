package interfaz_mezclaDeTodos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControladorLayout implements ActionListener {
	Layout l = new Layout();
	public static List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();
	public static List<ParametrosInterfaz> ParametrosInterfaz = new ArrayList<ParametrosInterfaz>();
	Aplicacion app = new Aplicacion();
	Configuracion conf = new Configuracion();
	Boolean tieneConfigsCargadas = false;

	public ControladorLayout(Layout l) {
		this.cargarAplicaciones();
	  this.mostrarContenidoApps();
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
						conf=c;
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
						conf=app.getConfiguraciones().get(0);
						l.mostrarControles(app.getConfiguraciones().get(0).getControls());
						}
					
					}
				}
			}
		}

	public void loadAPIs() {
		l.getComboAPIs().removeAllItems();
		for (Aplicacion a : aplicaciones) {
			ParametrosInterfaz ParametrosInter = new ParametrosInterfaz();
			ParametrosInter.setApp(a.getName());
			ParametrosInterfaz.add(ParametrosInter);
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
	
	public void mostrarContenidoApps (){
		

		System.out.println("++++++Aplicaciones ");
		for (Aplicacion a : aplicaciones){
			System.out.println("**********Nombre de la appp"+ a.getName());
			
				for (Configuracion c : a.getConfiguraciones()){
					System.out.println("++++Nombre de la Config:  "+ c.getNombre());
					
					
						for (Control cont : c.getControls()){
							
							System.out.println("**********Nombre del Control:  "+ cont.getName());
							
							System.out.println("**********Atributos");
							
							
							for (ParametroDeControl param : cont.getParametrosDeControl()){
								
								System.out.println("++++++Nombre del Atributo def dir"+ param.getDefDir());

								System.out.println("++++++Nombre del Atributo def value"+ param.getDefvalue());


								System.out.println("++++++Nombre del Atributo grado"+ param.grado);
								
								
							}
							
							
				
							
							
						}
								
					
					
				}
			
		}
		
		
	}

}
