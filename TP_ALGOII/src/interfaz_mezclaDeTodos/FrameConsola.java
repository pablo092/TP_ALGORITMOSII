package interfaz_mezclaDeTodos;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 10/10/2016.
 */
public class FrameConsola extends JPanel {
    private JFrame frame;
    private JButton button;
    private JTextArea textArea;

/*    static public void main(String[] a){
        new FrameConsola();
    }*/

    public FrameConsola(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.agregarPaneles();
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }

    private void agregarPaneles() {
        JPanel outer = new JPanel();
        outer.setMaximumSize(new Dimension(350, 350));
        outer.setPreferredSize(new Dimension(350, 350));
        outer.setLayout(new BoxLayout(outer,BoxLayout.Y_AXIS));
        //outer.setBackground(new Color(21,34,13));

        textArea = new JTextArea("Inicio de Ejecucion:\n");
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textArea.setBackground(new Color(250,250,250));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setVisible(true);
        textArea.setCaretPosition(textArea.getText().length());
        JScrollPane inner = new JScrollPane(textArea);
        inner.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        inner.setPreferredSize(new Dimension(310, 310));

        JPanel inner2 = new JPanel();
        inner.setPreferredSize(new Dimension(200, 30));
        inner2.setLayout(new BoxLayout(inner2,BoxLayout.Y_AXIS));
        inner2.setVisible(true);
        button = new JButton("Cancelar");
        button.setAlignmentX(RIGHT_ALIGNMENT);
        button.setPreferredSize(new Dimension(60,30));
        button.setVisible(true);
        inner2.add(button);
        inner2.setAlignmentX(RIGHT_ALIGNMENT);

        outer.add(inner);
        outer.add(inner2);
        this.add(outer);
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
