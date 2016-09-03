package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dialogo.DialogoAbstracto;
import excepction.ExcepcionControlada;
import excepction.ExcepcionControladaAlerta;
import excepction.ExcepcionControladaError;
import vista.VistaAbstracta;

public abstract class ControladorAbstracto implements ActionListener {

	protected VistaAbstracta vista;
	protected DialogoAbstracto dialogo;

	public abstract void actionPerformed(ActionEvent event);

	public void mostrar() {
		vista.mostrate();
	}

	public void ocultar() {
		vista.ocultate();
	}

	public void destruir() {
		vista.destruite();
	}

	public void activarBoton(JButton boton) {
		vista.activaBoton(boton);
	}

	public void anularBoton(JButton boton) {
		vista.anulaBoton(boton);
	}
	
	public void mostrarMensaje(ExcepcionControlada e){
		String mensaje = e.getMsj();
		if (e instanceof ExcepcionControladaError){
			vista.mostraError(mensaje);
		}else if (e instanceof ExcepcionControladaAlerta){
			vista.mostraAlerta(mensaje);
		}
	}
}