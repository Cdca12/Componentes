package componentes;

import java.util.Vector;

import javax.swing.JPanel;

import componentes.componentesAuxiliares.JPanelCaja;

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
	public void setDatos(Vector<JPanelCaja> datos) {
		this.datos = datos;
	}
}
