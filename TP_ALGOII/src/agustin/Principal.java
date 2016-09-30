package agustin;

import nicole.Xml_dom_parser;

import javax.swing.*;

import interfaz_mezclaDeTodos.Aplicacion;
import interfaz_mezclaDeTodos.Configuracion;

import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {

    private InterfazConstructor interfazConstructor;
    private InvocadorComando invocadorComando;
    private List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();
    private JFrame marcoPrincipal;

    private JComboBox<String> comboDeApps;
    private JComboBox<String> comboDeConfigs;
    private JPanel panel;

    public Principal() {
        this.marcoPrincipal = this.iniciarMarcoPrincipal();
        this.interfazConstructor = new InterfazConstructor();
        this.invocadorComando = new InvocadorComando();
        this.cargarAplicaciones();
        this.comboDeApps = this.iniciarComboDeAppsEn(this.getMarcoPrincipal());
        this.comboDeConfigs = this.iniciarComboDeConfigsEn(this.getMarcoPrincipal());
        this.panel = this.iniciarPanelDeParametros(this.getMarcoPrincipal());
    }

    private JPanel iniciarPanelDeParametros(JFrame marcoPrincipal) {
        JPanel unPanel = new JPanel();
        unPanel.setVisible(true);
        unPanel.setBounds(21,5,298,400);
        return null;
    }

    private JFrame iniciarMarcoPrincipal(){
        JFrame marco = new JFrame();
        marco.setResizable(true);
        marco.setVisible(true);
        marco.setBounds(20,20,300,500);
        return marco;
    }

    private JComboBox<String> iniciarComboDeAppsEn(JFrame unMarco) {
        JComboBox<String> unCombo = new JComboBox<String>(){
            @Override
            //Cuando selecciono algo, agrego las configs al combo de configs
            public void actionPerformed(ActionEvent e) {
                JComboBox box =(JComboBox)e.getSource();
                Object seleccionado = box.getSelectedItem();
                loadConfigs(seleccionado);
            }
        };
        unCombo.setVisible(true);
        unCombo.setBounds(21,19,200,100);
        unMarco.add(unCombo);
        this.agregarAppsA(unCombo);
        return unCombo;
    }

    private JComboBox<String> iniciarComboDeConfigsEn(JFrame marcoPrincipal) {
        JComboBox<String> box = new JComboBox<String>(){
            @Override
            //cuando selecciono una config, arma los parametros dinamicamente
            public void actionPerformed(ActionEvent e) {
                JComboBox jComboBox = (JComboBox) e.getSource();
                Object seleccionado = jComboBox.getSelectedItem();
                setearDinamicamenteInterfaz(seleccionado);
            }
        };
        box.setVisible(true);
        box.setBounds(14,22,20,14);
        marcoPrincipal.add(box);
        return box;
    }

    private void loadConfigs(Object seleccionado) {
        String appName = (String) seleccionado;
        Aplicacion appSeleccionada = this.getAplicacionSegunNombre(appName);
        List<Configuracion> configs = appSeleccionada.getConfiguraciones();
        configs.forEach(unaConfig -> this.getComboDeConfigs().addItem(unaConfig.getNombre()));
    }

    private Aplicacion getAplicacionSegunNombre(String seleccionado) {
        return this.getAplicaciones().stream()
                .filter(unaApp -> unaApp.getName().equals(seleccionado))
                .collect(Collectors.toList())
                .get(0);
    }

    private void setearDinamicamenteInterfaz(Object seleccionado) {
        //Magia que comienza el envio de mensajes a partir del evento
        String configSeleccionada = (String) seleccionado;
        String appName =(String) this.getComboDeApps().getSelectedItem();
        Aplicacion app = this.getAplicacionSegunNombre(appName);
        Configuracion configuracion = app.getConfiguraciones().stream()
                .filter(unaConfig -> unaConfig.getNombre().equals(configSeleccionada))
                .collect(Collectors.toList())
                .get(0);
        this.getInterfazConstructor().crearControladoresDe(configuracion,this.getPanel());
    }

    private void setearTituloDelFrameSegun(String nameApp) {
    }

    private void setearComboBoxDeLasConfigSegun(String nameApp) {
    }

    private void enviarCadaControladorAlInterfazConstructor(String nameApp) {

    }

    private void agregarAppsA(JComboBox<String> unCombo) {}

    public void cargarAplicaciones(){
        //Se fija todos lo XML que hay
        List<String> archivosXML=new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Indice.txt"));
            String linea=br.readLine();
            while(linea!=null){
                archivosXML.add(linea);
                linea=br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Crea las app en funcion de los XML
        this.parsearXMLs(archivosXML, this.getAplicaciones());
    }

    private void parsearXMLs(List<String> archivosXML,List<Aplicacion> aplicaciones){
        for(String XML:archivosXML){
            Aplicacion app=new Aplicacion();
            new Xml_dom_parser().cargaDatos(app,XML);
            aplicaciones.add(app);
        }
    }

    public JFrame getMarcoPrincipal() {
        return marcoPrincipal;
    }

    public List<Aplicacion> getAplicaciones() {
        return aplicaciones;
    }

    public JComboBox<String> getComboDeConfigs() {
        return comboDeConfigs;
    }

    public void setComboDeConfigs(JComboBox<String> comboDeConfigs) {
        this.comboDeConfigs = comboDeConfigs;
    }

    public InterfazConstructor getInterfazConstructor() {
        return interfazConstructor;
    }

    public void setInterfazConstructor(InterfazConstructor interfazConstructor) {
        this.interfazConstructor = interfazConstructor;
    }

    public InvocadorComando getInvocadorComando() {
        return invocadorComando;
    }

    public void setInvocadorComando(InvocadorComando invocadorComando) {
        this.invocadorComando = invocadorComando;
    }

    public JComboBox<String> getComboDeApps() {
        return comboDeApps;
    }

    public void setComboDeApps(JComboBox<String> comboDeApps) {
        this.comboDeApps = comboDeApps;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }


}
