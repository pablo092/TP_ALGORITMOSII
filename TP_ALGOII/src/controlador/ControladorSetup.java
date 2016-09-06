package controlador;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import dialogo.DialogoModal;
import vista.VistaSetup;

public class ControladorSetup extends ControladorAbstracto {
	
	FileNameExtensionFilter filtro;
	
	public ControladorSetup() {
		this.vista = new VistaSetup();
		this.dialogo = new DialogoModal();
		((VistaSetup) vista).getComboAPIs().addActionListener(this);
		((VistaSetup) vista).getComboConfigs().addActionListener(this);
		((VistaSetup) vista).getBtnAudio().addActionListener(this);
		((VistaSetup) vista).getBtnImagen().addActionListener(this);
		((VistaSetup) vista).getBtnVideo().addActionListener(this);
		((VistaSetup) vista).getBtnDestino().addActionListener(this);
		((VistaSetup) vista).getBtnComenzar().addActionListener(this);
	}
	
	public void iniciar() {
		((VistaSetup) vista).getFrmBasheador().setVisible(true);
		loadAPIs();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == ((VistaSetup) vista).getComboAPIs()) {
			((VistaSetup) vista).getFrmBasheador().setTitle((String) ((VistaSetup) vista).getComboAPIs().getSelectedItem());
			loadConfigs();
		}
		if(((VistaSetup) vista).getComboAPIs().getSelectedItem().equals("Audio to Video")){
			((VistaSetup) vista).mostrarParametros(2);
		}
		if(((VistaSetup) vista).getComboAPIs().getSelectedItem().equals("Video Extract")){
			((VistaSetup) vista).mostrarParametros(3);
		}
		if(((VistaSetup) vista).getComboAPIs().getSelectedItem().equals("API1")){
			((VistaSetup) vista).mostrarParametros(1);
		}
		if(event.getSource() == ((VistaSetup) vista).getComboConfigs()) {
			loadParametersPanel();
		}
		if(event.getSource() == ((VistaSetup) vista).getBtnComenzar()) {
			this.dialogo.mostrate();
		}
		if(event.getSource() == ((VistaSetup) vista).getBtnAudio()) {
			filtro = new FileNameExtensionFilter("*.MP3", "mp3");
			selectPath(((VistaSetup) this.vista).getTfAudio(), filtro, false);
		}
		if(event.getSource() == ((VistaSetup) vista).getBtnImagen()) {
			filtro = new FileNameExtensionFilter("*.JPEG", "jpeg");
			selectPath(((VistaSetup) this.vista).getTfImagen(), filtro, false);
		}
		if(event.getSource() == ((VistaSetup) vista).getBtnVideo()) {
			filtro = new FileNameExtensionFilter("*.WMV", "wmv");
			selectPath(((VistaSetup) this.vista).getTfVideo(), filtro, false);
		}
		if(event.getSource() == ((VistaSetup) vista).getBtnDestino()) {
			selectPath(((VistaSetup) this.vista).getTfDestiino(), null, true);
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
	
	private void loadAPIs() {
		((VistaSetup) vista).getComboAPIs().addItem("API1");
		((VistaSetup) vista).getComboAPIs().addItem("Audio to Video");
		((VistaSetup) vista).getComboAPIs().addItem("Video Extract");
	}
	
	private void loadConfigs() {
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