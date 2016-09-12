package nicole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorLayout implements ActionListener{
	Layout l=new Layout();
	List<Aplicacion> aplicaciones=new ArrayList<Aplicacion>();

	Aplicacion app=new Aplicacion();
	Configuracion config=new Configuracion();
	Boolean f=false;

	public ControladorLayout(Layout l){
		this.cargarAplicaciones();
		this.l=l;
		this.loadAPIs();

		l.getComboAPIs().addActionListener(this);
		l.getComboConfigs().addActionListener(this);
//		l.getBtnDestino().addActionListener(this);
//		l.getBtnComenzar().addActionListener(this);

	}

	public void actionPerformed(ActionEvent event) {
		if(!f){
		for(Aplicacion a: aplicaciones){
			if(l.getComboAPIs().getSelectedItem().equals(a.getName()) && l.getComboConfigs().getSelectedItem()==null){
				app=a;
				loadConfigs(app);
				f=true;
			}
		}}
		if(f){
		if(l.getComboAPIs().getSelectedItem().equals(app.getName())){
			for(Configuracion c: app.getConfiguraciones()){
				if(l.getComboConfigs().getSelectedItem().equals(c.getNombre())){
					config=c;
					l.mostrarParametros(c.getControls());
				}
			}
		}
		else{
			l.getComboConfigs().removeAllItems();
			f=false;
		}
		}
	}
	
	public void loadAPIs() {
		l.getComboAPIs().removeAllItems();
		for(Aplicacion a:aplicaciones){
			l.getComboAPIs().addItem(a.getName());
		}
	}
	public void loadConfigs(Aplicacion a) {
		l.getComboConfigs().removeAllItems();
		for(Configuracion c:a.getConfiguraciones()){
			l.getComboConfigs().addItem(c.getNombre());
		}
	}
	
	public void cargarAplicaciones(){
    	//Se fija todos lo XML que hay 
    	List<String> archivosXML=new ArrayList<String>();
    	try {
			BufferedReader br = new BufferedReader(new FileReader("Indice.txt"));
			String linea=br.readLine();
			while(linea!=null){
				archivosXML.add(linea);
				linea=br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	//Crea las app en funcion de los XML
    	this.parsearXMLs(archivosXML, this.getAplicaciones());
	}

	private void parsearXMLs(List<String> archivosXML,List<Aplicacion> aplicaciones){
		for(String XML:archivosXML){
			Aplicacion app=new Aplicacion();
			new Xml_dom_parser().cargaDatos(app,XML);
			aplicaciones.add(app);
		}
	}
	
	public List<Aplicacion> getAplicaciones() {
		return aplicaciones;
	}

	public void setAplicaciones(List<Aplicacion> aplicaciones) {
		this.aplicaciones = aplicaciones;
	}
	
}
