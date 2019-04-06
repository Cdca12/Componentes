package componentes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

import javax.swing.*;

public class JComboFilter extends JPanel implements ActionListener, KeyListener {

    private JComboBox<String> combo;
    private JPanel panelBotones;
    private JButton btnOrdenadoOriginal;
    private JButton btnOrdenadoAsc;
    private ComboBoxModel<String> comboModel;
    private Vector datosOriginal;
    private Vector datosOrdenado;

    public JComboFilter() {
        initInterface();
        hazEscuchas();
    }

    private void initInterface() {
        setLayout(new FlowLayout());

        combo = new JComboBox<>();
//        combo.addItem("Selecciona");
        combo.setPreferredSize(new Dimension(120, 40));
        combo.setEditable(true);
        add(combo);

        panelBotones = new JPanel(new GridLayout(0, 1, 0, 5));
        panelBotones.setPreferredSize(new Dimension(55, 40));

        btnOrdenadoOriginal = new JButton("Ori");
        btnOrdenadoOriginal.setPreferredSize(new Dimension(20, 10));
        btnOrdenadoOriginal.setEnabled(false);
        panelBotones.add(btnOrdenadoOriginal);

        btnOrdenadoAsc = new JButton("Ord");
        panelBotones.add(btnOrdenadoAsc);

        add(panelBotones);

        datosOriginal = new Vector<String>();

    }

    private void hazEscuchas() {
        btnOrdenadoAsc.addActionListener(this);
        btnOrdenadoOriginal.addActionListener(this);
        combo.getEditor().getEditorComponent().addKeyListener(this);
    }

    public void agrega(String dato) {
        combo.addItem(dato);
        datosOriginal.add(dato);
    }

    public void agrega(Vector datos) {
        comboModel = new DefaultComboBoxModel<>(datos);
        combo.setModel(comboModel);
        datosOriginal = datos;
    }

    private void ordenaDatos() {
        datosOrdenado = new Vector<String>(datosOriginal);
        Collections.sort(datosOrdenado);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnOrdenadoAsc) {
            System.out.println("llego1");
            ordenaDatos();
            comboModel = new DefaultComboBoxModel<>(datosOrdenado);
            combo.setModel(comboModel);
            btnOrdenadoAsc.setEnabled(false);
            btnOrdenadoOriginal.setEnabled(true);
            return;
        }
        if (evt.getSource() == btnOrdenadoOriginal) {
            System.out.println("llego2");
            comboModel = new DefaultComboBoxModel<>(datosOriginal);
            combo.setModel(comboModel);
            btnOrdenadoOriginal.setEnabled(false);
            btnOrdenadoAsc.setEnabled(true);
            return;
        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
