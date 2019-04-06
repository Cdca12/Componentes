package componentes;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

import javax.swing.*;

public class JComboFilter extends JPanel {

    private JComboBox<String> combo;
    private JPanel panelBotones;
    private JButton btnOrdenadoOriginal;
    private JButton btnOrdenadoAsc;
    private ComboBoxModel<String> comboModel;
    private Vector datosOriginal;
    private Vector datosOrdenado;
    public JComboFilter() {
        initInterface();
    }

    private void initInterface() {
        setLayout(new FlowLayout());
        
        
        combo = new JComboBox<>();
        combo.addItem("Selecciona");
        combo.setPreferredSize(new Dimension(120, 40));
        combo.setEditable(true);
        add(combo);


        panelBotones = new JPanel(new GridLayout(0, 1, 0, 5));
        panelBotones.setPreferredSize(new Dimension(55, 40));

        btnOrdenadoOriginal = new JButton("Ori");
        btnOrdenadoOriginal.setPreferredSize(new Dimension(20, 10));
        panelBotones.add(btnOrdenadoOriginal);

        btnOrdenadoAsc = new JButton("Ord");
        panelBotones.add(btnOrdenadoAsc);

        add(panelBotones);
        
        datosOriginal = new Vector<String>();
        
    }
    
    public void agrega(String dato) {
    	combo.addItem(dato);
    	datosOriginal.add(dato);
    }
    public void agrega(Vector datos) {
    	comboModel=new DefaultComboBoxModel<>(datos);
    	combo.setModel(comboModel);
    	datosOriginal = datos;
    }
    private void ordenaDatos() {
    	datosOrdenado = new Vector<String>(datosOriginal);
    	Collections.sort(datosOrdenado);
    }
}
