package constructoresPaneles;

public class TransFormacion {

	String Desde;
	String Hasta;
	
	public String getDesde() {
		return Desde;
	}
	public void setDesde(String desde) {
		Desde = desde;
	}
	public String getHasta() {
		return Hasta;
	}
	public void setHasta(String hasta) {
		Hasta = hasta;
	}

		public String DurTotalAHasta(){
			
			String[] h1 = Desde.split(":");
			String[] h2 = Hasta.split(":");
			int resto = 0;

			int segundo =( Integer.parseInt(h2[2]) -Integer.parseInt(h1[2]));
			//-10
			if (segundo < 0){
			   resto = -1;
			   segundo = 60 + segundo;
			   //50
			}
			//20-15+(-1)
			//4
			int minuto = Math.abs((Integer.parseInt(h2[1])-Integer.parseInt(h1[1]))) + resto;
			resto = 0;
			if (minuto < 0){
			   minuto = 60 - minuto;
			   resto = -1;
			}
			int hora = (Integer.parseInt(h2[0])-Integer.parseInt(h1[0])) + resto;
			
			String HORA="";
			
			String MINUTO="";
			
			String SEGUNDO="";
			
			HORA = RellenarCeros(hora);
			MINUTO= RellenarCeros(minuto);
			SEGUNDO= RellenarCeros(segundo);
			//01:04:50
			String Transformada ="";
			Transformada += (String.valueOf(HORA))+":"+(String.valueOf(MINUTO))+":"+ (String.valueOf(SEGUNDO));
			return Transformada;

		}

		public static String RellenarCeros(int tiempo){

			if (String.valueOf(tiempo).length()!=2){
				
				return "0"+String.valueOf(tiempo);
				
			}else{
				
				return String.valueOf(tiempo);
			}
			
		}
}
