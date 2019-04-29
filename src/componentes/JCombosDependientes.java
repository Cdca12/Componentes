package componentes;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Contreras
 */
public class JCombosDependientes extends JPanel implements ItemListener {

    private final String defaultValueCmbEstados = "Seleccione estado",
            defaultValueCmbMunicipios = "Seleccione municipio", 
            defaultValueCmbCiudades = "Selecciona ciudad";

    // TEST: Memoria
    private final String[] arregloEstados = {"BC", "BCS", "SONORA", "SINALOA", "COLIMA", "NAYARIT", "JALISCO", "MICHOACAN", "OAXACA", "GUERRERO", "CHIAPAS"};
    private final String[][] arregloMunicipios = {{"Tijuana", "Mexicali", "Tecate", "Ensenada", "Rosarito"},
    {"La Paz", "Los Cabos"}, {"Hermosillo", "Obregon", "Navojoa", "gUAYMAS"},
    {"Culiacán", "Mazatlán", "LosMochis", "Guasave"}};
    String[][][] arregloCiudades = {{{"Tij1", "Tij2", "Tij3", "Tij4"}, {"Mex1", "Mex2"}, {"Tec1", "Tec2", "Tec3"},
    {"Ens1", "Ens2", "Ens3"}, {"Ros1"}}, {{"Paz1", "Paz2", "Paz3"}, {"Cab1", "Cab2", "Cab3"}}, {}};

    private JLabel lbEstados, lbMunicipios, lbCiudades;
    private JComboBox cmbEstados, cmbMunicipios, cmbCiudades;

    public JCombosDependientes() {
        initComponents();
        addListeners();
    }

    public JCombosDependientes(String defaultValueCmbEstados) {
        this(); // Manda a llamar constructor por default
        this.cmbEstados.setSelectedItem(defaultValueCmbEstados);
    }

    public JCombosDependientes(String defaultValueCmbEstados, String defaultValueCmbMunicipios) {
        this();
        this.cmbEstados.setSelectedItem(defaultValueCmbEstados);
        this.cmbMunicipios.setSelectedItem(defaultValueCmbMunicipios);
    }

    public JCombosDependientes(String defaultValueCmbEstados, String defaultValueCmbMunicipios, String defaultValueCmbCiudades) {
        this();
        this.cmbEstados.setSelectedItem(defaultValueCmbEstados);
        this.cmbMunicipios.setSelectedItem(defaultValueCmbMunicipios);
        this.cmbCiudades.setSelectedItem(defaultValueCmbCiudades);
        
    }

    public void initComponents() {
        setLayout(new FlowLayout());
        lbEstados = new JLabel("Estados");
        add(lbEstados);

        cmbEstados = new JComboBox<>(arregloEstados);
        cmbEstados.setPreferredSize(new Dimension(120, 25));
        cmbEstados.insertItemAt(defaultValueCmbEstados, 0);
        cmbEstados.setSelectedIndex(0);
        add(cmbEstados);
        
        lbMunicipios = new JLabel("Municipios");
        add(lbMunicipios);

        cmbMunicipios = new JComboBox<>();
        cmbMunicipios.setPreferredSize(new Dimension(120, 25));
        cmbMunicipios.insertItemAt(defaultValueCmbMunicipios, 0);
        add(cmbMunicipios);

        lbCiudades = new JLabel("Ciudades");
        add(lbCiudades);
        
        cmbCiudades = new JComboBox<>();
        cmbCiudades.setPreferredSize(new Dimension(120, 25));
        cmbCiudades.insertItemAt(defaultValueCmbCiudades, 0);
        add(cmbCiudades);

    }

    public void addListeners() {
        cmbEstados.addItemListener(this);
        cmbMunicipios.addItemListener(this);
        cmbCiudades.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        if (evt.getStateChange() != ItemEvent.SELECTED) { // Evita que se disparen otros eventos
            return;
        }
        
        if (evt.getSource() == cmbEstados) {
            cmbMunicipios.removeItemListener(this);
            int idEstado = cmbEstados.getSelectedIndex() - 1;
            cmbMunicipios.removeAllItems();
            cmbCiudades.removeAllItems();

            for (int i = 0; i < arregloMunicipios[idEstado].length; i++) {
                cmbMunicipios.addItem(arregloMunicipios[idEstado][i]);
            }

            cmbMunicipios.insertItemAt("Seleccione municipio", 0);
            cmbMunicipios.setSelectedIndex(0);
            cmbMunicipios.addItemListener(this);
            return;
        }

        if (evt.getSource() == cmbMunicipios) {
            cmbCiudades.removeItemListener(this);
            int idEstado = cmbEstados.getSelectedIndex() - 1;
            int idMunicipio = cmbMunicipios.getSelectedIndex() - 1;
            cmbCiudades.removeAllItems();
            
            for (int i = 0; i < arregloCiudades[idEstado][idMunicipio].length; i++) {
                System.out.print(arregloCiudades[idEstado][idMunicipio].length);
                cmbCiudades.addItem(arregloCiudades[idEstado][idMunicipio][i]);
            }
            
            cmbCiudades.insertItemAt("Seleccione ciudad", 0);
            cmbCiudades.setSelectedIndex(0);
            cmbCiudades.addItemListener(this);
            return;

        }
    }
}
