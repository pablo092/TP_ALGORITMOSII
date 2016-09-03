package modelo;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class XML implements Serializable {

	private static final long serialVersionUID = -5010968187597719167L;
	Hashtable<String, Integer> etiquetas;
    Hashtable<String, Integer> atributos;
 
    public XML() {
        etiquetas = new Hashtable<String, Integer>();
        atributos = new Hashtable<String, Integer>();
    }
 
    /**
     * Recorre el árbol XML que se le proporciona en el elemento "e". Al
     * recorrer el árbol cuenta los tags que va encontrando en su camino.
     * El algoritmo es sencillo: dado el elemento raíz, obtiene los hijos, y
     * por cada hijo recorre nuevamente el árbol. El nombre de cada elemento
     * es pasado al método "cuenta", quien se encarga de llevar la contabilidad
     * de cada uno de los elementos.
     * @param e
     */
    public void recorreArbol(Element e) {
        //cuenta(e.getName());        
        List<?> children = e.getChildren();
        List<?> attributes = e.getAttributes();
        Iterator<?> itr = attributes.iterator();
        cuenta(e.getName());     
        while(itr.hasNext()){
            Attribute atributo = (Attribute)itr.next();
            String atr1 = "";
//            String atr2 = "";
            atr1 = atributo.getName();
  //          atr2 = atributo.getName();
            cuentaAtributo(atr1);
        }
        for (Iterator<?> i = children.iterator(); i.hasNext();) {
            recorreArbol((Element) i.next());
 
        }
    }
 
    public void cuenta(String key) {
        Object value = etiquetas.get(key);
 
        if (value == null) {
            //Añadimos una nueva entrada a la tabla
            etiquetas.put(key, new Integer(1));
        } else {
            //Obtenemos el valor actual y lo incrementamos
            int count = ((Integer) value).intValue();
            count++;
            etiquetas.put(key, new Integer(count));
        }
    }
 
    public void imprimeResumen() {
        Enumeration<String> e = etiquetas.keys();
        Enumeration<String> a = atributos.keys();
 
        while (e.hasMoreElements()) {
            //Obtenemos el siguiente tag XML
            String tag = (String) e.nextElement();
            //Obtenemos el número de veces que apareció
            int count = ((Integer) etiquetas.get(tag)).intValue();
            //Imprimimos los resultados
            System.out.println("Tag <" + tag + "> aparece " + count + " veces");
        }
        while (a.hasMoreElements()) {
            //Obtenemos el siguiente tag XML
            String tag = (String) a.nextElement();
            //Obtenemos el número de veces que apareció
            int count = ((Integer) atributos.get(tag)).intValue();
            //Imprimimos los resultados
            System.out.println("Atributo -" + tag + "- aparece " + count + " veces");
        }
    }
 
    private void cuentaAtributo(String key) {
        Object value = atributos.get(key);
 
        if (value == null) {
            //Añadimos una nueva entrada a la tabla
            atributos.put(key, new Integer(1));
        } else {
            //Obtenemos el valor actual y lo incrementamos
            int count = ((Integer) value).intValue();
            count++;
            atributos.put(key, new Integer(count));
        }
    }
    
//    public static void main(String[] args) throws Exception {
//    	 
//        String path = "C:\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\workspace\\TP_ALGO2-Basheador\\xmls\\";
//        String filename = path + "Configuracion1.xml";
// 
//        //Creamos un Document con el contenido del archivo XML
//        SAXBuilder builder = new SAXBuilder();
//        Document doc = builder.build(filename);
// 
//        //Creamos un objeto CuentaNodos para contar los nodos del archivo XML
//        XML counter = new XML();
//        //recorremos el documento XML pasándole el elemento raíz
//        counter.recorreArbol(doc.getRootElement());
//        //imprimimos un resumen de los nodos que hay en el documento XML
//        counter.imprimeResumen();
//    }
}
