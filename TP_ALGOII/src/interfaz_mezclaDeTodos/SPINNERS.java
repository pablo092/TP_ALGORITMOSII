package interfaz_mezclaDeTodos;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import com.sun.prism.image.Coords;

import javafx.geometry.Bounds;
import javafx.scene.layout.Region;

public class SPINNERS implements ControladorConstructor {

	@Override
	public void contruiYAgregaA(Control control, JPanel panel, List<JTextField> fields) {

		if ((control.getName().equals("DESDE")) | (control.getName().equals("HASTA"))) {

			System.out.println("desde");

			SpinnerDateModel model = new SpinnerDateModel();
			JSpinner spinner = new JSpinner(model);

			spinner.setEditor(new JSpinner.DateEditor(spinner, "mm:ss "));
			spinner.setValue(new Date(0));

			spinner.setPreferredSize(new Dimension(350, 30));
			spinner.setMinimumSize(new Dimension(350, 30));
			
			JPanel inner = new JPanel();
			inner.setMaximumSize(new Dimension(700, 50));
			inner.setPreferredSize(new Dimension(700, 50));
			inner.setBounds(50, 200, 200, 50);
			JLabel lbl = new JLabel(control.getLabel() + ":", JLabel.LEFT);
			lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbl.setMaximumSize(new Dimension(200, 30));
			lbl.setPreferredSize(new Dimension(200, 30));
			inner.add(lbl);
			inner.add(spinner);
			panel.add(inner);
		}

		else {
			SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, // min
					360, // max
					1);// step
			JSpinner spinner = new JSpinner(spinnerModel);

			int w = spinner.getWidth();
			int h = spinner.getHeight();
			Dimension d = new Dimension(w + 90, h + 30);
			spinner.setPreferredSize(new Dimension(350, 30));
			spinner.setMinimumSize(new Dimension(350, 30));
			JPanel inner = new JPanel();
			inner.setMaximumSize(new Dimension(700, 50));
			inner.setPreferredSize(new Dimension(700, 50));
			inner.setBounds(50, 200, 200, 50);
			JLabel lbl = new JLabel(control.getLabel() + ":", JLabel.LEFT);
			lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbl.setMaximumSize(new Dimension(200, 30));
			lbl.setPreferredSize(new Dimension(200, 30));
			inner.add(lbl);
			inner.add(spinner);
			panel.add(inner);
		}

	}

}