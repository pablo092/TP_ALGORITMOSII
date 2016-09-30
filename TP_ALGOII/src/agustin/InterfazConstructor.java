package agustin;

import javax.swing.*;

import interfaz_mezclaDeTodos.Configuracion;
import interfaz_mezclaDeTodos.Control;
import interfaz_mezclaDeTodos.ControladorConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class InterfazConstructor {
    private List<ControladorConstructor> controladorConstructors;

    public void crearControladoresDe(Configuracion configuracion, JPanel panel) {
        List<Control> controls = configuracion.getControls();
        for (Control control : controls) {
            ControladorConstructor controladorConstructor = this.encontrarControladorConstructorCorrespondienteA(control.getClase());
            controladorConstructor.contruiYAgregaA(control,panel,null);
        }
    }

    private ControladorConstructor encontrarControladorConstructorCorrespondienteA(String clase) {
        return (ControladorConstructor) this.getControladorConstructors().stream().filter(unControlador -> unControlador.getClass().toString().equals(clase))
                .collect(Collectors.toList())
                .get(0);
    }

    public List<ControladorConstructor> getControladorConstructors() {
        return controladorConstructors;
    }
    public void setControladorConstructors(List<ControladorConstructor> controladorConstructors) {
        this.controladorConstructors = controladorConstructors;
    }

}
