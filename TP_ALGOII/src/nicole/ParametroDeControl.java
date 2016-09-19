package nicole;

import java.util.ArrayList;
import java.util.List;

public class ParametroDeControl {
    //Todavia no se definio nada
	public String param;
	public String defDir;
	public int defvalue;
	public int grado;
	public  List<String> tipoArch=new ArrayList<String>();
	

	
	public String getDefDir() {
		return defDir;
	}

	public void setDefDir(String defDir) {
		this.defDir = defDir;
	}

	public int getDefvalue() {
		return defvalue;
	}

	public void setDefvalue(int defvalue) {
		this.defvalue = defvalue;
	}

	public List<String> getTipoArch() {
		return tipoArch;
	}

	public void setTipoArch(List<String> tipoArch) {
		this.tipoArch = tipoArch;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
}
