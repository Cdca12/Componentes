package componentes.ComponentesAuxiliares;

import java.awt.*;

import javax.swing.*;

public class JPanelCaja extends JPanel {
	private JLeeCorreo correo;
	private JLeeRFC rfc;
	private JLeeNumeroTel numTel;
	private JButton btnEliminar;
	private int tipo;
	
	public JPanelCaja(int tipo) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		creaCaja(tipo);
		this.tipo = tipo;
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
	public String getInfo() {
		if(tipo == 0)
			return correo.getTextValidado();
		if(tipo == 1)
			return rfc.getTextValidado();
		if(tipo == 2)
			return ""+numTel.getTextValidado();
		return "";
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
}
