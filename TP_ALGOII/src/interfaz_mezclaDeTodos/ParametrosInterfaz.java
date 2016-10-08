package interfaz_mezclaDeTodos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class ParametrosInterfaz {
		String App;
		
		List <PanelYControl> Paneles = new ArrayList<PanelYControl>();
		
		
		public List<PanelYControl> getPaneles() {
			return Paneles;
		}
		public void setPaneles(List<PanelYControl> paneles) {
			Paneles = paneles;
		}
		public String getApp() {
			return App;
		}
		public void setApp(String app) {
			App = app;
		}
		
		
}
