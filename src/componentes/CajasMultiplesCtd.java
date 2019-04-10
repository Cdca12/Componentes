package componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CajasMultiplesCtd implements ActionListener{
	CajasMultiplesVta vista;
	CajasMultiplesMdl modelo;
	public CajasMultiplesCtd(CajasMultiplesVta vista, CajasMultiplesMdl modelo) {
		this.vista = vista;
		this.modelo = modelo;
		hazEscuchas();
	}
	private void hazEscuchas() {
		vista.rdBtnCorreo.addActionListener(this);
		vista.rdBtnRFC.addActionListener(this);
		vista.rdBtnTelefono.addActionListener(this);
		vista.btnNuevaCaja.addActionListener(this);
		
	} 
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == vista.btnNuevaCaja) {
			vista.añadirCaja();
			vista.habilitarRadios(false);
            return;
        }

        if (evt.getSource() == vista.rdBtnCorreo) {
        	vista.setSeleccion(0);
            return;
        }
        if (evt.getSource() == vista.rdBtnRFC) {
        	vista.setSeleccion(1);
            return;
        }
        if (evt.getSource() == vista.rdBtnTelefono) {
        	vista.setSeleccion(2);
            return;
        }
	}
}
