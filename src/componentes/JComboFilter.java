package componentes;

import java.awt.*;

import javax.swing.*;

public class JComboFilter extends JPanel {

    private JComboBox<String> combo;
    private JPanel panelBotones;
    private JButton btnOrdenadoOriginal;
    private JButton btnOrdenadoAsc;

    public JComboFilter() {
        initInterface();
    }

    private void initInterface() {
        JPanel panelPrincipal = new JPanel(new FlowLayout());
        add(panelPrincipal);
        
        combo = new JComboBox<>();
        combo.addItem("Selecciona");
        combo.setPreferredSize(new Dimension(120, 60));
        combo.setEditable(true);
        panelPrincipal.add(combo);


        panelBotones = new JPanel(new GridLayout(0, 1, 0, 5));
        panelBotones.setPreferredSize(new Dimension(100, 60));

        btnOrdenadoOriginal = new JButton("Original");
        btnOrdenadoOriginal.setPreferredSize(new Dimension(20, 10));
        panelBotones.add(btnOrdenadoOriginal);

        btnOrdenadoAsc = new JButton("Ordenado");
        panelBotones.add(btnOrdenadoAsc);

        panelPrincipal.add(panelBotones);
        


    }
}
