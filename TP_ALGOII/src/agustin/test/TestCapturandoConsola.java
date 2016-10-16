package agustin.test;

import interfaz_mezclaDeTodos.FrameConsola;
import interfaz_mezclaDeTodos.InvocarComando;
import interfaz_mezclaDeTodos.Parametro;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by user on 10/10/2016.
 */
public class TestCapturandoConsola {
    public List<Parametro> entradas,inputs;
    public Parametro parametro,audio1,audio2,outvideo;
    public String directorioComando;
    public String lineaAEjecutar,otraLineaAEjecutar;

    @Before
    public void init() {
        entradas = new ArrayList<>();
        parametro = new Parametro();
        parametro.setParametro("C:\\Users\\user\\Desktop\\RUGBY 2016\\Delta vs Los Matreros\\DSC02323.jpg");
        parametro.setNombreParametro("[IMAGEN]");
        entradas.add(parametro);
        directorioComando = "C:\\Users\\user\\Documents\\agustin\\Image-ExifTool-10.29\\exiftool.exe";
        lineaAEjecutar = "-common [IMAGEN]";

        audio1 = new Parametro();



    }

    @Test
    public void testTranca(){
        //InvocarComando.invocarComando(new FrameConsola(), directorioComando, lineaAEjecutar, entradas);
    }

    @Test
    public void provandoElParser(){
        String res = new StringBuilder().append(" -common ").append('"').append("C:\\Users\\user\\Desktop\\RUGBY 2016\\Delta vs Los Matreros\\DSC02323.jpg").append('"').toString();
        assertEquals(res,InvocarComando.parsearComando(lineaAEjecutar,entradas));
    }

    @Test
    public void otraPruebaDelParserDeComando(){

    }

}
