package constructoresPaneles;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ControladorLayout;
import estructuras.Control;
import estructuras.PanelYControl;
import estructuras.ParametrosInterfaz;

public class Textfield implements ControladorConstructor{

	@Override
	public void contruiYAgregaA(Control control, JPanel panel,List<JTextField> fields,JComboBox<String> comboAPIs) {
		
		JPanel inner = new JPanel();
		JPanel inner2 = new JPanel();
        inner.setLayout(new FlowLayout(FlowLayout.CENTER));
        inner.setMaximumSize(new Dimension(360, 40));
        inner.setPreferredSize(new Dimension(360, 40));
        inner2.setLayout(new FlowLayout(FlowLayout.CENTER));
        inner2.setMaximumSize(new Dimension(200, 40));
        inner2.setPreferredSize(new Dimension(200, 40));
        
        JLabel label = new JLabel(control.getLabel() +":");
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setMaximumSize(new Dimension(200, 30));
        label.setPreferredSize(new Dimension(200, 30));
        inner2.add(label);
        JTextField tf = new JTextField("");
        tf.setMaximumSize(new Dimension(360, 30));
        tf.setPreferredSize(new Dimension(360, 30));
        inner.add(tf);
        fields.add(tf);
       
        panel.add(inner2);
        panel.add(inner);
        
        int defvalue=control.getParametrosDeControl().get(0).getDefvalue();
		tf.setText(Integer.toString(defvalue));
		for (ParametrosInterfaz p : ControladorLayout.ParametrosInterfaz){
			
			if (comboAPIs.getSelectedItem().equals(p.getApp())){
				
				PanelYControl pc = new PanelYControl();
				
				pc.setControl(control.getName());
				pc.setPanel(inner);	
				
				p.getPaneles().add(pc);	
				
			};
			}
		
		 tf.addActionListener(new ActionListener(){
	         

				@Override
				public void actionPerformed(ActionEvent event) {
				
					
										
					for (ParametrosInterfaz p : ControladorLayout.ParametrosInterfaz){
						
					if (comboAPIs.getSelectedItem().equals(p.getApp())){
						
						PanelYControl pc = new PanelYControl();
						
						pc.setControl(control.getName());
						pc.setPanel(inner);	
						
						boolean esta=false;
						
						for(PanelYControl pc2: p.getPaneles()){
						
						if	(pc2.getControl().equals(pc.getControl())){
							System.out.println("ya lo tien"+control.getName());
							esta=true;
						}
						}	
							
						if(!esta)
							p.getPaneles().add(pc);
						
					};
					
					switch(control.getName()){
					 
					case "DURMAX":
					
					
					//Pattern p = Pattern.compile(control.getParametrosDeControl().get(0).ExpRegGrado);
					//Matcher m = p.matcher(tf.getText());
					  
					 if (!(tf.getText().matches(control.getParametrosDeControl().get(0).ExpRegGrado))){
						 
						 tf.setText(Integer.toString(0));
						 
						 
					 } 
					
					 

					
					break;
					}
					
		}
	}
		
	

});
		 
	}
	
}
