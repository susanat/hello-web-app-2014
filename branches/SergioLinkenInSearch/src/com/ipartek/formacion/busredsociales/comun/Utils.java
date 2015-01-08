package com.ipartek.formacion.busredsociales.comun;



public class Utils {

	public static String changeTittle(String newTittle) {
		StringBuffer text = new StringBuffer();
		
		
		text.append("<script type='text/javascript'>").append(Constantes.SALTO_DE_LINEA);
		text.append("    $(document).ready(function() {").append(Constantes.SALTO_DE_LINEA);
			text.append("	document.title = ");
			text.append("'").append(newTittle).append("'").append(Constantes.SALTO_DE_LINEA);	
		text.append("});").append(Constantes.SALTO_DE_LINEA);		
		text.append("</script>").append(Constantes.SALTO_DE_LINEA);
		
		return text.toString();
	}
}
