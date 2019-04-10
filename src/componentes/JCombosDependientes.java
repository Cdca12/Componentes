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

    // TEST: Memoria
    private final String[] arregloEstados = {"BC", "BCS", "SONORA", "SINALOA", "COLIMA", "NAYARIT", "JALISCO", "MICHOACAN", "OAXACA", "GUERRERO", "CHIAPAS"};
    private final String[][] arregloCiudades = {{"Tijuana", "Mexicali", "Tecate", "Ensenada", "Rosarito"},
    {"La Paz", "Los Cabos"}, {"Hermosillo", "Obregon", "Navojoa", "gUAYMAS"},
    {"Culiacán", "Mazatlán", "LosMochis", "Guasave"}};
    String[][][] arregloColonias = {{{"Tij1", "Tij2", "Tij3", "Tij4"}, {"Mex1", "Mex2"}, {"Tec1", "Tec2", "Tec3"},
    {"Ens1", "Ens2", "Ens3"}, {"Ros1"}}, {{"Paz1", "Paz2", "Paz3"}, {"Cab1", "Cab2", "Cab3"}}, {}};

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
