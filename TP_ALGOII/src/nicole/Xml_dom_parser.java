package nicole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

	public class Xml_dom_parser {
			
		private Configuracion config=null;
		private int i=0;
		
			private void recorrerArbol(Node raiz,Aplicacion app){
				if(raiz.getNodeType()==Node.ELEMENT_NODE){
					Element r=(Element)raiz;
//					System.out.println(r.getNodeName());
					if(r.getNodeName().equals("app")){
						for(int i=0;i<r.getAttributes().getLength();i++){
							if(r.getAttributes().item(i).getNodeName().contains("title")){
								app.setName(r.getAttributes().item(i).getNodeValue());
							}
						}
					}

					if(r.getNodeName().equals("config")){
						if(config!=null){
							app.getConfiguraciones().add(config);
						}
						config=new Configuracion();
						i++;
						config.setNombre("Configuracion "+i);
						for(int i=0;i<r.getAttributes().getLength();i++){
							if(r.getAttributes().item(i).getNodeName().contains("command")){
								app.setCommand(r.getAttributes().item(i).getNodeValue());
							}
							if(r.getAttributes().item(i).getNodeName().contains("params")){
								app.setParametrosComando(r.getAttributes().item(i).getNodeValue());
							}
						}
					}
					if(r.getNodeName().equals("control")){
						Parametro param=new Parametro();
						for(int i=0;i<r.getAttributes().getLength();i++){
							if(r.getAttributes().item(i).getNodeName().contains("params")){
								app.setParametrosComando(r.getAttributes().item(i).getNodeValue());
							}
							if(r.getAttributes().item(i).getNodeName().contains("label")){
								param.setLabel(r.getAttributes().item(i).getNodeValue());
							}
							if(r.getAttributes().item(i).getNodeName().contains("name")){
								param.setName(r.getAttributes().item(i).getNodeValue());
							}
							if(r.getAttributes().item(i).getNodeName().contains("class")){
								param.setClase(r.getAttributes().item(i).getNodeValue());
							}
						}
						config.getParametros().add(param);
					}
					NodeList hijos=r.getChildNodes();
					List<Node> pendientes=new ArrayList();
					agregar(r.getChildNodes(),pendientes);
					while(!(pendientes.isEmpty())){
						Node hijo=pendientes.remove(0);
						recorrerArbol(hijo,app);
						
					}
				}
			}
			private void agregar(NodeList a,List<Node> b){
				for(int i=0;i<a.getLength();i++){
					b.add(a.item(i));
				}
			}
			public void cargaDatos(Aplicacion app,String archivo) {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

				DocumentBuilder builder;
				try {
					builder = factory.newDocumentBuilder();
					Document doc;
					try {
						doc = builder.parse(archivo);
						NodeList appList = doc.getElementsByTagName("app");
						recorrerArbol(appList.item(0),app);
						app.getConfiguraciones().add(config);
					} catch (SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
				

