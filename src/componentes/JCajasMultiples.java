package componentes;

import java.awt.Component;

import javax.swing.JPanel;

public class JCajasMultiples{
	CajasMultiplesMdl m;
	CajasMultiplesVta v;
	CajasMultiplesCtd c;
	
	public JCajasMultiples() {
		v = new CajasMultiplesVta(10);
		m = new CajasMultiplesMdl();
		c = new CajasMultiplesCtd(v, m);
	}
	public JCajasMultiples(int numCajas) {
		v = new CajasMultiplesVta(numCajas);
		m = new CajasMultiplesMdl();
		c = new CajasMultiplesCtd(v, m);
	}
	public JPanel getComponent() {
		return v;
	}
	public String[] getInfo() {
		return m.obtenerInfo();
	}
	public String getInfo(int pos) {
		return m.obtenerInfo(pos-1);
	}
}
