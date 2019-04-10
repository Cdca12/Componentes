package componentes;

import java.awt.Component;

import javax.swing.JPanel;

public class JCajasMultiples{
	CajasMultiplesVta v;
	CajasMultiplesCtd c;
	CajasMultiplesMdl m;
	public JCajasMultiples() {
		v = new CajasMultiplesVta();
		m = new CajasMultiplesMdl();
		c = new CajasMultiplesCtd(v, m);
	}
	public JPanel getComponent() {
		return v;
	}
}
