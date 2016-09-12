package nicole;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class Layout extends JPanel {

	private JFrame f = new JFrame();
	private JLabel lblAplicacion;
	private JLabel lblConfig;
	private JComboBox<String> comboAPIs;
	private JComboBox<String> comboConfigs;
	private JButton btnComenzar;
	private JLabel lblDestino;
	private JButton btnDestino;
	
    private List<JTextField> fields = new ArrayList<JTextField>();
    private List<String[]> parametros=new ArrayList<String[]>();

    public Layout() {
    	this.setComboAPIs(new JComboBox<String>());
    	comboAPIs.setMaximumSize(new Dimension(200, 30));
    	this.setComboConfigs(new JComboBox<String>());
    	comboConfigs.setMaximumSize(new Dimension(200, 30));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.agregarPaneles();
    }
    
    public void agregarPaneles(){
    	this.add(createIntroduc());
        if(!(parametros.isEmpty())){
        	for(String[] parametro:parametros){
        		if(parametro[0].equals("FileChooser")){
        			this.add(createTextoBoton(parametro[1]));
        		}
        		else{
        			this.add(createTexto(parametro[1]));
        		}
        	}
        }
        this.add(createFinal());
    }
    
    private JPanel createIntroduc() {
        JPanel outer = new JPanel();
        outer.setLayout(new BoxLayout(outer, BoxLayout.PAGE_AXIS));
        
        JPanel inner = new JPanel(new GridBagLayout());
        inner.setAlignmentX(LEFT_ALIGNMENT);
        inner.setLayout(new BoxLayout(inner, BoxLayout.X_AXIS));
        lblAplicacion = new JLabel("            Aplicacion:               ", JLabel.RIGHT);
        lblAplicacion.setPreferredSize(new Dimension(200, 30));
        inner.add(lblAplicacion);
        inner.add(comboAPIs);
            
        JPanel inner2 = new JPanel();
        inner2.setAlignmentX(LEFT_ALIGNMENT);
        inner2.setLayout(new BoxLayout(inner2, BoxLayout.X_AXIS));
        lblConfig = new JLabel("            Configuracion:        ", JLabel.RIGHT);
        lblConfig.setPreferredSize(new Dimension(200, 30));
        inner2.add(lblConfig);
        inner2.add(comboConfigs);
        outer.add(inner);
        outer.add(inner2);
        return outer;
    }

	private JPanel createTexto(String s) {
        JPanel outer = new JPanel();
        outer.setLayout(new BoxLayout(outer, BoxLayout.Y_AXIS));
        JPanel inner = new JPanel();
        inner.setAlignmentX(LEFT_ALIGNMENT);
        inner.setLayout(new BoxLayout(inner, BoxLayout.X_AXIS));
        JLabel label = new JLabel(s +":", JLabel.RIGHT);
        label.setPreferredSize(new Dimension(80, 32));
        inner.add(label);
        JTextField tf = new JTextField("", 32);
        tf.setMaximumSize(new Dimension(300, 30));
        inner.add(tf);
        fields.add(tf);
        outer.add(inner);
        return outer;
    }
    
    private JPanel createTextoBoton(String s) {
        JPanel outer = new JPanel();
        outer.setLayout(new BoxLayout(outer, BoxLayout.Y_AXIS));
        JPanel inner = new JPanel();
        inner.setAlignmentX(LEFT_ALIGNMENT);
        inner.setLayout(new BoxLayout(inner, BoxLayout.X_AXIS));
        JLabel label = new JLabel(s +":", JLabel.RIGHT);
        label.setPreferredSize(new Dimension(80, 32));
        inner.add(label);
        JTextField tf = new JTextField("", 32);
        tf.setMaximumSize(new Dimension(300, 30));
        inner.add(tf);
        fields.add(tf);
        JButton boton= new JButton(">>");
        boton.setPreferredSize(new Dimension(50, 32));
        inner.add(boton);
    
        outer.add(inner);
        return outer;
    }
    
    private JPanel createFinal() {
        JPanel outer = new JPanel();
        outer.setAlignmentX(LEFT_ALIGNMENT);
        outer.setLayout(new BoxLayout(outer, BoxLayout.Y_AXIS));
        JPanel inner = new JPanel();
        inner.setLayout(new BoxLayout(inner, BoxLayout.X_AXIS));
        lblDestino = new JLabel("Destino:", JLabel.RIGHT);
        lblDestino.setPreferredSize(new Dimension(80, 32));
        inner.add(lblDestino);
        JTextField tf = new JTextField("", 32);
        tf.setMaximumSize(new Dimension(300, 30));
        inner.add(tf);
        fields.add(tf);
        btnDestino= new JButton(">>");
        btnDestino.setPreferredSize(new Dimension(50, 32));
        inner.add(btnDestino);
        outer.add(inner);
        btnComenzar= new JButton("Comenzar");
        btnComenzar.setPreferredSize(new Dimension(100, 32));
        btnComenzar.setAlignmentX(LEFT_ALIGNMENT);
        outer.add(btnComenzar);
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
    
	public void mostrarParametros(List<Control> controls){
		this.getParametros().clear();
		for(Control p: controls){
			String[] param=new String[2];
			param[0]=p.getClase();
			param[1]=p.getLabel();
			this.getParametros().add(param);
		}
		this.removeAll();
		this.agregarPaneles();
		this.revalidate();
		this.repaint(getVisibleRect());
	}

    public List<String[]> getParametros() {
		return parametros;
	}

	public void setParametros(List<String[]> parametros) {
		this.parametros = parametros;
	}
	
	public JLabel getLblAplicacion() {
		return lblAplicacion;
	}

	public void setLblAplicacion(JLabel lblAplicacion) {
		this.lblAplicacion = lblAplicacion;
	}

	public JLabel getLblConfig() {
		return lblConfig;
	}

	public void setLblConfig(JLabel lblConfig) {
		this.lblConfig = lblConfig;
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

	public JButton getBtnComenzar() {
		return btnComenzar;
	}

	public void setBtnComenzar(JButton btnComenzar) {
		this.btnComenzar = btnComenzar;
	}

	public JLabel getLblDestino() {
		return lblDestino;
	}

	public void setLblDestino(JLabel lblDestino) {
		this.lblDestino = lblDestino;
	}

	public JButton getBtnDestino() {
		return btnDestino;
	}

	public void setBtnDestino(JButton btnDestino) {
		this.btnDestino = btnDestino;
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