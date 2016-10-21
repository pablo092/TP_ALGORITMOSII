package vistas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.*;

import constructoresPaneles.ControladorConstructor;
import control.ControladorLayout;
import control.InvocarComando;
import estructuras.Aplicacion;
import estructuras.Configuracion;
import estructuras.Control;
import estructuras.PanelYControl;
import estructuras.Parametro;
import estructuras.ParametrosInterfaz;


public class Layout extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame f = new JFrame();
	public  JComboBox<String> comboAPIs;
	public JComboBox<String> comboConfigs;
	
    private List<JTextField> fields = new ArrayList<JTextField>();
    private List<Control> controles=new ArrayList<Control>();
   
    public Layout() {
    	this.setComboAPIs(new JComboBox<String>());
    	comboAPIs.setMaximumSize(new Dimension(200, 30));
    	comboAPIs.setPreferredSize(new Dimension(200, 30));
    	this.setComboConfigs(new JComboBox<String>());
    	comboConfigs.setMaximumSize(new Dimension(200, 30));
    	comboConfigs.setPreferredSize(new Dimension(200, 30));
    	
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setMaximumSize(new Dimension(450, 200));
		this.setPreferredSize(new Dimension(450, 200));
        this.agregarPaneles();
    }
    
    public void agregarPaneles(){
    	this.add(createIntroduc());
    	JPanel outer=new JPanel();
		outer.setLayout(new FlowLayout(FlowLayout.CENTER));
		outer.setMaximumSize(new Dimension(700, 300));
		outer.setPreferredSize(new Dimension(700, 300));
		ControladorConstructor controlador;
        if(!(controles.isEmpty())){
        	for(Control control:controles){
        		try {
        			controlador=(ControladorConstructor) Class.forName("constructoresPaneles."+control.getClase()).newInstance();

					controlador.contruiYAgregaA(control, outer, fields,comboAPIs);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
        this.add(outer);
        this.add(createFinal());
    }
    
    private JPanel createIntroduc() {
        JPanel outer = new JPanel();
        outer.setMaximumSize(new Dimension(700, 100));
		outer.setPreferredSize(new Dimension(700, 100));
        outer.setLayout(new BoxLayout(outer, BoxLayout.Y_AXIS));
        outer.setAlignmentX(CENTER_ALIGNMENT);
        
        JPanel inner = new JPanel();
        inner.setPreferredSize(new Dimension(500, 30));
        JLabel lblAplicacion = new JLabel("Aplicacion:", JLabel.LEFT);
        lblAplicacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAplicacion.setPreferredSize(new Dimension(200, 30));
        inner.add(lblAplicacion);
        inner.add(comboAPIs);
            
        JPanel inner2 = new JPanel();
        inner.setPreferredSize(new Dimension(500, 30));
        JLabel lblConfig = new JLabel("Configuracion:", JLabel.LEFT);
        lblConfig.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblConfig.setPreferredSize(new Dimension(200, 30));
        inner2.add(lblConfig);
        inner2.add(comboConfigs);
        
        outer.add(inner);
        outer.add(inner2);
        return outer;
    }
    
    private JPanel createFinal() {
        JPanel outer = new JPanel();
        outer.setMaximumSize(new Dimension(700, 80));
		outer.setPreferredSize(new Dimension(700, 80));
        outer.setAlignmentX(CENTER_ALIGNMENT);
        outer.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btnComenzar= new JButton("Comenzar");
        
        btnComenzar.setPreferredSize(new Dimension(100, 32));
        
        btnComenzar.setAlignmentX(RIGHT_ALIGNMENT);
         
        outer.add(btnComenzar);
        
        btnComenzar.addActionListener(new ActionListener(){
        List<Parametro>	inputs;

		@Override
		public void actionPerformed(ActionEvent arg0) {
		inputs= new ArrayList<Parametro>();
		
		String app=	(String) comboAPIs.getSelectedItem();
		String conf =(String) comboConfigs.getSelectedItem();
		String comando = null;
		
		List<PanelYControl> paneles = new ArrayList<PanelYControl>();
		
		inputs.removeAll(getFields());
		
		
		for (ParametrosInterfaz p : control.ControladorLayout.ParametrosInterfaz){
			
			if (app.equals(p.getApp())){
		  	paneles=	p.getPaneles();
				
			};
			
		}
		
		Iterator<PanelYControl> pcc =paneles.iterator();
		
		 while (pcc.hasNext()){

		 	PanelYControl pc= pcc.next();
			Component[] components = pc.getPanel().getComponents();
		    		
				for(Component cop : components){

		    	System.out.println(cop.getClass().getName());

		        if((cop.getClass().getName()).equals("javax.swing.JTextField")){
		        	
		        	String inText    = ((JTextField) cop).getText();
		        		System.out.println("del tf : "+ inText);

		        		Parametro parametro = new Parametro();     		       		
		        		parametro.setParametro(inText);
			        	parametro.setNombreParametro(pc.getControl());
			        	
		        		inputs.add(parametro);
		        	}
		        if((cop.getClass().getName()).equals("javax.swing.JComboBox")){
		        		
						String inText    = (String)((JComboBox<String>) cop).getSelectedItem();
						System.out.println("del cb : "+ inText);
						Parametro parametro = new Parametro();     		       		
		        		parametro.setParametro(inText);
			        	parametro.setNombreParametro(pc.getControl());
			        	
		        		inputs.add(parametro);
		        	}
		        if((cop.getClass().getName()).equals("javax.swing.JFileChooser")){
		        	
					String inText    = ((JFileChooser) cop).getSelectedFile().getPath();
	        		System.out.println("del fc : "+ inText);
	        		Parametro parametro = new Parametro();     		       		
	        		parametro.setParametro(inText);
		        	parametro.setNombreParametro(pc.getControl());
		        	
	        		inputs.add(parametro);
	        	}
		        
		        if((cop.getClass().getName()).equals("javax.swing.JSpinner")){
	        	
					String inText    = (((JSpinner) cop).getValue()).toString();
					System.out.println("del spinner : "+ inText);
					Parametro parametro = new Parametro();     
					if(pc.getControl()!="GRADO"){
					String [] s = inText.split(" ");
					for (String s2: s){
						
						if(s2.contains(":")){
							
							inText= s2;
						}
						
					}
					}
					
					parametro.setParametro(inText);
		        	parametro.setNombreParametro(pc.getControl());
	        		inputs.add(parametro);
	        	}
		     
		    }
		    			
		    		
		 }
		 String parametro=null;
		    for (Aplicacion a : ControladorLayout.aplicaciones){
		    	if(a.getName().equals(app)){
		    		for (Configuracion c : a.getConfiguraciones()){
		    			if(c.getNombre().equals(conf)){
		    				comando=	(String)c.getCommand();
		    		    	parametro = c.getParametrosComando();
		    			}
		    		}
		    		
		    	}
		    
		     
		}
		System.out.println("++++++++++ EL COMANDO ES " + parametro);
			//CAMBIO ESTE METODO POR EL DE ABAJO, PARA PODER usar otro comando que no sea el ffmpeg
			//InvocarComando.ffmpeg(parametro, inputs);
			InvocarComando.invocarComando(comando,parametro,inputs);
    
		}

		});

        return outer;
    }

    public void display() {
    	f=new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane jsp = new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.validate();
        Dimension d = this.getPreferredSize();
        d.height /= 0.5;
        d.width /= 0.75;
        jsp.getViewport().setPreferredSize(d);
        if(fields.size()!=0){
        	jsp.getVerticalScrollBar().setUnitIncrement(this.getPreferredSize().height / fields.size());
        }
        f.add(jsp);
        f.pack();
        f.setVisible(true);
    }

	public void mostrarControles(List<Control> controls){
		controles.clear();
		controles.addAll(controls);
		this.removeAll();
		this.agregarPaneles();
		this.revalidate();
		this.repaint(getVisibleRect());
	}
	
	public void loadConfigs(List<Configuracion> conf) {
		getComboConfigs().removeAllItems();
		for (Configuracion c : conf) {
			getComboConfigs().addItem(c.getNombre());
		}
	}
	

	public JComboBox<String> getComboAPIs() {
		return comboAPIs;
	}

	public void setComboAPIs(JComboBox<String> comboAPIs) {
		this.comboAPIs = comboAPIs;
	}

	public JComboBox<String> getComboConfigs() {
		return comboConfigs;
	}

	public void setComboConfigs(JComboBox<String> comboConfigs) {
		this.comboConfigs = comboConfigs;
	}

	public List<JTextField> getFields() {
		return fields;
	}

	public void setFields(List<JTextField> fields) {
		this.fields = fields;
	}

	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}

	
}