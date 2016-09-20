package controlador;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import dialogo.DialogoModal;
import vista.VistaSetup;
import anto.parseoXML;
import main.Main2;
import nicole.Aplicacion;
import nicole.Configuracion;

public class ControladorSetup extends ControladorAbstracto {
	
	FileNameExtensionFilter filtro;
	//static public List<Aplicacion> Aplicaciones= new ArrayList<Aplicacion>();

	public ControladorSetup() {
		this.vista = new VistaSetup();
		this.dialogo = new DialogoModal();
		((VistaSetup) vista).getComboAPIs().addActionListener(this);
		((VistaSetup) vista).getComboConfigs().addActionListener(this);
		((VistaSetup) vista).getbtnCampo1().addActionListener(this);
		((VistaSetup) vista).getbtnCampo2().addActionListener(this);
		((VistaSetup) vista).getbtnCampo3().addActionListener(this);
		((VistaSetup) vista).getBtnDestino().addActionListener(this);
		((VistaSetup) vista).getBtnComenzar().addActionListener(this);
	}
	
	public void iniciar() {
		((VistaSetup) vista).getFrmBasheador().setVisible(true);
		//loadAPIs();
		
		cargarApis(Main2.Aplicaciones);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == ((VistaSetup) vista).getComboAPIs()) {
			((VistaSetup) vista).getFrmBasheador().setTitle((String) ((VistaSetup) vista).getComboAPIs().getSelectedItem());
			//loadConfigs();
            
            ((VistaSetup) vista).getComboConfigs().removeAllItems();

		   String nameAppSelection =(String) ((VistaSetup) vista).getComboAPIs().getSelectedItem();
		   
		   System.out.println("El nombre es " + nameAppSelection);
		   
		   cargarConfigSegunNombreApp(nameAppSelection);
		
		}
		/*Seleccion de alguna API*/
				
		
		if(((VistaSetup) vista).getComboAPIs().getSelectedItem().equals("Audio To Video")){
		
		((VistaSetup) vista).mostrarParametros(2);
		}
		if(((VistaSetup) vista).getComboAPIs().getSelectedItem().equals("Video Extract")){
			((VistaSetup) vista).mostrarParametros(3);
		}
		if(((VistaSetup) vista).getComboAPIs().getSelectedItem().equals("API1")){
			((VistaSetup) vista).mostrarParametros(1);
		}
		if(((VistaSetup) vista).getComboAPIs().getSelectedItem().equals("Join Wavs")){
			((VistaSetup) vista).mostrarParametros(4);
		}
		/* */
		if(event.getSource() == ((VistaSetup) vista).getComboConfigs()) {
			loadParametersPanel();
		}
		if(event.getSource() == ((VistaSetup) vista).getBtnComenzar()) {
			this.dialogo.mostrate();
		}
		if(event.getSource() == ((VistaSetup) vista).getbtnCampo1()) {
			filtro = new FileNameExtensionFilter("*.MP3", "mp3");
			selectPath(((VistaSetup) this.vista).gettfCampo1(), filtro, false);
		}
		if(event.getSource() == ((VistaSetup) vista).getbtnCampo2()) {
			filtro = new FileNameExtensionFilter("*.JPEG", "jpeg");
			selectPath(((VistaSetup) this.vista).gettfCampo2(), filtro, false);
		}
		if(event.getSource() == ((VistaSetup) vista).getbtnCampo3()) {
			filtro = new FileNameExtensionFilter("*.WMV", "wmv");
			selectPath(((VistaSetup) this.vista).gettfCampo3(), filtro, false);
		}
		if(event.getSource() == ((VistaSetup) vista).getBtnDestino()) {
			selectPath(((VistaSetup) this.vista).getTfDestiino(), null, true);
		}
	}
	
	
	public Aplicacion buscarAppPorNombre(String name){
		
		Iterator< Aplicacion> itApp = Main2.Aplicaciones.iterator();
		Aplicacion Ap = null;
				while (itApp.hasNext()){
					
							Aplicacion App = itApp.next();
							
								if( (App.getName())==name)
									 Ap=App;
						
						}
				return Ap;
		
					
	}
	
	private void cargarConfigSegunNombreApp(String nameAppSelection) {
		// TODO Auto-generated method stub
		
		Aplicacion App = buscarAppPorNombre(nameAppSelection);
		if(App != null){
			System.out.println("La app que llega es: "+App.getName());
			Iterator< Configuracion> itConf = App.getConfiguraciones().iterator();
	        while (itConf.hasNext()){
	            Configuracion Config = itConf.next();
	            
	            System.out.println(Config.getNombre());
	            
	            ((VistaSetup) vista).getComboConfigs().addItem(Config.getNombre());
	          
	        }
			
		}
	}
		
		
	

	private void selectPath(JTextField jTextField, FileNameExtensionFilter filtro, boolean guarda) {
		JFileChooser fc = new JFileChooser();
		int seleccion = fc.showSaveDialog(this.vista.getContentPane());
		fc.setFileFilter(filtro);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			if (!guarda) {
				if (filtro.accept(fichero)) {
					jTextField.setText(fichero.getAbsolutePath());
				} else {
					vista.mostraError("Debe seleccionar un archivo correspondiente al tipo");
				} 
			} else {
//				TODO
//				GENERAR EL NUEVO ARCHIVO ACA!!!!
				jTextField.setText(fichero.getAbsolutePath());
			}
		}
	}

	//Carga todas las configs de todas las app. 
	public void cargarConfis(){
		
		for(int i =0; i<Main2.Aplicaciones.size();i++){
			
			Aplicacion App = Main2.Aplicaciones.get(i);
			Iterator< Configuracion> itConf = App.getConfiguraciones().iterator();
	        while (itConf.hasNext()){
	            Configuracion Config = itConf.next();
	            
	            System.out.println(Config.getNombre());
	            ((VistaSetup) vista).getComboConfigs().addItem(Config.getNombre());
		          
	        			}
	     }
	}
	
	public void cargarApis(List<Aplicacion> Aplicaciones){
		
		for (int i =0; i< Aplicaciones.size();i++){
			Aplicacion app =Aplicaciones.get(i);
			
				((VistaSetup) vista).getComboAPIs().addItem(app.getName());
			}
		
		
	}
	
	

	private void loadAPIs() {
		((VistaSetup) vista).getComboAPIs().addItem("API1");
		((VistaSetup) vista).getComboAPIs().addItem("Audio To Video");
		((VistaSetup) vista).getComboAPIs().addItem("Video Extract");
		((VistaSetup) vista).getComboAPIs().addItem("Join Wavs");
		
		
	}
	
	private void loadConfigs() {
		((VistaSetup) vista).getComboConfigs().removeAllItems();
		((VistaSetup) vista).getComboConfigs().addItem("Config1");
		((VistaSetup) vista).getComboConfigs().addItem("Config2");
		((VistaSetup) vista).getComboConfigs().addItem("Config3");
	}
	
	private void loadParametersPanel() {
//		((VistaSetup) vista).getFrmBasheador().getContentPane().add(((VistaSetup) vista).getLblAudio());
//		((VistaSetup) vista).getFrmBasheador().getContentPane().add(((VistaSetup) vista).getLblImagen());
//		((VistaSetup) vista).getFrmBasheador().getContentPane().add(((VistaSetup) vista).getLblVideo());
//		((VistaSetup) vista).getFrmBasheador().getContentPane().add(((VistaSetup) vista).getLblDestino());
//		((VistaSetup) vista).getFrmBasheador().getContentPane().add(((VistaSetup) vista).getTfAudio());
//		((VistaSetup) vista).getFrmBasheador().getContentPane().add(((VistaSetup) vista).getTfImagen());
//		((VistaSetup) vista).getFrmBasheador().getContentPane().add(((VistaSetup) vista).getTfVideo());
//		((VistaSetup) vista).getFrmBasheador().getContentPane().add(((VistaSetup) vista).getTfDestiino());
//		((VistaSetup) vista).getFrmBasheador().getContentPane().add(((VistaSetup) vista).getBtnAudio());
//		((VistaSetup) vista).getFrmBasheador().getContentPane().add(((VistaSetup) vista).getBtnImagen());
//		((VistaSetup) vista).getFrmBasheador().getContentPane().add(((VistaSetup) vista).getBtnVideo());
//		((VistaSetup) vista).getFrmBasheador().getContentPane().add(((VistaSetup) vista).getBtnDestino());
	}
}