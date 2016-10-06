package interfaz_mezclaDeTodos;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;


import com.sun.prism.image.Coords;

import javafx.geometry.Bounds;
import javafx.scene.layout.Region;

public class SPINNERS implements ControladorConstructor{

	@Override
	public void contruiYAgregaA(Control control, JPanel panel,List<JTextField> fields) {
	
		if((control.getName()=="DESDE" )|(control.getName()=="HASTA" )){
			
			
			//minutos
			SpinnerModel spinnerModelMIN =
			         new SpinnerNumberModel(0, //initial value
			            0, //min
			            60, //max
			            1);//step
			      JSpinner spinnerMIN = new JSpinner(spinnerModelMIN);
			      
			      
		      
					      int w = spinnerMIN.getWidth();   int h = spinnerMIN.getHeight();
					      Dimension d = new Dimension(w +40, h+40);
					      spinnerMIN.setPreferredSize(d);
					      spinnerMIN.setMinimumSize(d);
					      
					     
					      
					      JPanel panel2 = new JPanel();
					        panel2.setPreferredSize(new Dimension(200, 100));
					       	
					        panel2.setMaximumSize(new Dimension(200, 50));
					        panel2.setPreferredSize(new Dimension(200, 50));
					        JLabel lbl = new JLabel(control.getLabel()+":", JLabel.LEFT);
					        lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
					        lbl.setMaximumSize(new Dimension(200, 30));
					        lbl.setPreferredSize(new Dimension(200, 30));
					        panel2.add(lbl);
					        //panel2.setBounds(0, 200, 200, 50);
					         panel2.add(spinnerMIN);
					        panel.add(panel2);

					
					        //segundos
					        SpinnerModel spinnerModelSEG =
							         new SpinnerNumberModel(0, //initial value
							            0, //min
							            60, //max
							            1);//step
							      JSpinner spinnerSEG = new JSpinner(spinnerModelSEG);
						
						
						
					      int w1 = spinnerSEG.getWidth();  
					      int h1 = spinnerSEG.getHeight();
					      Dimension d1 = new Dimension(w1 +40, h1+40);
					      spinnerSEG.setPreferredSize(d1);
					      spinnerSEG.setMinimumSize(d1);
						  JPanel panel3 = new JPanel();
						  
						spinnerSEG.setLocation(100,30);
						     
						     
						     
						       panel3.setPreferredSize(new Dimension(200, 100));
						        panel3.setMaximumSize(new Dimension(200,100));
						     
						        panel3.setLocation(200, 100);
						        panel3.add(spinnerSEG);
						        panel.add(panel3);
		}
		
		else{
		SpinnerModel spinnerModel =
		         new SpinnerNumberModel(0,  0, //min
		            60, //max
		            1);//step
		      JSpinner spinner = new JSpinner(spinnerModel);
		      
		      int w = spinner.getWidth();   int h = spinner.getHeight();
		      Dimension d = new Dimension(w +40, h+40);
		      spinner.setPreferredSize(d);
		      spinner.setMinimumSize(d);
		      JPanel inner = new JPanel();
				inner.setMaximumSize(new Dimension(700, 50));
		        inner.setPreferredSize(new Dimension(700, 50));
		        inner.setBounds(50, 200, 200, 50);
		        JLabel lbl = new JLabel(control.getLabel()+":", JLabel.LEFT);
		        lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		        lbl.setMaximumSize(new Dimension(200, 30));
		        lbl.setPreferredSize(new Dimension(200, 30));
		        inner.add(lbl);
		        inner.add(spinner);
		        panel.add(inner);
		} 
    	
        
		
		
	}
	


}