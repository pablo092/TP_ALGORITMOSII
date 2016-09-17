package agustin;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nicole.Control;
import nicole.ParametroDeControl;

public class ComboBox implements ControladorConstructor{

	@Override
	public void contruiYAgregaA(Control control, JPanel panel) {
		panel.setAlignmentX(0);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JLabel lbl = new JLabel(control.getLabel()+":", JLabel.RIGHT);
        lbl.setPreferredSize(new Dimension(200, 30));
        panel.add(lbl);
        JComboBox<String> combo=new JComboBox<String>();
        for(ParametroDeControl p:control.getParametrosDeControl()){
        	combo.addItem(p.getParam());
        }
    	combo.setMaximumSize(new Dimension(200, 30));
        panel.add(combo);
		
	}

}
