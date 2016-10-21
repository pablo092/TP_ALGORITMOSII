package constructoresPaneles;

import java.util.List;

import javax.swing.*;

import estructuras.Control;

public interface ControladorConstructor {

	void contruiYAgregaA(Control control, JPanel panel, List<JTextField> fields, JComboBox<String> comboAPIs);
}
