package dialogo;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class DialogoAbstracto extends JDialog {

	private static final long serialVersionUID = 2108159107120961206L;

	public void mostrate() {
		this.setVisible(true);

	}

	public void ocultate() {
		this.setVisible(false);
	}

	public void anulaBoton(JButton boton) {
		boton.setEnabled(false);

	}

	public void activaBoton(JButton boton) {
		boton.setEnabled(true);

	}

	public void mostraError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void mostraAlerta(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Alerta", JOptionPane.WARNING_MESSAGE);
	}

	public void mostraConfirmacion(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Confirmar", JOptionPane.YES_NO_OPTION);
	}
}