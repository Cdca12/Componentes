package componentes;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;


public class CajasMultiplesVta extends JPanel implements ActionListener {

    private JPanel panelOpciones, panelRadioButton, panelBoton, panelCaja, panelScroll;
    public JButton btnNuevaCaja;
    public JRadioButton rdBtnCorreo, rdBtnRFC, rdBtnTelefono;
    private ButtonGroup grupo;
    private Vector<JTextField> cajasdeTexto;
    private Vector<JButton> btnCajasdeTexto;
    private Vector<JPanelCaja> vectorCajasDeTexto;
    private JScrollPane scroll;
    private int seleccion;
    private int numCajas;
    private int cont;

    public CajasMultiplesVta(int numCajas) {
        vectorCajasDeTexto = new Vector<JPanelCaja>();
        panelCaja = new JPanel();
        panelCaja.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.numCajas = numCajas;
        creaVista();
        cont = 0;
    }
    
    public String[] getText() {
        String[] datos = new String[vectorCajasDeTexto.size()];
        for (int i = 0; i < vectorCajasDeTexto.size(); datos[i] = vectorCajasDeTexto.get(i).getText(), i++);
        return datos;
    }
    
    public String getText(int posicion) {
        return vectorCajasDeTexto.get(posicion).getText();
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

        panelScroll = new JPanel(new GridLayout(numCajas, 1));
        scroll = new JScrollPane(panelScroll);
        scroll.setBorder(null);

        add(panelOpciones, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    public void añadirCaja() {
    	JPanelCaja caja = new JPanelCaja(seleccion);
        caja.getBtnEliminar().addActionListener(this);
        vectorCajasDeTexto.add(caja);
        panelScroll.add(vectorCajasDeTexto.get(vectorCajasDeTexto.size() - 1));
        cont++;
        if (cont >= numCajas) {
            btnNuevaCaja.setEnabled(false);
        }

        SwingUtilities.updateComponentTreeUI(panelScroll);
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

    public Vector<JPanelCaja> getVectorCajasdeTexto() {
        return vectorCajasDeTexto;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        int pos = buscarPos(evt);
        panelScroll.remove(vectorCajasDeTexto.get(pos));
        vectorCajasDeTexto.remove(pos);
        cont--;
        if (cont < numCajas) {
            btnNuevaCaja.setEnabled(true);
        }
        if (vectorCajasDeTexto.size() == 0) {
            habilitarRadios(true);
        }
        SwingUtilities.updateComponentTreeUI(panelScroll);
    }

    private int buscarPos(ActionEvent evt) {
        for (int i = 0; i < vectorCajasDeTexto.size(); i++) {
            if (evt.getSource() == vectorCajasDeTexto.get(i).getBtnEliminar()) {
                return i;
            }
        }
        return -1;
    }

    public void habilitarRadios(boolean band) {
        rdBtnCorreo.setEnabled(band);
        rdBtnRFC.setEnabled(band);
        rdBtnTelefono.setEnabled(band);
    }

}
