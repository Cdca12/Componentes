package componentes;

import java.util.Vector;

import javax.swing.JPanel;


public class CajasMultiplesMdl {
	Vector<JPanelCaja> datos;
	private String[] info;
	
	public String[] obtenerInfo() {
		info = new String[datos.size()];
		for(int i=0; i<datos.size();i++) {
			info[i] = datos.get(i).getInfo();
		}
		return info;
	}
	public String obtenerInfo(int pos) {
		return datos.get(pos).getInfo();
	}
	public void setDatos(Vector<JPanelCaja> datos) {
		this.datos = datos;
	}
}
