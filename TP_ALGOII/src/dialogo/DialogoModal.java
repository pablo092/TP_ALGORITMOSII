package dialogo;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DialogoModal extends DialogoAbstracto {

	private static final long serialVersionUID = -8318215426703118791L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JButton btnCancelar;
	

	public DialogoModal() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 414, 206);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnCancelar = new JButton("Cancel");
		btnCancelar.setActionCommand("Cancel");
		btnCancelar.setBounds(310, 228, 97, 23);
		contentPanel.add(btnCancelar);
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}