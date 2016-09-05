package excepction;

import java.io.Serializable;

public class ExcepcionControladaAlerta extends ExcepcionControlada implements Serializable {

	private static final long serialVersionUID = -6010749059438963446L;
	
	private String msj;

    public ExcepcionControladaAlerta() {
    }

    public ExcepcionControladaAlerta(String msj) {
        this.msj = msj;
    }

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
}