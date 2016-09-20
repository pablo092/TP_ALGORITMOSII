package anto;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import nicole.Aplicacion;
import nicole.Configuracion;
import nicole.Control;

import nicole.ParametroDeControl;;

	public class parseoXML {
		
		public static final String CONFIG ="config";
		public static final String CONTROL ="control";
		public static final String DEFDIR ="def-dir";
		public static final String TIPOARCH ="tipo-arch";
		public static final String REGEX ="regex";
		public static final String DEFVALUE ="def-value";
		
		//private static int i=0;
		static Aplicacion app;
		ParametroDeControl  parametro;

		

			public Aplicacion parseoXMLs (List<Aplicacion> Aplicaciones){
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				try{
				
				DocumentBuilder builder = factory.newDocumentBuilder();
				
				Document doc = builder.parse("app.xml");
				
				NodeList appList = doc.getElementsByTagName("app");
				 System.out.println("what");
				
				for(int i=0;i<appList.getLength();i++){
					
					//recorro por APP
					    app =new Aplicacion();
					   
					  //  config=new Configuracion();
						
					//    Control control =new Control();
					    
					    		
						Node p =	appList.item(i);
			
						if(p.getNodeType()==Node.ELEMENT_NODE){
					
								Element ap = (Element) p;					
								
								String name = ap.getAttribute("title");
							
								app.setName(name);				
					
								NodeList child =ap.getChildNodes();
				   	
					for(int j=0;j<child.getLength();j++){
					
                       Configuracion config=new Configuracion();
						
					    Control control =new Control();
						// CONTROL //
						Node n =	child.item(j);
					
						if(n.getNodeType()==Node.ELEMENT_NODE){
						
							Element nombre = (Element) n;
							
							System.out.println(nombre.getTagName());;
							
							 parametro = new ParametroDeControl();
							
							
							
							SwitchPARSEO(nombre,config,parametro,control);
							 
							NodeList ListaHijos= nombre.getChildNodes();
							//HIJOS DE CONFIG --> CONTROL
							 if(ListaHijos != null){
							
								 for(int t=0;t<ListaHijos.getLength();t++){ 
								
									 Node h = ListaHijos.item(t);
									 
									 if(h.getNodeType()==Node.ELEMENT_NODE){
																													
									 Element Hijo = (Element) h;
									
									 System.out.println( "hijo "+ Hijo.getTagName());;
										
									 SwitchPARSEO(Hijo,config,parametro,control);
									 
									 
									 NodeList ListaSubHijos = h.getChildNodes();
									 
									 if(ListaSubHijos != null){
										 for(int k=0;k<ListaSubHijos.getLength();k++){ 
										
										Node sh = ListaSubHijos.item(k);
										 
										 if(sh.getNodeType()==Node.ELEMENT_NODE){
												
											 Element SubHijo = (Element) sh;
											
											 System.out.println( "sub hijo "+ SubHijo.getTagName());;
												
											 SwitchPARSEO(SubHijo,config,parametro,control);
									 }
									 }
										 
									 }
									 
									 	 
								
						
					
					
				
					
					
				}
				
			 }
				}  //end if hijos
					//termino de modificar parametro
						} //end 
					 control.parametrosDeControl.add(parametro);
				} 
				
						
						}
						Aplicaciones.add(app);
						//end primer if
				} //end for general
				} catch(ParserConfigurationException e){
						e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return app;	
				
			}
			
			public static void SwitchPARSEO(Element Elemt,Configuracion config ,ParametroDeControl parametro,Control control){
				
				switch (Elemt.getTagName()) {
				
				case CONFIG:
					
					
					//config=new Configuracion();
					
					config.setNombre(Elemt.getAttribute("name"));
					for(int i=0;i<Elemt.getAttributes().getLength();i++){
						if(Elemt.getAttributes().item(i).getNodeName().contains("command")){
							app.setCommand(Elemt.getAttributes().item(i).getNodeValue());
						}
						if(Elemt.getAttributes().item(i).getNodeName().contains("params")){
							app.setParametrosComando(Elemt.getAttributes().item(i).getNodeValue());
						}
					}
					
						app.getConfiguraciones().add(config);
						
					
					
					break;
					
				case CONTROL:
					if(Elemt.getNodeName().equals("control")){
						
						for(int i=0;i<Elemt.getAttributes().getLength();i++){
							if(Elemt.getAttributes().item(i).getNodeName().contains("label")){
								control.setLabel(Elemt.getAttributes().item(i).getNodeValue());
							}
							if(Elemt.getAttributes().item(i).getNodeName().contains("name")){
								control.setName(Elemt.getAttributes().item(i).getNodeValue())
															
								;
							}
							if(Elemt.getAttributes().item(i).getNodeName().contains("class")){
								control.setClase(Elemt.getAttributes().item(i).getNodeValue());
							}

						}
						
						
							
						config.getControls().add(control);
					}
					
					
				case DEFDIR:
					if(Elemt.getNodeName().equals("def-dir")){
						
					String defDIR=	Elemt.getTextContent();
					
					parametro.setDefDir(defDIR);
					
					}				
					
					break;
					
				case TIPOARCH:
					
					
					if(Elemt.getNodeName().equals("tipo-arch")){
						
						String tipos=	Elemt.getTextContent();
						
						//agrego por separado
						char[] arrayChar = tipos.toCharArray();
						 String type="";
						for(int i=0; i<arrayChar.length; i++){
				 
							if( arrayChar[i] == ','){
								
								parametro.tipoArch.add(type);
								type="";
								
							}
							
							else 
								type = type + arrayChar[i];
								
							
						}
					
											
						}
						
				
					break;
				
				case REGEX:
					
					String regex =Elemt.getTextContent();
					

					Pattern p = Pattern.compile(regex);
					
					
					
					/*
					  Matcher m = p.matcher(dato);
					 

					if (dato.matches(regex))
						System.out.println("Es un númerO");
						else
						System.out.println("No es un número");
						*/
						
					
					break;
				
				case DEFVALUE:
					
					int value = Integer.parseInt(Elemt.getTextContent());
					
					parametro.setDefvalue(value);
					break;
				default:
					System.out.println("No entiendo de que carajo hablas");
					
					
				}
			}			
	
				
				
				}
				
				
