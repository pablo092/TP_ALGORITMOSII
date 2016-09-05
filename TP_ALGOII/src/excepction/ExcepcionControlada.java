package excepction;

import java.io.Serializable;

public class ExcepcionControlada implements Serializable {

	private static final long serialVersionUID = 4187601604699447348L;
	
	private String msj;

    public ExcepcionControlada() {
    }

    public ExcepcionControlada(String msj) {
        this.msj = msj;
    }

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
}