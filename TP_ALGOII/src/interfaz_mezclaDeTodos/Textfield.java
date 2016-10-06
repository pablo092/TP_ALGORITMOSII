package interfaz_mezclaDeTodos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        
        int defvalue=control.getParametrosDeControl().get(0).getDefvalue();
		tf.setText(Integer.toString(defvalue));
		
		 tf.addActionListener(new ActionListener(){
	         

				@Override
				public void actionPerformed(ActionEvent event) {
				
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
	});
		 
	}

}
