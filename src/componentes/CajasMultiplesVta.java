package componentes;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

import componentes.ComponentesAuxiliares.*;

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
    private int numCajas;
    private int cont;

    public CajasMultiplesVta(int numCajas) {
        vectorCajasdeTexto = new Vector<JPanelCaja>();
        panelCaja = new JPanel();
        panelCaja.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.numCajas = numCajas;
        creaVista();
        cont=0;
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
        
        panelScroll = new JPanel(new GridLayout(numCajas,1));
        scroll = new JScrollPane(panelScroll);
        scroll.setBorder(null);

        add(panelOpciones, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }
    public void a�adirCaja() {
    
    	caja.getBtnEliminar().addActionListener(this);
        vectorCajasdeTexto.add(caja);
        panelScroll.add(vectorCajasdeTexto.get(vectorCajasdeTexto.size() - 1));
        cont++;
        if(cont >= numCajas)
        	btnNuevaCaja.setEnabled(false);
        
		SwingUtilities.updateComponentTreeUI(panelScroll);
    }
    
    public void setSeleccion(int seleccion) {
		this.seleccion = seleccion;
	}
    public Vector<JPanelCaja> getVectorCajasdeTexto() {
		return vectorCajasdeTexto;
	}
    
	@Override
	public void actionPerformed(ActionEvent evt) {
		int pos = buscarPos(evt);
		panelScroll.remove(vectorCajasdeTexto.get(pos));
		vectorCajasdeTexto.remove(pos);
		cont--;
		if(cont < numCajas)
        	btnNuevaCaja.setEnabled(true);
		if(vectorCajasdeTexto.size()==0)
			habilitarRadios(true);
		SwingUtilities.updateComponentTreeUI(panelScroll);
	}
	public int buscarPos(ActionEvent evt) {
		for(int i=0;i<vectorCajasdeTexto.size();i++) {
			if(evt.getSource() == vectorCajasdeTexto.get(i).getBtnEliminar())
				return i;
		}
		return -1;
	}

    public void habilitarRadios(boolean band) {
    	rdBtnCorreo.setEnabled(band);
    	rdBtnRFC.setEnabled(band);
    	rdBtnTelefono.setEnabled(band);
    }

}
