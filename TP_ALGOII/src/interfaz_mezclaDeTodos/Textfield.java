package interfaz_mezclaDeTodos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Textfield implements ControladorConstructor{

	@Override
	public void contruiYAgregaA(Control control, JPanel panel,List<JTextField> fields) {
		JPanel inner = new JPanel();
        inner.setLayout(new FlowLayout(FlowLayout.CENTER));
        inner.setMaximumSize(new Dimension(570, 50));
        inner.setPreferredSize(new Dimension(700, 50));
        JLabel label = new JLabel(control.getLabel() +":");
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setMaximumSize(new Dimension(200, 30));
        label.setPreferredSize(new Dimension(200, 30));
        inner.add(label);
        JTextField tf = new JTextField("");
        tf.setMaximumSize(new Dimension(350, 30));
        tf.setPreferredSize(new Dimension(350, 30));
        inner.add(tf);
        fields.add(tf);
        panel.add(inner);
		
	}

}
