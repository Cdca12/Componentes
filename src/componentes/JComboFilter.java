package componentes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class JComboFilter extends JPanel implements ActionListener, KeyListener {

    private JComboBox<String> combo;
    private JPanel panelBotones;
    private JButton btnOrdenadoOriginal;
    private JButton btnOrdenadoAsc;
    private ComboBoxModel<String> comboModel;
    private Vector datosOriginal;
    private Vector datosOrdenado;
    private JTextComponent editorTexto;
    private boolean originalActivo = true;

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
        editorTexto = (JTextComponent) combo.getEditor().getEditorComponent();
        add(combo);

        panelBotones = new JPanel(new GridLayout(0, 1, 0, 5));
        panelBotones.setPreferredSize(new Dimension(55, 40));

        btnOrdenadoOriginal = new JButton("Ori");
        btnOrdenadoOriginal.setEnabled(true);
        panelBotones.add(btnOrdenadoOriginal);

        btnOrdenadoAsc = new JButton("Ord");
        panelBotones.add(btnOrdenadoAsc);

        add(panelBotones);

        datosOriginal = new Vector<String>();

    }

    private void hazEscuchas() {
        btnOrdenadoAsc.addActionListener(this);
        btnOrdenadoOriginal.addActionListener(this);
        editorTexto.addKeyListener(this);
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
    
    public void agrega(String[] datos) {
        Vector<String> vectorDatos = new Vector<>(datos.length);
        for (int i = 0; i < datos.length; i++) {
            vectorDatos.add(datos[i]);
        }
        comboModel = new DefaultComboBoxModel<>(vectorDatos);
        combo.setModel(comboModel);
        datosOriginal = vectorDatos;
    }

    private void ordenaDatos() {
        datosOrdenado = new Vector<String>(datosOriginal);
        Collections.sort(datosOrdenado);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnOrdenadoAsc) {
            originalActivo = false;
            ordenaDatos();
            comboModel = new DefaultComboBoxModel<>(datosOrdenado);
            combo.setModel(comboModel);
            btnOrdenadoAsc.setEnabled(false);
            btnOrdenadoOriginal.setEnabled(true);
            return;
        }
        if (evt.getSource() == btnOrdenadoOriginal) {
            originalActivo = true;
            comboModel = new DefaultComboBoxModel<>(datosOriginal);
            combo.setModel(comboModel);
            btnOrdenadoOriginal.setEnabled(false);
            btnOrdenadoAsc.setEnabled(true);
            return;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
//        for (int i = 0; i < datosFiltrados.size(); i++) {
//            if (cadena == combo.getItemAt(i).substring(0, cadena.length())) {
//                datosFiltrados.removeElementAt(i);
//            }
//        }
//        comboModel = new DefaultComboBoxModel<>(datosFiltrados);
//        combo.setModel(comboModel);
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        Vector<String> datosFiltrados = new Vector();
        Vector<String> datosAFiltrar = originalActivo ? datosOriginal : datosOrdenado;

        String cadena = editorTexto.getText();
        // TODO: Evitar excepcón, que cuando esté en blanco 
        // TODO: Poner cursor al ultimo
        for (int i = 0; i < datosAFiltrar.size(); i++) {
            String cadenaAComparar = "";
            cadenaAComparar = datosAFiltrar.get(i).toLowerCase().substring(0, cadena.length());
            if (cadenaAComparar.contains(cadena.toLowerCase())) {
                datosFiltrados.add(datosAFiltrar.get(i));
            }
        }
        comboModel = new DefaultComboBoxModel<>(datosFiltrados);
        combo.setModel(comboModel);
        editorTexto.setText(cadena);
    }

}
