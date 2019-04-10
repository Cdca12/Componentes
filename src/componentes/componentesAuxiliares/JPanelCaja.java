package componentes.ComponentesAuxiliares;

import java.awt.*;

import javax.swing.*;

public class JPanelCaja extends JPanel {
	private JLeeCorreo correo;
	private JLeeRFC rfc;
	private JLeeNumeroTel numTel;
	private JButton btnEliminar;
	private int pos;
	
	public JPanelCaja(int tipo,int pos) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		creaCaja(tipo);
		this.pos = pos;
	}

	private void creaCaja(int tipo) {
		btnEliminar = new JButton("x");
		btnEliminar.setPreferredSize(new Dimension(80, 30));
		switch(tipo) {
		case 0://Correo
			correo = new JLeeCorreo();
			correo.setPreferredSize(new Dimension(300, 35));
			add(correo);
			add(btnEliminar);
			break;
		case 1://RFC
			rfc = new JLeeRFC();
			rfc.setPreferredSize(new Dimension(300, 35));
			add(rfc);
			add(btnEliminar);
			break;
		case 2://NumTel
			numTel = new JLeeNumeroTel();
			numTel.setPreferredSize(new Dimension(300, 35));
			add(numTel);
			add(btnEliminar);
			break;
		}
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public int getPos() {
		return pos;
	}
}
