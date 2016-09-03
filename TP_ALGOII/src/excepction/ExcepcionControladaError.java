package excepction;

import java.io.Serializable;

public class ExcepcionControladaError extends ExcepcionControlada implements Serializable {
	
	private static final long serialVersionUID = 7313803981000901940L;
	
	private String msj;

    public ExcepcionControladaError() {
    	
    }

    public ExcepcionControladaError(String msj) {
        this.msj = msj;
    }

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
}