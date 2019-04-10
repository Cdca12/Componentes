package componentes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import componentes.ComponentesAuxiliares.JLeeCorreo;
import componentes.ComponentesAuxiliares.JPanelCaja;

public class CajasMultiples extends JPanel implements ActionListener {

    private JPanel panelOpciones, panelRadioButton, panelBoton, panelCentral, panelCaja, panelScroll;
    private JRadioButton rdBtnCorreo, rdBtnRFC, rdBtnTelefono;
    private ButtonGroup grupo;
    private JButton btnNuevaCaja;
    private Vector<JTextField> cajasdeTexto;
    private Vector<JButton> btnCajasdeTexto;
    private Vector<JPanelCaja> vectorCajasdeTexto;
    private JScrollPane scroll;
    private int seleccion;

    public CajasMultiples() {
//		cajasdeTexto = new Vector<JTextField>();
//		btnCajasdeTexto = new Vector<JButton>();
        vectorCajasdeTexto = new Vector<JPanelCaja>();
        panelCaja = new JPanel();
        panelCaja.setLayout(new FlowLayout(FlowLayout.LEFT));
        creaVista();
        hazEscuchas();
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
        panelRadioButton.setBorder(BorderFactory.createLineBorder(Color.RED));
        //PanelBot�n
        panelBoton = new JPanel();
        panelBoton.setLayout(new FlowLayout(FlowLayout.LEFT));
        btnNuevaCaja = new JButton("Nueva Caja");
        btnNuevaCaja.setPreferredSize(new Dimension(100, 20));
        panelBoton.add(btnNuevaCaja);
        btnNuevaCaja.setBorder(BorderFactory.createLineBorder(Color.RED));
        //PanelOpciones
        panelOpciones = new JPanel();
        panelOpciones.setLayout(new GridLayout(2, 0));
        panelOpciones.add(panelRadioButton);
        panelOpciones.add(panelBoton);
        panelOpciones.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        //PanelCentral
        panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout());
        panelCentral.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        panelScroll = new JPanel(new FlowLayout(FlowLayout.LEFT));
        scroll = new JScrollPane(panelScroll);
//		scroll.add(panelScroll);
        panelCentral.add(scroll);

        add(panelOpciones, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
//		add(panelRadioButton, BorderLayout.NORTH);
    }

    private void hazEscuchas() {
        rdBtnCorreo.addActionListener(this);
        rdBtnRFC.addActionListener(this);
        rdBtnTelefono.addActionListener(this);
        btnNuevaCaja.addActionListener(this);
    }

    private void añadirCaja() {
        vectorCajasdeTexto.add(new JPanelCaja(seleccion));
//		switch(seleccion) {
//		case 0://Correo
//			cajasdeTexto.add(new JLeeCorreo());
//			
//			break;
//		case 1://RFC
//			cajasdeTexto.add(new JLeeCorreo());
//			break;
//		case 2://NumTel
//			cajasdeTexto.add(new JLeeCorreo());
//			break;
//		}
//		btnCajasdeTexto.add(new JButton("x"));
//		panelCentral.add(cajasdeTexto.get(cajasdeTexto.size()-1));
//		panelCentral.add(btnCajasdeTexto.get(btnCajasdeTexto.size()-1));
        panelScroll.add(vectorCajasdeTexto.get(vectorCajasdeTexto.size() - 1));

//		SwingUtilities.updateComponentTreeUI(panelScroll);
//		SwingUtilities.updateComponentTreeUI(scroll);
//		SwingUtilities.updateComponentTreeUI(panelCentral);
        panelScroll.updateUI();;
        scroll.updateUI();
        panelCentral.updateUI();;

    }

    @Override
    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == btnNuevaCaja) {
            añadirCaja();
            return;
        }

        if (evt.getSource() == rdBtnCorreo) {
            seleccion = 0;
            return;
        }
        if (evt.getSource() == rdBtnRFC) {
            seleccion = 1;
            return;
        }
        if (evt.getSource() == rdBtnTelefono) {
            seleccion = 2;
            return;
        }

    }

}
