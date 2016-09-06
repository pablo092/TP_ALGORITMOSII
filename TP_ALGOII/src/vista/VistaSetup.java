package vista;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaSetup extends VistaAbstracta {

	private static final long serialVersionUID = 6756875525951612576L;

	private JFrame frmBasheador;
	private JComboBox<String> comboAPIs;
	private JComboBox<String> comboConfigs;
	private JButton btnComenzar;
	private GroupLayout groupLayout;
	private JLabel lblAplicacion;
	private JLabel lblConfig;
	private JLabel lblAudio;
	private JLabel lblImagen;
	private JLabel lblVideo;
	private JLabel lblDestino;
	private JPanel panelParametros;
	private JTextField tfAudio;
	private JTextField tfImagen;
	private JTextField tfVideo;
	private JTextField tfDestiino;
	private JButton btnAudio;
	private JButton btnImagen;
	private JButton btnVideo;
	private JButton btnDestino;
	
	//Video extract
	private JLabel lblInicio;
	private JLabel lblFinal;
	private JTextField tfInicio;
	private JTextField tfFinal;

	/**
	 * Create the application.
	 */
	public VistaSetup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBasheador = new JFrame();
		frmBasheador.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frmBasheador.setResizable(false);
		frmBasheador.setBounds(100, 100, 508, 389);
		frmBasheador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		comboAPIs = new JComboBox<String>();
		comboAPIs.setBounds(167, 21, 275, 20);
		comboAPIs.setEditable(true);
		btnComenzar = new JButton("Comenzar");
		btnComenzar.setBounds(353, 323, 108, 23);

		lblAudio = new JLabel("Audio:");
		lblAudio.setBounds(73, 122, 46, 14);

		lblImagen = new JLabel("Imagen:");
		lblImagen.setBounds(73, 162, 46, 14);

		lblVideo = new JLabel("Video:");
		lblVideo.setBounds(73, 207, 46, 14);

		lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDestino.setBounds(43, 267, 67, 17);

		tfAudio = new JTextField();
		tfAudio.setBounds(129, 119, 222, 20);
		tfAudio.setColumns(10);

		tfImagen = new JTextField();
		tfImagen.setColumns(10);
		tfImagen.setBounds(129, 159, 222, 20);

		tfVideo = new JTextField();
		tfVideo.setColumns(10);
		tfVideo.setBounds(129, 204, 222, 20);

		tfDestiino = new JTextField();
		tfDestiino.setColumns(10);
		tfDestiino.setBounds(120, 267, 222, 20);

		btnAudio = new JButton(">>");
		btnAudio.setBounds(375, 118, 67, 23);

		btnImagen = new JButton(">>");
		btnImagen.setBounds(375, 158, 67, 23);

		btnVideo = new JButton(">>");
		btnVideo.setBounds(375, 203, 67, 23);

		btnDestino = new JButton("Seleccionar");
		btnDestino.setBounds(353, 266, 118, 23);

		lblAplicacion = new JLabel("Aplicacion:");
		lblAplicacion.setBounds(46, 21, 64, 17);
		lblAplicacion.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblConfig = new JLabel("Configuracion:");
		lblConfig.setBounds(46, 59, 101, 17);
		lblConfig.setFont(new Font("Tahoma", Font.PLAIN, 14));

		comboConfigs = new JComboBox<String>();
		comboConfigs.setBounds(167, 59, 275, 20);
		comboConfigs.setEditable(true);
		
		//Video Extract//
		lblInicio = new JLabel("Inicio:");
		lblInicio.setBounds(73, 122, 46, 14);

		lblFinal = new JLabel("Final:");
		lblFinal.setBounds(73, 162, 46, 14);
		
		tfInicio = new JTextField();
		tfInicio.setBounds(129, 119, 222, 20);
		tfInicio.setColumns(10);

		tfFinal = new JTextField();
		tfFinal.setColumns(10);
		tfFinal.setBounds(129, 159, 222, 20);

		settearVisibilidadAV(false);
		settearVisibilidadVE(false);
		
		frmBasheador.getContentPane().setLayout(null);
		frmBasheador.getContentPane().add(lblConfig);
		frmBasheador.getContentPane().add(comboConfigs);
		frmBasheador.getContentPane().add(lblAplicacion);
		frmBasheador.getContentPane().add(comboAPIs);
		frmBasheador.getContentPane().add(btnComenzar);

		// SACAR DE ACA!!!

		frmBasheador.getContentPane().add(lblAudio);
		frmBasheador.getContentPane().add(lblImagen);
		frmBasheador.getContentPane().add(lblVideo);
		frmBasheador.getContentPane().add(lblDestino);
		frmBasheador.getContentPane().add(tfAudio);
		frmBasheador.getContentPane().add(tfImagen);
		frmBasheador.getContentPane().add(tfVideo);
		frmBasheador.getContentPane().add(tfDestiino);
		frmBasheador.getContentPane().add(btnAudio);
		frmBasheador.getContentPane().add(btnImagen);
		frmBasheador.getContentPane().add(btnVideo);
		frmBasheador.getContentPane().add(btnDestino);
		
		frmBasheador.getContentPane().add(lblInicio);
		frmBasheador.getContentPane().add(lblFinal);
		frmBasheador.getContentPane().add(tfInicio);
		frmBasheador.getContentPane().add(tfFinal);
	}
	
	public void mostrarParametros(Integer caso){
		switch(caso){
		case 2: settearVisibilidadVE(false); 
			    settearVisibilidadAV(true);
				break;
		case 3: settearVisibilidadAV(false);
				settearVisibilidadVE(true);
				break;
		default: settearVisibilidadAV(false);
				 settearVisibilidadVE(false);
				 break;
			
		}
	}
	
	private void settearVisibilidadAV(Boolean bool){
		lblAudio.setVisible(bool);
		lblImagen.setVisible(bool);
		lblVideo.setVisible(bool);
		tfAudio.setVisible(bool);
		tfImagen.setVisible(bool);
		tfVideo.setVisible(bool);
		btnAudio.setVisible(bool);
		btnImagen.setVisible(bool);
		btnVideo.setVisible(bool);
	}
	private void settearVisibilidadVE(Boolean bool){
		lblInicio.setVisible(bool);
		lblFinal.setVisible(bool);
		tfInicio.setVisible(bool);
		tfFinal.setVisible(bool);
		lblVideo.setVisible(bool);
		tfVideo.setVisible(bool);
		btnVideo.setVisible(bool);
	}

	public JFrame getFrmBasheador() {
		return frmBasheador;
	}

	public void setFrmBasheador(JFrame frmBasheador) {
		this.frmBasheador = frmBasheador;
	}

	public JComboBox<String> getComboAPIs() {
		return comboAPIs;
	}

	public void setComboAPIs(JComboBox<String> comboAPIs) {
		this.comboAPIs = comboAPIs;
	}

	public JButton getBtnComenzar() {
		return btnComenzar;
	}

	public void setBtnComenzar(JButton btnComenzar) {
		this.btnComenzar = btnComenzar;
	}

	public GroupLayout getGroupLayout() {
		return groupLayout;
	}

	public void setGroupLayout(GroupLayout groupLayout) {
		this.groupLayout = groupLayout;
	}

	public JLabel getLblAplicacion() {
		return lblAplicacion;
	}

	public void setLblAplicacion(JLabel lblAplicacion) {
		this.lblAplicacion = lblAplicacion;
	}

	public JLabel getLblConfig() {
		return lblConfig;
	}

	public void setLblConfig(JLabel lblConfig) {
		this.lblConfig = lblConfig;
	}

	public JComboBox<String> getComboConfigs() {
		return comboConfigs;
	}

	public void setComboConfigs(JComboBox<String> comboConfigs) {
		this.comboConfigs = comboConfigs;
	}

	public JPanel getPanelParametros() {
		return panelParametros;
	}

	public void setPanelParametros(JPanel panelParametros) {
		this.panelParametros = panelParametros;
	}

	public JTextField getTfAudio() {
		return tfAudio;
	}

	public void setTfAudio(JTextField tfAudio) {
		this.tfAudio = tfAudio;
	}

	public JTextField getTfImagen() {
		return tfImagen;
	}

	public void setTfImagen(JTextField tfImagen) {
		this.tfImagen = tfImagen;
	}

	public JTextField getTfVideo() {
		return tfVideo;
	}

	public void setTfVideo(JTextField tfVideo) {
		this.tfVideo = tfVideo;
	}

	public JTextField getTfDestiino() {
		return tfDestiino;
	}

	public void setTfDestiino(JTextField tfDestiino) {
		this.tfDestiino = tfDestiino;
	}

	public JButton getBtnAudio() {
		return btnAudio;
	}

	public void setBtnAudio(JButton btnAudio) {
		this.btnAudio = btnAudio;
	}

	public JButton getBtnImagen() {
		return btnImagen;
	}

	public void setBtnImagen(JButton btnImagen) {
		this.btnImagen = btnImagen;
	}

	public JButton getBtnVideo() {
		return btnVideo;
	}

	public void setBtnVideo(JButton btnVideo) {
		this.btnVideo = btnVideo;
	}

	public JButton getBtnDestino() {
		return btnDestino;
	}

	public void setBtnDestino(JButton btnDestino) {
		this.btnDestino = btnDestino;
	}

	public JLabel getLblAudio() {
		return lblAudio;
	}

	public void setLblAudio(JLabel lblAudio) {
		this.lblAudio = lblAudio;
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}

	public JLabel getLblVideo() {
		return lblVideo;
	}

	public void setLblVideo(JLabel lblVideo) {
		this.lblVideo = lblVideo;
	}

	public JLabel getLblDestino() {
		return lblDestino;
	}

	public void setLblDestino(JLabel lblDestino) {
		this.lblDestino = lblDestino;
	}
}