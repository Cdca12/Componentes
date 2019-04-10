package componentes;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Contreras
 */
public class JCombosDependientes extends JPanel {

    private JLabel lbEstados, lbMunicipios, lbCiudades;
    private JComboBox cmbEstados, cmbMunicipios, cmbCiudades;

    public JCombosDependientes() {
        initComponents();
        addListeners();
    }

    public void initComponents() {
        setLayout(new FlowLayout());
        lbEstados = new JLabel("Estados");
        add(lbEstados);

        cmbEstados = new JComboBox<>();
        cmbEstados.setPreferredSize(new Dimension(120, 25));
        add(cmbEstados);

        lbMunicipios = new JLabel("Municipios");
        add(lbMunicipios);

        cmbMunicipios = new JComboBox<>();
        cmbMunicipios.setPreferredSize(new Dimension(120, 25));
        add(cmbMunicipios);

        lbCiudades = new JLabel("Ciudades");
        add(lbCiudades);

        cmbCiudades = new JComboBox<>();
        cmbCiudades.setPreferredSize(new Dimension(120, 25));
        add(cmbCiudades);

    }

    public void addListeners() {

    }
}
