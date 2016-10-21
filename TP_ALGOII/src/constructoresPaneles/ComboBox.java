package constructoresPaneles;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ControladorLayout;
import estructuras.Control;
import estructuras.PanelYControl;
import estructuras.ParametroDeControl;
import estructuras.ParametrosInterfaz;
import vistas.Layout;


public abstract class ComboBox implements ControladorConstructor{

	@Override
	public void contruiYAgregaA(Control control, JPanel panel,List<JTextField> fields,JComboBox<String> comboAPIs) {

		JComboBox<Integer> combo=new JComboBox<Integer>();
    	combo.setMaximumSize(new Dimension(350, 30));
    	combo.setPreferredSize(new Dimension(350, 30));
    	ParametroDeControl p= control.getParametrosDeControl().get(0);

		combo.setSelectedItem(Integer.toString(p.getDefvalue()));

    	JPanel inner = new JPanel();

    	JPanel inner2 = new JPanel();
		inner.setMaximumSize(new Dimension(700, 50));
        inner.setPreferredSize(new Dimension(700, 50));
        JLabel lbl = new JLabel(control.getLabel()+":", JLabel.LEFT);
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl.setMaximumSize(new Dimension(200, 30));
        lbl.setPreferredSize(new Dimension(200, 30));
        inner2.add(lbl);
        inner.add(combo);
        panel.add(inner);
        panel.add(inner2);
        combo.setEditable(true);
        
        for (ParametrosInterfaz p1 : ControladorLayout.ParametrosInterfaz){
			
			if (comboAPIs.getSelectedItem().equals(p1.getApp())){
				
				PanelYControl pc = new PanelYControl();
				
				pc.setControl(control.getName());
				pc.setPanel(inner);	
				
				boolean esta=false;
				
				for(PanelYControl pc2: p1.getPaneles()){
				
				if	(pc2.getControl().equals(pc.getControl())){
					System.out.println("ya lo tien"+control.getName());
					esta=true;
				}
				}	
					
				if(!esta)
					p1.getPaneles().add(pc);
				
			};
		}
	} //Fin else
}

