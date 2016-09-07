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
	private JLabel lblCampo1;
	private JLabel lblCampo2;
	private JLabel lblCampo3;
	private JLabel lblDestino;
	private JPanel panelParametros;
	private JTextField tfCampo1;
	private JTextField tfCampo2;
	private JTextField tfCampo3;
	private JTextField tfDestino;
	private JButton btnCampo1;
	private JButton btnCampo2;
	private JButton btnCampo3;
	private JButton btnDestino;
	

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

		lblCampo1 = new JLabel("");
		lblCampo1.setBounds(73, 122, 46, 14);

		lblCampo2 = new JLabel("");
		lblCampo2.setBounds(73, 162, 46, 14);

		lblCampo3 = new JLabel("");
		lblCampo3.setBounds(73, 207, 46, 14);

		lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDestino.setBounds(43, 267, 67, 17);

		tfCampo1 = new JTextField();
		tfCampo1.setBounds(129, 119, 222, 20);
		tfCampo1.setColumns(10);

		tfCampo2 = new JTextField();
		tfCampo2.setColumns(10);
		tfCampo2.setBounds(129, 159, 222, 20);

		tfCampo3 = new JTextField();
		tfCampo3.setColumns(10);
		tfCampo3.setBounds(129, 204, 222, 20);

		tfDestino = new JTextField();
		tfDestino.setColumns(10);
		tfDestino.setBounds(120, 267, 222, 20);

		btnCampo1 = new JButton(">>");
		btnCampo1.setBounds(375, 118, 67, 23);

		btnCampo2 = new JButton(">>");
		btnCampo2.setBounds(375, 158, 67, 23);

		btnCampo3 = new JButton(">>");
		btnCampo3.setBounds(375, 203, 67, 23);

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

		settearVisibilidadAV(false);
		settearVisibilidadVE(false);
		
		frmBasheador.getContentPane().setLayout(null);
		frmBasheador.getContentPane().add(lblConfig);
		frmBasheador.getContentPane().add(comboConfigs);
		frmBasheador.getContentPane().add(lblAplicacion);
		frmBasheador.getContentPane().add(comboAPIs);
		frmBasheador.getContentPane().add(btnComenzar);

		// SACAR DE ACA!!!

		frmBasheador.getContentPane().add(lblCampo1);
		frmBasheador.getContentPane().add(lblCampo2);
		frmBasheador.getContentPane().add(lblCampo3);
		frmBasheador.getContentPane().add(lblDestino);
		frmBasheador.getContentPane().add(tfCampo1);
		frmBasheador.getContentPane().add(tfCampo2);
		frmBasheador.getContentPane().add(tfCampo3);
		frmBasheador.getContentPane().add(tfDestino);
		frmBasheador.getContentPane().add(btnCampo1);
		frmBasheador.getContentPane().add(btnCampo2);
		frmBasheador.getContentPane().add(btnCampo3);
		frmBasheador.getContentPane().add(btnDestino);
	}
	
	public void mostrarParametros(Integer caso){
		settearVisibilidadVE(false); 
		settearVisibilidadAV(false);
		settearVisibilidadJW(false);
		switch(caso){
		case 2: settearVisibilidadAV(true);
				break;
		case 3: settearVisibilidadVE(true);
				break;
		case 4: settearVisibilidadJW(true);
				break;
		default: break;		 
			
		}
	}
	
	private void settearVisibilidadAV(Boolean bool){
		lblCampo1.setText("Audio:");
		lblCampo1.setVisible(bool);
		lblCampo2.setText("Imagen:");
		lblCampo2.setVisible(bool);
		lblCampo3.setText("Video:");
		lblCampo3.setVisible(bool);
		tfCampo1.setVisible(bool);
		tfCampo2.setVisible(bool);
		tfCampo3.setVisible(bool);
		btnCampo1.setVisible(bool);
		btnCampo2.setVisible(bool);
		btnCampo3.setVisible(bool);
	}
	private void settearVisibilidadVE(Boolean bool){
		lblCampo1.setText("Desde:");
		lblCampo1.setVisible(bool);
		lblCampo2.setText("Hasta:");
		lblCampo2.setVisible(bool);
		tfCampo1.setVisible(bool);
		tfCampo2.setVisible(bool);
		lblCampo3.setVisible(bool);
		tfCampo3.setVisible(bool);
		btnCampo3.setVisible(bool);
	}
	
	private void settearVisibilidadJW(Boolean bool){
		lblCampo1.setText("Video 1:");
		lblCampo1.setVisible(bool);
		lblCampo2.setText("Video 2:");
		lblCampo2.setVisible(bool);
		tfCampo1.setVisible(bool);
		tfCampo2.setVisible(bool);
		btnCampo1.setVisible(bool);
		btnCampo2.setVisible(bool);
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

	public JTextField gettfCampo1() {
		return tfCampo1;
	}

	public void settfCampo1(JTextField tfCampo1) {
		this.tfCampo1 = tfCampo1;
	}

	public JTextField gettfCampo2() {
		return tfCampo2;
	}

	public void settfCampo2(JTextField tfCampo2) {
		this.tfCampo2 = tfCampo2;
	}

	public JTextField gettfCampo3() {
		return tfCampo3;
	}

	public void settfCampo3(JTextField tfCampo3) {
		this.tfCampo3 = tfCampo3;
	}

	public JTextField getTfDestiino() {
		return tfDestino;
	}

	public void setTfDestiino(JTextField tfDestino) {
		this.tfDestino = tfDestino;
	}

	public JButton getbtnCampo1() {
		return btnCampo1;
	}

	public void setbtnCampo1(JButton btnCampo1) {
		this.btnCampo1 = btnCampo1;
	}

	public JButton getbtnCampo2() {
		return btnCampo2;
	}

	public void setbtnCampo2(JButton btnCampo2) {
		this.btnCampo2 = btnCampo2;
	}

	public JButton getbtnCampo3() {
		return btnCampo3;
	}

	public void setbtnCampo3(JButton btnCampo3) {
		this.btnCampo3 = btnCampo3;
	}

	public JButton getBtnDestino() {
		return btnDestino;
	}

	public void setBtnDestino(JButton btnDestino) {
		this.btnDestino = btnDestino;
	}

	public JLabel getlblCampo1() {
		return lblCampo1;
	}

	public void setlblCampo1(JLabel lblCampo1) {
		this.lblCampo1 = lblCampo1;
	}

	public JLabel getlblCampo2() {
		return lblCampo2;
	}

	public void setlblCampo2(JLabel lblCampo2) {
		this.lblCampo2 = lblCampo2;
	}

	public JLabel getlblCampo3() {
		return lblCampo3;
	}

	public void setlblCampo3(JLabel lblCampo3) {
		this.lblCampo3 = lblCampo3;
	}

	public JLabel getLblDestino() {
		return lblDestino;
	}

	public void setLblDestino(JLabel lblDestino) {
		this.lblDestino = lblDestino;
	}
}