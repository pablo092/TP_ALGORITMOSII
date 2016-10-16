package interfaz_mezclaDeTodos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10/10/2016.
 */
public class FrameConsola extends JPanel {
	private JFrame frame;
	private JButton button;
	private JTextArea textArea;
	private List<String> lineas = new ArrayList<String>();
	/*
	 * static public void main(String[] a){ new FrameConsola(); }
	 */

	public FrameConsola() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.agregarPaneles();
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
	}

	private void agregarPaneles() {
		JPanel outer = new JPanel();
		outer.setMaximumSize(new Dimension(350, 350));
		outer.setPreferredSize(new Dimension(350, 350));
		outer.setLayout(new BoxLayout(outer, BoxLayout.Y_AXIS));
		// outer.setBackground(new Color(21,34,13));

		textArea = new JTextArea("Inicio de Ejecucion:\n ");
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textArea.setBackground(new Color(250, 250, 250));
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setVisible(true);
		textArea.setCaretPosition(textArea.getText().length());
		JScrollPane inner = new JScrollPane(textArea);
		inner.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		inner.setPreferredSize(new Dimension(310, 310));

		if (!(lineas.isEmpty())) {
			for (String linea : lineas) {
				textArea.append(linea);
			}
		}
		outer.add(inner);
		this.add(outer);

	}

	public void agregarLineas(String l) {
		lineas.add(l);
		this.removeAll();
		this.agregarPaneles();
		this.revalidate();
		this.repaint(getVisibleRect());
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

}
