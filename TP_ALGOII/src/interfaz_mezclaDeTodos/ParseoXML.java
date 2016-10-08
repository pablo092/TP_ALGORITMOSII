package interfaz_mezclaDeTodos;

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
import org.xml.sax.SAXException;;

public class ParseoXML {

	public static final String CONFIG = "config";
	public static final String CONTROL = "control";
	public static final String DEFDIR = "def-dir";
	public static final String TIPOARCH = "tipo-arch";
	public static final String REGEX = "regex";
	public static final String DEFVALUE = "def-value";
	public static final String MINUTOS = "minutos";
	public static final String SEGUNDOS = "segundos";
	
	// private static int i=0;
	static Aplicacion app;
	ParametroDeControl parametro;
	Control control;
	public Aplicacion parseoXMLs(List<Aplicacion> Aplicaciones) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse("app.xml");

			NodeList appList = doc.getElementsByTagName("app");
			// System.out.println("what");

			for (int i = 0; i < appList.getLength(); i++) {

				// recorro por APP
				app = new Aplicacion();

				// config=new Configuracion();

				// Control control =new Control();

				Node p = appList.item(i);

				if (p.getNodeType() == Node.ELEMENT_NODE) {

					Element ap = (Element) p;

					String name = ap.getAttribute("title");

					app.setName(name);
					
					NodeList configList= ap.getChildNodes();

					for (int j = 0; j < configList.getLength(); j++) {

						Configuracion config = new Configuracion();

						// control = new Control();
						// CONTROL //
						Node n = configList.item(j);

						if (n.getNodeType() == Node.ELEMENT_NODE) {

							Element nombre = (Element) n;

							// System.out.println(nombre.getTagName());;

							//parametro = new ParametroDeControl();

						/*	config.setNombre(nombre.getAttribute("name"));
							for (int i1 = 0; i1 < nombre.getAttributes().getLength(); i1++) {
								if (nombre.getAttributes().item(i1).getNodeName().contains("command")) {
									app.setCommand(nombre.getAttributes().item(i1).getNodeValue());
								}
								if (nombre.getAttributes().item(i1).getNodeName().contains("params")) {
									app.setParametrosComando(nombre.getAttributes().item(i1).getNodeValue());
								}
							}
							
							app.getConfiguraciones().add(config);
							*/
							
							
							SwitchPARSEO(nombre, config, parametro, control);

							NodeList ControlList = nombre.getChildNodes();
							// HIJOS DE CONFIG --> CONTROL
							if (ControlList != null) {

								for (int t = 0; t < ControlList.getLength(); t++) {
											//CONTROL
									Node h = ControlList.item(t);
									
									if (h.getNodeType() == Node.ELEMENT_NODE) {
											
										control = new Control();
										Element Hijo = (Element) h;
										
								/*	control.setName(Hijo.getAttribute("name"));
									control.setLabel(Hijo.getAttribute("label"));
									control.setClase(Hijo.getAttribute("class"));
									*/
									//control = new Control();
																		
									SwitchPARSEO(Hijo, config, parametro, control);

										NodeList ParamList = h.getChildNodes();

										if (ParamList != null) {
											parametro = new ParametroDeControl();
												for (int k = 0; k < ParamList.getLength(); k++) {

												Node sh = ParamList.item(k);
												if (sh.getNodeType() == Node.ELEMENT_NODE) {

													Element SubHijo = (Element) sh;

													// System.out.println( "sub
													// hijo "+
													// SubHijo.getTagName());;

													SwitchPARSEO(SubHijo, config, parametro, control);
												}
												
												
														}
											//kk
										} control.getParametrosDeControl().add(parametro);
												
										if(control!= null)
									config.getControls().add(control); 
											
									}											
									
								}
								
								
								
								
								
								
							} // end if hijos
									
						
					
								// termino de modificar parametro
						} // end
				
					
					}//(POR CONFIGGGG)
					
				}
				Aplicaciones.add(app);
				// end primer if
			} // end for general
		} catch (ParserConfigurationException e) {
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

	public static void SwitchPARSEO(Element Elemt, Configuracion config, ParametroDeControl parametro,
			Control control) {

		switch (Elemt.getTagName()) {

		case CONFIG:

			// config=new Configuracion();

			config.setNombre(Elemt.getAttribute("name"));
			for (int i = 0; i < Elemt.getAttributes().getLength(); i++) {
				if (Elemt.getAttributes().item(i).getNodeName().contains("command")) {
					config.setCommand(Elemt.getAttributes().item(i).getNodeValue());
				}
				if (Elemt.getAttributes().item(i).getNodeName().contains("params")) {
					config.setParametrosComando(Elemt.getAttributes().item(i).getNodeValue());
				}
			}
			
			app.getConfiguraciones().add(config);

			break;

		case CONTROL:
			if (Elemt.getNodeName().equals("control")) {
				
				//control = new Control();
				for (int i = 0; i < Elemt.getAttributes().getLength(); i++) {
					
					if (Elemt.getAttributes().item(i).getNodeName().contains("label")) {
						control.setLabel(Elemt.getAttributes().item(i).getNodeValue());
					}
					if (Elemt.getAttributes().item(i).getNodeName().contains("name")) {
						control.setName(Elemt.getAttributes().item(i).getNodeValue());
					}
					if (Elemt.getAttributes().item(i).getNodeName().contains("class")) {
						control.setClase(Elemt.getAttributes().item(i).getNodeValue());
					}

				}
			
			}
			break;

		case DEFDIR:
			if (Elemt.getNodeName().equals("def-dir")) {

				String defDIR = Elemt.getTextContent();

				parametro.setDefDir(defDIR);
				
				

			}

			break;

		case TIPOARCH:

			if (Elemt.getNodeName().equals("tipo-arch")) {

				String tipos = Elemt.getTextContent();

				// agrego por separado
				char[] arrayChar = tipos.toCharArray();
				String type = "";
				for (int i = 0; i < arrayChar.length; i++) {

					if (arrayChar[i] == ',') {
						
						parametro.tipoArch.add(type);
						type = "";
						
					}

					else
						type = type + arrayChar[i];

				}

			}

			break;

		case REGEX:

			String regex = Elemt.getTextContent();
			
			
			parametro.ExpRegGrado=regex;
			//Pattern p = Pattern.compile(regex);

			/*
			 * Matcher m = p.matcher(dato);
			 * 
			 * 
			 * if (dato.matches(regex)) System.out.println("Es un n�merO"); else
			 * System.out.println("No es un n�mero");
			 */

			break;

		case DEFVALUE:

			int value = Integer.parseInt(Elemt.getTextContent());
			
			parametro.setDefvalue(value);
			break;
			
			
		case MINUTOS:

			String minutos = Elemt.getTextContent();
			
			
			parametro.ExpRegMinutos=minutos;
			
			break;
			
		case SEGUNDOS:

			String seg = Elemt.getTextContent();
			
			
			parametro.ExpRegSegundos=seg;
		break;
		}
	}

}
