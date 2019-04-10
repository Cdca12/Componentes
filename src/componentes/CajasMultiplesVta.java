package componentes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import componentes.ComponentesAuxiliares.JLeeCorreo;
import componentes.ComponentesAuxiliares.JPanelCaja;

public class CajasMultiplesVta extends JPanel implements ActionListener{

    private JPanel panelOpciones, panelRadioButton, panelBoton, panelCaja, panelScroll;
    public JButton btnNuevaCaja;
    public JRadioButton rdBtnCorreo, rdBtnRFC, rdBtnTelefono;
    private ButtonGroup grupo;
    private Vector<JTextField> cajasdeTexto;
    private Vector<JButton> btnCajasdeTexto;
    private Vector<JPanelCaja> vectorCajasdeTexto;
    private JScrollPane scroll;
    private int seleccion;

    public CajasMultiplesVta() {
        vectorCajasdeTexto = new Vector<JPanelCaja>();
        panelCaja = new JPanel();
        panelCaja.setLayout(new FlowLayout(FlowLayout.LEFT));
        creaVista();
    }

    private void creaVista() {
        setLayout(new BorderLayout());
        this.seleccion = 0;
        panelRadioButton = new JPanel();
        grupo = new ButtonGroup();
        rdBtnCorreo = new JRadioButton("Correos", true);
        rdBtnRFC = new JRadioButton("RFC");
        rdBtnTelefono = new JRadioButton("Teléfonos");
        grupo.add(rdBtnCorreo);
        grupo.add(rdBtnRFC);
        grupo.add(rdBtnTelefono);
        panelRadioButton.add(rdBtnCorreo);
        panelRadioButton.add(rdBtnRFC);
        panelRadioButton.add(rdBtnTelefono);
        //PanelBotón
        panelBoton = new JPanel();
        panelBoton.setLayout(new FlowLayout(FlowLayout.LEFT));
        btnNuevaCaja = new JButton("Nueva Caja");
        btnNuevaCaja.setPreferredSize(new Dimension(100, 20));
        panelBoton.add(btnNuevaCaja);
        //PanelOpciones
        panelOpciones = new JPanel();
        panelOpciones.setLayout(new GridLayout(2, 0));
        panelOpciones.add(panelRadioButton);
        panelOpciones.add(panelBoton);
        //PanelScroll
        
        panelScroll = new JPanel(new GridLayout(0,1));
        scroll = new JScrollPane(panelScroll);
        scroll.setBorder(null);

        add(panelOpciones, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }
    JPanelCaja caja;
    public void añadirCaja() {
    	caja = new JPanelCaja(seleccion,vectorCajasdeTexto.size()-1);
    	caja.getBtnEliminar().addActionListener(this);
        vectorCajasdeTexto.add(caja);
        panelScroll.add(vectorCajasdeTexto.get(vectorCajasdeTexto.size() - 1));

		SwingUtilities.updateComponentTreeUI(panelScroll);
    }
    public void eliminarCaja() {
    	
    }
    public void habilitarRadios(boolean band) {
    	rdBtnCorreo.setEnabled(band);
    	rdBtnRFC.setEnabled(band);
    	rdBtnTelefono.setEnabled(band);
    }
    public void setSeleccion(int seleccion) {
		this.seleccion = seleccion;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
//		System.out.println(vectorCajasdeTexto.size());
//		vectorCajasdeTexto.remove(evt);
//		System.out.println(vectorCajasdeTexto.size());
	}

}
