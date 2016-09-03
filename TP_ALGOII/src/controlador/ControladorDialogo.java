package controlador;

import java.awt.event.ActionEvent;

import dialogo.DialogoModal;

public class ControladorDialogo extends ControladorAbstracto {
	
	public ControladorDialogo() {
		this.dialogo = new DialogoModal();
		((DialogoModal) dialogo).getBtnCancelar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == ((DialogoModal) this.dialogo).getBtnCancelar()) {
			this.dialogo.mostraConfirmacion("¿Desea cancelar el proceso?");
		}
	}
}