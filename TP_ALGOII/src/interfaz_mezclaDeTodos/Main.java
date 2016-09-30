package interfaz_mezclaDeTodos;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
          
            public void run() {
            	Layout l=new Layout();
            	ControladorLayout c= new ControladorLayout(l);

            	
                l.display();
            }
        });
    }
}
