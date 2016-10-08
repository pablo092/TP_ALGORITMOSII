package interfaz_mezclaDeTodos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import interfaz_mezclaDeTodos.Layout;


import interfaz_mezclaDeTodos.ControladorLayout;;


public class FileChooser implements ControladorConstructor{

	@Override
	public void contruiYAgregaA(Control control, JPanel panel,List<JTextField> fields,JComboBox<String> comboAPIs) {
		
	
		
		JPanel inner = new JPanel();
		JPanel inner2 = new JPanel();
        inner.setLayout(new FlowLayout(FlowLayout.CENTER));
        inner.setMaximumSize(new Dimension(570, 50));
        inner.setPreferredSize(new Dimension(700, 50));
        JLabel label = new JLabel(control.getLabel() +":");
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setMaximumSize(new Dimension(200, 30));
        label.setPreferredSize(new Dimension(200, 30));
        inner2.add(label);
        JTextField tf = new JTextField("");
        tf.setMaximumSize(new Dimension(300, 30));
        tf.setPreferredSize(new Dimension(300, 30));
        inner.add(tf);
        fields.add(tf);
        JButton boton=new JButton(">>");
       
        boton.setMaximumSize(new Dimension(50, 32));
        boton.setPreferredSize(new Dimension(50, 32));   
        
        inner2.add(boton);
        panel.add(inner);
        panel.add(inner2);

      
        
        
         boton.addActionListener(new ActionListener(){
         

		@Override
		public void actionPerformed(ActionEvent arg0) {

			JFileChooser fc=new JFileChooser();
			
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			
		
			ParametroDeControl Parametro = control.getParametrosDeControl().get(0);
			
			String dir = Parametro.getDefDir();
		
			
			//Seteamos el valor default	
			
			fc.setCurrentDirectory((new java.io.File(dir)));
				
			//Creamos el filtro
			
			
			for(String TipoArch: ((ParametroDeControl) Parametro).getTipoArch()){
					
			
					fc.addChoosableFileFilter(new FileNameExtensionFilter(TipoArch, TipoArch));
			           
					//fc.setFileFilter(filtro);
					
					};
				
				fc.setAcceptAllFileFilterUsed(false);
					
	


			//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
			int seleccion=fc.showOpenDialog(inner);

			//Si el usuario, pincha en aceptar
			if(seleccion==JFileChooser.APPROVE_OPTION){

				//Seleccionamos el fichero
				
				//[VIDEO]
				String fichero=fc.getSelectedFile().getPath();
				
			for (ParametrosInterfaz p : interfaz_mezclaDeTodos.ControladorLayout.ParametrosInterfaz){
				
			if (comboAPIs.getSelectedItem().equals(p.getApp())){
				
				
				PanelYControl pc = new PanelYControl();
				
				pc.setControl(control.getName());
				pc.setPanel(inner);
							
				p.getPaneles().add(pc);
			};
			}
			
			
			tf.setText(fichero);
				
		
			fc.resetChoosableFileFilters();
			}
			}
				
		
		
         });
         
	}

}
			
		
			
