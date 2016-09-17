package agustin;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nicole.Control;

public class Textfield implements ControladorConstructor{

	@Override
	public void contruiYAgregaA(Control control, JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel inner = new JPanel();
        inner.setAlignmentX(0);
        inner.setLayout(new BoxLayout(inner, BoxLayout.X_AXIS));
        JLabel label = new JLabel(control.getLabel() +":", JLabel.RIGHT);
        label.setPreferredSize(new Dimension(80, 32));
        inner.add(label);
        JTextField tf = new JTextField("", 32);
        tf.setMaximumSize(new Dimension(300, 30));
        inner.add(tf);
        panel.add(inner);
		
	}

}
