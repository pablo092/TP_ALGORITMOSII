package interfaz_mezclaDeTodos;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;


public class SPINNERS implements ControladorConstructor {

	@Override
	public void contruiYAgregaA(Control control, JPanel panel, List<JTextField> fields,JComboBox<String> comboAPIs) {

		if ((control.getName().equals("DESDE")) | (control.getName().equals("HASTA"))) {

			
			SpinnerDateModel model = new SpinnerDateModel();
			JSpinner spinner = new JSpinner(model);

			spinner.setEditor(new JSpinner.DateEditor(spinner, "mm:ss "));
			spinner.setValue(new Date(0));

			spinner.setPreferredSize(new Dimension(350, 30));
			spinner.setMinimumSize(new Dimension(350, 30));
			
			JPanel inner = new JPanel();
			JPanel inner2 = new JPanel();
			inner.setMaximumSize(new Dimension(700, 50));
			inner.setPreferredSize(new Dimension(700, 50));
			inner.setBounds(50, 200, 200, 50);
			JLabel lbl = new JLabel(control.getLabel() + ":", JLabel.LEFT);
			lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbl.setMaximumSize(new Dimension(200, 30));
			lbl.setPreferredSize(new Dimension(200, 30));
			inner2.add(lbl);
			inner.add(spinner);
			panel.add(inner);
			panel.add(inner2);
			for (ParametrosInterfaz p : interfaz_mezclaDeTodos.ControladorLayout.ParametrosInterfaz){
				
			if (comboAPIs.getSelectedItem().equals(p.getApp())){
				

				PanelYControl pc = new PanelYControl();
				
				pc.setControl(control.getName());
				pc.setPanel(inner);	
				
				p.getPaneles().add(pc);
				
			};
			}
		}

		else {
			SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, // min
					360, // max
					1);// step
			JSpinner spinner = new JSpinner(spinnerModel);
			
			int w = spinner.getWidth();
			int h = spinner.getHeight();
			Dimension d = new Dimension(w + 90, h + 30);
			spinner.setPreferredSize(new Dimension(350, 30));
			spinner.setMinimumSize(new Dimension(350, 30));
			JPanel inner = new JPanel();
			JPanel inner2 = new JPanel();
			inner.setMaximumSize(new Dimension(700, 50));
			inner.setPreferredSize(new Dimension(700, 50));
			inner.setBounds(50, 200, 200, 50);
			JLabel lbl = new JLabel(control.getLabel() + ":", JLabel.LEFT);
			lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbl.setMaximumSize(new Dimension(200, 30));
			lbl.setPreferredSize(new Dimension(200, 30));
			inner2.add(lbl);
			inner.add(spinner);
			panel.add(inner);
			panel.add(inner2);
			for (ParametrosInterfaz p : interfaz_mezclaDeTodos.ControladorLayout.ParametrosInterfaz){
				
				if (comboAPIs.getSelectedItem().equals(p.getApp())){
					PanelYControl pc = new PanelYControl();
					
					pc.setControl(control.getName());
					pc.setPanel(inner);	
					
					p.getPaneles().add(pc);
					
				};
				}
		}

	}

}