package pack;

import java.util.ArrayList;
import java.util.List;

import interfaz_mezclaDeTodos.Aplicacion;

public class RotarVideo extends Aplicacion{

	private String InvokeCommand="";
	private TipoParametro Param1=new TipoParametro();
	

	public String getInvokeCommand() {
		return InvokeCommand;
	}


	public void setInvokeCommand(String invokeCommand) {
		InvokeCommand = invokeCommand;
	}


	public TipoParametro getParam1() {
		return Param1;
	}


	public void setParam1(TipoParametro param1) {
		Param1 = param1;
	}


	
}
